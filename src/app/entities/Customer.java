package app.entities;

import gui.SimpleTime;

public class Customer {
	private Title title;
	private String name;
	private String address;
	private final SimpleTime birthday;
	private int customerId;
	public Customer(Title t, String n, String a, SimpleTime b,int id){
		title = t;
		name = n;
		address = a;
		birthday = b;

		setCustomerId(id);
	}
	public Customer(Title t, String n, String a, SimpleTime b){
		title = t;
		name = n;
		address = a;
		birthday = b;
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

	public SimpleTime getBirthday() {
		return birthday;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String toString(){
		return " -Kunde:" +title+" " + name+"\n -Adresse: "+address+"\n -Geburstag: "+ birthday+"\n -DatenbankID: "+ customerId; 
	}
}
