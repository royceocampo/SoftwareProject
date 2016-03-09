package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbconnection.DBConnection;
import managers.Product;

public class GetProduct {
	private Connection conn;
	private Statement ps;
	private ResultSet rs;
	
	private ArrayList<Product> p = new ArrayList<Product>();
	
	public GetProduct(){
		conn = new DBConnection().getConnection();	
	}
	
	public ArrayList<Product> getProduct(){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("SELECT * FROM products_table;");
		
		p.clear();
		while(rs.next()){
			String a = rs.getString("purchaseID");
			String b = rs.getString("product");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("stocks");
			
			Product pd = new Product(b,c,d,e,f,g,h);
			p.add(pd);
			
		}
		return p;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
}
