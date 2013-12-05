/**
 * 
 */
package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBBookingService;
import db.DBIface;

/**
 * @author david
 *
 */
public class BookingService implements DBBookingService {
	private int bsid;
	private Date date;
	private Service service;
	private BookingRoom bookingRoom;

	/**Constructor for BookingService object
	 * 
	 * @param bsid: Id of the service-booking. Leave NULL if you want to use auto_increment!
	 * @param date: Date for which the service is being booked
	 * @param service: Service which is being booked
	 * @param bookingRoom: Corresponding room-booking
	 */
	public BookingService(int bsid, Date date, Service service,
			BookingRoom bookingRoom) {
		this.bsid = bsid;
		this.date = date;
		this.service = service;
		this.bookingRoom = bookingRoom;
	}

	@Override
	public ResultSet getAll() throws SQLException {
		return DBIface.executeQuery("SELECT * from Booking_Service");
	}


	@Override
	public int create(BookingService bs) throws SQLException {
		DBIface.executeQuery("Insert into Booking_Service values ("+bs.getBsid()+","+bs.getDate()+","+bs.getService().getSid()+","+bs.getBookingRoom().getBrid()+")");
		this.setBsid(DBIface.executeQuery("SELECT LAST_INSERT_ID();").getInt(1));
		return this.getBsid();
	}

	@Override
	public boolean update(int newBookingServiceId, BookingService bs)
			throws SQLException {
		DBIface.executeQuery(
				"Update Booking_Service set "+
						"BSID = "+newBookingServiceId+
						",Date = "+bs.getDate()+
						",SID = "+bs.getService().getSid()+
						",BRID = "+bs.getBookingRoom().getBrid()+
						" Where BSID = "+bs.getBsid()
			);
			if (DBIface.executeQuery("SELECT COUNT(*) from Booking_Service where id = "+newBookingServiceId).getInt(1)==1){
				return true;
			}
			return false;
	}

	@Override
	public boolean delete(int bookingServiceId) throws SQLException {
		DBIface.executeQuery("DELETE from Booking_Service where BSID = "+bookingServiceId);
		if (DBIface.executeQuery("SELECT COUNT(*) from Booking_Service where BSID = "+bookingServiceId).getInt(1)==0){
			return true;
		}
		return false;
	}

	/**
	 * @return the bsid
	 */
	public int getBsid() {
		return bsid;
	}

	/**
	 * @param bsid the bsid to set
	 */
	public void setBsid(int bsid) {
		this.bsid = bsid;
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
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(Service service) {
		this.service = service;
	}

	/**
	 * @return the bookingRoom
	 */
	public BookingRoom getBookingRoom() {
		return bookingRoom;
	}

	/**
	 * @param bookingRoom the bookingRoom to set
	 */
	public void setBookingRoom(BookingRoom bookingRoom) {
		this.bookingRoom = bookingRoom;
	}

}
