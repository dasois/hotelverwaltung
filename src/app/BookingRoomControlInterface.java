package app;

import gui.SimpleTime;
import app.entities.BookingRoom;
import app.entities.HotelRoom;

public interface BookingRoomControlInterface {
	BookingRoom[] getAll();
	HotelRoom[] getFreeRoom(SimpleTime startDate, SimpleTime endDate);
	HotelRoom[] getBookedRoom(SimpleTime boookedDate);
	int create(BookingRoom br);
	boolean update(int BookingRoomId, BookingRoom br);
	boolean delete(int BookingRoomId);
}