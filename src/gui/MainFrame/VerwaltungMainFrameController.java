package gui.MainFrame;

import gui.AbstractFrame;
import gui.IController;
import gui.ShowCustomer.ShowCustomerFrameView;
import gui.book.SelectCustomerFrameController;
import gui.book.SelectCustomerFrameView;

import gui.book.room.RoomModel;
import gui.book.room.SelectTimeIntervallRoomFrame;
import gui.book.service.SelectTimeFrameView;
import gui.create.CreateCostumerFrameController;
import gui.create.CreateCustomerModel;
import gui.create.CreateCostumerFrameView;
import gui.create.CreateRoomFrameController;
import gui.create.CreateRoomModel;
import gui.create.CreateRoomFrameView;
import gui.create.CreateServiceFrameController;
import gui.create.CreateServiceModel;
import gui.create.CreateServiceFrameView;
import gui.delete.DeleteFrameController;
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
public class VerwaltungMainFrameController implements IController {
	private VerwaltungMainFrameView gui;
	public VerwaltungMainFrameController(VerwaltungMainFrameView gui){
		this.gui = gui;
	}
	public VerwaltungMainFrameController(){
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("action")){
			String khd = (String)gui.khd.getSelectedItem();
			String action = (String)gui.actions.getSelectedItem();
			if(khd=="Kunden"){
				if(action == "Erstellen"){
					gui.setEnabled(false);
					CreateCustomerModel m = new CreateCustomerModel();
					CreateCostumerFrameController c = new CreateCostumerFrameController(gui,m);
					CreateCostumerFrameView cf = new CreateCostumerFrameView(gui,c,m);
					c.setConnectedView(cf);
					cf.init();
					new JDialog(cf);
				}
				else if(action =="L�schen"){
					gui.setEnabled(false);
					DeleteFrameController<Customer> c = new DeleteFrameController<Customer>(gui);
					DeleteFrameView<Customer> dcf;
					//TODO sinnvolle exception
					try {
						dcf = new DeleteFrameView<Customer>(gui,c,"Kunde Entfernen",new JList<Customer>(new CustomerControlImp().getAll()));
						c.setConnectedView(dcf);
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
				else if(action =="Einbuchen"){
					gui.setEnabled(false);
					RoomModel m = new RoomModel();
					IController c = new gui.combinedbooking.SelectTimeIntervallRoomFrameController(gui, m);
					SelectTimeIntervallRoomFrame scf = new SelectTimeIntervallRoomFrame(gui,c,m);
					c.setConnectedView(scf);
					scf.init();
					new JDialog(scf);
				}
				else{
					gui.setEnabled(false);
					IController c = new SelectCustomerFrameController(gui);
					SelectCustomerFrameView scf = new SelectCustomerFrameView(gui,c);
					c.setConnectedView(scf);
					scf.init();
					new JDialog(scf);
				}
			}
			else if(khd=="Zimmer"){
				if(action == "Erstellen"){
					gui.setEnabled(false);
					CreateRoomModel m = new CreateRoomModel();
					CreateRoomFrameController c = new CreateRoomFrameController(gui, m);
					CreateRoomFrameView rf = new CreateRoomFrameView(gui,c,m);
					c.setConnectedView(rf);
					rf.init();
					new JDialog(rf);
				}
				else if(action =="Buchen"){
					gui.setEnabled(false);
					RoomModel m = new RoomModel();
					IController c = new gui.book.room.SelectTimeIntervallRoomFrameController(gui, m);
					SelectTimeIntervallRoomFrame rf = new SelectTimeIntervallRoomFrame(gui,c,m);
					c.setConnectedView(rf);
					rf.init();
					new JDialog(rf);
				}
				else{
					gui.setEnabled(false);
					DeleteFrameController<Room> c= new DeleteFrameController<>(gui);
					DeleteFrameView<Room> drf;
					//TODO sinnvolle Exception
					try {
						drf = new DeleteFrameView<Room>(gui,c,"Zimmer Entfernen",new JList<Room>(new RoomControlImp().getAll()));
						c.setConnectedView(drf);
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
					CreateServiceModel m = new CreateServiceModel();
					CreateServiceFrameController c = new CreateServiceFrameController(gui, m);
					CreateServiceFrameView sf = new CreateServiceFrameView(gui,c,m);
					c.setConnectedView(sf);
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
					DeleteFrameController<Service> c = new DeleteFrameController<>(gui);
					DeleteFrameView<Service> dsf;
					//TODO sinnvolle Exception
					try {
						dsf = new DeleteFrameView<Service>(gui,c,"Service Entfernen",new JList<Service>(new ServiceControlImp().getAll()));
						c.setConnectedView(dsf);
						dsf.init();
						new JDialog(dsf);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	@Override
	public void setConnectedView(AbstractFrame f) {
		this.gui = (VerwaltungMainFrameView) f;
	}
}