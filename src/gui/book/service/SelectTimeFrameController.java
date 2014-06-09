package gui.book.service;

import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SelectTimeFrameController implements ActionListener{
	private VerwaltungMainFrameView mf;
	private SelectTimeFrameView stf;

	public SelectTimeFrameController(SelectTimeFrameView stf,VerwaltungMainFrameView mf){
		this.mf = mf;
		this.stf = stf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(stf,mf);
		SelectServiceFrameView ssf = new SelectServiceFrameView(mf,stf);
		ssf.init();
		ssf.setVisible(false);
		final FrameSwitcher fs2 = new FrameSwitchImpl(stf,ssf);
		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Search"){
			if (stf.datePicker.isValid()){
				JOptionPane.showMessageDialog(null, "Bitte Datum auswählen");
			}
			else{
				fs2.switchFrame();
			}
		}
	}
}