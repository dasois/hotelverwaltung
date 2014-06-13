package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import app.ServiceControlImp;
import db.entities.Service;
/** Selection of a service wich should get booked*/
@SuppressWarnings("serial")
public class SelectServiceFrameView extends AbstractFrame{

	private JLabel header;
	private JList<Service> list;
	private JScrollPane listScroller;
	private JPanel southPanel;
	private JButton book;
	private JButton stepback;
	private JPanel boxdsouthPanel;
	private VerwaltungMainFrameView mf;
	private SelectTimeFrameView ssf;
	private IController c;
	public SelectServiceFrameView(VerwaltungMainFrameView mf,IController c,SelectTimeFrameView ssf) {
		this.mf = mf;
		this.ssf = ssf;
		this.c = c;
	}

	@Override
	protected void createWidget() {
		header = new JLabel("Dienstleistung wählen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		//TODO sinnvolle excp
		try {
			list = new JList<>(new ServiceControlImp().getAll());
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	@Override
	protected void setupInteractions() {
//		SelectServiceFrameController c = new SelectServiceFrameController(this, mf, ssf);
		stepback.addActionListener(c);
		book.addActionListener(c);
	}
	public int getServiceSelectionid(){
		return list.getSelectedValue().getSid();
	}
	public String getServiceName(){
		return list.getSelectedValue().getType();
	}
}