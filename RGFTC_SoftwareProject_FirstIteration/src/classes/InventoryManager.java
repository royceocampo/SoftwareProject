package classes;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbconnection.DBConnection;
import managers.Inventory;

public class InventoryManager {
	public InventoryManager() {}
	
	public String addInventory(Inventory i, String type){
		String error="none";
		InventoryManager inventoryManager = new InventoryManager();
		
		Connection conn = DBConnection.getConnection();
		String quantity = inventoryManager.checkInventory(i.getProduct());
		// System.out.println(quantity);
		if(quantity != null){
			String sql = "UPDATE products_table SET stocks = ? WHERE productName = ?;";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				String sql1 = "INSERT INTO inventory_table (person, product, action, date, productID)"
						+ "VALUES (?,?,?,?,?);";
				
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, i.getPerson());
				pstmt1.setString(2, i.getProduct());
				pstmt1.setString(3, type);
				pstmt1.setString(4, i.getDate());
				pstmt1.setInt(5, i.getProductID());
				
				if(type.equals("Deposit")){
					pstmt.setInt(1, Integer.parseInt(quantity)+i.getQuantity());
					pstmt1.executeUpdate();
				} else if(Integer.parseInt(quantity)>=i.getQuantity()){
					pstmt.setInt(1, Integer.parseInt(quantity)-i.getQuantity());
					pstmt1.executeUpdate();
				} else{
					pstmt.setInt(1, Integer.parseInt(quantity));
					// System.out.println("haha");
					error="Overflow";
				}
				pstmt.setString(2, i.getProduct());
				pstmt.executeUpdate();
				
				
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			String sql = "INSERT INTO inventory_table (person, product, quantity, date, productID)"
					+ "VALUES (?,?,?,?,?);";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, i.getPerson());
				pstmt.setString(2, i.getProduct());
				pstmt.setInt(3, i.getQuantity());
				pstmt.setString(4, i.getDate());
				pstmt.setInt(5, i.getProductID());
				if(type.equals("Deposit")){
					//pstmt.executeUpdate();
					error="No";
				} else{
					error="No";
				}
				
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return error;
	}
	public String checkInventory(String product){
		String sql = "SELECT * FROM products_table;";
		String valid = null;
		Connection conn = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()){
				if(product.equals(rs.getString("productName"))){
					valid = Integer.toString(rs.getInt("stocks"));
				}
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return valid;
	}
}
