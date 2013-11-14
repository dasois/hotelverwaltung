/**
 * 
 */
package db;
import app.Customer;

/**
 * @author david
 *
 */
public interface DBCustomer {
	JTableview getAll();
	int create(Customer cust);
	boolean update(int customerId, Customer cust);
	boolean delete(int customerId);
}