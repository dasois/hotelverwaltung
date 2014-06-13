package gui.combinedbooking;



import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.room.FreeRoomsFrameModel;
import gui.book.room.FreeRoomsFrameView;
import gui.book.room.SelectCostumerByRoomFrameModel;
import gui.book.room.SelectCostumerByRoomFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import db.entities.Room;

public class FreeRoomsFrameController implements IController{
	private FreeRoomsFrameView f;
	private VerwaltungMainFrameView mf;
	private FreeRoomsFrameModel m;
	public FreeRoomsFrameController(FreeRoomsFrameView f, VerwaltungMainFrameView mf){
		this.f = f;
		this.mf = mf;
		m = new FreeRoomsFrameModel();
	}
	public FreeRoomsFrameController(VerwaltungMainFrameView mf){
		this.mf = mf;
		m = new FreeRoomsFrameModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,f.sf);
		final FreeRoomsFrameView frf = f;
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(f.list.getSelectedValuesList().isEmpty()){
			JOptionPane.showMessageDialog(null, "Wähle mindestens ein freies Zimmer");
		}else{
			m.setTmp(f.list.getSelectedValuesList().toArray(new Room[0]));
			SelectCostumerByRoomFrameModel m2 = new SelectCostumerByRoomFrameModel();
			m2.setSelectedRooms(m.getTmp());
			SelectCostumerByRoomFrameController c = new SelectCostumerByRoomFrameController(mf,m2);
			SelectCostumerByRoomFrameView scf = new SelectCostumerByRoomFrameView(mf,c,frf,m.getTmp(),f.sf);
			c.setConnectedView(scf);
			scf.init();
			scf.setVisible(false);
			FrameSwitcher fs2 = new FrameSwitchImpl(frf,scf);
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (FreeRoomsFrameView) f;
	}
}