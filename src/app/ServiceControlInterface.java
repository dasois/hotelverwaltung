package app;


import java.sql.SQLException;
import java.util.Vector;
import db.entities.Service;


public interface ServiceControlInterface {
	Vector<Service> getAll() throws SQLException;
	int create(Service srv) throws SQLException;
	boolean delete(int ServiceId) throws SQLException;
	boolean update(Service srv) throws SQLException;
}
