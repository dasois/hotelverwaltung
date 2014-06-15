package gui.book.service;

import javax.swing.JList;

import db.entities.BookingRoom;
import app.entities.State;
import gui.IModel;

public class ServiceModel implements IModel{
	private JList<BookingRoom> list;
	
	public boolean checkCorrespondingState(State s) {
		return State.Dienstleistung==s;
	}
	

	public JList<BookingRoom> getList() {
		return list;
	}

	public void setList(JList<BookingRoom> list) {
		this.list = list;
	}
}
