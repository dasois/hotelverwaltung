package app;


import java.sql.SQLException;
import java.util.Vector;
import db.entities.Room;


public interface RoomControlInterface {
	Vector<Room> getAll() throws SQLException;
	int create(Room room) throws SQLException;
	boolean delete(int RoomId) throws SQLException;
	boolean update(Room room) throws SQLException;
}
