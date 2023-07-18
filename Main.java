package swingDemo2;

import java.util.*;
import java.io.*;


public class Main {
	public static HashMap<String, String> allEvents;
	
	public static Map<String, String> HashMapFromTextFile()
    {
  
        Map<String, String> map
            = new HashMap<String, String>();
        BufferedReader br = null;
  
        try {
  
            // create file object
            File file = new File("eventfiles.dat");
  
            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // read file line by line
            while ((line = br.readLine()) != null) {
  
                // split the line by :
                String[] parts = line.split(":");
  
                // first part is name, second is number
                String key = parts[0].trim();
                String value = parts[1].trim();
  
                // put name, number in HashMap if they are
                // not empty
                if (!key.equals("") && !value.equals(""))
                    map.put(key, value);
            }
        }
        catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter outputStream;
			try {
				outputStream = new PrintWriter(new FileOutputStream("eventfiles.dat"));
				outputStream.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
        return map;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allEvents = new HashMap<String, String>();
		allEvents = (HashMap<String, String>) HashMapFromTextFile();
		
		
		
		MyFrame mf = new MyFrame();

	}

}
