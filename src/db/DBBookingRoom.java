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
public interface DBBookingRoom {
	ResultSet getAll() throws SQLException;
	ResultSet getAllFromCustomer(int CustomerId) throws SQLException;
	ResultSet getRelatedServiceBookings() throws SQLException;
	int create() throws SQLException;
	boolean update() throws SQLException;
	boolean delete() throws SQLException;
}