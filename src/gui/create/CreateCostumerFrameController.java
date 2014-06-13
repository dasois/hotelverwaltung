package gui.create;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import app.CustomerControlImp;
import app.CustomerControlInterface;
import app.entities.Title;

public class CreateCostumerFrameController implements IController{
	private CreateCostumerFrameView ccf;
	private VerwaltungMainFrameView vmf;
	private CreateCostumerFrameModel m;
	public CreateCostumerFrameController(CreateCostumerFrameView ccf,VerwaltungMainFrameView vmf,CreateCostumerFrameModel m){
		this.ccf = ccf;
		this.vmf = vmf;
		this.m = m;
	}
	public CreateCostumerFrameController(VerwaltungMainFrameView vmf,CreateCostumerFrameModel m){
		this.vmf = vmf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(ccf,vmf);
		if(e.getActionCommand()=="Cancel"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Revise"){
			ccf.createWidgetFirstView();
		}else if(e.getActionCommand()=="Create"){
			ccf.createWidgetSecondView();
		}else{
			CustomerControlInterface tmp = new CustomerControlImp();
			try {
				int id = tmp.create(m.getCustomerFirstNameInput().getText(),
						m.getCustomerLastNameInput().getText(),m.getAddressInput().getText(),new java.sql.Date(m.getBirthdayPicker().getCalendar().getTime().getTime()),
						(Title)m.getTitleSelection().getSelectedItem());
				vmf.addProtocolLine("Kunde mit Id:\n"+id+"\n Namens: "+m.getCustomerLastNameInput().getText()+" wurde in der Datenbank angelegt\n");

			} catch (SQLException e1) {

				vmf.addProtocolLine("Es konnte kein Kunde erstellt werden, rufen sie ihren Administrator");
			}catch (NullPointerException e2) {

				vmf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Kunde Angelegt.\nVergewissern sie sich das alle Felder ausgefüllt werden!");
			}
			fs.switchFrame();
		}
	}
	@Override
	public void setConnectedView(AbstractFrame f) {
		this.ccf = (CreateCostumerFrameView) f;
		
	}
}