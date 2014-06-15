package gui.create;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class CreateRoomModel {
	private JCheckBox doubleRoomCheck;
	private JTextField price;

	public JTextField getPrice() {
		return price;
	}

	public void setPrice(JTextField price) {
		this.price = price;
	}

	public JCheckBox getDoubleRoomCheck() {
		return doubleRoomCheck;
	}

	public void setDoubleRoomCheck(JCheckBox doubleRoomCheck) {
		this.doubleRoomCheck = doubleRoomCheck;
	}
}