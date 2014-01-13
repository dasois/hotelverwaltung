package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DatePicker extends JPanel implements ActionListener{
	private final JComboBox<Integer> year;

	private JComboBox<Integer> day;
	private JComboBox<Integer> month;	
	private ComboBoxModel<Integer> dayModel[] = new ComboBoxModel[3];

	public DatePicker(boolean present) {
		Date d = new Date(System.currentTimeMillis());
		if(present){
		year = new JComboBox<Integer>(new Integer[]{d.getYear()+1900,d.getYear()+1901,d.getYear()+1902,d.getYear()+1903,d.getYear()+1904});
		}
		else{
			Integer[] nums = new Integer[100];
			for (int i = 0; i < nums.length; i++)
			    nums[i] = d.getYear()+1800+i;
			year = new JComboBox<Integer>(nums);
		}
		month = new JComboBox<Integer>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
		day = new JComboBox<Integer>();
		Integer[] temp = new Integer[31];
		for(int i = 0; i<temp.length; i++){
			temp[i] = i+1;

		}
		dayModel[0] = new DefaultComboBoxModel<Integer>(Arrays.copyOfRange(temp, 0, 28));
		dayModel[1] = new DefaultComboBoxModel<Integer>(Arrays.copyOfRange(temp, 0, 30));
		dayModel[2] = new DefaultComboBoxModel<Integer>(temp);
		day.setModel(dayModel[2]);
		setLayout(new GridLayout(1,3,10,10));
		add(day);
		add(month);
		add(year);
		month.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(month.getSelectedIndex()%2!=0){
			if(month.getSelectedIndex()==1)
				day.setModel(dayModel[0]);		
			else{
				day.setModel(dayModel[2]);	
			}
		}
		else{
			day.setModel(dayModel[1]);	
		}
	}
	
	public void setEnabled(boolean b){
		day.setEnabled(b);
		month.setEnabled(b);
		year.setEnabled(b);
	}

	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}else if(obj instanceof DatePicker){
			DatePicker that = (DatePicker)obj;
			return this.getSelections()==that.getSelections();
		}else{
			return false;
		}	
	}
	public java.sql.Date getSelections(){
		String date = ""+(Integer)day.getSelectedItem()+"."+(Integer)month.getSelectedItem()+"."+(Integer)year.getSelectedItem();
		Date datum;
		java.sql.Date sqlDate = null;
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
			datum = formatter.parse(date);
			sqlDate = new java.sql.Date(datum.getTime());
			return sqlDate;
		} catch (ParseException e) {
			System.out.println("parseFehler");
			e.printStackTrace();
		}
		return sqlDate;
	}	
	public SimpleTime getSelectionSimpleTime(){
		
		return new SimpleTime((Integer)year.getSelectedItem(),(Integer)month.getSelectedItem(),(Integer)day.getSelectedItem());	
	}
//	public SimpleTime getSelections(){
//		SimpleTime tmp = new SimpleTime((Integer)day.getSelectedItem(), (Integer)month.getSelectedItem(),(Integer)year.getSelectedItem());
//		return tmp;		
//	}
}