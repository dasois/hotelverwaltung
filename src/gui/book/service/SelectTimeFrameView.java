package gui.book.service;

import gui.AbstractFrame;
import gui.IController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
/** Selection of a date on which a service gets booked*/
@SuppressWarnings("serial")
public class SelectTimeFrameView extends AbstractFrame{
	private IController c;
	private ServiceModel m;
	private JLabel header;
	private JPanel leftPanel;
	private JLabel date;
	private JPanel boxdleftPanel;
	private JPanel centerPanel;
	private JDateChooser datePicker;
	private JPanel boxdCenterPanel;
	private JPanel southPanel;
	protected JButton search;
	protected JButton cancel;
	private JPanel boxdsouthPanel;
	
	public SelectTimeFrameView(IController c,ServiceModel m) {
		this.c = c;
		this.m = m;
	}

	protected void createWidget() {
		header = new JLabel("Zeitpunkt Buchen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1,10,10));

		date = new JLabel("Von ");
		date.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));

		centerPanel = new JPanel();	
		centerPanel.setLayout(new GridLayout(1,1,10,10));

		datePicker = new JDateChooser();
		if(m.getDateLimit()){
			datePicker.setMinSelectableDate(m.getminDate());
			datePicker.setMaxSelectableDate(m.getmaxDate());
		}
		m.setDatePicker(datePicker);
		boxdCenterPanel = new JPanel();
		boxdCenterPanel.setLayout(new BoxLayout(boxdCenterPanel,BoxLayout.PAGE_AXIS));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		search = new JButton("Wählen");
		search.setPreferredSize(new Dimension(20, 30));
		search.setActionCommand("Search");

		cancel = new JButton("Abbruch");
		cancel.setPreferredSize(new Dimension(20, 30));
		cancel.setActionCommand("Cancel");
		boxdsouthPanel = new JPanel();
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,BoxLayout.PAGE_AXIS));
	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5,5));
		getContentPane().add(BorderLayout.NORTH,header);
		leftPanel.add(date);
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(datePicker);
		boxdCenterPanel.add(centerPanel);
		boxdCenterPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdCenterPanel);
		southPanel.add(search);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
	protected void setupInteractions() {
		cancel.addActionListener(c);
		search.addActionListener(c);
	}
}