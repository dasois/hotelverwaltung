package gui.combinedbooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.room.FreeRoomsFrameView;
import gui.book.room.RoomModel;
import gui.book.room.SelectCostumerByRoomFrameView;
import java.awt.event.ActionEvent;

public class SelectCostumerByRoomFrameController implements IController{
	private SelectCostumerByRoomFrameView f;
	private VerwaltungMainFrameView mf;
	private FreeRoomsFrameView frf;
	private RoomModel m;
	
	public SelectCostumerByRoomFrameController(SelectCostumerByRoomFrameView f, VerwaltungMainFrameView mf,RoomModel m,FreeRoomsFrameView frf){
		this.f = f;
		this.mf = mf;
		this.m = m;
		this.frf = frf;
	}
	public SelectCostumerByRoomFrameController(VerwaltungMainFrameView mf, RoomModel m,FreeRoomsFrameView frf){
		this.mf = mf;
		this.m = m;
		this.frf = frf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,frf);
		WishOfServiceFrame wf;
		WishOfServiceController c = new WishOfServiceController(mf,m);
		wf = new WishOfServiceFrame(c);
		c.setConnectedView(wf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(f,wf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			
			//TODO daten im model speichern
			wf.init();
			wf.setVisible(false);
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectCostumerByRoomFrameView) f;
	}
}