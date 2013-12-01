package app.entities;

import gui.SimpleTime;

public class BookingRoom {
	private SimpleTime bookingdate[];
	private Customer customer;
	private HotelRoom hotelRoom[];
	
	public BookingRoom(SimpleTime bookingdate[],Customer customer,HotelRoom[] hotelRoom){
		this.setBookingdate(bookingdate);
		this.setCustomer(customer);
		this.setHotelRoom(hotelRoom);
	}

	public SimpleTime[] getBookingdate() {
		return bookingdate;
	}

	public void setBookingdate(SimpleTime bookingdate[]) {
		this.bookingdate = bookingdate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public HotelRoom[] getHotelRoom() {
		return hotelRoom;
	}

	public void setHotelRoom(HotelRoom hotelRoom[]) {
		this.hotelRoom = hotelRoom;
	}
	public String toString(){
		String rooms= "";
		for(HotelRoom h:hotelRoom){
			rooms = rooms + h.getRoomNumber()+" ";
		}
		return customer.getTitle()+" "+customer.getName()+" Zimmer: " +rooms+" gebucht von "+bookingdate[0]+" bis " +bookingdate[bookingdate.length-1]; 
	}
}
