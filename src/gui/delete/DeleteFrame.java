package gui.delete;

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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import app.DeleteControlImp;
import app.DeleteControlInterface;
import gui.AbstractFrame;
import gui.FrameSwitcher;
import gui.VerwaltungMainFrame;


@SuppressWarnings("serial")
public class DeleteFrame<T> extends AbstractFrame{
	private VerwaltungMainFrame mf;
	private JLabel header;
	private JPanel southPanel;
	private JButton delete;
	private JButton cancel;
	private JPanel boxdsouthPanel;
	private JList<T> list;
	private JScrollPane listScroller;
	private String label;
	public DeleteFrame(VerwaltungMainFrame mf,String label,JList<T> list) {
		this.mf = mf;
		this.label = label;
		this.list = list;
	}
	
	@Override
	protected void createWidget() {
		header = new JLabel(label);
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));
		
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setVisibleRowCount(-1);
		listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
			
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		delete = new JButton("Löschen");
		delete.setPreferredSize(new Dimension(20, 30));
		delete.setActionCommand("Delete");

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
		getContentPane().add(BorderLayout.CENTER,listScroller);

		southPanel.add(delete);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
	
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
		delete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Delete"){
					createWidgetSecondView();
				}
				else{
					DeleteControlInterface<T> controller = new DeleteControlImp<>();	
					//TODO sinnvolle exception
					try {
						controller.deleteEntitie(list.getSelectedValue());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					mf.addProtocolLine("--Löschen--\n"+list.getSelectedValue().toString()+"\nwurde in der Datenbank gelöscht\n");
					fs.switchFrame();
				}
			}	
		});
	}
	private void createWidgetSecondView(){
		list.setEnabled(false);		
		delete.setText("Korrekt");		
		delete.setActionCommand("accept");
		cancel.setText("Fehler");		
		cancel.setActionCommand("Revise");
	}
	private void createWidgetFirstView(){
		list.setEnabled(true);	
		delete.setText("Anlegen");		
		delete.setActionCommand("Create");
		cancel.setText("Abbruch");		
		cancel.setActionCommand("Cancel");
	}
}
