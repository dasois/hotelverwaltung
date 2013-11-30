package app;

import app.entities.Customer;

public interface CustomerControlInterface {
	Customer[] getAll(); // lieber array wegen schichtentrennung
	int create(Customer cust);
	boolean update(int customerId, Customer cust);
	boolean delete(int customerId);
}
