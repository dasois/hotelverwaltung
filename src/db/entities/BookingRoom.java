/**
 * 
 */
package db.entities;

import db.DBBookingRoom;
import db.DBIface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author david
 *
 */
public class BookingRoom implements DBBookingRoom{
	private int brid;
	private Date date;
	private Room room;
    private Booking booking;

	/**Constructor for BookingRoom object
	 * 
	 * @param brid: Id of the room-booking. Leave NULL if you want to use auto_increment!
	 * @param date: Date for which the room is being booked
	 * @param bookedRoom: Room which is being booked
	 */
    public BookingRoom(Date date, Room room, Booking booking) {
        this.date = date;
		this.room = room;
        this.booking = booking;
    }

    public BookingRoom(Date date, int roomId, Booking booking) {
        this.date = date;
		this.room = new Room(roomId);
        this.booking = booking;
    }
    public BookingRoom(Date date, int roomId, int bookingID) {
        this.date = date;
		this.room = new Room(roomId);
        this.booking = new Booking(bookingID);
    }
    public BookingRoom(int id, Date date, int roomId, Booking booking) {
        this.brid = id;
		this.date = date;
		this.room = new Room(roomId);
        this.booking = booking;
    }
    public BookingRoom(int id, Date date, int roomId, int booking) {
        this.brid = id;
		this.date = date;
		this.room = new Room(roomId);
		this.booking = new Booking(booking);
    }
	public BookingRoom(int brid){this.brid = brid;}
	public BookingRoom(){}

	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Booking_Room");
	}

    @Override
    public ResultSet getByDate(Date date) throws SQLException {
        return DBIface.executeQuery("SELECT * from Booking_Room where Date = \"" + this.getDate().toString() + "\"");
    }


    @Override
    public int create() throws SQLException {
        ResultSet rs = DBIface.executeQuery("Insert into Booking_Room values (" + this.getBrid() + ",\"" + this.getDate().toString() + "\"," + this.getRoom().getRid() + "," + this.getBooking().getBid() + ")");
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
                    "BID = " + this.getBooking().getBid() +
                    " Where BRID = "+this.getBrid()
		);
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking_Room where BRID = " + this.getBrid());
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * @param brid the brid to set
	 */
	public void setBrid(int brid) {
		this.brid = brid;
	}
	public String toString(){

        return "brId: " + brid + " Zimmernummer: " + room.getRid() + " Buchungstag: " + getDate();
    }
}
