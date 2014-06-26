package gui.combinedbooking;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.ListModel;

import db.entities.BookingRoom;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.room.RoomModel;
import gui.book.service.SelectTimeFrameView;
import gui.book.service.ServiceModel;

public class WishOfServiceController implements IController{
	private WishOfServiceFrame f;
	private VerwaltungMainFrameView mf;
	private RoomModel rm;
	private ArrayList<ServiceModel> sm;
	public WishOfServiceController(VerwaltungMainFrameView mf,RoomModel rm){
		this.mf = mf;	
		this.rm = rm;
		sm = new ArrayList<ServiceModel>();
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="no"){
			CombinedBookingFrameController c = new CombinedBookingFrameController(mf);
			CombinedBookingFrameView view = new CombinedBookingFrameView(c, rm, sm);
			c.setConnectedView(view);
			view.init();
			view.setVisible(false);
			final FrameSwitcher fs = new FrameSwitchImpl(f, view);
			fs.switchFrame();
		}
		else{
			ServiceModel m = new ServiceModel();
			m.setActualBookingId(rm.getActualbookingID());
			m.setBookedRoomList(rm.getBookingRoomList());
			m.setDateLimit(true);
			m.setMinDate(rm.getStartDatePicker().getDate());
			m.setMaxDate(rm.getEndDatePicker().getDate());
			sm.add(m);
			SelectTimeFrameController c = new SelectTimeFrameController(f,m);
			SelectTimeFrameView sf = new SelectTimeFrameView(c, m);
			c.setConnectedView(sf);
			sf.init();
			sf.setVisible(false);
			final FrameSwitcher fs = new FrameSwitchImpl(f, sf);
			fs.switchFrame();
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.f = (WishOfServiceFrame) f;
	}
}