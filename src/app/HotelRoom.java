package app;

import java.util.Date;

public class HotelRoom {
	private final boolean doubleRoom;
	private final int roomNumber;
	private Date date;
	private double price;
	
	public HotelRoom(boolean d,int z,Date da,double p){
		doubleRoom = d;
		roomNumber = z;
		setDate(da);
		setPrice(p);
	}

	public boolean isDoubleRoom() {
		return doubleRoom;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
