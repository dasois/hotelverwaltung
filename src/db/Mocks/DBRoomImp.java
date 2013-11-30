package db.Mocks;

import app.entities.HotelRoom;
import db.DBRoom;

public class DBRoomImp implements DBRoom{

	@Override
	public int create(HotelRoom room) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(int RoomId, HotelRoom room) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int RoomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HotelRoom[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
