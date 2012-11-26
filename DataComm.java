
package datacomm;

import java.io.*;
import java.net.*;

/**
 *
 * @author Frank Gadri
 */
public class DataComm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try  {
               // String data1 = URLEncoder.encode("first", "UTF-8") + "=" + URLEncoder.encode("Fred", "UTF-8"); 
//  			  String data = URLEncoder.encode("User ID:", "UTF-8") + "="  + URLEncoder.encode ("1", "UTF-8");
//                String data1 = URLEncoder.encode("Start Time:", "UTF-8") + "=" + URLEncoder.encode ("1:30", "UTF-8");
//                String data2 = URLEncoder.encode("End Time:", "UTF-8") + "="  + URLEncoder.encode ("4:30", "UTF-8");
//                String data3 = URLEncoder.encode("Mileage:", "UTF-8") + "="  + URLEncoder.encode ("9999", "UTF-8");
//                String data4 = URLEncoder.encode("Start Location:", "UTF-8") + "="  + URLEncoder.encode ("SomeWhere", "UTF-8");
//                String data5= URLEncoder.encode("End Location:", "UTF-8") + "="  + URLEncoder.encode ("Where we stop", "UTF-8");

                
                String data = ("user ID: 1");
                 String data1 =("Start Time: 1:30pm ") ;
                String data2 = ("End Time: 4:30pm ");
                String data3 = ("Mileage: 1000");
                 String data4 = ("Starts Location: Someplace somwhere ");
                String data5 = ("End Location: The place that we stopped ");
                
                
                
                String Inline;
                 //URL u1 = new URL("http://cs2450.intogeek.com/postFromPhone.php?");  
                 URL u1 = new URL ("http://cs2450.intogeek.com/postFromPhone.php?user_id=1&start_"
                         + "time=9:00pm&end_time=9:30pm&mileage=89000&start_location=Orem%20Bulevard&end_location=Salt%20lake%20city");
                 
              
               URLConnection uc1 = u1.openConnection();
                uc1.setDoOutput(true);  
               
                        
                OutputStreamWriter out = new OutputStreamWriter(uc1.getOutputStream()); 
              
                 out.write(data); 
                 out.write(data1);
                 out.write(data2);
                 out.write(data3);
                 out.write(data4);
                 out.write(data5);
                 System.out.println(data1);
                 out.flush();  
                
                BufferedReader in = new BufferedReader( new InputStreamReader( uc1.getInputStream() ) ); 
                
                 while ((Inline = in.readLine()) != null)
                 {  
               System.out.println(Inline);  
               }  
                
                in.close();
            
             }
        catch(Exception e)
        {
        }
        
    }
}
