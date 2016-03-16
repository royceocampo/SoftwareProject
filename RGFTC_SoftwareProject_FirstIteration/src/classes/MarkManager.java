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

import java.sql.PreparedStatement;
import java.sql.SQLException;

import managers.Product;
import dbconnection.DBConnection;

public class MarkManager {
	public static void markProduct(int purchaseID) throws Exception{	
		
		Connection conn = (Connection)DBConnection.getConnection();
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement("UPDATE orders_table SET deliveryStatus = ? WHERE purchase_orderID = ?");
			pstmt.setInt(1, 1);
			pstmt.setInt(2, purchaseID);
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
