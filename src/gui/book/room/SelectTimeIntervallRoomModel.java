package gui.book.room;

import com.toedter.calendar.JDateChooser;

public class SelectTimeIntervallRoomModel {
	private JDateChooser startDatePicker;
	private JDateChooser endDatePicker;
	public JDateChooser getStartDatePicker() {
		return startDatePicker;
	}
	public void setStartDatePicker(JDateChooser startDatePicker) {
		this.startDatePicker = startDatePicker;
	}
	public JDateChooser getEndDatePicker() {
		return endDatePicker;
	}
	public void setEndDatePicker(JDateChooser endDatePicker) {
		this.endDatePicker = endDatePicker;
	}
}
