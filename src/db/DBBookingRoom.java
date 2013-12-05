/**
 * 
 */
package db;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.BookingRoom;

/**
 * @author david
 *
 */
public interface DBBookingRoom {
	ResultSet getAll() throws SQLException;
	int create(BookingRoom br) throws SQLException;
	boolean update(int newBookingRoomId, BookingRoom br) throws SQLException;
	boolean delete(int bookingRoomId) throws SQLException;
}