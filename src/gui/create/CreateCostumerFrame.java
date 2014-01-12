package gui.create;

import gui.AbstractFrame;
import gui.DatePicker;
import gui.FrameSwitcher;
import gui.VerwaltungMainFrame;
import gui.AbstractFrame.FrameSwitchImpl;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.entities.Customer;
import app.CustomerControlImp;
import app.CustomerControlInterface;
import app.entities.Title;



public class CreateCostumerFrame extends AbstractFrame{
	private VerwaltungMainFrame mf;
	public CreateCostumerFrame(VerwaltungMainFrame mf) {
		this.mf = mf;
	}
	private JLabel header;

	private JPanel leftPanel;
	private JPanel boxdleftPanel;
	private JLabel title;
	private JLabel costumer;
	private JLabel address;
	private JLabel birthday;

	private JPanel centerPanel;	
	private JPanel boxdCenterPanel;
	private JComboBox<Title> titleSelection;
	private JTextField customerNameInput;
	private JTextField addressInput;
	private DatePicker birthdayPicker;
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	private JButton create;
	private JButton cancel;

	protected void setupInteractions() {
		final FrameSwitcher fs = new FrameSwitchImpl(this,mf);
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Cancel")
					fs.switchFrame();
				else{
					createWidgetFirstView();
				}
			}	
		});
		create.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Create"){
					createWidgetSecondView();			
				}
				else{
					Customer tmp = new Customer(((Title)titleSelection.getSelectedItem()).toString(),customerNameInput.getText(),addressInput.getText(),birthdayPicker.getSelections());
					CustomerControlInterface tmp2 = new CustomerControlImp();
					
					//TODO exception handling
					try {
						tmp.setId(tmp2.create(tmp));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					mf.addProtocolLine("Kunde:\n"+tmp.toString()+"\nwurde in der Datenbank angelegt\n");
					fs.switchFrame();
				}
			}	
		});
	}

	protected void createWidget() {
		header = new JLabel("Kunde Anlegen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(4,1,10,10));

		title = new JLabel("Anrede ");
		title.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		costumer = new JLabel("Name ");
		costumer.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		address = new JLabel("Adresse ");
		address.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		birthday = new JLabel("Geburstag ");
		birthday.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));

		centerPanel = new JPanel();	
		centerPanel.setLayout(new GridLayout(4,1,10,10));

		titleSelection = new JComboBox<Title>(Title.values());

		customerNameInput =  new JTextField();
		customerNameInput.setFont(header.getFont().deriveFont(Font.BOLD , 20));
		addressInput =  new JTextField();
		addressInput.setFont(header.getFont().deriveFont(Font.BOLD , 20));
		birthdayPicker = new DatePicker(false);
		birthdayPicker.setFont(header.getFont().deriveFont(Font.BOLD , 20));

		boxdCenterPanel = new JPanel();	
		boxdCenterPanel.setLayout(new BoxLayout(boxdCenterPanel,BoxLayout.PAGE_AXIS));


		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		create = new JButton("Anlegen");
		create.setPreferredSize(new Dimension(20, 30));
		create.setActionCommand("Create");

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
		leftPanel.add(title);
		leftPanel.add(costumer);
		leftPanel.add(address);
		leftPanel.add(birthday);
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(titleSelection);
		centerPanel.add(customerNameInput);
		centerPanel.add(addressInput);
		centerPanel.add(birthdayPicker);
		boxdCenterPanel.add(centerPanel);
		boxdCenterPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdCenterPanel);
		southPanel.add(create);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);


	}

	private void createWidgetSecondView(){
		customerNameInput.setEditable(false);
		addressInput.setEditable(false);
		birthdayPicker.setEnabled(false);
		titleSelection.setEnabled(false);
		create.setText("Korrekt");		
		create.setActionCommand("accept");
		cancel.setText("Fehler");		
		cancel.setActionCommand("Revise");
	}
	private void createWidgetFirstView(){
		customerNameInput.setEditable(true);
		addressInput.setEditable(true);
		birthdayPicker.setEnabled(true);
		titleSelection.setEnabled(true);
		create.setText("Anlegen");		
		create.setActionCommand("Create");
		cancel.setText("Abbruch");		
		cancel.setActionCommand("Cancel");
	}

}
