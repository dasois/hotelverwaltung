package gui;

import gui.book.room.SelectTimeIntervallRoomFrame;
import gui.book.service.SelectTimeFrame;
import gui.create.CreateCostumerFrame;
import gui.create.CreateRoomFrame;
import gui.create.CreateServiceFrame;
import gui.delete.DeleteFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JList;

import app.entities.Customer;
import app.entities.HotelRoom;
import app.entities.Service;

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
				else{
					gui.setEnabled(false);
					DeleteFrame<Customer> dcf = new DeleteFrame<Customer>(gui,"Kunde Entfernen",new JList<Customer>());
					dcf.init();
					new JDialog(dcf);
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
					DeleteFrame<HotelRoom> drf = new DeleteFrame<HotelRoom>(gui,"Zimmer Entfernen",new JList<HotelRoom>());
					drf.init();
					new JDialog(drf);
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
					DeleteFrame<Service> dsf = new DeleteFrame<Service>(gui,"Service Entfernen",new JList<Service>());
					dsf.init();
					new JDialog(dsf);
				}
			}
		}
	}
}