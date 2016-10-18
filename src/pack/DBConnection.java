package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBConnection {
	
	
	public static String getEmailFromDB() throws SQLException {
		String email = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","1234");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from user");
			
				
			while(rs.next()) {
					
				email =  rs.getString(2);
				System.out.println(rs.getString(2));
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
		
	}
	
	public static String getPasswordFromDB() throws SQLException {
		String pwd = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart","root","1234");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from user");
			
				
			while(rs.next()) {
					
				pwd =  rs.getString(3);
				System.out.println(rs.getString(3));
			}
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwd;
		
	}

}
