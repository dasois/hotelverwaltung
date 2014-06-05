/**
 * 
 */
package db.entities;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBIface;
import db.DBRoom;

/**
 * @author david
 *
 */
public class Room implements DBRoom{
	private int rid;
	private double price;
	private boolean isDoubleRoom;

	public Room (int rid, double price, boolean isDoubleRoom){
		this.rid = rid;
		this.price = price;
		this.isDoubleRoom = isDoubleRoom;
	}

	public Room (double price, boolean isDoubleRoom){
		this.price = price;
		this.isDoubleRoom = isDoubleRoom;
	}

	public Room(int rid){
		this.rid = rid;
	}

	public Room(){}

	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Room");
	}

	@Override
	public ResultSet getFree(Date startDate, Date endDate) throws SQLException {
		return DBIface.executeQuery("SELECT * from Room r " +
				"WHERE NOT EXISTS ( SELECT * FROM Booking_Room WHERE (Date between \""+startDate+"\" and \""+endDate+"\") AND RID = r.RID)");
	}

	@Override
	public int create() throws SQLException {
		ResultSet rs = DBIface.executeQuery("Insert into Room values ("+this.getRid()+","+this.getPrice()+","+this.isDoubleRoom()+")");
		if (rs.next()) {
			this.rid = rs.getInt(1);
		}
		return this.getRid();
	}
	@Override
	public boolean update() throws SQLException {
		DBIface.executeQuery(
				"Update Room set "+
						"Price = "+this.getPrice()+
						",isDoubleRoom = "+this.isDoubleRoom()+
						" Where RID = "+this.getRid()
			);
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Room where rid = "+this.getRid());
		rs.next();
			if (rs.getInt(1)==1){
				return true;
			}
			return false;
	}
	@Override
	public boolean delete() throws SQLException {
		DBIface.executeQuery("DELETE from Room where RID = "+this.getRid());
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Room where RID = "+this.getRid());
		rs.next();
		if (rs.getInt(1)==0){
			return true;
		}
		return false;
	}
	/**
	 * @return the id
	 */
	public int getRid() {
		return rid;
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
	 * @return the isDoubleRoom
	 */
	public boolean isDoubleRoom() {
		return isDoubleRoom;
	}
	/**
	 * @param isDoubleRoom the isDoubleRoom to set
	 */
	public void setDoubleRoom(boolean isDoubleRoom) {
		this.isDoubleRoom = isDoubleRoom;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String toString(){
		if(isDoubleRoom)
			return "Zimmer: "+ rid + " Price " +price+ " Doppelzimmer"+"\n";
		else{
			return "Zimmer: "+ rid + " Price " +price+ " Einzelzimmer"+"\n";
		}
	}
}
