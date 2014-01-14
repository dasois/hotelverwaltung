package gui.book.room;

import gui.AbstractFrame;
import gui.DatePicker;
import gui.FrameSwitcher;
import gui.SimpleTime;
import gui.VerwaltungMainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



@SuppressWarnings("serial")
public class SelectTimeIntervallRoomFrame extends AbstractFrame{

	private VerwaltungMainFrame mf;
	private JLabel header;
	private JPanel leftPanel;
	private JLabel startDate;
	private JLabel endDate;
	private JPanel boxdleftPanel;
	private JPanel centerPanel;
	private DatePicker startDatePicker;
	private DatePicker endDatePicker;
	private JPanel boxdCenterPanel;
	private JPanel southPanel;
	protected JButton search;
	protected JButton cancel;
	private JPanel boxdsouthPanel;
	
	public SelectTimeIntervallRoomFrame(VerwaltungMainFrame mf) {
		this.mf = mf;
	}	

	protected void createWidget() {
		header = new JLabel("Zimmer Buchen");
		header.setPreferredSize(new Dimension(400,40));
		header.setForeground(Color.WHITE);
		header.setBackground(Color.BLACK);
		header.setOpaque(true);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 30));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2,1,10,10));

		startDate = new JLabel("Von ");
		startDate.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		endDate = new JLabel("Bis ");
		endDate.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC , 20));

		boxdleftPanel = new JPanel();
		boxdleftPanel.setLayout(new BoxLayout(boxdleftPanel,BoxLayout.PAGE_AXIS));

		centerPanel = new JPanel();	
		centerPanel.setLayout(new GridLayout(2,1,10,10));

		startDatePicker = new DatePicker(true);
		endDatePicker = new DatePicker(true);

		boxdCenterPanel = new JPanel();	
		boxdCenterPanel.setLayout(new BoxLayout(boxdCenterPanel,BoxLayout.PAGE_AXIS));

		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,2,10,10));

		search = new JButton("Suchen");
		search.setPreferredSize(new Dimension(20, 30));
		search.setActionCommand("Search");

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
		leftPanel.add(startDate);
		leftPanel.add(endDate);
		boxdleftPanel.add(leftPanel);
		boxdleftPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.WEST,boxdleftPanel);
		centerPanel.add(startDatePicker);
		centerPanel.add(endDatePicker);
		boxdCenterPanel.add(centerPanel);
		boxdCenterPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.CENTER,boxdCenterPanel);
		southPanel.add(search);
		southPanel.add(cancel);
		boxdsouthPanel.add(southPanel);
		boxdsouthPanel.add(Box.createVerticalGlue());
		getContentPane().add(BorderLayout.SOUTH,boxdsouthPanel);
	}
	protected void setupInteractions() {
		final FrameSwitcher fs = new FrameSwitchImpl(this,mf);
		
		final SelectTimeIntervallRoomFrame srf = this;
		
		cancel.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
					fs.switchFrame();
			}			
		});
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				FreeRoomsFrame ff = new FreeRoomsFrame(mf,srf);
				ff.init();
				ff.setVisible(false);
				FrameSwitcher fs2 = new FrameSwitchImpl(srf,ff);
					fs2.switchFrame();
			}
		});
	}
	public SimpleTime getStartDate(){
		return startDatePicker.getSelectionSimpleTime();
	}
	public SimpleTime  getEndDate(){
		return startDatePicker.getSelectionSimpleTime();
	}
	public SimpleTime[] getTimeInterval(){
		ArrayList<SimpleTime> time = new ArrayList<SimpleTime>();
		time.add(getStartDate());
		SimpleTime tmp = getStartDate();
		while(!tmp.equals(getEndDate())){
			tmp = tmp.getNextDay();
			time.add(tmp);
		}
		return time.toArray(new SimpleTime[0]);
	}
}
