package gui.book;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCustomerFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectCustomerFrameView cf;

	public SelectCustomerFrameController(SelectCustomerFrameView cf,VerwaltungMainFrameView mf){
		this.mf = mf;
		this.cf = cf;
	}
	public SelectCustomerFrameController(VerwaltungMainFrameView mf){
		this.mf = mf;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="book"){
			CheckOutFrame cof = new CheckOutFrame(cf,mf);
			cof.init();
			cof.setVisible(false);
			final FrameSwitcher fs2 = new gui.FrameSwitchImpl(cf,cof);
			fs2.switchFrame();
		}else if(e.getActionCommand()=="Cancel"){
			final FrameSwitcher fs = new gui.FrameSwitchImpl(cf,mf);
			fs.switchFrame();
		}
	}
	@Override
	public void setConnectedView(AbstractFrame f) {
		this.cf = (SelectCustomerFrameView) f;
	}
}