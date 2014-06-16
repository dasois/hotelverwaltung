package gui.book.room;

import gui.AbstractFrame;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;
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
import app.CustomerControlImp;
/** Selection of the customer wich wants to book a room */
@SuppressWarnings("serial")
public class SelectCostumerByRoomFrameView extends AbstractFrame{

	private VerwaltungMainFrameView mf;
	private FreeRoomsFrameView frf;
	private JLabel header;
	private JScrollPane listScroller;
	private JPanel southPanel;
	protected JButton book;
	protected JButton stepback;
	private JPanel boxdsouthPanel;
	private SelectTimeIntervallRoomFrame sf;
	private IController c;
	private RoomModel m;
	public SelectCostumerByRoomFrameView(VerwaltungMainFrameView mf,IController c,RoomModel m) {
		this.mf = mf;
		this.c = c;
		this.m = m;
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
			m.setList( new JList<>(new CustomerControlImp().getAll()));
		} catch (SQLException e) {
			mf.addProtocolLine("Es konnte keine verbindung zur Datenbank hergestellt werden, rufen sie ihren Administrator");
			e.printStackTrace();
		}
		m.getList().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		m.getList().setLayoutOrientation(JList.HORIZONTAL_WRAP);
		m.getList().setVisibleRowCount(-1);
		listScroller = new JScrollPane(m.getList());
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
		stepback.addActionListener(c);
		book.addActionListener(c);
	}
}