package gui.book;

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
import javax.swing.SwingConstants;

import app.CustomerControlImp;
import db.entities.Customer;

@SuppressWarnings("serial")
public class SelectCustomerFrame extends AbstractFrame{
	private VerwaltungMainFrame mf;
	private JLabel header;
	private JPanel southPanel;
	private JButton cancel;
	private JPanel boxdsouthPanel;
	private JList<Customer> list;
	private JScrollPane listScroller;
	private JButton book;

	public SelectCustomerFrame(VerwaltungMainFrame mf){
		this.mf = mf;
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
			list = new JList<Customer>(new CustomerControlImp().getAll());
		} catch (SQLException e) {
			System.out.println("Fehler bei der Datenbank, rufen sie ihren Administrator");
			e.printStackTrace();
		}
		list.setEnabled(true);	
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(4);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(600, 160));

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
		final FrameSwitcher fs = new FrameSwitchImpl(this,mf);
		final SelectCustomerFrame scf = this;

		book.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				if(e.getActionCommand()=="book"){
					
					CheckOutFrame cof = new CheckOutFrame(scf,mf);
					cof.init();
					cof.setVisible(false);
					final FrameSwitcher fs2 = new FrameSwitchImpl(scf,cof);
					fs2.switchFrame();
				}
			}

		});
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Cancel")
					fs.switchFrame();
			}	
		});
	}
	public Customer getSelectedCustomer(){
		return list.getSelectedValue();
	}
}