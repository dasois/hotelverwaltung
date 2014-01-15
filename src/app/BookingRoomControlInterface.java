package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;
import db.entities.Customer;
import db.entities.Room;


public interface BookingRoomControlInterface {
	Vector<BookingRoom> getAll() throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
	int create(Date date, int roomId, int customerId) throws SQLException;
}
