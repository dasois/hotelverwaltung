package app.entities;

public class HotelRoom {
	private final boolean doubleRoom;
	private int roomNumber;
	private double price;
	private int roomId;
	public HotelRoom(boolean d,int z,double p,int id){
		doubleRoom = d;
		roomNumber = z;

		price = p;
		roomId = id;
	}

	public HotelRoom(boolean selected, int i, double p) {
		doubleRoom = selected;
		roomNumber = i;

		price = p;
	}

	public boolean isDoubleRoom() {
		return doubleRoom;
	}
	public void setRoomNumber(int n) {
		roomNumber = n;
	}
	public int getRoomNumber() {
		return roomNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String toString(){
		String decision;
		if(doubleRoom){
			decision = "ja";
		}else
			decision = "nein";
			
		return "DoppelZimmer: "+decision+"\nZimmernummer: "+roomNumber+"\nPreis: "+price+"\nDatenbankID: " + roomId ; 
	}
}
