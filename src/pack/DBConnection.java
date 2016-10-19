package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static String getEmailFromDB() throws SQLException {
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

	public static String getPasswordFromDB() throws SQLException {
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
		String str = itemName;
		int id = userID;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into cart(ProductDetail,ID) values('" + str + "','" + id + "');");
			System.out.println("Product has been added");
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static int getIdFromEmailDB(String userEmail) throws SQLException {
		String email = userEmail;
		int newId = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipkart", "root", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select id from user where email='" + email + "';");

			while (rs.next()) {
				newId = Integer.parseInt(rs.getString(1));
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newId;
	}

}
