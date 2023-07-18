package swingDemo2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;
import java.io.*;
import java.util.Map;

public class EventEditor extends JFrame{
     public EventEditor(String head) {
    	 this.setTitle(head);
    	 this.setLayout(null);
    	 this.setSize(300,330);
    	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	 
    	 JTextArea ta = new JTextArea();
    	 ta.setLineWrap(true);
    	 ta.setBounds(10, 10, 280, 230);
    	 this.add(ta);
    	 
    	 JButton saveBtn = new JButton("save");
    	 JButton delBtn = new JButton("delete");
    	 
    	 if(Main.allEvents.containsKey(head)) {
    		 ta.setText(Main.allEvents.get(head));
    	 }
    	 
    	 saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String key = head;
				String content = ta.getText();
				Main.allEvents.put(key, content);
				
				File file = new File("eventfiles.dat");
				  
		        BufferedWriter bf = null;
		  
		        try {
		  
		            // create new BufferedWriter for the output file
		            bf = new BufferedWriter(new FileWriter(file));
		  
		            // iterate map entries
		            for (Map.Entry<String, String> entry :
		                 Main.allEvents.entrySet()) {
		  
		                // put key and value separated by a colon
		                bf.write(entry.getKey() + ":"
		                         + entry.getValue());
		  
		                // new line
		                bf.newLine();
		            }
		  
		            bf.flush();
		        }
		        catch (IOException e) {
		            e.printStackTrace();
		        }
		        finally {
		  
		            try {
		  
		                // always close the writer
		                bf.close();
		            }
		            catch (Exception e) {
		            }
		        }
				
				
			}
		});
    	 
    	 delBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    	 
    	 saveBtn.setBounds(10, 240, 100, 30);
    	 this.add(saveBtn);
    	 
    	 
    	 this.setVisible(true);
     }
}
