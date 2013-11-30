package app;
import app.entities.HotelRoom;

public interface RoomControlInterface {
	HotelRoom[] getAll();
	int create(HotelRoom room);
	boolean update(int RoomId, HotelRoom room);
	boolean delete(int RoomId);
}
