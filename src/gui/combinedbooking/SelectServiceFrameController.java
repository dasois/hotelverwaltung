package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import gui.book.service.SelectRoomByServiceFrameView;
import gui.book.service.SelectServiceFrameView;
import gui.book.service.SelectTimeFrameView;
import gui.book.service.ServiceModel;

import java.awt.event.ActionEvent;

public class SelectServiceFrameController implements IController{
	private WishOfServiceFrame wf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	private ServiceModel m;
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
		ServiceModel m = new ServiceModel();
		SelectRoomByServiceFrameController c = new SelectRoomByServiceFrameController(wf,sf,m);
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