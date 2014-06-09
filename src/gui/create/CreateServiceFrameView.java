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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.ServiceControlImp;
import app.ServiceControlInterface;

/**Frame to register a new service.
 * @author Tobias */
@SuppressWarnings("serial")
public class CreateServiceFrameView extends AbstractFrame{
	private JLabel header;
	private JPanel leftPanel;
	private JPanel boxdleftPanel;
	private JLabel serviceName;
	private JLabel servicePrice;

	private JPanel centerPanel;
	private JPanel boxdCenterPanel;

	private JButton create;
	private JButton cancel;		
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	private VerwaltungMainFrameView mf;
	private CreateServiceFrameModel m;

	public CreateServiceFrameView(VerwaltungMainFrameView mf) {
		this.mf = mf;
		m = new CreateServiceFrameModel();
	}

	protected void createWidget() {
		header = new JLabel("Dienstleistung hinzufügen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1,10,10));

		serviceName = new JLabel("Name ");
		serviceName.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		servicePrice = new JLabel("Preis ");
		servicePrice.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));	

		centerPanel = new JPanel();	
		centerPanel.setLayout(new GridLayout(2,1,10,10));

		m.setName(new JTextField());
		m.setPrice(new JTextField());

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
		leftPanel.add(serviceName);
		leftPanel.add(servicePrice);
		leftPanel.setPreferredSize(leftPanel.getPreferredSize());
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(m.getName());
		centerPanel.add(m.getPrice());
		boxdCenterPanel.add(centerPanel);
		boxdCenterPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdCenterPanel);

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		southPanel.add(create);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
	protected void setupInteractions() {
		CreateServiceFrameController c = new CreateServiceFrameController(this, mf,m);
		cancel.addActionListener(c);
		create.addActionListener(c);
	}
	void createWidgetSecondView(){
		m.getName().setEditable(false);
		m.getPrice().setEditable(false);
		create.setText("Korrekt");
		create.setActionCommand("accept");
		cancel.setText("Fehler");
		cancel.setActionCommand("Revise");
	}
	void createWidgetFirstView(){
		m.getName().setEditable(true);
		m.getPrice().setEditable(true);
		create.setText("Anlegen");
		create.setActionCommand("Create");
		cancel.setText("Abbruch");
		cancel.setActionCommand("Cancel");
	}

	public String getName() {
		return m.getName().getText();
	}
}