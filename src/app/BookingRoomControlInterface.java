package app;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.entities.BookingRoom;
import gui.SimpleTime;



public interface BookingRoomControlInterface {
	ResultSet getAll() throws SQLException;
	ResultSet getFreeRoom(SimpleTime startDate, SimpleTime endDate);
	ResultSet getBookedRoom(SimpleTime boookedDate);
	int create(BookingRoom br) throws SQLException;
	boolean delete(int BookingRoomId) throws SQLException;
	boolean update(BookingRoom br);
}
