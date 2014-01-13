package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import db.DBRoom;
import db.entities.Room;

public class RoomControlImp implements RoomControlInterface{

	public Vector<Room> getAll() throws SQLException {
		
		ResultSet resultset = new Room().getAll();
		Vector<Room> temp = new Vector<Room>();
		while (resultset.next()) {
			Room c = new Room(Integer.parseInt(resultset.getString(1)),Double.parseDouble(resultset.getString(2)),Boolean.parseBoolean(resultset.getString(3)));		
			temp.add(c);
		    }
		return temp;	
		}

	public int create(double price, boolean isDoubleRoom) throws SQLException {
		DBRoom room = new Room(price, isDoubleRoom);
		room.create();
		return room.getRid();
	}

	public boolean update(Room room) throws SQLException {
		
		return room.update();
	}

	public boolean delete(int RoomId) throws SQLException {
		DBRoom tmp = new Room(RoomId);
		return tmp.delete();
	}
}
