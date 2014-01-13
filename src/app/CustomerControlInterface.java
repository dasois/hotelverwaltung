package app;


import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import db.entities.Customer;



public interface CustomerControlInterface {
	Vector<Customer> getAll() throws SQLException;
	boolean update(Customer cust);
	boolean delete(int customerId) throws SQLException;
	int create(String fName, String lName, String address, Date date)throws SQLException;
}
