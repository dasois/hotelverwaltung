package db.Mocks;

import app.entities.Customer;
import db.DBCustomer;

public class DBCustomerImp implements DBCustomer{

	@Override
	public Customer[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Customer cust) {
		// TODO Auto-generated method stub
		return 0;
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
