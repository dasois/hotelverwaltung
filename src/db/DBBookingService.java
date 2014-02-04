/**
 * 
 */
package db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author david
 * 
 */
public interface DBBookingService {
	ResultSet getAll() throws SQLException;

	double getSericePrice() throws SQLException;

	int create() throws SQLException;

	boolean update() throws SQLException;

	boolean delete() throws SQLException;
}