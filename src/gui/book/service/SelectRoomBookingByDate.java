package gui.book.service;

import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.VerwaltungMainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import app.BookingServiceControlImp;
import app.BookingServiceControlInterface;
import db.entities.BookingRoom;

/** Selection of a room wich a service gets booked to */
@SuppressWarnings("serial")
public class SelectRoomBookingByDate extends AbstractFrame {
	private JLabel header;
	private JList<BookingRoom> list;
	private JScrollPane listScroller;
	private JPanel southPanel;
	private JButton book;
	private JButton stepback;
	private JPanel boxdsouthPanel;
	private VerwaltungMainFrame mf;
	private SelectServiceFrame ssf;
	private SelectTimeFrame stf;

	public SelectRoomBookingByDate(VerwaltungMainFrame mf,
			SelectServiceFrame ssf, SelectTimeFrame stf) {
		this.mf = mf;
		this.ssf = ssf;
		this.stf = stf;
	}

	@Override
	protected void createWidget() {
		header = new JLabel("Zimmerbuchung wählen");
		header.setPreferredSize(new Dimension(400, 40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC, 30));

		try {
			list = new JList<BookingRoom>(
					new BookingRoomControlImp().getByDate(stf.getDate()));
			list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
			list.setVisibleRowCount(-1);
		} catch (Exception e) {// SQLException e) {
			mf.addProtocolLine("Fehler bei der Datenbank, rufen sie ihren Administrator");
			e.printStackTrace();
		}

		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 2, 10, 10));

		book = new JButton("Buchen");
		book.setPreferredSize(new Dimension(20, 30));
		book.setActionCommand("Book");

		stepback = new JButton("Zurück");
		stepback.setPreferredSize(new Dimension(20, 30));
		stepback.setActionCommand("Back");
		boxdsouthPanel = new JPanel();
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,
				BoxLayout.PAGE_AXIS));
	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5, 5));
		getContentPane().add(BorderLayout.NORTH, header);
		getContentPane().add(BorderLayout.CENTER, listScroller);
		southPanel.add(book);
		southPanel.add(stepback);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH, boxdsouthPanel);
	}

	@Override
	protected void setupInteractions() {
		final FrameSwitcher fs = new FrameSwitchImpl(this, ssf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(this, mf);
		stepback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fs.switchFrame();
			}
		});
		book.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookingServiceControlInterface controller = new BookingServiceControlImp();
				try {
					controller.create(stf.getDate(), list.getSelectedValue(),
							ssf.getServiceSelectionid());
					mf.addProtocolLine("Buchung von Service: "
							+ ssf.getServiceName()
							+ " wurde in der Datenbank angelegt\n");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fs2.switchFrame();
			}
		});
	}
}