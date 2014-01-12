package app;


import java.sql.SQLException;
import java.util.Vector;

import db.entities.Customer;



public interface CustomerControlInterface {
	Vector<Customer> getAll() throws SQLException;
	int create(Customer cust) throws SQLException;
	boolean update(Customer cust);
	boolean delete(int customerId) throws SQLException;
}
