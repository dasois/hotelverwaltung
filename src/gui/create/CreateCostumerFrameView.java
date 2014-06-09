package gui.create;

import gui.AbstractFrame;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import app.CustomerControlImp;
import app.CustomerControlInterface;
import app.entities.Title;

/**Frame to register a new customer.
 * @author Tobias */
@SuppressWarnings("serial")
public class CreateCostumerFrameView extends AbstractFrame{
	private VerwaltungMainFrameView mf;
	private CreateCostumerFrameModel m;
	public CreateCostumerFrameView(VerwaltungMainFrameView mf) {
		this.mf = mf;
		m = new CreateCostumerFrameModel();
	}
	private JLabel header;

	private JPanel leftPanel;
	private JPanel boxdleftPanel;
	private JLabel title;
	private JLabel costumerFirstN;
	private JLabel costumerLastN;
	private JLabel address;
	private JLabel birthday;
	private JPanel centerPanel;	
	private JPanel boxdCenterPanel;
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	private JButton create;
	private JButton cancel;

	protected void setupInteractions() {
		CreateCostumerFrameController ccfc = new CreateCostumerFrameController(this, mf,m);
		cancel.addActionListener(ccfc);
		create.addActionListener(ccfc);
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
		leftPanel.setLayout(new GridLayout(5,1,10,10));

		title = new JLabel("Anrede ");
		title.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		costumerFirstN = new JLabel("Vorname ");
		costumerFirstN.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));
		
		costumerLastN = new JLabel("Nachname ");
		costumerLastN.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));
		
		address = new JLabel("Adresse ");
		address.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		birthday = new JLabel("Geburstag ");
		birthday.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));

		centerPanel = new JPanel();	
		centerPanel.setLayout(new GridLayout(5,1,10,10));

		m.setTitleSelection(new JComboBox<Title>(Title.values()));

		m.setCustomerFirstNameInput(new JTextField());
		m.getCustomerFirstNameInput().setFont(header.getFont().deriveFont(Font.BOLD , 20));
		m.setCustomerLastNameInput( new JTextField());
		m.getCustomerLastNameInput().setFont(header.getFont().deriveFont(Font.BOLD , 20));
		m.setAddressInput(new JTextField());
		m.getAddressInput().setFont(header.getFont().deriveFont(Font.BOLD , 20));
		m.setBirthdayPicker(new JDateChooser());
		m.getBirthdayPicker().setFont(header.getFont().deriveFont(Font.BOLD , 20));

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
		leftPanel.add(costumerFirstN);
		leftPanel.add(costumerLastN);
		leftPanel.add(address);
		leftPanel.add(birthday);
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(m.getTitleSelection());
		centerPanel.add(m.getCustomerFirstNameInput());
		centerPanel.add(m.getCustomerLastNameInput());
		centerPanel.add(m.getAddressInput());
		centerPanel.add(m.getBirthdayPicker());
		boxdCenterPanel.add(centerPanel);
		boxdCenterPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdCenterPanel);
		southPanel.add(create);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}

	void createWidgetSecondView(){
		m.getCustomerFirstNameInput().setEditable(false);
		m.getCustomerLastNameInput().setEditable(false);
		m.getAddressInput().setEditable(false);
		m.getBirthdayPicker().setEnabled(false);
		m.getTitleSelection().setEnabled(false);
		create.setText("Korrekt");
		create.setActionCommand("accept");
		cancel.setText("Fehler");
		cancel.setActionCommand("Revise");
	}
	void createWidgetFirstView(){
		m.getCustomerFirstNameInput().setEditable(true);
		m.getAddressInput().setEditable(true);
		m.getBirthdayPicker().setEnabled(true);
		m.getTitleSelection().setEnabled(true);
		create.setText("Anlegen");
		create.setActionCommand("Create");
		cancel.setText("Abbruch");
		cancel.setActionCommand("Cancel");
	}
}