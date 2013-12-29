package db.Mocks;

import db.DBService;

public class DBServiceImp implements DBService{

	@Override
	public Service[] getAll() {
		Service[] s = new Service[1];
		s[0] = new Service("massage",25.3);
		return s;
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
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
