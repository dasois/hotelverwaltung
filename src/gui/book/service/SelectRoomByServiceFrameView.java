package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
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

import db.entities.BookingRoom;
/** Selection of a room wich a service gets booked to*/
@SuppressWarnings("serial")
public class SelectRoomByServiceFrameView extends AbstractFrame{
	private JLabel header;
	private JScrollPane listScroller;
	private JPanel southPanel;
	private JButton book;
	private JButton stepback;
	private JPanel boxdsouthPanel;
	private ServiceModel m;
	private IController c;
	public SelectRoomByServiceFrameView(IController c,ServiceModel m) {
		this.c = c;
		this.m = m;
	}
	protected void createWidget() {
		header = new JLabel("Zimmer w�hlen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

					try {
						m.setjList((new JList<BookingRoom>(new BookingRoomControlImp().getAll())));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					m.getjList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
					m.getjList().setLayoutOrientation(JList.HORIZONTAL_WRAP);
					m.getjList().setVisibleRowCount(-1);
		
		listScroller = new JScrollPane(m.getjList());
		listScroller.setPreferredSize(new Dimension(250, 80));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		book = new JButton("Buchen");
		book.setPreferredSize(new Dimension(20, 30));
		book.setActionCommand("Book");

		stepback = new JButton("Zur�ck");
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
		stepback.addActionListener(c);
		book.addActionListener(c);
	}
}