package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.Room;
/** interface for using the db from inside the app-layer
*	This is for the entity room*/
public interface RoomControlInterface {
	Vector<Room> getAll() throws SQLException;
	Vector<Room> getFreeRooms(Date startDate, Date endDate) throws SQLException;
	int create(double price, boolean isDoubleRoom ) throws SQLException;
	boolean delete(int RoomId) throws SQLException;
	boolean update(Room room) throws SQLException;
}