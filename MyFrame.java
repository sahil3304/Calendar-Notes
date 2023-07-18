package swingDemo2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;


public class MyFrame extends JFrame{
	
   private boolean checkValidDate(int year, int date, int mon) {
	   boolean validDate = true;
	   if((mon==2)&&(date>29) && (year%4==0))
		   validDate = false;
	   else if((mon==2)&&(date>28) && (year%4!=0))
		   validDate = false;
	   else if(( (mon==1) || (mon==3) || (mon==5) || (mon==7) || (mon==8) || (mon==10) || (mon==12)  )&&(date>31))
		   validDate = false;
	   else if(( (mon==2) || (mon==4) || (mon==6) || (mon==9) || (mon==11)  )&&(date>30))
		   validDate = false;
	   
	   return validDate;
   }
	
   public MyFrame() {
	   this.setTitle("My Scheduler");
	   this.setResizable(false);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	   JLabel yearLbl = new JLabel("Year");
	   JLabel monLbl = new JLabel("Month");
	   JComboBox<String> monList = new JComboBox<String>();
	   JTextField yearTxt = new JTextField();
	   JButton btn = new JButton("Show");
	   yearLbl.setBounds(10,10,60,30);
	   yearTxt.setBounds(80,10,60,30);
	   yearTxt.setHorizontalAlignment(SwingConstants.CENTER);
	   monLbl.setBounds(150,10,60,30);
	   monList.setBounds(220,10,140,30);
	   btn.setBounds(370,10,100,30);
	   
	   JLabel sundLbl = new JLabel("SUN");
	   sundLbl.setBounds(10, 60, 75, 40);
	   sundLbl.setForeground(Color.red);
	   sundLbl.setFont(sundLbl.getFont().deriveFont(16f));
	   sundLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(sundLbl);
	   
	   JLabel mondLbl = new JLabel("MON");
	   mondLbl.setBounds(85, 60, 75, 40);
	   mondLbl.setFont(mondLbl.getFont().deriveFont(16f));
	   mondLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(mondLbl);
	   
	   JLabel tuedLbl = new JLabel("TUE");
	   tuedLbl.setBounds(160, 60, 75, 40);
	   tuedLbl.setFont(tuedLbl.getFont().deriveFont(16f));
	   tuedLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(tuedLbl);
	   
	   JLabel weddLbl = new JLabel("WED");
	   weddLbl.setBounds(235, 60, 75, 40);
	   weddLbl.setFont(weddLbl.getFont().deriveFont(16f));
	   weddLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(weddLbl);
	   
	   JLabel thudLbl = new JLabel("THU");
	   thudLbl.setBounds(310, 60, 75, 40);
	   thudLbl.setFont(thudLbl.getFont().deriveFont(16f));
	   thudLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(thudLbl);
	   
	   JLabel fridLbl = new JLabel("FRI");
	   fridLbl.setBounds(385, 60, 75, 40);
	   fridLbl.setFont(fridLbl.getFont().deriveFont(16f));
	   fridLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(fridLbl);
	   
	   JLabel satdLbl = new JLabel("SAT");
	   satdLbl.setBounds(450, 60, 75, 40);
	   satdLbl.setFont(satdLbl.getFont().deriveFont(16f));
	   satdLbl.setHorizontalAlignment(SwingConstants.CENTER);
	   this.add(satdLbl);
	   
	   JButton dates[] = new JButton[42];
	   NewActionListener listeners[] = new NewActionListener[42];
	   
	   monList.addItem("Select");
	   monList.addItem("January");
	   monList.addItem("February");
	   monList.addItem("March");
	   monList.addItem("April");
	   monList.addItem("May");
	   monList.addItem("June");
	   monList.addItem("July");
	   monList.addItem("August");
	   monList.addItem("September");
	   monList.addItem("October");
	   monList.addItem("November");
	   monList.addItem("December");
	  
	   
	   int vshift = 100;
	   int hshift = 10;
	   int buttonsize = 75;
	   java.util.Date date = new java.util.Date();
	   int yearVal1 = date.getYear();
	   int dateVal1 = 1;
	   int monVal1 = date.getMonth();
	   System.out.println("Date: "+date.getDate());   
	    System.out.println("Month: "+date.getMonth());
	    System.out.println("Year: "+(date.getYear()+1900));
	    System.out.println("Day of week: "+(date.getDay()));
	   
	   java.util.Date date21 = new java.util.Date(yearVal1,monVal1,dateVal1);
	   
	   
	   
	   for(int i=0;i<6;i++) {
		   for(int j=0;j<7;j++) {
			   dates[i*7+j] = new JButton(""+(i*7+j));
			   dates[i*7+j].setBounds(hshift+(j*buttonsize),vshift+(i*buttonsize), buttonsize, buttonsize);
			   listeners[i*7+j] = new NewActionListener((i*7+j), 0, 0, 0);
			   dates[i*7+j].addActionListener(listeners[i*7+j]);
			   dates[i*7+j].setFont(dates[i*7+j].getFont().deriveFont(18f));
			   if(j==0) {
				   dates[i*7+j].setForeground(Color.red);
			   }
			   this.add(dates[i*7+j]);
		   }
	   }
	   
	   int startingIndex1 = date21.getDay();
	   System.out.println(startingIndex1+" **");
	   monList.setSelectedIndex(date21.getMonth()+1);
	   yearTxt.setText(""+(date21.getYear()+1900));
	   int dateCounter = 1;
		for(int i=0;i<6;i++) {
			   for(int j=0;j<7;j++) {
				   if((i*7+j)<startingIndex1) {
					   dates[i*7+j].setText("");
					   dates[i*7+j].setEnabled(false);
				   }
				   else if(!checkValidDate((yearVal1+1900),dateCounter,monVal1+1)) {
					   dates[i*7+j].setText("");
					   dates[i*7+j].setEnabled(false);
				   }
				   else {
					   dates[i*7+j].setText(""+dateCounter);
					   dates[i*7+j].setEnabled(true);
					   listeners[i*7+j].date = dateCounter;
					   listeners[i*7+j].month = monVal1;
					   listeners[i*7+j].year = yearVal1+1900;
					   listeners[i*7+j].day = (j);
					   dateCounter++;
				   }
			   }
		}
	   
	   
	   btn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int yearVal = 0;
			int dateVal = 0;
			int monVal = 0;
			try {
				yearVal = Integer.parseInt(yearTxt.getText());
				if(yearVal<1900) {
					JOptionPane.showMessageDialog(MyFrame.this, "Give a year >= 1900",
        	                "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(MyFrame.this, "Invalid year format",
    	                "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				dateVal = 1;
				monVal = monList.getSelectedIndex();
				if(monVal == 0) {
					JOptionPane.showMessageDialog(MyFrame.this, "Select a month",
	    	                "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					if((dateVal<0)||(!checkValidDate(yearVal,dateVal,monVal))) {
						JOptionPane.showMessageDialog(MyFrame.this, "Invalid date value",
		    	                "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(MyFrame.this, "Invalid year format",
    	                "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(dateVal>0 && monVal>0 && yearVal>1899) {
				java.util.Date date2 = new Date((yearVal-1900), monVal-1, dateVal);
				int startingIndex = date2.getDay();
				int dateCntr = 1;
				for(int i=0;i<6;i++) {
					   for(int j=0;j<7;j++) {
						   if((i*7+j<startingIndex)) {
							   dates[i*7+j].setText("");
							   dates[i*7+j].setEnabled(false);
						   }
						   else if(!checkValidDate(yearVal,dateCntr,monVal)) {
							   dates[i*7+j].setText("");
							   dates[i*7+j].setEnabled(false);
						   }
						   else {
							   dates[i*7+j].setText(""+dateCntr);
							   listeners[i*7+j].date = dateCntr;
							   listeners[i*7+j].month = monVal;
							   listeners[i*7+j].year = yearVal;
							   listeners[i*7+j].day = (j);
							   dates[i*7+j].setEnabled(true);
							   dateCntr++;
						   }
					   }
				}
			}
		}
	});
	   
	   
	   this.add(yearLbl);
	   this.add(monLbl);
	   this.add(yearTxt);
	   this.add(monList);
	   this.add(btn);
	   this.setSize(545,595);
	   this.setLayout(null);
	   this.setVisible(true);
   }
}
