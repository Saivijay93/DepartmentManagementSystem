
package org.java.model;

import java.sql.*;  
import java.io.*;  
public class Small {  
public static void main(String[] args) {  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/mahiproject","root","password");  
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from cust where ssc='3232'");
 

	int i = 0;
	while (rs.next()) {
		System.out.println("hello small");
		InputStream in = rs.getBinaryStream(1);
		OutputStream f = new FileOutputStream(new File("test"+i+".jpg"));
		i++;
		int c = 0;
		while ((c = in.read()) > -1) {
			f.write(c);
		}
		
		f.close();
		in.close();
	}  
 
System.out.println("ok");  
              
con.close();  
}catch (Exception e) {e.printStackTrace();  }  
}  
}  