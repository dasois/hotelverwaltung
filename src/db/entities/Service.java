/**
 * 
 */
package db.entities;
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
	
	/**
	 * @param type
	 * @param price
	 */
	public Service(String type, double price) {
		this.type = type;
		this.price = price;
	}
	public Service(int sid,String type, double price) {
		this.type = type;
		this.price = price;
		this.sid = sid;
	}
	public Service(){
		
	}
	public Service(int sid){
		this.sid = sid;
	}
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Service");
	}
	@Override
	public int create() throws SQLException {
		ResultSet rs = DBIface.executeQuery("Insert into Service values ("+this.getSid()+", \""+this.getType()+"\","+this.getPrice()+")");
		if (rs.next()) {
			this.sid = rs.getInt(1);
		}
		return this.getSid();
	}
	@Override
	public boolean update() throws SQLException {
		DBIface.executeQuery(
				"Update Service set "+
						"Type = \""+this.getType()+"\""+
						",Price = "+this.getPrice()+
						" Where SID = "+this.getSid()
			);
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Service where sid = "+this.getSid());
		rs.next();
			if (rs.getInt(1)==1){
				return true;
			}
			return false;
	}
	@Override
	public boolean delete() throws SQLException {
		DBIface.executeQuery("DELETE from Service where SID = "+this.getSid());
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Service where SID = "+this.getSid());
		rs.next();
		if (rs.getInt(1)==0){
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

	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String toString(){
		return "SId: " + sid + " DName: "+ type + " Price: " + price;
	}
	
}
