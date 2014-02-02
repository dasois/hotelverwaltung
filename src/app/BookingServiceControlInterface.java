package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Customer;
import db.entities.Room;
import db.entities.Service;


public interface BookingServiceControlInterface {
	Vector<BookingService> getAll() throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingService br);
	int create(Date date, BookingRoom br, Service serv) throws SQLException;
}
