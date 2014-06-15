package gui.book.room;

import com.toedter.calendar.JDateChooser;

import db.entities.Customer;
import db.entities.Room;
import app.entities.State;
import gui.IModel;

public class RoomModel implements IModel{
	private JDateChooser startDatePicker;
	private JDateChooser endDatePicker;
	private Customer customer;
	private  Room[] selectedRooms;
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
		return customer;
	}
	public void setCustomer(Customer c) {
		this.customer = c;
	}
}
