package gui.combinedbooking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.entities.Room;
import gui.AbstractFrame;
import gui.IController;
import gui.book.room.RoomModel;
import gui.book.service.ServiceModel;

@SuppressWarnings("serial")
public class CombinedBookingFrameView extends AbstractFrame{
	private RoomModel roomModel;
	private ArrayList<ServiceModel> serviceModels;
	private JButton btnyes;
	private JButton btnabort;
	private JLabel header;
	private JLabel customer;
	private JLabel rooms;
	private JLabel services;
	private JLabel timeInterval;
	private JLabel price;
	
	private JTextField customerIn;
	private JTextField roomsIn;
	private JTextField servicesIn;	
	private JTextField timeIntervalIn;	
	private JTextField priceIn;
	private double priceMath;
	private JPanel southPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel boxdsouthPanel;
	private JPanel boxdrightPanel;
	private JPanel boxdleftPanel;
	private IController c;
	public CombinedBookingFrameView(IController c,RoomModel rm,ArrayList<ServiceModel> serviceModels){
		this.c = c;
		this.roomModel = rm;
		this.serviceModels = serviceModels;
	}
	protected void setupInteractions() {
		btnyes.addActionListener(c);
		btnabort.addActionListener(c);
	}

	protected void createWidget() {
		//header section
		header = new JLabel("Überblick");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		//header section
		//leftpanel
		customer = new JLabel("Kunde: ");
		rooms = new JLabel("zu buchende Zimmer: ");
		services = new JLabel("zu buchende Dienstl: ");
		timeInterval = new JLabel("von-bis: ");
		price = new JLabel("Gesamtpreis: ");
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(5,1,15,15));
		boxdleftPanel= new JPanel();	
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));
		//leftpanel
		//rightpanel
		customerIn = new JTextField(roomModel.getCustomer().getlName());
		customerIn.setEditable(false);
		Room[] r = roomModel.getSelectedRooms();
		String roomNumbers="";
		for(int i = 0;i<r.length;i++){
			roomNumbers = roomNumbers + r[i].getRid() + ". ";
			roomModel.setTotalPrice(r[i].getPrice()+roomModel.getTotalPrice());
		}
		roomsIn = new JTextField(roomNumbers);
		roomsIn.setEditable(false);
		String serviceNames = "";
		for(int i = 0;i<serviceModels.size();i++){
			serviceNames = serviceNames + serviceModels.get(i).getServiceList().getSelectedValue().getType()+", ";
			priceMath = priceMath + serviceModels.get(i).getServiceList().getSelectedValue().getPrice();
		}
		servicesIn = new JTextField(serviceNames);
		servicesIn.setEditable(false);
		priceMath = priceMath + roomModel.getTotalPrice();
		
		String dateString1 = String.format("%1$td-%1$tm-%1$tY", roomModel.getStartDatePicker().getDate());
		String dateString2 = String.format("%1$td-%1$tm-%1$tY", roomModel.getEndDatePicker().getDate());
		timeIntervalIn = new JTextField(dateString1 +" bis "+ dateString2);
		timeIntervalIn.setEditable(false);
		priceIn = new JTextField(""+priceMath);
		priceIn.setEditable(false);
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(5,1,15,15));
		boxdrightPanel = new JPanel();	
		boxdrightPanel.setLayout(new BoxLayout(boxdrightPanel,BoxLayout.PAGE_AXIS));
		//rightpanel
		//button
		btnyes = new JButton("Buchen");
		btnyes.setPreferredSize(new Dimension(20, 30));
		btnyes.setActionCommand("yes");
		//button
		btnabort = new JButton("Abbruch");
		btnabort.setPreferredSize(new Dimension(20, 30));
		btnabort.setActionCommand("abort");
	
		//button
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));
		boxdsouthPanel = new JPanel();	
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,BoxLayout.PAGE_AXIS));
	}

	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5,5));
		getContentPane().add(BorderLayout.NORTH,header);
		leftPanel.add(customer);
		leftPanel.add(rooms);
		leftPanel.add(services);
		leftPanel.add(timeInterval);
		leftPanel.add(price);
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		rightPanel.add(customerIn);
		rightPanel.add(roomsIn);
		rightPanel.add(servicesIn);
		rightPanel.add(timeIntervalIn);
		rightPanel.add(priceIn);
		boxdrightPanel.add(rightPanel);
		boxdrightPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdrightPanel);
		southPanel.add(btnyes);
		southPanel.add(btnabort);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
}