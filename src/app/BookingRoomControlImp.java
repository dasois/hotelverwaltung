package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBookingRoom;
import db.entities.BookingRoom;
import db.entities.Customer;
/** Implementation of BookingRoomControlInterface */
public class BookingRoomControlImp extends AbstractTransactionController implements BookingRoomControlInterface{

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
	public int create(Date date, int roomId,int bookingId) throws SQLException {
		DBBookingRoom tmp = new BookingRoom(date,roomId,bookingId);		
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