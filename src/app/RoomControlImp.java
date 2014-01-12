package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import db.DBRoom;
import db.entities.Room;

public class RoomControlImp implements RoomControlInterface{

	@Override
	public Vector<Room> getAll() throws SQLException {
		
		ResultSet resultset = new Room().getAll();
		Vector<Room> temp = new Vector<Room>();
		while (resultset.next()) {
			Room c = new Room(Integer.parseInt(resultset.getString(1)),Double.parseDouble(resultset.getString(2)),Boolean.parseBoolean(resultset.getString(3)));		
		    temp.add(c);
		    }
		return temp;	
		}

	@Override
	public int create(Room room) throws SQLException {
		DBRoom tmp = new Room();
		return tmp.create();
	}

	@Override
	public boolean update(Room room) throws SQLException {
		
		return room.update();
	}

	@Override
	public boolean delete(int RoomId) throws SQLException {
		DBRoom tmp = new Room();
		return tmp.delete();
	}
}
