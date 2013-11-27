package app;

import java.util.Date;

public class Service {
	private String nameOfService;
	private double price;
	private Date date;
	
	public Service(String n, double p, Date d){
		setNameOfService(n);
		setPrice(p);
		setDate(d);
	}

	public String getNameOfService() {
		return nameOfService;
	}

	public void setNameOfService(String nameOfService) {
		this.nameOfService = nameOfService;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
