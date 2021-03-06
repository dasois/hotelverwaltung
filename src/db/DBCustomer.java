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
public interface DBCustomer {
	ResultSet getAll() throws SQLException;
	int create() throws SQLException;
	boolean update() throws SQLException;
	boolean delete() throws SQLException;
}