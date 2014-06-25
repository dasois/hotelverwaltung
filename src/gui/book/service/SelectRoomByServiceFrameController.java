package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.SQLException;
import app.BookingServiceControlInterface;
import app.BookingServiceImp;

public class SelectRoomByServiceFrameController implements IController{
	private SelectRoomByServiceFrameView sf;
	private VerwaltungMainFrameView mf;
	private SelectServiceFrameView ssf;
	private ServiceModel m;
	private BookingServiceControlInterface controller = new BookingServiceImp();
	public SelectRoomByServiceFrameController(SelectRoomByServiceFrameView sf,VerwaltungMainFrameView mf,SelectServiceFrameView ssf,ServiceModel m){
		this.sf = sf;
		this.mf = mf;
		this.ssf = ssf;
		this.m = m;
	}
	
	public SelectRoomByServiceFrameController(VerwaltungMainFrameView mf,SelectServiceFrameView ssf,ServiceModel m){
		this.mf = mf;
		this.ssf = ssf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,mf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){	
			try {
				controller.create(new Date(m.getDatePicker().getCalendar().getTime().getTime()), m.getList().getSelectedValue().getBrid(), m.getServiceList().getSelectedValue().getSid());
				mf.addProtocolLine("Buchung von Service: "+ m.getServiceList().getSelectedValue().getType()+" wurde in der Datenbank angelegt\n");
				controller.saveChanges();
			} catch (SQLException e1) {
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