package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;
import db.entities.BookingRoom;
import db.entities.Room;




public interface BookingRoomControlInterface {
	Vector<BookingRoom> getAll() throws SQLException;
	Vector<Room> getFreeRoom(Date startDate, Date endDate);
	Vector<Room>getBookedRoom(Date boookedDate);
	int create(BookingRoom br) throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
}
