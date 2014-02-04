package app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

import app.entities.Title;
import db.entities.Customer;

/**
 * interface for using the db from inside the app-layer This is for the entity
 * customer
 */
public interface CustomerControlInterface {
	Vector<Customer> getAll() throws SQLException;

	boolean update(Customer cust);

	boolean delete(int customerId) throws SQLException;

	int create(String fName, String lName, String address, Date date,
			Title title) throws SQLException;
}