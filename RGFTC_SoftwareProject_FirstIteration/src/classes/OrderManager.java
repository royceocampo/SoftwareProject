package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnection.DBConnection;
import managers.Order;

public class OrderManager {

	public OrderManager() {
	}

	public void addOrder(Order order) {
		String sql = "INSERT INTO orders_table (clientName, price, orderReceiver, deliveryDueDate, notes, deliveryStatus) VALUES (?,?,?,?,?,?);";
		Connection conn = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, order.getClientName());
			pstmt.setFloat(2, order.getPrice());
			pstmt.setString(3, order.getOrderReceiver());
			pstmt.setDate(4, (Date) order.getDeliveryDueDate());
			pstmt.setString(5, order.getNotes());
			pstmt.setBoolean(6, false);

			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Order getOrder(int id) {
		Order order = new Order();

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orders_table WHERE purchase_orderID = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				order.setClientName(rs.getString("clientName"));
				order.setPrice(rs.getInt("price"));
				order.setOrderReceiver(rs.getString("orderReceiver"));
				order.setDeliveryDueDate(rs.getDate("deliveryDueDate"));
				order.setDeliveryStatus(rs.getBoolean("deliveryStatus"));
				order.setNotes(rs.getString("notes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}

	public ArrayList<Order> getAllOrders() {
		Connection conn = DBConnection.getConnection();
		ArrayList<Order> orderList = new ArrayList<Order>();

		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM orders_table");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();

				order.setPurchase_orderID(rs.getInt("purchase_orderID"));
				order.setClientName(rs.getString("clientName"));
				order.setPrice(rs.getInt("price"));
				order.setOrderReceiver(rs.getString("orderReceiver"));
				order.setDeliveryDueDate(rs.getDate("deliveryDueDate"));
				order.setDeliveryStatus(rs.getBoolean("deliveryStatus"));
				order.setNotes(rs.getString("notes"));

				orderList.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;

	}

	public Order getLastOrder() {
		Order order = new Order();

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM orders_table ORDER BY purchase_orderID DESC LIMIT 1");
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				order.setPurchase_orderID(rs.getInt("purchase_orderID"));
				order.setClientName(rs.getString("clientName"));
				order.setPrice(rs.getInt("price"));
				order.setOrderReceiver(rs.getString("orderReceiver"));
				order.setDeliveryDueDate(rs.getDate("deliveryDueDate"));
				order.setDeliveryStatus(rs.getBoolean("deliveryStatus"));
				order.setNotes(rs.getString("notes"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return order;
	}

	public void deleteOrder(int id) {
		String sql = "DELETE FROM orders_table WHERE purchase_orderID = ?";

		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void editOrder(int orderid, Order order){
		String sql = "UPDATE orders_table SET clientName = ?, price = ?, orderReceiver = ?, deliveryDueDate = ?, notes = ? WHERE purchase_orderID = ?;";
		
		Connection conn = DBConnection.getConnection();
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, order.getClientName());
			pstmt.setFloat(2, order.getPrice());
			pstmt.setString(3, order.getOrderReceiver());
			pstmt.setDate(4, (Date) order.getDeliveryDueDate());
			pstmt.setString(5, order.getNotes());
			pstmt.setInt(6, orderid);

			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
