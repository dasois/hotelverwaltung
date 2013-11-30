/**
 * 
 */
package db;

import app.entities.BookingService;

/**
 * @author david
 *
 */
public interface DBBookingService {
	BookingService[] getAll();
	int create(BookingService bs);
	boolean update(int BookingServiceId, BookingService bs);
	boolean delete(int BookingServiceId);
}