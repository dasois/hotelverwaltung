/**
 * 
 */
package app;
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
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Room");
	}
	@Override
	public int create(Room room) throws SQLException {
		ResultSet rs = DBIface.executeQuery("Insert into Room values ("+room.getRid()+","+room.getPrice()+","+room.isDoubleRoom()+")");
		if (rs.next()) {
			this.setRid(rs.getInt(1));
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
			if (DBIface.executeQuery("SELECT COUNT(*) from Room where rid = "+this.getRid()).getInt(1)==1){
				return true;
			}
			return false;
	}
	@Override
	public boolean delete(int rid) throws SQLException {
		DBIface.executeQuery("DELETE from Room where RID = "+rid);
		if (DBIface.executeQuery("SELECT COUNT(*) from Room where RID = "+rid).getInt(1)==0){
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
	 * @param rid the id to set
	 */
	public void setRid(int rid) {
		this.rid = rid;
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
}
