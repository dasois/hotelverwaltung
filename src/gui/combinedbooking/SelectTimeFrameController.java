package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.book.service.SelectServiceFrameView;
import gui.book.service.SelectTimeFrameView;
import gui.book.service.ServiceModel;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class SelectTimeFrameController implements IController{
	private WishOfServiceFrame mf;
	private SelectTimeFrameView stf;
	WishOfServiceController cc;
	ServiceModel m;
	public SelectTimeFrameController(SelectTimeFrameView stf,WishOfServiceFrame mf,ServiceModel m){
		this.mf = mf;
		this.stf = stf;
		this.m = m;
	}
	public SelectTimeFrameController(WishOfServiceFrame mf,ServiceModel m,WishOfServiceController cc){
		this.mf = mf;
		this.m = m;
		this.cc = cc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(stf,mf);
		SelectServiceFrameController c = new SelectServiceFrameController(mf, stf, m);
		SelectServiceFrameView ssf = new SelectServiceFrameView(c,m);
		c.setConnectedView(ssf);
		ssf.init();
		ssf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(stf,ssf);
		if(e.getActionCommand()=="Cancel"){
			cc.removeLastServiceModel();
			fs.switchFrame();
		}else if(e.getActionCommand()=="Search"){
			if (m.getDatePicker().isValid()){
				JOptionPane.showMessageDialog(null, "Bitte Datum ausw�hlen");
			}
			else{
				fs2.switchFrame();
			}
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.stf = (SelectTimeFrameView) f;	
	}
}