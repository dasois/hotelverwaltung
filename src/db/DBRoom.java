/**
 * 
 */
package db;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Room;

/**
 * @author david
 *
 */
public interface DBRoom {
	ResultSet getAll() throws SQLException;
	int create(Room room) throws SQLException;
	boolean update() throws SQLException;
	boolean delete(int roomId) throws SQLException;
}