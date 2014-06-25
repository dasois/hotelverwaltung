package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;
/** interface for using the db from inside the app-layer
*	This is for the entity bookingroom*/
public interface BookingRoomControlInterface {
	Vector<BookingRoom> getAll() throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
	int create(Date date, int roomId, int serviceId) throws SQLException;
}