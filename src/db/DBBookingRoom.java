/**
 * 
 */
package db;
import app.BookingRoom;

/**
 * @author david
 *
 */
public interface DBBookingRoom {
	JTableview getAll();
	int create(BookingRoom br);
	boolean update(int BookingRoomId, BookingRoom br);
	boolean delete(int BookingRoomId);
}