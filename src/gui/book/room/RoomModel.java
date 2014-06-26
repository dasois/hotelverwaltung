package gui.book.room;

import java.util.ArrayList;

import javax.swing.JList;
import com.toedter.calendar.JDateChooser;

import db.entities.BookingRoom;
import db.entities.Customer;
import db.entities.Room;

public class RoomModel{
	private JDateChooser startDatePicker;
	private JDateChooser endDatePicker;
	private double totalPrice;
	private  Room[] selectedRooms;
	private ArrayList<BookingRoom> bookingRoomList = new ArrayList<>();
	private JList<Customer> list;
	private int actualbookingID;
	
	public JDateChooser getStartDatePicker() {
		return startDatePicker;
	}
	public void setStartDatePicker(JDateChooser startDatePicker) {
		this.startDatePicker = startDatePicker;
	}
	public JDateChooser getEndDatePicker() {
		return endDatePicker;
	}
	public void setEndDatePicker(JDateChooser endDatePicker) {
		this.endDatePicker = endDatePicker;
	}
	public Room[] getSelectedRooms() {
		return selectedRooms;
	}
	public void setSelectedRooms(Room[] selectedRooms) {
		this.selectedRooms = selectedRooms;
	}
	public Customer getCustomer() {
		return list.getSelectedValue();
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public JList<Customer> getList() {
		return list;
	}
	public void setList(JList<Customer> list) {
		this.list = list;
	}
	private  Room[] tmp;

	public  Room[] getTmp() {
		return tmp;
	}

	public void setTmp(Room[] tmp) {
		this.tmp = tmp;
	}
	public ArrayList<BookingRoom> getBookingRoomList() {
		return bookingRoomList;
	}
	public void setBookingRoomList(ArrayList<BookingRoom> bookingRoomList) {
		this.bookingRoomList = bookingRoomList;
	}
	public void addBookingRoom(BookingRoom b){
		bookingRoomList.add(b);
	}
	public int getActualbookingID() {
		return actualbookingID;
	}
	public void setActualbookingID(int actualbookingID) {
		this.actualbookingID = actualbookingID;
	}
}
