package db.entities;

import db.DBIface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by david on 14.06.14.
 */
public class Booking implements db.DBBooking {
    private int bid;
    private Customer customer;
    private Date CreatedOn;

    public Booking(Customer customer, Date createdOn) {
        this.customer = customer;
        CreatedOn = createdOn;
    }
    public Booking(int bid,Customer customer, Date createdOn) {
        this.customer = customer;
        CreatedOn = createdOn;
        this.bid = bid;
    }
    public Booking(int bid) {
        this.setBid(bid);
    }
    public Booking(){}
	@Override
    public ResultSet getAll() throws SQLException {
        return DBIface.executeQuery("SELECT * from Booking");
    }
    @Override
    public ResultSet getAllByCustomer(int CustomerId) throws SQLException {
        return DBIface.executeQuery("SELECT * from Booking WHERE CID = " + CustomerId);
    }

    @Override
    public ResultSet getRelatedServiceBookings() throws SQLException {
        return DBIface.executeQuery("SELECT * FROM Booking_Service WHERE BID=" + this.bid);
    }

    @Override
    public ResultSet getRelatedRoomBookings() throws SQLException {
        return DBIface.executeQuery("SELECT * FROM Booking_Room WHERE BID=" + this.bid);
    }
    @Override
    public int create() throws SQLException {
        ResultSet rs = DBIface.executeQuery("Insert into Booking values (" + this.getBid() + ",\"" + this.getCreatedOn().toString() + "\"," + this.getCustomer().getCid() + ")");
        if (rs.next()) {
            this.setBid(rs.getInt(1));
        }
        return this.getBid();
    }
    @Override
    public boolean update() throws SQLException {
        DBIface.executeQuery(
                "Update Booking set " +
                        "CreatedOn = \"" + this.getCreatedOn() +
                        ",CID = " + this.getCustomer().getCid() +
                        " Where BID = " + this.getBid()
        );
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking where BID = " + this.getBid());
        rs.next();
        if (rs.getInt(1) == 1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean delete() throws SQLException {
        DBIface.executeQuery("DELETE from Booking_Room where BID = " + this.getBid());
        ResultSet rs = DBIface.executeQuery("SELECT COUNT(*) from Booking where BID = " + this.getBid());
        rs.next();
        if (rs.getInt(1) == 0) {
            return true;
        }
        return false;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(Date createdOn) {
        CreatedOn = createdOn;
    }
}