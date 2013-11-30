package app;

import gui.SimpleTime;

import java.util.Calendar;

import db.DBBookingRoom;
import db.Mocks.DBBookingRoomimp;
import app.entities.BookingRoom;

public interface BookingRoomControlInterface {
	BookingRoom[] getAll();
	BookingRoom[] getFreeRoom(SimpleTime startDate, SimpleTime endDate);
	BookingRoom[] getBookedRoom(SimpleTime boookedDate);
	int create(BookingRoom br);
	boolean update(int BookingRoomId, BookingRoom br);
	boolean delete(int BookingRoomId);
}
