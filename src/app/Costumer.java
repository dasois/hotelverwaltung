package app;

import java.util.Date;

public class Costumer {
	private String title;
	private String name;
	private String address;
	private final Date birthday;
	private Date date;
	
	public Costumer(String t, String n, String a, Date b,Date d){
		title = t;
		name = n;
		address = a;
		birthday = b;
		date = d;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
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

	public Date getBirthday() {
		return birthday;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
