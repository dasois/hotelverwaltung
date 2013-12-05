/**
 * 
 */
package app;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBBookingRoom;
import db.DBIface;

/**
 * @author david
 *
 */
public class BookingRoom implements DBBookingRoom{
	private int brid;
	private Date date;
	private Room room;
	private Customer customer;
	
	/**Constructor for BookingRoom object
	 * 
	 * @param brid: Id of the room-booking. Leave NULL if you want to use auto_increment!
	 * @param date: Date for which the room is being booked
	 * @param bookedRoom: Room which is being booked
	 * @param customer: Customer who is booking the room
	 */
	public BookingRoom(int brid, Date date, Room room, Customer customer) {
		this.brid = brid;
		this.date = date;
		this.room = room;
		this.customer = customer;
	}
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Booking_Room");
	}

	@Override
	public int create(BookingRoom br) throws SQLException {
		DBIface.executeQuery("Insert into Booking_Room values ("+br.getBrid()+","+br.getDate()+","+br.room.getRid()+","+br.getCustomer().getId()+")");
		this.setBrid(DBIface.executeQuery("SELECT LAST_INSERT_ID();").getInt(1));
		return this.getBrid();
	}
	
	@Override
	public boolean update(int newBrId, BookingRoom br) throws SQLException {
		DBIface.executeQuery(
			"Update Booking_Room set "+
					"BRID = "+newBrId+
					",Date = "+br.getDate()+
					",RID = "+br.getRoom().getRid()+
					",CID = "+br.getCustomer().getId()+
					" Where BRID = "+br.getBrid()
		);
		if (DBIface.executeQuery("SELECT COUNT(*) from Booking_Room where id = "+newBrId).getInt(1)==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int brId) throws SQLException {
		DBIface.executeQuery("DELETE from Booking_Room where BRID = "+brId);
		if (DBIface.executeQuery("SELECT COUNT(*) from Booking_Room where BRID = "+brId).getInt(1)==0){
			return true;
		}
		return false;
	}

	/**
	 * @return the brid
	 */
	public int getBrid() {
		return brid;
	}

	/**
	 * @param brid the brid to set
	 */
	public void setBrid(int brid) {
		this.brid = brid;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
