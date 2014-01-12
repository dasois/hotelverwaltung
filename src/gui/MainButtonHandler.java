package gui;

import gui.book.room.SelectTimeIntervallRoomFrame;
import gui.book.service.SelectTimeFrame;
import gui.create.CreateCostumerFrame;
import gui.create.CreateRoomFrame;
import gui.create.CreateServiceFrame;
import gui.delete.DeleteFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JList;

import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;
import app.CustomerControlImp;
import app.RoomControlImp;
import app.ServiceControlImp;




public class MainButtonHandler implements ActionListener {
	private VerwaltungMainFrame gui;
	public MainButtonHandler(VerwaltungMainFrame gui){
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
					CreateCostumerFrame cf = new CreateCostumerFrame(gui);
					cf.init();
					new JDialog(cf);
										
				}
				else if(action =="Löschen"){
					gui.setEnabled(false);
					DeleteFrame<Customer> dcf;
					//TODO sinnvolle exception
					try {
						dcf = new DeleteFrame<Customer>(gui,"Kunde Entfernen",new JList<Customer>(new CustomerControlImp().getAll()));
						dcf.init();
						new JDialog(dcf);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
				}else{
					gui.setEnabled(false);
					ShowCustomerFrame scf = new ShowCustomerFrame(gui);
					scf.init();
					new JDialog(scf);
				}
			}
			else if(khd=="Zimmer"){
				if(action == "Erstellen"){				
					gui.setEnabled(false);
					CreateRoomFrame rf = new CreateRoomFrame(gui);
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
					DeleteFrame<Room> drf;
					//TODO sinnvolle Exception
					try {
						drf = new DeleteFrame<Room>(gui,"Zimmer Entfernen",new JList<Room>(new RoomControlImp().getAll()));
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
					CreateServiceFrame sf = new CreateServiceFrame(gui);
					sf.init();
					new JDialog(sf);	
					
				}
				else if(action =="Buchen"){
					gui.setEnabled(false);
					SelectTimeFrame rf = new SelectTimeFrame(gui);
					rf.init();
					new JDialog(rf);
				}
				else{
					gui.setEnabled(false);
					DeleteFrame<Service> dsf;
					//TODO sinnvolle Exception
					try {
						dsf = new DeleteFrame<Service>(gui,"Service Entfernen",new JList<Service>(new ServiceControlImp().getAll()));
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