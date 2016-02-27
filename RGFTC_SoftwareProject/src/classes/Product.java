package classes;

import gui.AddProduct;

public class Product {
	public static void addProduct(){	
		String productName = AddProduct.txtProdName.getText();
		String prodCategory = AddProduct.cmbCategory.getSelectedItem().toString();
		String prodSubtype = AddProduct.cmbSubtype.getSelectedItem().toString();
		String prodBrand = AddProduct.txtBrand.getText();
		String prodPackaging = AddProduct.txtPackaging.getText();
		float prodPrice = (Integer)AddProduct.spinPrice.getValue();
		
		System.out.println("Product Name: " +productName);
		System.out.println("Category: " +prodCategory);
		System.out.println("Subtype: " +prodSubtype);
		System.out.println("Brand: " +prodBrand);
		System.out.println("Packaging: " +prodPackaging);
		System.out.println("Price: " +prodPrice);
		
	}
}
