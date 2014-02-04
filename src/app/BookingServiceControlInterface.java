package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;
import db.entities.BookingService;

public interface BookingServiceControlInterface {
	Vector<BookingService> getAll() throws SQLException;

	boolean delete(int BookingRoomId) throws SQLException;

	boolean update(BookingService br);

	int create(Date date, BookingRoom br, int serviceId) throws SQLException;
}
