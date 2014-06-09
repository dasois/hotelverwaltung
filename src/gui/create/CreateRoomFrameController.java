package gui.create;

import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.RoomControlImp;
import app.RoomControlInterface;

public class CreateRoomFrameController implements ActionListener{
	private CreateRoomFrameView crf;
	private VerwaltungMainFrameView mf;
	private CreateRoomFrameModel m;
	public CreateRoomFrameController(CreateRoomFrameView crf,VerwaltungMainFrameView mf,CreateRoomFrameModel m){
		this.crf = crf;
		this.mf = mf;
		this.m = m;
	}


	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(crf,mf);
		if(e.getActionCommand()=="Revise"){
			crf.createWidgetFirstView();
		}else if(e.getActionCommand()=="accept"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Create"){
			crf.createWidgetSecondView();
		}else{
			RoomControlInterface controller = new RoomControlImp();
			//TODO sinnvolle exception
			try {
				int roomId = controller.create(Double.parseDouble(m.getPrice().getText()),m.getDoubleRoomCheck().isSelected());
				mf.addProtocolLine("Zimmer: "+roomId+" wurde mit dem Preis: "+Double.parseDouble(m.getPrice().getText())
						+"€ in der Datenbank angelegt\n");
				fs.switchFrame();
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Zimmer erstellt werden, rufen sie ihren Administrator");
			}catch (NumberFormatException e1) {
				mf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Zimmer Angelegt.\nVergewissern sie sich das alle Felder ausgefüllt werden!");
			}
			fs.switchFrame();
		}
	}
}