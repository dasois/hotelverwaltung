package app;

import app.entities.Service;

public interface ServiceControlInterface {
	Service[] getAll();
	int create(Service srv);
	boolean update(int ServiceId, Service srv);
	boolean delete(int ServiceId);
}
