package classes;

import java.sql.DriverManager;

import gui.AddProduct;
import dbconnection.DBConnection;

public class Product {
	public static void addProduct(String strProdName, String strCategory,
			String strSubtype, String strBrand, String strPackaging, int nPrice){	
				
		System.out.println("Product Name: " +strProdName);
		System.out.println("Category: " +strCategory);
		System.out.println("Subtype: " +strSubtype);
		System.out.println("Brand: " +strBrand);
		System.out.println("Packaging: " +strPackaging);
		System.out.println("Price: " +nPrice);
		
//		PreparedStatement pstmt = DBConnection.
		
	}
}
