package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBookingRoom;
import db.entities.BookingRoom;
import db.entities.BookingService;
/** Implementation of BookingRoomControlInterface */
public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public Vector<BookingRoom> getAll() throws SQLException {
		ResultSet resultset = new BookingRoom().getAll();
		Vector<BookingRoom> temp = new Vector<BookingRoom>();
		while (resultset.next()) {
			BookingRoom c = new BookingRoom(resultset.getInt(1),resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));
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

	@Override
	public Vector<BookingRoom> getAllFromCustomer(int CustomerId)throws SQLException {
		ResultSet resultset = new BookingRoom().getAllFromCustomer(CustomerId);
		Vector<BookingRoom> temp = new Vector<BookingRoom>();
		while (resultset.next()) {
			BookingRoom c = new BookingRoom(resultset.getInt(1),resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));
			temp.add(c);
		}
		return temp;
	}

	@Override
	public Vector<BookingService> getRelatedServiceBookings(int bookingRoomId)throws SQLException {
		ResultSet resultset = new BookingRoom(bookingRoomId).getRelatedServiceBookings();
		Vector<BookingService> temp = new Vector<BookingService>();
		while (resultset.next()) {
			BookingService c = new BookingService(resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));
			temp.add(c);
		}
		return temp;
	}
}