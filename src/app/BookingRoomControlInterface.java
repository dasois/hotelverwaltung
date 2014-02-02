package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Customer;
import db.entities.Room;
/** interface for using the db from inside the app-layer
*	This is for the entity bookingroom
*/
public interface BookingRoomControlInterface {
	Vector<BookingRoom> getAll() throws SQLException;
	Vector<BookingRoom> getAllFromCustomer(int CustomerId) throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
	Vector<BookingService> getRelatedServiceBookings(int bookingRoomId)	throws SQLException;
	int create(Date date, Room room, Customer customer) throws SQLException;
}