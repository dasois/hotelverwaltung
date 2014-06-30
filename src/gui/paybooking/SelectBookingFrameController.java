package gui.paybooking;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.SelectCustomerFrameView;
import gui.book.room.RoomModel;
import gui.book.service.ServiceModel;
import gui.combinedbooking.CombinedBookingFrameView;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import app.BookingControlImp;
import app.BookingInterface;

import com.toedter.calendar.JDateChooser;

import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Room;
import db.entities.Service;

public class SelectBookingFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private PayBookingModel m;
	private ArrayList<ServiceModel> serviceModels;
	SelectBookingFrameView f;
	SelectCustomerFrameView back;
	private RoomModel rm;
	public SelectBookingFrameController (VerwaltungMainFrameView mf,PayBookingModel m,SelectCustomerFrameView back,RoomModel rm){
		this.mf = mf;
		this.m = m;
		this.back = back;
		serviceModels = new ArrayList<>();
		this.rm = rm;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Cancel"){
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,back);
			fs.switchFrame();
		}else{
			BookingInterface b = new BookingControlImp();
			m.setSelBooking(f.getSelectedBooking());
			
			try {
				ArrayList<BookingRoom> br =new ArrayList<BookingRoom>(b.getRelatedRoomBookings(m.getSelBooking().getBid()));
				rm.setBookingRoomList(br);
				ArrayList<Room> selectedRoom = new ArrayList<Room>();
				for(BookingRoom tmp: br){
					rm.setTotalPrice(rm.getTotalPrice()+tmp.getRoom().getPrice());
					if(selectedRoom.contains(tmp.getRoom())==false)
						selectedRoom.add(tmp.getRoom());
				}
				rm.setSelectedRooms(selectedRoom.toArray(new Room[0]));
				JDateChooser startDate = new JDateChooser();
				startDate.setDate(br.get(0).getDate());
				rm.setStartDatePicker(startDate );
				JDateChooser endDate = new JDateChooser();
				endDate.setDate(br.get(br.size()-1).getDate());
				rm.setEndDatePicker(endDate);
				ArrayList<BookingService> bs = new ArrayList<BookingService>(b.getRelatedServiceBookings(m.getSelBooking().getBid()));
				for(BookingService i: bs){
					ServiceModel tmp = new ServiceModel();
					DefaultListModel<Service> listModel = new DefaultListModel<>();
					listModel.addElement(i.getService());
					rm.setTotalPrice(rm.getTotalPrice()+i.getService().getPrice());
					JList<Service> tmp2 = new JList<>(listModel);
					tmp2.setSelectedValue(i.getService(), false);
					tmp.setServiceList(tmp2);
					serviceModels.add(tmp);
				}
				CombinedBookingController c = new CombinedBookingController(mf);
				CombinedBookingFrameView view = new CombinedBookingFrameView(c, rm, serviceModels);
				view.init();
				c.setConnectedView(view);
				view.setVisible(false);
				b.delete(m.getSelBooking().getBid());
				final FrameSwitcher fs = new gui.FrameSwitchImpl(f,view);
				fs.switchFrame();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectBookingFrameView) f;
	}
}