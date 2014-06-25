package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.Booking;
import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Customer;

public interface BookingInterface extends TransactionInterface {
	Vector<Booking>  getAll() throws SQLException;

	Vector<Booking> getAllByCustomer(int CustomerId) throws SQLException;

	Vector<BookingService> getRelatedServiceBookings(int bid) throws SQLException;

	Vector<BookingRoom> getRelatedRoomBookings(int bid) throws SQLException;

	int create(Customer customer, Date createdOn) throws SQLException;

	boolean update(Booking b) throws SQLException;

	boolean delete(int bookingID) throws SQLException;
}
