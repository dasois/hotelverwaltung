package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VerwaltungMainFrame2 extends AbstractFrame{

	
	private JPanel leftPanel;
	private JButton kunde;
	private JButton hotelzimmer;
	private JButton dienstleistung;
	private JTable db;
	private JScrollPane scrollTable;
	private JPanel boxdleftPanel;
	
	@Override
	protected void createWidget() {
		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1,10,10));
		kunde = new JButton("Kunde");
		hotelzimmer = new JButton("Zimmer");
		dienstleistung = new JButton("Leistung");
		db = new JTable(100,4);
		scrollTable = new JScrollPane(db);
		
		boxdleftPanel = new JPanel();	
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));

	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout());
		leftPanel.add(kunde);
		leftPanel.add(hotelzimmer);
		leftPanel.add(dienstleistung);
		
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		getContentPane().add(BorderLayout.CENTER,scrollTable);
		
	}
	public static void main(String[] args) {
		VerwaltungMainFrame2 li = new VerwaltungMainFrame2();
	}

	@Override
	protected void setupInteractions() {
		// TODO Auto-generated method stub
		
	}
}
