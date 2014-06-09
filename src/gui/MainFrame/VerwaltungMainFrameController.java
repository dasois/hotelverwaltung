package gui.MainFrame;

import gui.ShowCustomer.ShowCustomerFrameView;
import gui.book.SelectCustomerFrameView;
import gui.book.room.SelectTimeIntervallRoomFrame;
import gui.book.service.SelectTimeFrameView;
import gui.create.CreateCostumerFrameView;
import gui.create.CreateRoomFrameView;
import gui.create.CreateServiceFrameView;
import gui.delete.DeleteFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JList;

import app.CustomerControlImp;
import app.RoomControlImp;
import app.ServiceControlImp;
import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;

/**Buttonhandler of VerwaltungsMainFrame
 * @author Tobias */
public class VerwaltungMainFrameController implements ActionListener {
	private VerwaltungMainFrameView gui;
	public VerwaltungMainFrameController(VerwaltungMainFrameView gui){
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("action")){
			String khd = (String)gui.khd.getSelectedItem();
			String action = (String)gui.actions.getSelectedItem();
			if(khd=="Kunden"){
				if(action == "Erstellen"){
					gui.setEnabled(false);
					CreateCostumerFrameView cf = new CreateCostumerFrameView(gui);
					cf.init();
					new JDialog(cf);
				}
				else if(action =="Löschen"){
					gui.setEnabled(false);
					DeleteFrameView<Customer> dcf;
					//TODO sinnvolle exception
					try {
						dcf = new DeleteFrameView<Customer>(gui,"Kunde Entfernen",new JList<Customer>(new CustomerControlImp().getAll()));
						dcf.init();
						new JDialog(dcf);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
				}else if(action =="Anzeigen"){
					gui.setEnabled(false);
					ShowCustomerFrameView scf = new ShowCustomerFrameView(gui);
					scf.init();
					new JDialog(scf);
				}
				else{
					gui.setEnabled(false);
					SelectCustomerFrameView scf = new SelectCustomerFrameView(gui);
					scf.init();
					new JDialog(scf);
				}
			}
			else if(khd=="Zimmer"){
				if(action == "Erstellen"){
					gui.setEnabled(false);
					CreateRoomFrameView rf = new CreateRoomFrameView(gui);
					rf.init();
					new JDialog(rf);
				}
				else if(action =="Buchen"){
					gui.setEnabled(false);
					SelectTimeIntervallRoomFrame rf = new SelectTimeIntervallRoomFrame(gui);
					rf.init();
					new JDialog(rf);
				}
				else{
					gui.setEnabled(false);
					DeleteFrameView<Room> drf;
					//TODO sinnvolle Exception
					try {
						drf = new DeleteFrameView<Room>(gui,"Zimmer Entfernen",new JList<Room>(new RoomControlImp().getAll()));
						drf.init();
						new JDialog(drf);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			else if(khd=="Leistung"){
				if(action == "Erstellen"){
					gui.setEnabled(false);
					CreateServiceFrameView sf = new CreateServiceFrameView(gui);
					sf.init();
					new JDialog(sf);
				}
				else if(action =="Buchen"){
					gui.setEnabled(false);
					SelectTimeFrameView rf = new SelectTimeFrameView(gui);
					rf.init();
					new JDialog(rf);
				}
				else{
					gui.setEnabled(false);
					DeleteFrameView<Service> dsf;
					//TODO sinnvolle Exception
					try {
						dsf = new DeleteFrameView<Service>(gui,"Service Entfernen",new JList<Service>(new ServiceControlImp().getAll()));
						dsf.init();
						new JDialog(dsf);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
}