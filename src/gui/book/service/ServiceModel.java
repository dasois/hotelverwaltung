package gui.book.service;

import javax.swing.JList;
import com.toedter.calendar.JDateChooser;
import db.entities.BookingRoom;
import db.entities.Service;
import java.util.Date;
public class ServiceModel{
	private JList<BookingRoom> bookedRoomList;
	private JList<Service> serviceList;
	private JDateChooser datePicker;
	private boolean dateLimit;
	private Date minDate;
	private Date maxDate;


	public JList<BookingRoom> getList() {
		return bookedRoomList;
	}

	public void setList(JList<BookingRoom> list) {
		this.bookedRoomList = list;
	}

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
}