package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Connection successful!");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rgftc_inventory", "root", "p@ssword");
//			System.out.println("Connected!");
			return conn;
		}
		catch(Exception e){
			System.out.println("Unable to connect.");
			System.out.println("Error: "+e);
		}
		return null;
	}
}
