package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBookingRoom;
import db.entities.BookingRoom;
import db.entities.Customer;
import db.entities.Room;


public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public Vector<BookingRoom> getAll() throws SQLException {
		ResultSet resultset = new BookingRoom().getAll();
		Vector<BookingRoom> temp = new Vector<BookingRoom>();
		while (resultset.next()) {
			BookingRoom c = new BookingRoom(resultset.getDate(1),resultset.getInt(2),resultset.getInt(3));		
		    temp.add(c);
		}		
		return temp;
	}

	@Override
	public int create(Date date, int roomId, int customerId) throws SQLException {
		DBBookingRoom tmp = new BookingRoom(date, roomId, customerId);		
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
