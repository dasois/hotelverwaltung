package db.Mocks;

import app.Customer;
import db.DBCustomer;

public class DBCustomerImp implements DBCustomer{

	@Override
	public Customer[] getAll() {
		Customer[] c = new Customer[1];
		c[0] = new Customer(Title.Dr,"Herbert","strasse5",new SimpleTime(5,29,1990));
		return c;
	}

	@Override
	public int create(Customer cust) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean update(int customerId, Customer cust) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int customerId) {
		// TODO Auto-generated method stub
		return false;
	}

}
