package app;

import java.util.Calendar;

import db.DBBookingRoom;
import db.Mocks.DBBookingRoomimp;
import app.entities.BookingRoom;

public class BookingRoomControlImp implements BookingRoomControlInterface{

	@Override
	public BookingRoom[] getAll() {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.getAll();
	}

	@Override
	public BookingRoom[] getFreeRoom(Calendar startDate, Calendar endDate) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.getFreeRoom(startDate, endDate);
	}

	@Override
	public int create(BookingRoom br) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.create(br);
	}

	@Override
	public boolean update(int BookingRoomId, BookingRoom br) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.update(BookingRoomId, br);
	}

	@Override
	public boolean delete(int BookingRoomId) {
		DBBookingRoom tmp = new DBBookingRoomimp();		
		return tmp.delete(BookingRoomId);
	}

}
