package gui.paybooking;

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
import javax.swing.SwingConstants;

import app.BookingControlImp;
import app.CustomerControlImp;
import db.entities.Booking;
import db.entities.Customer;

public class SelectBookingFrameView extends AbstractFrame{
	private JLabel header;
	private JPanel southPanel;
	private JButton cancel;
	private JPanel boxdsouthPanel;
	private JList<Booking> list;
	private JScrollPane listScroller;
	private JButton book;
	private IController c;
	private PayBookingModel m;
	public SelectBookingFrameView (IController c,PayBookingModel m){
		this.c = c;
		this.m = m;
	}

	protected void createWidget() {
		header = new JLabel("Kundenliste");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		try {
			list = new JList<Booking>(new BookingControlImp().getAllByCustomer(m.getCID()));
		} catch (SQLException e) {
			System.out.println("Fehler bei der Datenbank, rufen sie ihren Administrator");
			e.printStackTrace();
		}
		list.setEnabled(true);	
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(4);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		book = new JButton("Ausbuchen");
		book.setPreferredSize(new Dimension(20, 30));
		book.setActionCommand("book");
		cancel = new JButton("Zurück");
		cancel.setPreferredSize(new Dimension(20, 30));
		cancel.setActionCommand("Cancel");
		boxdsouthPanel = new JPanel();
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,BoxLayout.PAGE_AXIS));
	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5,5));
		getContentPane().add(BorderLayout.NORTH,header);
		getContentPane().add(BorderLayout.CENTER,listScroller);
		list.repaint();
		southPanel.add(book);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
	protected void setupInteractions() {	
		book.addActionListener(c);
		cancel.addActionListener(c);
	}
	public Booking getSelectedBooking(){
		m.setSelBooking(list.getSelectedValue());
		return m.getSelBooking();
	}
}