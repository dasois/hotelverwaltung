package gui.create;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import app.RoomControlImp;
import app.RoomControlInterface;

public class CreateRoomFrameController implements IController{
	private CreateRoomFrameView crf;
	private VerwaltungMainFrameView mf;
	private CreateRoomModel m;
	private RoomControlInterface controller = null;
	public CreateRoomFrameController(CreateRoomFrameView crf,VerwaltungMainFrameView mf,CreateRoomModel m){
		this.crf = crf;
		this.mf = mf;
		this.m = m;
	}
	public CreateRoomFrameController(VerwaltungMainFrameView mf,CreateRoomModel m){
		this.mf = mf;
		this.m = m;
	}

	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(crf,mf);
		if(e.getActionCommand()=="Revise"){
			try {
				controller.discardChanges();
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Zimmer erstellt werden, rufen sie ihren Administrator");
			}
			crf.createWidgetFirstView();
		}else if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Create"){
			controller = new RoomControlImp();
			//TODO sinnvolle exception
			try {
				int roomId = controller.create(Double.parseDouble(m.getPrice().getText()),m.getDoubleRoomCheck().isSelected());
				mf.addProtocolLine("Zimmer: "+roomId+" wurde mit dem Preis: "+Double.parseDouble(m.getPrice().getText())
						+"€ in der Datenbank angelegt\n");
				fs.switchFrame();
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Zimmer erstellt werden, rufen sie ihren Administrator");
			}catch (NumberFormatException e1) {
				mf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Zimmer Angelegt.\nVergewissern sie sich das alle Felder ausgefï¿½llt werden!");
			}
			crf.createWidgetSecondView();
		}else{
			try {
				controller.saveChanges();
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Zimmer erstellt werden, rufen sie ihren Administrator");
			}
			fs.switchFrame();
		}
	}
	@Override
	public void setConnectedView(AbstractFrame f) {
		this.crf = (CreateRoomFrameView) f;	
	}
}