package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class VerwaltungMainFrame extends AbstractFrame{

	private JLabel header;
	private JPanel leftPanel;
	JComboBox<String> khd;
	JComboBox actions;
	private ComboBoxModel model[];

	private JButton action;
	private JTable db;
	private JScrollPane scrollTable;
	private JPanel boxdleftPanel;

	protected void createWidget() {
		header = new JLabel("Hausverwaltung");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));	

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(3,1,10,10));
		action = new JButton("Aktion");
		action.setActionCommand("action");
		db = new JTable(100,4);
		scrollTable = new JScrollPane(db);
		khd = new JComboBox<String>(new String[]{"Kunden","Zimmer","Leistung"});

		actions = new JComboBox<Object>();
		model = new ComboBoxModel[2];
		model[0] = new DefaultComboBoxModel<Object>(
				new String[]{"Erstellen", "Löschen","Anzeigen"});
		model[1] = new DefaultComboBoxModel<Object>(
				new String[]{"Erstellen","Buchen","Löschen"});
		actions.setModel(model[0]);

		boxdleftPanel = new JPanel();	
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));	
	}

	@Override
	protected void addWidget() {
		getContentPane().setLayout(new BorderLayout(2,2));
		getContentPane().add(BorderLayout.NORTH,header);
		leftPanel.add(khd);
		leftPanel.add(actions);
		leftPanel.add(action);
		leftPanel.setMaximumSize(leftPanel.getPreferredSize());
		leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		getContentPane().add(BorderLayout.CENTER,scrollTable);

	}

	@Override
	protected void setupInteractions() {
		action.addActionListener(new MainButtonHandler(this));
		khd.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = khd.getSelectedIndex();
				if(i==2)
					i--;
		        actions.setModel(model[i]);				
			}
		});
	}

	public static void main(String[] args) {
		VerwaltungMainFrame li = new VerwaltungMainFrame();
		li.init();
	}
}
