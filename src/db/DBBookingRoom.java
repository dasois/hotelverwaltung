/**
 * 
 */
package db;

import gui.SimpleTime;

import java.util.Calendar;

import app.entities.BookingRoom;


/**
 * @author david
 *
 */
public interface DBBookingRoom {
	BookingRoom[] getAll();
	BookingRoom[] getFreeRoom(SimpleTime startDate, SimpleTime endDate);
	BookingRoom[] getBookedRoom(SimpleTime boookedDate);
	int create(BookingRoom br);
	boolean update(int BookingRoomId, BookingRoom br);
	boolean delete(int BookingRoomId);
	
}