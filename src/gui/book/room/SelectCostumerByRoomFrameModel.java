package gui.book.room;

import db.entities.Room;

public class SelectCostumerByRoomFrameModel {
	private  Room[] selectedRooms;

	public Room[] getSelectedRooms() {
		return selectedRooms;
	}

	public void setSelectedRooms(Room[] selectedRooms) {
		this.selectedRooms = selectedRooms;
	}
}