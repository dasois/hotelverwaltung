package gui.book.service;

import javax.swing.JList;

import com.toedter.calendar.JDateChooser;

import db.entities.BookingRoom;
import db.entities.Service;
import app.entities.State;
import gui.IModel;

public class ServiceModel implements IModel{
	private JList<BookingRoom> bookedRoomList;
	private JList<Service> serviceList;
	private JDateChooser datePicker;
	
	public boolean checkCorrespondingState(State s) {
		return State.Dienstleistung==s;
	}

	public JList<BookingRoom> getList() {
		return bookedRoomList;
	}

	public void setList(JList<BookingRoom> list) {
		this.bookedRoomList = list;
	}

	public JList<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(JList<Service> serviceList) {
		this.serviceList = serviceList;
	}


	public JDateChooser getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDateChooser datePicker) {
		this.datePicker = datePicker;
	}
}