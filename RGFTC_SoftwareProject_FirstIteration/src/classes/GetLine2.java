package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dbconnection.DBConnection;
import managers.LineData;

public class GetLine2 {
	private Connection conn;
	private Statement ps;
	private ResultSet rs;
	private ArrayList<LineData> l = new ArrayList<LineData>();
	private ArrayList<LineData> l1 = new ArrayList<LineData>();
	private ArrayList<LineData> l2 = new ArrayList<LineData>();
	private ArrayList<LineData> l3 = new ArrayList<LineData>();
	private ArrayList<LineData> l4 = new ArrayList<LineData>();
	private ArrayList<LineData> l5 = new ArrayList<LineData>();
	
	public GetLine2(){
		conn = new DBConnection().getConnection();
		
	}
	public ArrayList<LineData> getLineAll(){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select o.purchase_orderID, productName, category,subtype,brand,packaging, l.pricePerKilo,quantity, weight, o.deliveryStatus from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID;");
		
		l.clear();
		while(rs.next()){
			int a = rs.getInt("purchase_orderID");
			String b = rs.getString("productName");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("quantity");
			int i = rs.getInt("weight");
			int j = rs.getInt("deliveryStatus");
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l.add(ld);
			
		}
		return l;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<LineData> getLineDelivery(String date){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select o.purchase_orderID,productName, category,subtype,brand,packaging, l.pricePerKilo,quantity, weight,o.deliveryStatus from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.deliveryDueDate = '" + date + "';");
		
		l1.clear();
		
		while(rs.next()){
			int a = rs.getInt("purchase_orderID");
			String b = rs.getString("productName");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("quantity");
			int i = rs.getInt("weight");
			int j = rs.getInt("deliveryStatus");
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l1.add(ld);
			
		}
		return l1;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<LineData> getLineClientName(String name){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select o.purchase_orderID,productName, category,subtype,brand,packaging, l.pricePerKilo,quantity, weight,o.deliveryStatus from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.clientName =  '" + name + "'");
		
		l2.clear();
		while(rs.next()){
			
			int a = rs.getInt("purchase_orderID");
			String b = rs.getString("productName");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("quantity");
			int i = rs.getInt("weight");

			int j = rs.getInt("deliveryStatus");
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l2.add(ld);
			
		}
		return l2;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<LineData> getLinePending(){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select o.purchase_orderID,p.productName, p.category, p.subtype, p.brand, p.packaging, l.pricePerKilo, l.quantity, p.weight,o.deliveryStatus from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.deliveryStatus = 0;");
		
		l3.clear();
		while(rs.next()){
			int a = rs.getInt("purchase_orderID");
			String b = rs.getString("productName");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("quantity");
			int i = rs.getInt("weight");
			int j = rs.getInt("deliveryStatus");
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l3.add(ld);
			
		}
		return l3;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<LineData> getLineDelivered(){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select o.purchase_orderID,p.productName, p.category,p.subtype,p.brand,p.packaging, l.pricePerKilo,l.quantity, p.weight,o.deliveryStatus from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.deliveryStatus = 1;");
		
		l4.clear();
		while(rs.next()){
			int a = rs.getInt("purchase_orderID");
			String b = rs.getString("productName");
			String c = rs.getString("category");
			String d = rs.getString("subtype");
			String e = rs.getString("brand");
			String f = rs.getString("packaging");
			int g = rs.getInt("pricePerKilo");
			int h = rs.getInt("quantity");
			int i = rs.getInt("weight");
			int j = rs.getInt("deliveryStatus");
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l4.add(ld);
			
		}
		return l4;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	
	
	public ArrayList<LineData> getLineSum(String date){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select productName, sum(quantity) from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.deliveryDueDate = '" + date + "' group by productName;");
		
		l5.clear();
		while(rs.next()){
			int a=0;
			String b = rs.getString("productName");
			String c = null;
			String d = null;
			String e = null;
			String f = null;
			int g = 0;
			int h = rs.getInt("sum(quantity)");
			int i=0;
			int j=0;
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l5.add(ld);
			
		}
		return l5;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
	
	public ArrayList<LineData> getLineSumName(String name){
		try {
			ps = conn.createStatement();
		
		rs = ps.executeQuery("select productName, sum(quantity) from products_table p, orders_table o, lineitems_table l where o.purchase_orderID = l.purchase_orderID AND p.productID = l.productID AND o.clientName = '" + name + "' group by productName;");
		
		l5.clear();
		while(rs.next()){
			int a=0;
			String b = rs.getString("productName");
			String c = null;
			String d = null;
			String e = null;
			String f = null;
			int g = 0;
			int h = rs.getInt("sum(quantity)");
			int i=0;
			int j=0;
			
			LineData ld = new LineData(a,b,c,d,e,f,g,h,i,j);
			l5.add(ld);
			
		}
		return l5;	
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	return null;
	}
}
