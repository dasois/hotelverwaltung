package app;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBBookingService;
import db.entities.BookingRoom;
import db.entities.BookingService;
import db.entities.Service;

public class BookingServiceControlImp implements BookingServiceControlInterface{

	@Override
	public Vector<BookingService> getAll() throws SQLException {
		ResultSet resultset = new BookingService().getAll();
		Vector<BookingService> temp = new Vector<BookingService>();
		while (resultset.next()) {
			BookingService c = new BookingService(resultset.getInt(1), resultset.getDate(2),resultset.getInt(3),resultset.getInt(4));		
		    temp.add(c);
		}		
		return temp;
	}
	

	@Override
	public boolean delete(int bookingServiceId) throws SQLException {
		DBBookingService tmp = new BookingService(bookingServiceId);
		return tmp.delete();
	}

	@Override
	public boolean update(BookingService br) {
		return update(br);
	}

	@Override
	public int create(Date date, BookingRoom br, int serviceId) throws SQLException {
		DBBookingService bs = new BookingService(date, new Service(serviceId), br);
		return bs.create();
	}

}
