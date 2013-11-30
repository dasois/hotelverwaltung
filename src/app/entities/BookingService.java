package app.entities;

import java.util.Date;

public class BookingService extends Service{
	private Date bookingDate;
	public BookingService(String n, double p, int id,Date date) {
		super(n, p, id);
		setBookingDate(date);
	}
	public BookingService(String n, double p,Date date) {
		super(n, p);
		setBookingDate(date);
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
}
