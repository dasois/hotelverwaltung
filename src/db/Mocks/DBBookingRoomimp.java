package db.Mocks;

import java.util.Calendar;

import app.entities.BookingRoom;
import db.DBBookingRoom;

public class DBBookingRoomimp implements DBBookingRoom{

	@Override
	public BookingRoom[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingRoom[] getFreeRoom(Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(BookingRoom br) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(int BookingRoomId, BookingRoom br) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int BookingRoomId) {
		// TODO Auto-generated method stub
		return false;
	}

}
