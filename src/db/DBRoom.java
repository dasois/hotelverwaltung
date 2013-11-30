/**
 * 
 */
package db;

import app.entities.HotelRoom;


/**
 * @author david
 *
 */
public interface DBRoom {
	HotelRoom[] getAll();
	int create(HotelRoom room);
	boolean update(int RoomId, HotelRoom room);
	boolean delete(int RoomId);
}