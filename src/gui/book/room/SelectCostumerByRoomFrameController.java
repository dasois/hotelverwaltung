package gui.book.room;

import gui.AbstractFrame;
import gui.IController;
import gui.FrameSwitchImpl;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import app.BookingRoomControlImp;
import app.BookingRoomControlInterface;
import app.CustomerControlImp;
import app.CustomerControlInterface;
import db.entities.Customer;
import db.entities.Room;

public class SelectCostumerByRoomFrameController implements IController{
	private FreeRoomsFrameView frf;
	private SelectCostumerByRoomFrameView f;
	private VerwaltungMainFrameView mf;
	private RoomModel m;
	public SelectCostumerByRoomFrameController(SelectCostumerByRoomFrameView f, VerwaltungMainFrameView mf, RoomModel m,FreeRoomsFrameView frf){
		this.f = f;
		this.mf = mf;
		this.m = m;
		this.frf = frf;
	}
	public SelectCostumerByRoomFrameController(VerwaltungMainFrameView mf, RoomModel m,FreeRoomsFrameView frf){
		this.mf = mf;
		this.m = m;
		this.frf = frf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		final FrameSwitcher fs = new FrameSwitchImpl(f,frf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(f,mf);
		if(e.getActionCommand()=="Back"){
			fs.switchFrame();
		}else if(e.getActionCommand()=="Book"){
			Calendar start = Calendar.getInstance();
			start.setTime(m.getStartDatePicker().getDate());
			Calendar end = Calendar.getInstance();
			end.setTime(m.getEndDatePicker().getDate());
			BookingRoomControlInterface controller = new BookingRoomControlImp();
			double price =0.0;
			for (Date date = start.getTime(); !start.after(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
				for(Room r:m.getSelectedRooms()){
					try {
						price = price + r.getPrice();
						m.setCustomer(m.getList().getSelectedValue());
						controller.create(new java.sql.Date(date.getTime()),r.getRid(),m.getList().getSelectedValue().getCid());
						mf.addProtocolLine("Buchung von Zimmer: "+r.getRid()+"am Tag:"+date.toString()+" wurde in der Datenbank angelegt\n");
					} catch (SQLException e1) {
						mf.addProtocolLine("Buchung konnte nicht erstellt werden");
						e1.printStackTrace();
					}catch (NullPointerException e1) {
						mf.addProtocolLine("Fehler, Es wurde kein Kunde ausgewählt");
					}
				}

			}
			m.setTotalPrice(price);
			mf.addProtocolLine("Die Komplette buchung kostet: "+price);
			fs2.switchFrame();
		}
	}

	@Override
	public void setConnectedView(AbstractFrame f) {
		this.f = (SelectCostumerByRoomFrameView) f;
	}
}
