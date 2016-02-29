package dbconnectionlib;

import java.sql.*;

public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver found.");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found.");
		}
		
		String url = "jdbc:mysql://localhost:3306/?user=root/foobar_sql";
		String user = "root";
		String password = "p@ssword";
				
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection successful!");
		}
		catch(SQLException e){
			System.out.println("Something is wrong with the connection string.");
		}
		
	}

}
