package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectServiceFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	public SelectServiceFrameController(SelectServiceFrameView sf,VerwaltungMainFrameView mf,SelectTimeFrameView ssf){
		this.mf = mf;
		this.sf = sf;
		this.ssf = ssf;
	}
	public SelectServiceFrameController(VerwaltungMainFrameView mf,SelectTimeFrameView ssf){
		this.mf = mf;
		this.ssf = ssf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		SelectRoomByServiceFrameModel m = new SelectRoomByServiceFrameModel();
		SelectRoomByServiceFrameController c = new SelectRoomByServiceFrameController(mf,sf,m);
		SelectRoomByServiceFrameView scf = new SelectRoomByServiceFrameView(mf,c,sf,ssf,m);
		scf.init();
		scf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,scf);
		
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.sf = (SelectServiceFrameView) f;
	}

}
