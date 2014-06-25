package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class SelectTimeFrameController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectTimeFrameView stf;
	ServiceModel m;
	public SelectTimeFrameController(SelectTimeFrameView stf,VerwaltungMainFrameView mf,ServiceModel m){
		this.mf = mf;
		this.stf = stf;
		this.m = m;
	}
	public SelectTimeFrameController(VerwaltungMainFrameView mf,ServiceModel m){
		this.mf = mf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(stf,mf);
		SelectServiceFrameController c = new SelectServiceFrameController(mf,stf,m);
		SelectServiceFrameView ssf = new SelectServiceFrameView(c,m);
		c.setConnectedView(ssf);
		ssf.init();
		ssf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(stf,ssf);
		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Search"){
			if (m.getDatePicker().isValid()){
				JOptionPane.showMessageDialog(null, "Bitte Datum auswählen");
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