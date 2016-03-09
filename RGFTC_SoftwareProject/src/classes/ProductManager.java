package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

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
		
		String query = "SELECT productName, category, subtype, brand, packaging, priceperkilo FROM products_table ORDER BY category ASC";
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
}
