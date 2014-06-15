package gui.book.room;

import db.entities.Room;

public class FreeRoomsFrameModel {
	private  Room[] tmp;

	public  Room[] getTmp() {
		return tmp;
	}

	public void setTmp(Room[] tmp) {
		this.tmp = tmp;
	}
	private  Room[] selectedRooms;

	public Room[] getSelectedRooms() {
		return selectedRooms;
	}

	public void setSelectedRooms(Room[] selectedRooms) {
		this.selectedRooms = selectedRooms;
	}
}