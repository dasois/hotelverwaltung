package gui.create;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.ServiceControlImp;
import app.ServiceControlInterface;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

public class CreateServiceFrameController implements ActionListener {
	private CreateServiceFrameView csf;
	private VerwaltungMainFrameView mf;
	private CreateServiceFrameModel m;
	public CreateServiceFrameController(CreateServiceFrameView csf, VerwaltungMainFrameView mf,CreateServiceFrameModel m){
		this.csf = csf;
		this.mf = mf;
		this.m = m;
	}

	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(csf,mf);
		if(e.getActionCommand()=="Revise"){
			csf.createWidgetFirstView();
		}else if (e.getActionCommand()=="accept"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Create"){
			csf.createWidgetSecondView();
		}else{
			ServiceControlInterface controller = new ServiceControlImp();
			//TODO
			try {
				int sid = controller.create(csf.getName(),Double.parseDouble(m.getPrice().getText()));
				mf.addProtocolLine("Service:\n"+sid+" "+csf.getName()+" wurde in der Datenbank angelegt\n");

			} catch (NumberFormatException e1) {
				mf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Service Angelegt.\nVergewissern sie sich das alle Felder ausgefüllt werden!");
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Kunde erstellt werden, rufen sie ihren Administrator");
			}
			
			fs.switchFrame();
		}
	}
}