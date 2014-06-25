package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import db.DBService;
import db.entities.Service;
/** Implementation of ServiceControlInterface */
public class ServiceControlImp extends AbstractTransactionController implements ServiceControlInterface{

	@Override
	public Vector<Service> getAll() throws SQLException {

		ResultSet resultset = new Service().getAll();
		Vector<Service> temp = new Vector<Service>();
		while (resultset.next()) {
			Service c = new Service(Integer.parseInt(resultset.getString(1)),resultset.getString(2),Double.parseDouble(resultset.getString(3)));
			temp.add(c);
		}
		return temp;
	}

	@Override
	public int create(String type, double price) throws SQLException {
		Service s = new Service (type,price);
		return s.create();
	}

	@Override
	public boolean update(Service srv) throws SQLException {

		return srv.update();
	}

	@Override
	public boolean delete(int ServiceId) throws SQLException {
		DBService tmp = new Service(ServiceId);
		return tmp.delete();
	}
}