package app;

import db.DBRoom;
import db.Mocks.DBRoomImp;
import app.entities.HotelRoom;
public class RoomControlImp implements RoomControlInterface{

	@Override
	public HotelRoom[] getAll() {
		DBRoom tmp = new DBRoomImp();
		return tmp.getAll();
	}

	@Override
	public int create(HotelRoom room) {
		DBRoom tmp = new DBRoomImp();
		return tmp.create();
	}

	@Override
	public boolean update(int RoomId, HotelRoom room) {
		DBRoom tmp = new DBRoomImp();
		return tmp.update(RoomId, room);
	}

	@Override
	public boolean delete(int RoomId) {
		DBRoom tmp = new DBRoomImp();
		return tmp.delete();
	}

}
