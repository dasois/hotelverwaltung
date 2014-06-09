package gui.book.room;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import app.BookingRoomControlImp;
import app.BookingRoomControlInterface;
import app.CustomerControlImp;
import db.entities.Customer;
import db.entities.Room;
/** Selection of the customer wich wants to book a room */
@SuppressWarnings("serial")
public class SelectCostumerByRoomFrameView extends AbstractFrame{

	private VerwaltungMainFrameView mf;
	private FreeRoomsFrameView frf;
	private JLabel header;
	private JList<Customer> list;
	private JScrollPane listScroller;
	private JPanel southPanel;
	protected JButton book;
	protected JButton stepback;
	private JPanel boxdsouthPanel;
	private SelectTimeIntervallRoomFrame sf;
	private SelectCostumerByRoomFrameModel m;
	public SelectCostumerByRoomFrameView(VerwaltungMainFrameView mf,FreeRoomsFrameView frf, Room[] selectedRooms, SelectTimeIntervallRoomFrame sf) {
		this.mf = mf;
		this.setFrf(frf);
		m = new SelectCostumerByRoomFrameModel();
		m.setSelectedRooms(selectedRooms);
		this.setSf(sf);
	}
	protected void createWidget() {
		header = new JLabel("Kunde wählen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		try {
			setList(new JList<>(new CustomerControlImp().getAll()));
		} catch (SQLException e) {
			mf.addProtocolLine("Es konnte keine verbindung zur Datenbank hergestellt werden, rufen sie ihren Administrator");
			e.printStackTrace();
		}
		getList().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		getList().setLayoutOrientation(JList.HORIZONTAL_WRAP);
		getList().setVisibleRowCount(-1);
		listScroller = new JScrollPane(getList());
		listScroller.setPreferredSize(new Dimension(250, 80));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		book = new JButton("Buchen");
		book.setPreferredSize(new Dimension(20, 30));
		book.setActionCommand("Book");

		stepback = new JButton("Zurück");
		stepback.setPreferredSize(new Dimension(20, 30));
		stepback.setActionCommand("Back");
		boxdsouthPanel = new JPanel();	
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,BoxLayout.PAGE_AXIS));
	}

	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5,5));
		getContentPane().add(BorderLayout.NORTH,header);
		getContentPane().add(BorderLayout.CENTER,listScroller);
		southPanel.add(book);
		southPanel.add(stepback);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);

	}
	protected void setupInteractions() {
		SelectCostumerByRoomFrameController c = new SelectCostumerByRoomFrameController(this, mf,m);
		stepback.addActionListener(c);
		book.addActionListener(c);
	}
	public FreeRoomsFrameView getFrf() {
		return frf;
	}
	public void setFrf(FreeRoomsFrameView frf) {
		this.frf = frf;
	}
	public SelectTimeIntervallRoomFrame getSf() {
		return sf;
	}
	public void setSf(SelectTimeIntervallRoomFrame sf) {
		this.sf = sf;
	}
	public JList<Customer> getList() {
		return list;
	}
	public void setList(JList<Customer> list) {
		this.list = list;
	}
}