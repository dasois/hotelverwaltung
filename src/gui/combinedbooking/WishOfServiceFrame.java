package gui.combinedbooking;

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

import gui.AbstractFrame;
import gui.IController;

public class WishOfServiceFrame extends AbstractFrame{
	private JButton btnyes;
	private JButton btnNo;
	private IController c;
	private JLabel header;
	private JLabel text;
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	private JPanel centerPanel;
	
	public WishOfServiceFrame(IController c) {
		this.c = c;
	}
	@Override
	protected void setupInteractions() {
		btnyes.addActionListener(c);
		btnNo.addActionListener(c);
	}

	@Override
	protected void createWidget() {
		//header section
		header = new JLabel("Service Wunsch");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		//header section
		
		//button
		btnyes = new JButton("Ja");
		btnyes.setPreferredSize(new Dimension(20, 30));
		btnyes.setActionCommand("yes");
		//button
		
		//button
		btnNo = new JButton("Nein");
		btnNo.setPreferredSize(new Dimension(20, 30));
		btnNo.setActionCommand("no");
		//button
		
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2,1,10,10));
		boxdsouthPanel = new JPanel();
		boxdsouthPanel.setLayout(new BoxLayout(boxdsouthPanel,BoxLayout.PAGE_AXIS));
		
		text = new JLabel("Soll noch eine Dienstleistung gebucht werden ");
		header.setPreferredSize(new Dimension(400,40));
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		
	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(5,5));
		getContentPane().add(BorderLayout.NORTH,header);
		getContentPane().add(BorderLayout.CENTER,text);
		southPanel.add(btnyes);
		southPanel.add(btnNo);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
}