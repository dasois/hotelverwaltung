package gui.book.room;

import javax.swing.JList;

import com.toedter.calendar.JDateChooser;

import db.entities.Customer;
import db.entities.Room;
import app.entities.State;
import gui.IModel;

public class RoomModel implements IModel{
	private JDateChooser startDatePicker;
	private JDateChooser endDatePicker;
	private double totalPrice;
	private Customer customer;
	private  Room[] selectedRooms;
	private JList<Customer> list;
	public boolean checkCorrespondingState(State s) {
		return State.Zimmer==s;
	}
	public JDateChooser getStartDatePicker() {
		return startDatePicker;
	}
	public void setStartDatePicker(JDateChooser startDatePicker) {
		this.startDatePicker = startDatePicker;
	}
	public JDateChooser getEndDatePicker() {
		return endDatePicker;
	}
	public void setEndDatePicker(JDateChooser endDatePicker) {
		this.endDatePicker = endDatePicker;
	}
	public Room[] getSelectedRooms() {
		return selectedRooms;
	}

	public void setSelectedRooms(Room[] selectedRooms) {
		this.selectedRooms = selectedRooms;
	}
	public Customer getCustomer() {
		return list.getSelectedValue();
	}
	public void setCustomer(Customer c) {
		this.customer = c;
	
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public JList<Customer> getList() {
		return list;
	}
	public void setList(JList<Customer> list) {
		this.list = list;
	}
}
