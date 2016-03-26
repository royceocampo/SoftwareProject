package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.ProductManager;
import managers.Product;

public class AddProduct {

	protected Shell shlAddProduct;
	
	public static Text txtProdName;
	public static Text txtBrand;
	public static Text txtPackaging;
	public static Combo cmbCategory;
	public static Combo cmbSubtype;
	public static Spinner spinPrice;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddProduct window = new AddProduct();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAddProduct.open();
		shlAddProduct.layout();
		while (!shlAddProduct.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAddProduct = new Shell();
		shlAddProduct.setMinimumSize(new Point(200, 50));
		shlAddProduct.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlAddProduct.setSize(405, 300);
		shlAddProduct.setText("Rare Global Food Trading Corp. Add Product");
		
		Button buttonSubmit = new Button(shlAddProduct, SWT.NONE);
		
		buttonSubmit.setText("Add Product");
		buttonSubmit.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		buttonSubmit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		buttonSubmit.setBounds(126, 214, 120, 37);
		
		Label lblProductName = new Label(shlAddProduct, SWT.NONE);
		lblProductName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setBounds(10, 24, 110, 26);
		lblProductName.setText("Product Name:");
		
		Label lblCategory = new Label(shlAddProduct, SWT.NONE);
		lblCategory.setText("Category:");
		lblCategory.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblCategory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCategory.setBounds(46, 56, 71, 26);
		
		Label lblSubtype = new Label(shlAddProduct, SWT.NONE);
		lblSubtype.setText("Subtype:");
		lblSubtype.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSubtype.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSubtype.setBounds(46, 88, 60, 26);
		
		Label lblBrand = new Label(shlAddProduct, SWT.NONE);
		lblBrand.setText("Brand:");
		lblBrand.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblBrand.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrand.setBounds(60, 120, 60, 26);
		
		Label lblPackaging = new Label(shlAddProduct, SWT.NONE);
		lblPackaging.setText("Packaging:");
		lblPackaging.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPackaging.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPackaging.setBounds(31, 152, 79, 26);
		
		Label lblPrice = new Label(shlAddProduct, SWT.NONE);
		lblPrice.setText("Price:");
		lblPrice.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrice.setBounds(60, 184, 42, 26);
		
		txtProdName = new Text(shlAddProduct, SWT.BORDER);
		txtProdName.setBounds(126, 26, 120, 26);
		
		txtBrand = new Text(shlAddProduct, SWT.BORDER);
		txtBrand.setBounds(126, 120, 120, 26);
		
		txtPackaging = new Text(shlAddProduct, SWT.BORDER);
		txtPackaging.setBounds(126, 152, 120, 26);
		
		Spinner spinPrice = new Spinner(shlAddProduct, SWT.BORDER);
		spinPrice.setMaximum(10000);
		spinPrice.setBounds(126, 186, 120, 22);
		
		Combo cmbCategory = new Combo(shlAddProduct, SWT.NONE);
		cmbCategory.setItems(new String[] {"Meat", "Seafood"});
		cmbCategory.setBounds(126, 56, 120, 23);
		
		
		
		Combo cmbSubtype = new Combo(shlAddProduct, SWT.NONE);
		cmbSubtype.setItems(new String[] {"AA", "AB", "AC", "AD"});
		cmbSubtype.setBounds(126, 91, 120, 23);
		
		Label lblErrProdName = new Label(shlAddProduct, SWT.NONE);
		lblErrProdName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrProdName.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblErrProdName.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrProdName.setBounds(252, 29, 110, 15);
		lblErrProdName.setText("This field is required.");
//		lblErrProdName.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));     -> visible when error

		
		Label lblErrCat = new Label(shlAddProduct, SWT.NONE);
		lblErrCat.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrCat.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrCat.setBounds(252, 61, 110, 15);
		lblErrCat.setText("This field is required.");
		
		Label lblErrSub = new Label(shlAddProduct, SWT.NONE);
		lblErrSub.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrSub.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrSub.setBounds(252, 93, 110, 15);
		lblErrSub.setText("This field is required.");
		
		Label lblErrPri = new Label(shlAddProduct, SWT.NONE);
		lblErrPri.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrPri.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblErrPri.setBounds(252, 189, 110, 15);
		lblErrPri.setText("This field is required.");
		
		cmbCategory.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				if (cmbCategory.getText().equals("Meat")){
					String newItems[] = { "Pork", "Beef", "Poultry", "Japanese Wagyu",
										"Cuts"};
					cmbSubtype.setItems(newItems);
					cmbSubtype.setEnabled(true);
				}
				else if (cmbCategory.getText().equals("Seafood")){
					String newItems[] = { "Black Tiger", "Shrimps", "Nobashi", "Japanese Wagyu",
					"Norwegian Salmon", "Squid/Octopus", "Tuna", "Cream Dory", "Fish (Whole, Fillet, Steak)",
					"Scallops and Shellfish"};
					cmbSubtype.setItems(newItems);
					cmbSubtype.setEnabled(true);
				}
				else{
					cmbSubtype.add(" ");
					cmbSubtype.setText(" ");
				}
				
			}
		});
		
		buttonSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblErrProdName.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
				lblErrCat.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
				lblErrSub.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
				lblErrPri.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
				String strProdName = txtProdName.getText();
				String strCategory = cmbCategory.getText();
				String strSubtype = cmbSubtype.getText();
				String strBrand = txtBrand.getText();
				String strPackaging = txtPackaging.getText();
				float fPrice = (float)spinPrice.getSelection();
				int nStocks = 0;
				if ((strProdName.equals(""))||
					(strCategory.equals(""))||
					(strSubtype.equals(""))||
					 fPrice == 0){
					MessageBox msg = new MessageBox(shlAddProduct, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Required fields have no input.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}
					if (strProdName.equals("")){
						lblErrProdName.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					}
					if(strCategory.equals("")){
						lblErrCat.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					}
					if (strSubtype.equals("")){
						lblErrSub.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					}
					
					if(fPrice == 0){
						lblErrPri.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					}
				}
				else{
					saveProduct(strProdName, strCategory, strSubtype, strBrand, strPackaging, fPrice, nStocks);
					MessageBox msg = new MessageBox(shlAddProduct, SWT.ICON_INFORMATION | SWT.OK);
					lblErrProdName.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
					lblErrCat.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
					lblErrSub.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
					lblErrPri.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
					msg.setText("Success!");
					msg.setMessage("New product was added successfully!");
					int buttonID = msg.open();
					switch (buttonID){
					case SWT.OK:
						txtProdName.setText("");
						cmbCategory.setText("");
						cmbSubtype.setText("");
						txtBrand.setText("");
						txtPackaging.setText("");
						spinPrice.setSelection(0);
						shlAddProduct.close(); //please check if it's ok!
						
					}
				}
				
			}
		});
	}
	
	protected void saveProduct(String prodName, String prodCategory, String prodSubtype,
								String prodBrand, String prodPackaging, float prodPrice, int nStocks){			
		Product newProduct = new Product(prodName, prodCategory, prodSubtype, prodBrand, prodPackaging, prodPrice, nStocks);
		try{
			ProductManager.addProduct(newProduct);
//			System.out.println("Product added successfully! (show this on message as well)");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}