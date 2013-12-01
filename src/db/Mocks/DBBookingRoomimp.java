package db.Mocks;

import gui.SimpleTime;
import app.entities.BookingRoom;
import app.entities.HotelRoom;
import db.DBBookingRoom;

public class DBBookingRoomimp implements DBBookingRoom{

	@Override
	public BookingRoom[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelRoom[] getFreeRoom(SimpleTime startDate, SimpleTime endDate) {
		
		HotelRoom[] h = new HotelRoom[1];
		h[0] = new HotelRoom(1,false,5.5,13);
		
		return h;
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

	@Override
	public HotelRoom[] getBookedRoom(SimpleTime boookedDate) {
		HotelRoom[] h = new HotelRoom[1];
		h[0] = new HotelRoom(1,false,5.5,13);
		
		return h;
	}

}
