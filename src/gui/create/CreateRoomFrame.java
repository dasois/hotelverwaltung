package gui.create;

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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.RoomControlImp;
import app.RoomControlInterface;

@SuppressWarnings("serial")
public class CreateRoomFrame extends AbstractFrame{
	private JLabel header;
	private JPanel leftPanel;
	private JPanel boxdleftPanel;
	private JPanel centerPanel;
	private JPanel boxdCenterPanel;
	private JLabel roomPrice;
	private JLabel doubleRoom;
	private JTextField price;
	private JCheckBox doubleRoomCheck;
	private JButton create;
	private JButton cancel;
	private JPanel southPanel;
	private JPanel boxdsouthPanel;
	VerwaltungMainFrame mf;
	
	public CreateRoomFrame(VerwaltungMainFrame mf) {
		this.mf = mf;
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
		
		price = new JTextField();
		doubleRoomCheck = new JCheckBox();
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
		centerPanel.add(price);
		centerPanel.add(doubleRoomCheck);
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
		final FrameSwitcher fs = new FrameSwitchImpl(this,mf);
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Revise")
					createWidgetFirstView();
				else{
					fs.switchFrame();
				}				
			}	
		});
		create.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Create")
					createWidgetSecondView();
				else{
					RoomControlInterface controller = new RoomControlImp();
					//TODO sinnvolle exception
					try {
						int roomId = controller.create(Double.parseDouble(price.getText()),doubleRoomCheck.isSelected());
						mf.addProtocolLine("Zimmer: "+roomId+" wurde mit dem Preis: "+Double.parseDouble(price.getText())
								+"€ in der Datenbank angelegt\n");
						fs.switchFrame();
					} catch (NumberFormatException | SQLException e1) {
						mf.addProtocolLine("Es konnte kein Zimmer erstellt werden, rufen sie ihren Administrator");
					}						
				}				
			}	
		});
	}


	private void createWidgetSecondView(){
		price.setEditable(false);
		doubleRoomCheck.setEnabled(false);
		create.setText("Korrekt");		
		create.setActionCommand("accept");
		cancel.setText("Fehler");		
		cancel.setActionCommand("Revise");
	}
	private void createWidgetFirstView(){
		price.setEditable(true);
		doubleRoomCheck.setEnabled(true);
		create.setText("Anlegen");		
		create.setActionCommand("Create");
		cancel.setText("Abbruch");		
		cancel.setActionCommand("Cancel");
	}
}
