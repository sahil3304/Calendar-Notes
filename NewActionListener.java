package swingDemo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewActionListener implements ActionListener{
    int date;
    int year;
    int month;
    int day;
    public NewActionListener(int date, int year, int month, int day) {
    	this.date = date;
    	this.year = year;
    	this.month = month;
    	this.day = day;
    }
    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("The day is: "+this.day);
		System.out.println("The date is: "+this.date);
		System.out.println("The month is: "+this.month);
		System.out.println("The year is: "+this.year);
		new EventEditor(this.date+"-"+this.month+"-"+this.year);
		
	}

}
