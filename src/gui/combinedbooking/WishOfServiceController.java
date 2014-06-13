package gui.combinedbooking;

import java.awt.event.ActionEvent;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

public class WishOfServiceController implements IController{
	private WishOfServiceFrame f;
	private VerwaltungMainFrameView mf;
	public WishOfServiceController(VerwaltungMainFrameView mf,WishOfServiceFrame f){
		this.mf = mf;
		this.f = f;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="no"){
			final FrameSwitcher fs = new FrameSwitchImpl(f, mf);
			fs.switchFrame();
		}
		else{
			final FrameSwitcher fs = new FrameSwitchImpl(f, mf);
			fs.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (WishOfServiceFrame) f;
	}
}