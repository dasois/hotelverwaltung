package gui.book.room;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SelectTimeIntervallRoomFrameController implements IController{
	private SelectTimeIntervallRoomFrame f;
	private VerwaltungMainFrameView mf;
	private RoomModel m;
	public SelectTimeIntervallRoomFrameController(SelectTimeIntervallRoomFrame f, VerwaltungMainFrameView mf,RoomModel m){
		this.f = f;
		this.mf = mf;
		this.m = m;
	}
	public SelectTimeIntervallRoomFrameController(VerwaltungMainFrameView mf,RoomModel m){
		this.mf = mf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,mf);
		final SelectTimeIntervallRoomFrame srf = f;
		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Search"){
			if(m.getStartDatePicker().getDate()==null)
				JOptionPane.showMessageDialog(null, "Bitte die Daten eingeben");
			else if(m.getStartDatePicker().getDate().after(m.getEndDatePicker().getDate())){
				JOptionPane.showMessageDialog(null, "Das End-Datum muss nach/gleich dem Anfangsdatum sein");
			}
			else{
				FreeRoomsFrameController c = new FreeRoomsFrameController(mf);
				FreeRoomsFrameView ff = new FreeRoomsFrameView(mf,srf,c);
				c.setConnectedView(ff);
				ff.init();
				ff.setVisible(false);
				FrameSwitcher fs2 = new FrameSwitchImpl(srf,ff);
				fs2.switchFrame();
			}
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectTimeIntervallRoomFrame) f;		
	}
}