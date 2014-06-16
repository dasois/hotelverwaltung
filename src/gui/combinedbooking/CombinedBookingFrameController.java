package gui.combinedbooking;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.room.RoomModel;
import gui.book.service.ServiceModel;

public class CombinedBookingFrameController implements IController{
	private CombinedBookingFrameView f;
	private RoomModel rm;
	private ArrayList<ServiceModel> sm;
	private VerwaltungMainFrameView mf;
	private WishOfServiceFrame wf;
	public CombinedBookingFrameController(VerwaltungMainFrameView mf,RoomModel rm,ArrayList<ServiceModel> sm){
		this.mf = mf;
		this.rm = rm;
		this.sm = sm;
	}
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,mf);
		if(e.getActionCommand()=="abort"){
			fs.switchFrame();
			//rollback
		}else{
			//buchen
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.f = (CombinedBookingFrameView) f;
	}
}