package gui.book.service;

import javax.swing.JList;
import com.toedter.calendar.JDateChooser;
import db.entities.BookingRoom;
import db.entities.Service;

import java.util.ArrayList;
import java.util.Date;
public class ServiceModel{
	private ArrayList<BookingRoom> bookedRoomList;
	private JList<Service> serviceList;
	private JDateChooser datePicker;
	private boolean dateLimit;
	private Date minDate;
	private Date maxDate;

	public JList<Service> getServiceList() {
		return serviceList;
	}

	public void setServiceList(JList<Service> serviceList) {
		this.serviceList = serviceList;
	}

	public JDateChooser getDatePicker() {
		return datePicker;
	}

	public void setDatePicker(JDateChooser datePicker) {
		this.datePicker = datePicker;
	}
	public boolean getDateLimit(){
		return dateLimit;
	}
	public void setDateLimit(boolean dateLimit){
		this.dateLimit = dateLimit;
	}
	public Date getminDate(){
		return minDate;
	}
	public Date getmaxDate(){
		return maxDate;
	}
	public void setMinDate(Date min){
		minDate = min;
	}
	public void setMaxDate(Date max){
		maxDate = max;
	}

	public ArrayList<BookingRoom> getBookedRoomList() {
		return bookedRoomList;
	}

	public void setBookedRoomList(ArrayList<BookingRoom> bookedRoomList) {
		this.bookedRoomList = bookedRoomList;
	}
}