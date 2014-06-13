package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.BookingServiceControlInterface;
import app.BookingServiceImp;

public class SelectRoomByServiceFrameController implements IController{
	private SelectRoomByServiceFrameView sf;
	private VerwaltungMainFrameView mf;
	private SelectServiceFrameView ssf;
	private SelectRoomByServiceFrameModel m;
	public SelectRoomByServiceFrameController(SelectRoomByServiceFrameView sf,VerwaltungMainFrameView mf,SelectServiceFrameView ssf,SelectRoomByServiceFrameModel m){
		this.sf = sf;
		this.mf = mf;
		this.ssf = ssf;
		this.m = m;
	}
	public SelectRoomByServiceFrameController(VerwaltungMainFrameView mf,SelectServiceFrameView ssf,SelectRoomByServiceFrameModel m){
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
			BookingServiceControlInterface controller = new BookingServiceImp();
			try {
				controller.create(sf.ssf2.getDate(), m.getList().getSelectedValue().getBrid(), ssf.getServiceSelectionid());
				mf.addProtocolLine("Buchung von Service: "+ ssf.getServiceName()+" wurde in der Datenbank angelegt\n");
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
