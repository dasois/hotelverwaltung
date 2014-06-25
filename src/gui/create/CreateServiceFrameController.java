package gui.create;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import app.ServiceControlImp;
import app.ServiceControlInterface;

public class CreateServiceFrameController implements IController {
	private CreateServiceFrameView csf;
	private VerwaltungMainFrameView mf;
	private CreateServiceModel m;
	public CreateServiceFrameController(CreateServiceFrameView csf, VerwaltungMainFrameView mf,CreateServiceModel m){
		this.csf = csf;
		this.mf = mf;
		this.m = m;
	}
	public CreateServiceFrameController(VerwaltungMainFrameView mf,CreateServiceModel m){
		this.mf = mf;
		this.m = m;
	}
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(csf,mf);
		if(e.getActionCommand()=="Revise"){
			csf.createWidgetFirstView();
		}else if (e.getActionCommand()=="cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Create"){
			csf.createWidgetSecondView();
		}else{
			ServiceControlInterface controller = new ServiceControlImp();
			//TODO
			try {
				int sid = controller.create(m.getName().getText(),Double.parseDouble(m.getPrice().getText()));
				mf.addProtocolLine("Service:\n"+sid+" "+m.getName().getText()+" wurde in der Datenbank angelegt\n");

			} catch (NumberFormatException e1) {
				mf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Service Angelegt.\nVergewissern sie sich das alle Felder ausgef�llt werden!");
			} catch (SQLException e1) {
				mf.addProtocolLine("Es konnte kein Service erstellt werden, rufen sie ihren Administrator");
			}
			
			fs.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.csf = (CreateServiceFrameView) f;
	}
}