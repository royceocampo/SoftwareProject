package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			System.out.println("Error: "+e);
			e.printStackTrace();
		}
		
	}
}
