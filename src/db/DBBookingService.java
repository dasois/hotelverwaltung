/**
 * 
 */
package db;
import app.BookingService;

/**
 * @author david
 *
 */
public interface DBBookingService {
	JTableview getAll();
	int create(BookingService bs);
	boolean update(int BookingServiceId, BookingService bs);
	boolean delete(int BookingServiceId);
}