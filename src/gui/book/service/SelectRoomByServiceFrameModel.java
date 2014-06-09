package gui.book.service;

import javax.swing.JList;

import db.entities.BookingRoom;

public class SelectRoomByServiceFrameModel {
	private JList<BookingRoom> list;

	public JList<BookingRoom> getList() {
		return list;
	}

	public void setList(JList<BookingRoom> list) {
		this.list = list;
	}
}