package app;

import db.DBCustomer;
import db.Mocks.DBCustomerImp;
import app.entities.Customer;

public class CustomerControlImp implements CustomerControlInterface{

	@Override
	public Customer[] getAll() {
		DBCustomer tmp = new DBCustomerImp();
		return tmp.getAll();
	}

	@Override
	public int create(Customer cust) {
		DBCustomer tmp = new DBCustomerImp();
		return tmp.create();
	}

	@Override
	public boolean update(int customerId, Customer cust) {
		DBCustomer tmp = new DBCustomerImp();
		return tmp.update(customerId, cust);
	}

	@Override
	public boolean delete(int customerId) {
		DBCustomer tmp = new DBCustomerImp();
		return tmp.delete(); 
	}
	
}
