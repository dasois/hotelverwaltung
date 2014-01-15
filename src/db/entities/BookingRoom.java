/**
 * 
 */
package db.entities;
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
	public BookingRoom(Date date, Room room, Customer customer) {
		this.date = date;
		this.room = room;
		this.customer = customer;
	}
	public BookingRoom(Date date, int roomId, int customerId) {
		this.date = date;
		this.room = new Room(roomId);
		this.customer = new Customer(customerId);
	}
	public BookingRoom(int brid){this.brid = brid;}
	public BookingRoom(){}
	
	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Booking_Room");
	}
	
	@Override
	public int create() throws SQLException {
		ResultSet rs = DBIface.executeQuery("Insert into Booking_Room values ("+this.getBrid()+",\""+this.getDate().toString()+"\","+this.getRoom().getRid()+","+this.getCustomer().getId()+")");
		if (rs.next()) {
			this.brid = rs.getInt(1); }
		return this.getBrid();
	}
	
	@Override
	public boolean update() throws SQLException {
		DBIface.executeQuery(
			"Update Booking_Room set "+
					"Date = \""+this.getDate()+
					"\",RID = "+this.getRoom().getRid()+
					",CID = "+this.getCustomer().getId()+
					" Where BRID = "+this.getBrid()
		);
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking_Room where id = "+this.getBrid());
		rs.next();
		if (rs.getInt(1)==1){
			return true;
		}
		return false;
	}
	@Override
	public boolean delete() throws SQLException {
		DBIface.executeQuery("DELETE from Booking_Room where BRID = "+this.getBrid());
		ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking_Room where BRID = "+this.getBrid());
		rs.next();
		if (rs.getInt(1)==0){
			return true;
		}
		return false;
	}

	/**
	 * @return the ID of the booking
	 */
	public int getBrid() {
		return brid;
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

	/**
	 * @param brid the brid to set
	 */
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public String toString(){
		
		return "brId: " + brid + " Zimmernummer: "+ room.getRid() + " Kundennummer: " + customer.getId();
	}
}
