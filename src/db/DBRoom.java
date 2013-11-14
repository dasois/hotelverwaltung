/**
 * 
 */
package db;
import app.Room;

/**
 * @author david
 *
 */
public interface DBRoom {
	JTableview getAll();
	int create(Room room);
	boolean update(int RoomId, Room room);
	boolean delete(int RoomId);
}