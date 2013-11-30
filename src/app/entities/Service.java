package app.entities;

public class Service {
	private String nameOfService;
	private double price;
	private int serviceId;
	public Service(String n, double p, int id){
		nameOfService = n;
		price = p;
		serviceId = id;
	}

	public Service(String n, double p) {
		nameOfService = n;
		price = p;
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

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
}
