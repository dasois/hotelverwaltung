/**
 * 
 */
package db;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.Customer;

/**
 * @author david
 *
 */
public interface DBCustomer {
	ResultSet getAll() throws SQLException;
	int create(Customer cust) throws SQLException;
	boolean update(int newCustomerId, Customer cust) throws SQLException;
	boolean delete(int customerId) throws SQLException;
}