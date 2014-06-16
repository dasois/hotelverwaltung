package gui.combinedbooking;



import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.room.FreeRoomsFrameModel;
import gui.book.room.FreeRoomsFrameView;
import gui.book.room.RoomModel;
import gui.book.room.SelectCostumerByRoomFrameView;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import db.entities.Room;

public class FreeRoomsFrameController implements IController{
	private FreeRoomsFrameView f;
	private VerwaltungMainFrameView mf;
	private FreeRoomsFrameModel m;
	private RoomModel m2;
	public FreeRoomsFrameController(VerwaltungMainFrameView mf,RoomModel m2){
		this.mf = mf;
		m = new FreeRoomsFrameModel();
		this.m2 = m2;
	}
	public FreeRoomsFrameController(VerwaltungMainFrameView mf){
		this.mf = mf;
		m = new FreeRoomsFrameModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,f.sf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(f.list.getSelectedValuesList().isEmpty()){
			JOptionPane.showMessageDialog(null, "Wähle mindestens ein freies Zimmer");
		}else{
			m.setTmp(f.list.getSelectedValuesList().toArray(new Room[0]));
			m2.setSelectedRooms(m.getTmp());
			SelectCostumerByRoomFrameController c = new SelectCostumerByRoomFrameController(mf,m2,f);
			SelectCostumerByRoomFrameView scf = new SelectCostumerByRoomFrameView(mf,c,m2);
			c.setConnectedView(scf);
			scf.init();
			scf.setVisible(false);
			FrameSwitcher fs2 = new FrameSwitchImpl(f,scf);
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (FreeRoomsFrameView) f;
	}
}