package db.Mocks;

import app.entities.Service;
import db.DBService;

public class DBServiceImp implements DBService{

	@Override
	public Service[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(Service srv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(int ServiceId, Service srv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int ServiceId) {
		// TODO Auto-generated method stub
		return false;
	}

}
