package gui.ShowCustomer;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCustomerFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private ShowCustomerFrameView scf;

	public ShowCustomerFrameController(VerwaltungMainFrameView mf,ShowCustomerFrameView scf){
		this.mf = mf;
		this.scf = scf;
	}
	public ShowCustomerFrameController(VerwaltungMainFrameView mf){
		this.mf = mf;
	}
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(scf,mf);
		if(e.getActionCommand()=="Cancel")
			fs.switchFrame();
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.scf = (ShowCustomerFrameView) f;
		
	}
}