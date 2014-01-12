package app;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ListModel;

import gui.SimpleTime;
import db.DBBookingRoom;
import db.entities.BookingRoom;
import db.entities.Room;


public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public ResultSet getAll() throws SQLException {
		DBBookingRoom tmp = new BookingRoom();		
		return tmp.getAll();
	}

	@Override
	public ResultSet getFreeRoom(SimpleTime startDate, SimpleTime endDate) {
		DBBookingRoom tmp = new BookingRoom();		
		return tmp.getFreeRoom(startDate, endDate);
	}
	public ResultSet getBookedRoom(SimpleTime boookedDate) {
		DBBookingRoom tmp = new BookingRoom();		
		return tmp.getBookedRoom(boookedDate);
	}

	@Override
	public int create(BookingRoom br) throws SQLException {
		DBBookingRoom tmp = new BookingRoom();		
		return tmp.create();
	}

	@Override
	public boolean update(BookingRoom br) {
			
		return update(br);
	}

	@Override
	public boolean delete(int BookingRoomId) throws SQLException {
		DBBookingRoom tmp = new BookingRoom(BookingRoomId);		
		return tmp.delete();
	}

}
