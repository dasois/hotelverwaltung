package gui.book.service;

import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectServiceFrameController implements ActionListener{
	private VerwaltungMainFrameView mf;
	private SelectServiceFrameView sf;
	private SelectTimeFrameView ssf;
	public SelectServiceFrameController(SelectServiceFrameView sf,VerwaltungMainFrameView mf,SelectTimeFrameView ssf){
		this.mf = mf;
		this.sf = sf;
		this.ssf = ssf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(sf,ssf);
		SelectRoomByServiceFrameView scf = new SelectRoomByServiceFrameView(mf,sf,ssf);
		scf.init();
		scf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(sf,scf);
		
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			fs2.switchFrame();
		}
	}

}
