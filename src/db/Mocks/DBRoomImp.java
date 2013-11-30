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
		HotelRoom[] h = new HotelRoom[1];
		h[0] = new HotelRoom(true,2,45,4);
		return h;
	}

}
