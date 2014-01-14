package app;

import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;


public interface BookingRoomControlInterface {
	Vector<BookingRoom> getAll() throws SQLException;
	int create(BookingRoom br) throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
}
