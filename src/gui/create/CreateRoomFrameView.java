package gui.create;

import gui.AbstractFrame;
import gui.IController;
import gui.MainFrame.VerwaltungMainFrameView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**Frame to register a new room.
 * @author Tobias */
@SuppressWarnings("serial")
public class CreateRoomFrameView extends AbstractFrame{
	private JLabel header;
	private JPanel leftPanel;
	private JPanel boxdleftPanel;
	private JPanel centerPanel;
	private JPanel boxdCenterPanel;
	private JLabel roomPrice;
	private JLabel doubleRoom;
	private JButton create;
	private JButton cancel;
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	VerwaltungMainFrameView mf;
	private CreateRoomModel m;
	private IController c;
	
	public CreateRoomFrameView(VerwaltungMainFrameView mf,IController c,CreateRoomModel m) {
		this.mf = mf;
		this.c = c;
		this.m = m;
	}
	@Override
	protected void createWidget() {
		header = new JLabel("Zimmer hinzufügen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1,10,10));
		roomPrice = new JLabel("Preis ");
		roomPrice.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		doubleRoom = new JLabel("Doppelzimmer? ");
		doubleRoom.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));	

		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1,10,10));
		
		m.setPrice(new JTextField());
		m.setDoubleRoomCheck(new JCheckBox());
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
		leftPanel.add(roomPrice);
		leftPanel.add(doubleRoom);
		leftPanel.setPreferredSize(leftPanel.getPreferredSize());
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(m.getPrice());
		centerPanel.add(m.getDoubleRoomCheck());
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
		cancel.addActionListener(c);
		create.addActionListener(c);
	}

	void createWidgetSecondView(){
		m.getPrice().setEditable(false);
		m.getDoubleRoomCheck().setEnabled(false);
		create.setText("Korrekt");
		create.setActionCommand("accept");
		cancel.setText("Fehler");
		cancel.setActionCommand("Revise");
	}
	void createWidgetFirstView(){
		m.getPrice().setEditable(true);
		m.getDoubleRoomCheck().setEnabled(true);
		create.setText("Anlegen");
		create.setActionCommand("Create");
		cancel.setText("Abbruch");
		cancel.setActionCommand("Cancel");
	}
}