package gui.book.room;

import gui.AbstractFrame;
import gui.IController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import app.RoomControlImp;
import app.RoomControlInterface;
import db.entities.Room;
/** Selection of the rooms wich should be booked */
@SuppressWarnings("serial")
public class FreeRoomsFrameView extends AbstractFrame{

	private JLabel header;
	public JList<Room> list;
	private JScrollPane listScroller;
	private JPanel southPanel;
	private JButton book;
	private JButton stepback;
	private JPanel boxdsouthPanel;
	public SelectTimeIntervallRoomFrame sf;
	private Vector<Room> freeRooms;
	private IController c;
	public FreeRoomsFrameView(SelectTimeIntervallRoomFrame sf,IController c) {
		this.sf = sf;
		this.c = c;
		RoomControlInterface tmp = new RoomControlImp();
		//TODO sinnvolle exception
		try {
			freeRooms = tmp.getFreeRooms(sf.getStartDate(), sf.getEndDate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void createWidget() {
		header = new JLabel("Freie Zimmer");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));


		list = new JList<>(freeRooms);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		listScroller = new JScrollPane(list);
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

	@Override
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
		stepback.addActionListener(c);
		book.addActionListener(c);
	}
}