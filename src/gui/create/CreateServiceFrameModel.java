package gui.create;

import javax.swing.JTextField;

public class CreateServiceFrameModel {
	private JTextField price;
	private JTextField name;

	public JTextField getPrice() {
		return price;
	}

	public void setPrice(JTextField price) {
		this.price = price;
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}
}
