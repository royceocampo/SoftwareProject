package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbconnection.DBConnection;
import managers.Order;

public class GetOrders {
	
	private Connection conn;
	private Statement ps;
	private ResultSet rs;
	private ArrayList<Order> o = new ArrayList<Order>();

	public GetOrders(){
		conn = new DBConnection().getConnection();
		
	}
	

	
	public ArrayList<Order> getOrder(){
		
			try {
				ps = conn.createStatement();
			
			rs = ps.executeQuery("SELECT * FROM orders_table;");
			
			o.clear();
			while(rs.next()){
				String a = rs.getString("purchase_orderID");
				String b = rs.getString("clientName");
				Float c = rs.getFloat("price");
				String d = rs.getString("orderReceiver");
				Date e = rs.getDate("deliveryDueDate");
				Boolean f = rs.getBoolean("deliveryStatus");
				String g = rs.getString("notes");
				
				Order od = new Order(b,c,d,e,f,g);
				o.add(od);
				
			}
			return o;
//			rs.close();
//			ps.close();
//			conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return null;
	}
	
	public ArrayList<Order> getOrderDueDate(){
		
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("SELECT * FROM orders_table ORDER BY deliveryDueDate;");
		
		o.clear();
		while(rs.next()){
			String a = rs.getString("purchase_orderID");
			String b = rs.getString("clientName");
			Float c = rs.getFloat("price");
			String d = rs.getString("orderReceiver");
			Date e = rs.getDate("deliveryDueDate");
			Boolean f = rs.getBoolean("deliveryStatus");
			String g = rs.getString("notes");
			
			Order od = new Order(b,c,d,e,f,g);
			o.add(od);
			
		}
		return o;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<Order> getOrderClientName(){
		
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("SELECT * FROM orders_table ORDER BY clientName;");
		
		o.clear();
		while(rs.next()){
			String a = rs.getString("purchase_orderID");
			String b = rs.getString("clientName");
			Float c = rs.getFloat("price");
			String d = rs.getString("orderReceiver");
			Date e = rs.getDate("deliveryDueDate");
			Boolean f = rs.getBoolean("deliveryStatus");
			String g = rs.getString("notes");
			
			Order od = new Order(b,c,d,e,f,g);
			o.add(od);
			
		}
		return o;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<Order> getOrderPending(){
		
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("SELECT * FROM orders_table where deliveryStatus = 0;");
		
		o.clear();
		while(rs.next()){
			String a = rs.getString("purchase_orderID");
			String b = rs.getString("clientName");
			Float c = rs.getFloat("price");
			String d = rs.getString("orderReceiver");
			Date e = rs.getDate("deliveryDueDate");
			Boolean f = rs.getBoolean("deliveryStatus");
			String g = rs.getString("notes");
			
			Order od = new Order(b,c,d,e,f,g);
			o.add(od);
			
		}
		return o;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<Order> getOrderDelivered(){
		
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("SELECT * FROM orders_table where deliveryStatus = 1;");
		
		o.clear();
		while(rs.next()){
			String a = rs.getString("purchase_orderID");
			String b = rs.getString("clientName");
			Float c = rs.getFloat("price");
			String d = rs.getString("orderReceiver");
			Date e = rs.getDate("deliveryDueDate");
			Boolean f = rs.getBoolean("deliveryStatus");
			String g = rs.getString("notes");
			
			Order od = new Order(b,c,d,e,f,g);
			o.add(od);
			
		}
		return o;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
}
