package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBookingRoom;
import db.entities.BookingRoom;


public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public Vector<BookingRoom> getAll() throws SQLException {
		ResultSet resultset = new BookingRoom().getAll();
		//TODO: implement
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
