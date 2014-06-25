package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBooking;
import db.entities.Booking;
import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Customer;

public class BookingControlImp extends AbstractTransactionController implements BookingInterface{

	@Override
	public Vector<Booking> getAll() throws SQLException {
		ResultSet resultset = new Booking().getAll();
		Vector<Booking> temp = new Vector<Booking>();
		while(resultset.next()){
			Booking b = new Booking(resultset.getInt(1),new Customer(resultset.getInt(3)),resultset.getDate(2));
			temp.add(b);
		}
		return temp;
	}

	@Override
	public Vector<Booking> getAllByCustomer(int CustomerId) throws SQLException {
		ResultSet resultset = new Booking().getAllByCustomer(CustomerId);
		Vector<Booking> temp = new Vector<Booking>();
		while(resultset.next()){
			Booking b = new Booking(resultset.getInt(1),new Customer(resultset.getInt(3)),resultset.getDate(2));
			temp.add(b);
		}
		return temp;
	}

	@Override
	public Vector<BookingService> getRelatedServiceBookings(int bid)throws SQLException {
		ResultSet resultset = new Booking(bid).getRelatedServiceBookings();
		Vector<BookingService> temp = new Vector<BookingService>();
		while (resultset.next()) {
			BookingService c = new BookingService(resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));
			temp.add(c);
		}
		return temp;
	}

	@Override
	public Vector<BookingRoom> getRelatedRoomBookings(int bid) throws SQLException {
		ResultSet resultset = new Booking(bid).getRelatedRoomBookings();
		Vector<BookingRoom> temp = new Vector<BookingRoom>();
		while (resultset.next()) {
			BookingRoom c = new BookingRoom(resultset.getInt(1),resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));
			temp.add(c);
		}
		return temp;
	}


	@Override
	public int create(Customer customer, Date createdOn) throws SQLException {
		DBBooking tmp = new Booking(customer,createdOn);
		return tmp.create();
	}

	@Override
	public boolean update(Booking b) throws SQLException {	
		return update(b);
	}

	@Override
	public boolean delete(int bookingID) throws SQLException {
		DBBooking tmp = new Booking(bookingID);		
		return tmp.delete();
	}
}