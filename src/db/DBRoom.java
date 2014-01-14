/**
 * 
 */
package db;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * @author david
 *
 */
public interface DBRoom {
	ResultSet getAll() throws SQLException;
	ResultSet getFree(Date startDate, Date endDate) throws SQLException;
	int create() throws SQLException;
	boolean update() throws SQLException;
	boolean delete() throws SQLException;
	int getRid();
}