package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
		public DBConnection(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connection successful!");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rgftc_inventory", "root", "p@ssword");
				stmt = conn.createStatement();
			}
			catch(Exception e){
				System.out.println("Error: "+e);
			}
		}
		
//		public void getData(){
//			try{
//				String query = "SELECT * FROM product";
//				rs = stmt.executeQuery(query);
//				System.out.println("Records from database:");
//				while (rs.next()){
//					String product = rs.getString("ProductName");
//					float price = rs.getFloat("Price/kg");
//					System.out.println("Product: "+product+ " Price: "+price);
//				}
//			}
//			catch(Exception ex){
//				System.out.println(ex);
//			}
//		}
}
