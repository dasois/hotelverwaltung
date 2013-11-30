package app.entities;

import java.util.Date;

public class BookingRoom extends HotelRoom{
	private Date bookingdate;
	private Customer customer;
	
	public BookingRoom(boolean d, int z, double p, int id,Date date,Customer c) {
		super(d, z, p, id);
		customer = c;
		bookingdate = date;
	}
	public BookingRoom(boolean d, int z, double p, int id,Date date) {
		super(d, z, p, id);
		bookingdate = date;
	}
	
	public Date getBookingDate(){
		return bookingdate;
	}
	public void setBookingDate(Date date){
		bookingdate = date;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
