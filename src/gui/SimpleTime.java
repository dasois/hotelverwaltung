package gui;

public class SimpleTime {
	private int day;
	private int month;
	private int year;
	private int monthDays;
	public SimpleTime(int d,int m,int y){
		setDay(d);
		setMonth(m);
		setYear(y);

		if(m%2!=0){
			monthDays = 31;
		}else{
			if(m==2){
				if(y%4==0){
					monthDays = 29;
				}else{
					monthDays = 28;
				}
			}else{
				monthDays = 30;
			}
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String toString(){
		return ""+day+"."+month+"."+year;
	}
	public SimpleTime getNextDay(){
		if(day==monthDays){
			if(month==12){
				return new SimpleTime(1,1,year+1);
			}else{
				return new SimpleTime(1,month+1,year);
			}
		}else{
			return new SimpleTime(day+1,month,year);
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj){
			return true;
		}else if(obj instanceof SimpleTime){
			SimpleTime s = (SimpleTime)obj;
			return (this.day==s.getDay()&&this.month==s.getMonth()&&this.year==s.getYear());
		}else{
			return false;
		}
	}
}
