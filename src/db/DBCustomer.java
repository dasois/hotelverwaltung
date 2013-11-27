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
	Customer[] getAll(); // lieber array wegen schichtentrennung
	int create(Customer cust);
	boolean update(int customerId, Customer cust);
	boolean delete(int customerId);
}