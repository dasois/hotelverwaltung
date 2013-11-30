package gui.book.room;

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
import java.util.Calendar;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import app.CustomerControlImp;
import app.entities.BookingRoom;
import app.entities.Customer;

public class SelectCostumerByRoomFrame extends AbstractFrame{

	private VerwaltungMainFrame mf;
	private FreeRoomsFrame frf;
	private JLabel header;
	private JList<Customer> list;
	private JScrollPane listScroller;
	private JPanel southPanel;
	protected JButton book;
	protected JButton stepback;
	private JPanel boxdsouthPanel;
	private BookingRoom[] selectedRooms;
	private SelectTimeIntervallRoomFrame sf;
	public SelectCostumerByRoomFrame(VerwaltungMainFrame mf,FreeRoomsFrame frf, BookingRoom[] selectedRooms, SelectTimeIntervallRoomFrame sf) {
		this.mf = mf;
		this.frf = frf;
		this.selectedRooms = selectedRooms;
		this.sf = sf;
	}
	protected void createWidget() {
		header = new JLabel("Kunde wählen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		
		list = new JList<>(new CustomerControlImp().getAll());
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
		final FrameSwitcher fs = new FrameSwitchImpl(this,frf);
		final FrameSwitcher fs2 = new FrameSwitchImpl(this,mf);
		stepback.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				fs.switchFrame();
			}
		});
		book.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				for(BookingRoom b: selectedRooms){
					b.setCustomer(list.getSelectedValue());
					Calendar startDate = sf.getStartDate();
					Calendar endDate = sf.getEndDate();
					
					b.setBookingDate(date);
				}
				fs2.switchFrame();
			}	
		});
	}
}
