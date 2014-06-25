package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.book.service.SelectRoomByServiceFrameView;
import gui.book.service.SelectServiceFrameView;
import gui.book.service.ServiceModel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import app.BookingServiceControlInterface;
import app.BookingServiceImp;

public class SelectRoomByServiceFrameController implements IController{
	private SelectRoomByServiceFrameView sf;
	private WishOfServiceFrame wf;
	private SelectServiceFrameView ssf;
	private ServiceModel m;
	public SelectRoomByServiceFrameController(SelectRoomByServiceFrameView sf,WishOfServiceFrame wf,SelectServiceFrameView ssf,ServiceModel m){
		this.sf = sf;
		this.wf = wf;
		this.ssf = ssf;
		this.m = m;
	}
	public SelectRoomByServiceFrameController(WishOfServiceFrame wf,SelectServiceFrameView ssf,ServiceModel m){
		this.wf = wf;
		this.ssf = ssf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,wf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			BookingServiceControlInterface controller = new BookingServiceImp();
			try {
				controller.create(new Date(m.getDatePicker().getCalendar().getTime().getTime()), m.getServiceList().getSelectedValue().getSid());
				 
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.sf = (SelectRoomByServiceFrameView) f;	
	}
}