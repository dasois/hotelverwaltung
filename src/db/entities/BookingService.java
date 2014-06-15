/**
 *
 */
package db.entities;

import db.DBBookingService;
import db.DBIface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author david
 */
public class BookingService implements DBBookingService {
    private int bsid;
    private Date date;
    private Service service;
    private Booking booking;

    /**
     * Constructor for BookingService object
     *
     * @param bsid:    Id of the service-booking. Leave NULL if you want to use auto_increment!
     * @param date:    Date for which the service is being booked
     * @param service: Service which is being booked
     * @param booking: Corresponding room-booking
     */
    public BookingService(Date date, Service service,
                          Booking booking) {
        this.date = date;
        this.service = service;
        this.booking = booking;
    }

    public BookingService(Date date, int serviceId, int bid) {
        this.date = date;
        this.booking = new Booking(bid);
        this.service = new Service(serviceId);
    }

    public BookingService() {
    }

    public BookingService(int bsid) {
        this.bsid = bsid;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return DBIface.executeQuery("SELECT * from Booking_Service");
    }

    @Override
    public int create() throws SQLException {
        ResultSet rs = DBIface.executeQuery("Insert into Booking_Service values (" + this.getBsid() + ",\"" + this.getDate() + "\"," + this.getService().getSid() + "," + this.getBooking().getBid() + ")");
        if (rs.last()) {
            this.bsid = rs.getInt(1);
        }
        return this.getBsid();
    }

    @Override
    public boolean update() throws SQLException {
        DBIface.executeQuery(
                "Update Booking_Service set " +
                        "Date = " + this.getDate() +
                        ",SID = " + this.getService().getSid() +
                        ",BID = " + this.getBooking().getBid() +
                        " Where BSID = " + this.getBsid()
        );
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking_Service where BSID = " + this.getBsid());
        rs.next();
        if (rs.getInt(1) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete() throws SQLException {
        DBIface.executeQuery("DELETE from Booking_Service where BSID = " + this.getBsid());
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking_Service where BSID = " + this.getBsid());
        rs.next();
        if (rs.getInt(1) == 0) {
            return true;
        }
        return false;
    }

    /**
     * @return the ID of the booking
     */
    public int getBsid() {
        return bsid;
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
     * @return the booking
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * @param booking the booking to set
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    /**
     * @param bsid the bsid to set
     */
    public void setBsid(int bsid) {
        this.bsid = bsid;
    }

}
