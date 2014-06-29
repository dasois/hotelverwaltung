package gui.paybooking;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.SelectCustomerFrameView;
import java.awt.event.ActionEvent;

public class SelectCustomerController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectCustomerFrameView f;
	private PayBookingModel m;
	public SelectCustomerController(VerwaltungMainFrameView mf){
		this.mf = mf;
		m = new PayBookingModel();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="book"){
			m.setCID(f.getSelectedCustomer().getCid());
			SelectBookingFrameController c = new SelectBookingFrameController(mf,m,f);
			SelectBookingFrameView bf = new SelectBookingFrameView(c, m);
			bf.init();
			bf.setVisible(false);
			c.setConnectedView(bf);		
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,bf);
			fs.switchFrame();
		}else{
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,mf);
			fs.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectCustomerFrameView) f;
	}
}