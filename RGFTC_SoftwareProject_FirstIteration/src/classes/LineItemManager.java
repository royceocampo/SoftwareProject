package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import managers.LineItem;
import dbconnection.DBConnection;

public class LineItemManager {

	public LineItemManager(){}
	
	public void addLineItem(LineItem item){
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
}
