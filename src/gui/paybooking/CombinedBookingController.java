package gui.paybooking;

import gui.AbstractFrame;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
import gui.combinedbooking.CombinedBookingFrameView;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import app.BookingControlImp;
import app.BookingInterface;

public class CombinedBookingController implements IController{
	private CombinedBookingFrameView f;
	private VerwaltungMainFrameView mf;

	private BookingInterface controller = new BookingControlImp();
	public CombinedBookingController(VerwaltungMainFrameView mf){
		this.mf = mf;
	}
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,mf);
		if(e.getActionCommand()=="abort"){
			try {
				controller.discardChanges();
				mf.addProtocolLine("Buchung wurde nicht angelegt");
			} catch (SQLException e1) {
				mf.addProtocolLine("Buchung hatte einen Fehler");
			}
			fs.switchFrame();
		}else{
			try {
				
				controller.saveChanges();
				mf.addProtocolLine("Buchung wurde komplett ausgebucht");
			} catch (SQLException e1) {
				mf.addProtocolLine("Buchung hatte einen Fehler");
			}
			fs.switchFrame();	
		}
	}

	public void setConnectedView(AbstractFrame f) {
		this.f = (CombinedBookingFrameView) f;
	}
}