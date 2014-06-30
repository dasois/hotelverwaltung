package gui.paybooking;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.book.SelectCustomerFrameView;
import gui.book.room.RoomModel;

import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import db.entities.Customer;

public class SelectCustomerController implements IController{
	private VerwaltungMainFrameView mf;
	private SelectCustomerFrameView f;
	private PayBookingModel m;
	private RoomModel rm;
	public SelectCustomerController(VerwaltungMainFrameView mf){
		this.mf = mf;
		m = new PayBookingModel();
		rm = new RoomModel();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="book"){
			m.setCID(f.getSelectedCustomer().getCid());
			
			DefaultListModel<Customer> customerList = new DefaultListModel<>();
			customerList.addElement(f.getSelectedCustomer());
			JList<Customer> Clist = new JList<Customer>(customerList);
			Clist.setSelectedValue(f.getSelectedCustomer(),false);
			rm.setList(Clist);
			
			SelectBookingFrameController c = new SelectBookingFrameController(mf,m,f,rm);
			SelectBookingFrameView bf = new SelectBookingFrameView(c, m);
			bf.init();
			bf.setVisible(false);
			c.setConnectedView(bf);		
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,bf);
			fs.switchFrame();
		}else{
			final FrameSwitcher fs = new gui.FrameSwitchImpl(f,mf);
			fs.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectCustomerFrameView) f;
	}
}