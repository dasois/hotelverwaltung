package app.entities;

import java.util.Calendar;
import java.util.Date;

public class Customer {
	private Title title;
	private String name;
	private String address;
	private final Calendar birthday;
	private Date date;
	private int customerId;
	public Customer(Title t, String n, String a, Calendar b,Date d,int id){
		title = t;
		name = n;
		address = a;
		birthday = b;
		date = d;
		setCustomerId(id);
	}
	public Customer(Title t, String n, String a, Calendar b){
		title = t;
		name = n;
		address = a;
		birthday = b;
		date = new Date();
	}
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Calendar getBirthday() {
		return birthday;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
