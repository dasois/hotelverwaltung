/**
 * 
 */
package app;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBIface;
import db.DBService;

/**
 * @author david
 *
 */
public class Service implements DBService{
	private int sid;
	private String type;
	private double price;
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Service");
	}
	@Override
	public int create(Service srv) throws SQLException {
		DBIface.executeQuery("Insert into Service values ("+srv.getSid()+","+srv.getType()+","+srv.getPrice()+")");
		this.setSid(DBIface.executeQuery("SELECT LAST_INSERT_ID();").getInt(1));
		return this.getSid();
	}
	@Override
	public boolean update(int newServiceId, Service srv) throws SQLException {
		DBIface.executeQuery(
				"Update Service set "+
						"SID = "+newServiceId+
						",Type = "+srv.getType()+
						",Price = "+srv.getPrice()+
						" Where SID = "+srv.getSid()
			);
			if (DBIface.executeQuery("SELECT COUNT(*) from Service where sid = "+newServiceId).getInt(1)==1){
				return true;
			}
			return false;
	}
	@Override
	public boolean delete(int serviceId) throws SQLException {
		DBIface.executeQuery("DELETE from Service where SID = "+serviceId);
		if (DBIface.executeQuery("SELECT COUNT(*) from Service where SID = "+serviceId).getInt(1)==0){
			return true;
		}
		return false;
	}
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
