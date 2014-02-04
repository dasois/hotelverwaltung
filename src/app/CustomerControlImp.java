package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import app.entities.Title;
import db.DBCustomer;
import db.entities.Customer;

/** Implementation of CustomerControlInterface */
public class CustomerControlImp implements CustomerControlInterface {

	@Override
	public Vector<Customer> getAll() throws SQLException {
		ResultSet resultset = new Customer().getAll();
		Vector<Customer> temp = new Vector<Customer>();
		while (resultset.next()) {
			Customer c = new Customer(Integer.parseInt(resultset.getString(1)),
					resultset.getString(2), resultset.getString(3),
					resultset.getString(4), resultset.getDate(5),
					resultset.getString(6));
			temp.add(c);
		}
		return temp;
	}

	@Override
	public int create(String fName, String lName, String address, Date date,
			Title title) throws SQLException {
		DBCustomer c = new Customer(fName, lName, address, date,
				title.toString());
		return c.create();
	}

	@Override
	public boolean update(Customer cust) {
		return update(cust);
	}

	@Override
	public boolean delete(int customerId) throws SQLException {
		DBCustomer tmp = new Customer(customerId);
		return tmp.delete();
	}
}