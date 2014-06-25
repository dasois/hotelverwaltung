package app;

import java.sql.SQLException;
import java.util.Vector;
import db.entities.Service;
/** interface for using the db from inside the app-layer
*	This is for the entity service*/
public interface ServiceControlInterface extends TransactionInterface{
	Vector<Service> getAll() throws SQLException;
	int create(String type, double price) throws SQLException;
	boolean delete(int ServiceId) throws SQLException;
	boolean update(Service srv) throws SQLException;
}