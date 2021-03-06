package gui.create;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Calendar;

import app.CustomerControlImp;
import app.CustomerControlInterface;
import app.entities.Title;

public class CreateCostumerFrameController implements IController{
	private CreateCostumerFrameView ccf;
	private VerwaltungMainFrameView vmf;
	private CreateCustomerModel m;
	private CustomerControlInterface tmp = new CustomerControlImp();
	private int id;
	public CreateCostumerFrameController(CreateCostumerFrameView ccf,VerwaltungMainFrameView vmf,CreateCustomerModel m){
		this.ccf = ccf;
		this.vmf = vmf;
		this.m = m;
	}
	public CreateCostumerFrameController(VerwaltungMainFrameView vmf,CreateCustomerModel m){
		this.vmf = vmf;
		this.m = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new gui.FrameSwitchImpl(ccf,vmf);
		if(e.getActionCommand()=="Cancel"){
			try {
				tmp.discardChanges();
			} catch (SQLException e1){
				vmf.addProtocolLine("Es konnte kein Kunde erstellt werden, rufen sie ihren Administrator");
			}
			fs.switchFrame();
		}else if(e.getActionCommand()=="Revise"){
			ccf.createWidgetFirstView();
		}else if(e.getActionCommand()=="Create"){
			try {
				Calendar bday = Calendar.getInstance();
				bday.setTime(m.getBirthdayPicker().getDate());
				id = tmp.create(m.getCustomerFirstNameInput().getText(),
						m.getCustomerLastNameInput().getText(),m.getAddressInput().getText(),new java.sql.Date(bday.getTime().getTime()),
						(Title)m.getTitleSelection().getSelectedItem());
				
			} catch (SQLException e1) {
				vmf.addProtocolLine("Es konnte kein Kunde erstellt werden, rufen sie ihren Administrator");
			}catch (NullPointerException e2) {
				vmf.addProtocolLine("Fehlerhafte eingabe, es wurde kein Kunde Angelegt.\nVergewissern sie sich das alle Felder ausgef�llt werden!");
			}
			ccf.createWidgetSecondView();
		}else{
			try {
				vmf.addProtocolLine("Kunde mit Id: "+id
						+"\n Namens: "+m.getCustomerLastNameInput().getText()+" wurde in der Datenbank angelegt\n");
				tmp.saveChanges();
			} catch (SQLException e1) {
				vmf.addProtocolLine("Es konnte kein Kunde erstellt werden, rufen sie ihren Administrator");
			}
			fs.switchFrame();
		}
	}
	@Override
	public void setConnectedView(AbstractFrame f) {
		this.ccf = (CreateCostumerFrameView) f;	
	}
}