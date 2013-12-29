package db.Mocks;

import db.DBCustomer;
import db.entities.Customer;

public class DBCustomerImp implements DBCustomer{

	@Override
	public Customer[] getAll() {
		Customer[] c = new Customer[1];
		c[0] = new Customer(Title.Dr,"Herbert","strasse5",new SimpleTime(5,29,1990));
		return c;
	}

	@Override
	public int create() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean update(int customerId, Customer cust) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
