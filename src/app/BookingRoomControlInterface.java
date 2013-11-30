package app;

import java.util.Calendar;

import app.entities.BookingRoom;

public interface BookingRoomControlInterface {
	BookingRoom[] getAll();
	BookingRoom[] getFreeRoom(Calendar startDate, Calendar endDate);
	int create(BookingRoom br);
	boolean update(int BookingRoomId, BookingRoom br);
	boolean delete(int BookingRoomId);
}
