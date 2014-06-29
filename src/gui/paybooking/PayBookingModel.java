package gui.paybooking;

import java.util.ArrayList;

import db.entities.Booking;
import db.entities.BookingService;

public class PayBookingModel {
	private int CID;
	private Booking selBooking;
	private ArrayList<BookingService> ServiceList;
	public int getCID() {
		return CID;
	}

	public void setCID(int cID) {
		CID = cID;
	}

	public Booking getSelBooking() {
		return selBooking;
	}

	public void setSelBooking(Booking selBooking) {
		this.selBooking = selBooking;
	}

	public ArrayList<BookingService> getServiceList() {
		return ServiceList;
	}

	public void setServiceList(ArrayList<BookingService> serviceList) {
		ServiceList = serviceList;
	}
}