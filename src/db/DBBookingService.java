/**
 * 
 */
package db;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.BookingService;

/**
 * @author david
 *
 */
public interface DBBookingService {
	ResultSet getAll() throws SQLException;
	int create(BookingService bs) throws SQLException;
	boolean update(int newBookingServiceId, BookingService bs) throws SQLException;
	boolean delete(int bookingServiceId) throws SQLException;
}