package gui.paybooking;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Service;
import app.BookingControlImp;
import app.BookingInterface;
import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.SelectCustomerFrameView;
import gui.book.room.RoomModel;
import gui.book.service.ServiceModel;
import gui.combinedbooking.CombinedBookingFrameController;
import gui.combinedbooking.CombinedBookingFrameView;

public class SelectBookingFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private PayBookingModel m;
	private ArrayList<ServiceModel> serviceModels;
	SelectBookingFrameView f;
	SelectCustomerFrameView back;
	public SelectBookingFrameController (VerwaltungMainFrameView mf,PayBookingModel m,SelectCustomerFrameView back){
		this.mf = mf;
		this.m = m;
		this.back = back;
		serviceModels = new ArrayList<>();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="cancel"){
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,back);
			fs.switchFrame();
		}else{
			RoomModel rm = new RoomModel();
			BookingInterface b = new BookingControlImp();
			try {
				rm.setBookingRoomList(new ArrayList<BookingRoom>(b.getRelatedRoomBookings(m.getSelBooking().getBid())));
				ArrayList<BookingService> bs = new ArrayList<BookingService>(b.getRelatedServiceBookings(m.getSelBooking().getBid()));
				for(BookingService i: bs){
					ServiceModel tmp = new ServiceModel();
					DefaultListModel<Service> listModel = new DefaultListModel<>();
					listModel.addElement(i.getService());
					JList<Service> tmp2 = new JList<>(listModel);
					tmp2.setSelectedValue(i.getService(), false);
					tmp.setServiceList(tmp2);
					serviceModels.add(tmp);
				}
				CombinedBookingController c = new CombinedBookingController(mf);
				CombinedBookingFrameView view = new CombinedBookingFrameView(c, rm, serviceModels);
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