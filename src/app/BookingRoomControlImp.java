package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ListModel;

import gui.SimpleTime;
import db.DBBookingRoom;
import db.entities.BookingRoom;
import db.entities.Customer;
import db.entities.Room;


public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public Vector<BookingRoom> getAll() throws SQLException {
		ResultSet resultset = new BookingRoom().getAll();
		
	}

	@Override
	public Vector<Room> getFreeRoom(Date startDate, Date endDate) {
		DBBookingRoom tmp = new BookingRoom();		
		return tmp.getFreeRoom(startDate, endDate);
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
