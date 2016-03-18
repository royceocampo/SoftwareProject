package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import dbconnection.DBConnection;
import managers.Product;

public class ProductManager {
	public static void addProduct(Product newProduct) throws Exception{	
		
		Connection conn = (Connection)DBConnection.getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement("INSERT INTO products_table"
					+"(productName, category, subtype, brand, packaging, pricePerKilo)"
				     + "VALUES (?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, newProduct.getProductName());
			pstmt.setString(2, newProduct.getProdCategory());
			pstmt.setString(3, newProduct.getProdSubtype());
			pstmt.setString(4, newProduct.getProdBrand());
			pstmt.setString(5, newProduct.getProdPackaging());
			pstmt.setFloat(6, newProduct.getProdPrice());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public static void displayProducts(Table table){
		Connection conn = (Connection)DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		String query = "SELECT productID, productName, category, subtype, brand, packaging, priceperkilo FROM products_table ORDER BY category ASC";
		try{
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			TableItem item = null;
			int numColumns = rsmd.getColumnCount();
			while (rs.next()){
				item = new TableItem(table, SWT.NONE);
				for (int i = 1; i<=numColumns; i++){
					if(rs.getString(i) != null){
						if(i == 6){
							item.toString();
						}
						item.setText(i - 1, rs.getString(i));
					}
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

//	public Product getProduct(int id) {
//		Product product = new Product( null, null, null, null, null, id, id);
//
//		try {
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement pstmt = conn
//					.prepareStatement("SELECT * FROM products_table WHERE productID = ?");
//			pstmt.setInt(1, id);
//			ResultSet rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				product.setProductName(rs.getString("productName"));
//				product.setProdCategory(rs.getString("category"));
//				product.setProdSubtype(rs.getString("subtype"));
//				product.setProdBrand(rs.getString("brand"));
//				product.setProdPackaging(rs.getString("packaging"));
//				product.setProdPrice(rs.getFloat("pricePerKilo"));
//				product.setProdStocks(rs.getInt("stocks"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return product;
//	}
	
	public static void editProduct(Product modProduct, int productID)throws Exception{
		System.out.println("ProductID (editProduct): "+productID);
		Connection conn = (Connection)DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE products_table"
				+" SET productName = ?,"
				+" category = ?,"
				+" subtype = ?,"
				+" brand = ?,"
				+" packaging = ?,"
				+" pricePerKilo = ?"
				+" WHERE productID = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(7, productID);
			pstmt.setString(1, modProduct.getProductName());
			pstmt.setString(2, modProduct.getProdCategory());
			pstmt.setString(3, modProduct.getProdSubtype());
			pstmt.setString(4, modProduct.getProdBrand());
			pstmt.setString(5, modProduct.getProdPackaging());
			pstmt.setFloat(6, modProduct.getProdPrice());
			System.out.println(pstmt);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	public static void deleteProduct(int id){
		try{
			Connection conn = DBConnection.getConnection();
			String sql = "DELETE FROM products_table WHERE productID = " +id;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
					
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getAllProducts() {
		Connection conn = DBConnection.getConnection();
		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM products_table");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product( null, null, null, null, null, 0, 0);
				
				product.setProductID(rs.getInt("productID"));
				product.setProductName(rs.getString("productName"));
				product.setProdCategory(rs.getString("category"));
				product.setProdSubtype(rs.getString("subtype"));
				product.setProdBrand(rs.getString("brand"));
				product.setProdPackaging(rs.getString("packaging"));
				product.setProdPrice(rs.getFloat("pricePerKilo"));
				product.setProdStocks(rs.getInt("stocks"));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	public int getProductsCount(){
		Connection conn = DBConnection.getConnection();
		String sql = "SELECT COUNT(*) AS 'prodCount' FROM products_table";
		int productsCount = 0;
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				productsCount = rs.getInt("prodCount");
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productsCount;
	}
}
