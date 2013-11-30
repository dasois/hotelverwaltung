package app;

import db.DBService;
import db.Mocks.DBServiceImp;
import app.entities.Service;

public class ServiceControlImp implements ServiceControlInterface{

	@Override
	public Service[] getAll() {
		DBService tmp = new DBServiceImp();
		return tmp.getAll();
	}

	@Override
	public int create(Service srv) {
		DBService tmp = new DBServiceImp();
		return tmp.create(srv);
	}

	@Override
	public boolean update(int ServiceId, Service srv) {
		DBService tmp = new DBServiceImp();
		return tmp.update(ServiceId, srv);
	}

	@Override
	public boolean delete(int ServiceId) {
		DBService tmp = new DBServiceImp();
		return tmp.delete(ServiceId);
	}
}
