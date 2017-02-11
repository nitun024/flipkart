package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static String getEmailfromMySQL() throws SQLException {
		String email = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");

			while (rs.next()) {
				email = rs.getString(2);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return email;

	}

	public static String getPasswordFromMySQL() throws SQLException {
		String pwd = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");

			while (rs.next()) {
				pwd = rs.getString(3);
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pwd;

	}

	public static void putItemIntoCartDB(String itemName, int userID) throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into item(ProductName,Id) values('" + itemName + "'," + userID+ ");");
			System.out.println("Product has been added");
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static int getIdFromEmailDB(String userEmail) throws SQLException {
		int newId = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id from user where email='" + userEmail + "';");

			while (rs.next()) {
				newId = Integer.parseInt(rs.getString(1));
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newId;
	}
	
	public static String getEmailfromSQLServer() throws ClassNotFoundException, SQLException {
		
		String boom = null;
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://NITUNP-L;databasename=Flipkart","","");
		Statement sta = conn.createStatement();
		String Sql = "select top 1 * from hra";
		ResultSet rs = sta.executeQuery(Sql);
			System.out.println(rs);
		while (rs.next()) {
			System.out.println(Integer.toString(rs.getInt("FirstName")));
			System.out.println(Integer.toString(rs.getInt("LastName")));

		}
		return boom;
	}

}
