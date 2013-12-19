/**
 * 
 */
package db;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Service;

/**
 * @author david
 *
 */
public interface DBService {
	ResultSet getAll() throws SQLException;
	int create(Service srv) throws SQLException;
	boolean update() throws SQLException;
	boolean delete(int serviceId) throws SQLException;
}