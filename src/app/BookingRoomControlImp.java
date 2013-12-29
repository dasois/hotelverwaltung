package app;

import javax.swing.ListModel;

import gui.SimpleTime;
import db.DBBookingRoom;
import db.Mocks.DBBookingRoomimp;
import app.entities.BookingRoom;
import app.entities.HotelRoom;

public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public BookingRoom[] getAll() {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.getAll();
	}

	@Override
	public HotelRoom[] getFreeRoom(SimpleTime startDate, SimpleTime endDate) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.getFreeRoom(startDate, endDate);
	}
	public HotelRoom[] getBookedRoom(SimpleTime boookedDate) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.getBookedRoom(boookedDate);
	}

	@Override
	public int create(BookingRoom br) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.create();
	}

	@Override
	public boolean update(int BookingRoomId, BookingRoom br) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.update(BookingRoomId, br);
	}

	@Override
	public boolean delete(int BookingRoomId) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.delete();
	}

}
