package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import managers.LineItem;
import managers.Order;
import dbconnection.DBConnection;

public class LineItemManager {

	public LineItemManager() {
	}

	public void addLineItem(LineItem item) {
		String sql = "INSERT INTO lineitems_table (purchase_orderID, productID, pricePerKilo, quantity) VALUES (?,?,?,?);";
		Connection conn = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, item.getOrderID());
			pstmt.setInt(2, item.getProductID());
			pstmt.setFloat(3, item.getPricePerKilo());
			pstmt.setFloat(4, item.getQuantity());

			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<LineItem> getLineItems(int orderID) {
		Connection conn = DBConnection.getConnection();
		ArrayList<LineItem> lineItemList = new ArrayList<LineItem>();

		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM lineitems_table WHERE purchase_orderID = ?");
			pstmt.setInt(1, orderID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				LineItem newItem = new LineItem();
				
				newItem.setOrderID(rs.getInt("purchase_orderID"));
				newItem.setProductID(rs.getInt("productID"));
				newItem.setPricePerKilo(rs.getFloat("pricePerKilo"));
				newItem.setQuantity(rs.getFloat("quantity"));
				
				lineItemList.add(newItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineItemList;

	}
	
	public void deleteLineItem(int orderid) {
		String sql = "DELETE FROM lineitems_table WHERE purchase_orderID = ?";

		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderid);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
