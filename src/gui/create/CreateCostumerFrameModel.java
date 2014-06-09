package gui.create;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import app.entities.Title;

public class CreateCostumerFrameModel {
	private JComboBox<Title> titleSelection;
	private JTextField customerFirstNameInput;
	private JTextField customerLastNameInput;
	private JTextField addressInput;
	private JDateChooser birthdayPicker;
	public JComboBox<Title> getTitleSelection() {
		return titleSelection;
	}

	public void setTitleSelection(JComboBox<Title> titleSelection) {
		this.titleSelection = titleSelection;
	}

	public  JTextField getCustomerFirstNameInput() {
		return customerFirstNameInput;
	}

	public void setCustomerFirstNameInput(JTextField customerFirstNameInput) {
		this.customerFirstNameInput = customerFirstNameInput;
	}

	public JTextField getCustomerLastNameInput() {
		return customerLastNameInput;
	}

	public void setCustomerLastNameInput(JTextField customerLastNameInput) {
		this.customerLastNameInput = customerLastNameInput;
	}

	public JTextField getAddressInput() {
		return addressInput;
	}

	public void setAddressInput(JTextField addressInput) {
		this.addressInput = addressInput;
	}

	public  JDateChooser getBirthdayPicker() {
		return birthdayPicker;
	}

	public  void setBirthdayPicker(JDateChooser birthdayPicker) {
		this.birthdayPicker = birthdayPicker;
	}
}
