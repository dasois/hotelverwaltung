package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.book.service.SelectServiceFrameView;
import gui.book.service.SelectTimeFrameView;
import gui.book.service.ServiceModel;

import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;

import app.BookingServiceControlInterface;
import app.BookingServiceImp;

public class SelectServiceFrameController implements IController{
	private WishOfServiceFrame wf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	private ServiceModel m;
	private BookingServiceControlInterface controller = new BookingServiceImp();
	public SelectServiceFrameController(SelectServiceFrameView sf,WishOfServiceFrame wf,SelectTimeFrameView ssf,ServiceModel m){
		this.wf = wf;
		this.sf = sf;
		this.ssf = ssf;
		this.m = m;
	}
	public SelectServiceFrameController(WishOfServiceFrame wf,SelectTimeFrameView ssf,ServiceModel m){
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
			try {
				controller.create(new Date(m.getDatePicker().getCalendar().getTime().getTime()), m.getServiceList().getSelectedValue().getBrid(), m.getServiceList().getSelectedValue().getSid());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//TODO buchung ins model übernehmen
			fs2.switchFrame();
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.sf = (SelectServiceFrameView) f;
	}
}