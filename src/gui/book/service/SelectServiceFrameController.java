package gui.book.service;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;

public class SelectServiceFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	private ServiceModel m;
	public SelectServiceFrameController(SelectServiceFrameView sf,VerwaltungMainFrameView mf,SelectTimeFrameView ssf,ServiceModel m){
		this.mf = mf;
		this.sf = sf;
		this.ssf = ssf;
		this.m = m;
	}
	public SelectServiceFrameController(VerwaltungMainFrameView mf,SelectTimeFrameView ssf,ServiceModel m){
		this.mf = mf;
		this.ssf = ssf;
		this.m = m;
	}

	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		SelectRoomByServiceFrameController c = new SelectRoomByServiceFrameController(mf,sf,m);
		SelectRoomByServiceFrameView scf = new SelectRoomByServiceFrameView(c,m);
		c.setConnectedView(scf);
		scf.init();
		scf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,scf);
		
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			fs2.switchFrame();
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.sf = (SelectServiceFrameView) f;
	}
}