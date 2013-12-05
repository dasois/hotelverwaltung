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
		DBIface.executeQuery("Insert into Room values ("+room.getRid()+","+room.getPrice()+","+room.isDoubleRoom()+")");
		this.setRid(DBIface.executeQuery("SELECT LAST_INSERT_ID();").getInt(1));
		return this.getRid();
	}
	@Override
	public boolean update(int newRoomId, Room room) throws SQLException {
		DBIface.executeQuery(
				"Update Room set "+
						"RID = "+newRoomId+
						",Price = "+room.getPrice()+
						",isDoubleRoom = "+room.isDoubleRoom()+
						" Where RID = "+room.getRid()
			);
			if (DBIface.executeQuery("SELECT COUNT(*) from Room where rid = "+newRoomId).getInt(1)==1){
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
