package gui.ShowCustomer;

import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCustomerFrameController implements ActionListener{
	private VerwaltungMainFrameView mf;
	private ShowCustomerFrameView scf;

	public ShowCustomerFrameController(VerwaltungMainFrameView mf,ShowCustomerFrameView scf){
		this.mf = mf;
		this.scf = scf;
	}

	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(scf,mf);
		if(e.getActionCommand()=="Cancel")
			fs.switchFrame();
	}

}
