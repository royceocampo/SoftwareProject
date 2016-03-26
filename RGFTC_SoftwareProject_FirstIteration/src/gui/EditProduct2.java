package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.ProductManager;

public class EditProduct2 {

	protected Shell shlEditProduct;
	
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
			EditProduct2 window = new EditProduct2();
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
		shlEditProduct.open();
		shlEditProduct.layout();
		while (!shlEditProduct.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEditProduct = new Shell();
		shlEditProduct.setMinimumSize(new Point(200, 50));
		shlEditProduct.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlEditProduct.setSize(339, 300);
		shlEditProduct.setText("Rare Global Food Trading Corp. Add Product");
		
		Button buttonSubmit = new Button(shlEditProduct, SWT.NONE);
		
		buttonSubmit.setText("Confirm");
		buttonSubmit.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		buttonSubmit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		buttonSubmit.setBounds(126, 214, 120, 37);
		
		Label lblProductName = new Label(shlEditProduct, SWT.NONE);
		lblProductName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setBounds(10, 24, 110, 26);
		lblProductName.setText("Product Name:");
		
		Label lblCategory = new Label(shlEditProduct, SWT.NONE);
		lblCategory.setText("Category:");
		lblCategory.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblCategory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCategory.setBounds(46, 56, 71, 26);
		
		Label lblSubtype = new Label(shlEditProduct, SWT.NONE);
		lblSubtype.setText("Subtype:");
		lblSubtype.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSubtype.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSubtype.setBounds(46, 88, 60, 26);
		
		Label lblBrand = new Label(shlEditProduct, SWT.NONE);
		lblBrand.setText("Brand:");
		lblBrand.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblBrand.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrand.setBounds(60, 120, 60, 26);
		
		Label lblPackaging = new Label(shlEditProduct, SWT.NONE);
		lblPackaging.setText("Packaging:");
		lblPackaging.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPackaging.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPackaging.setBounds(31, 152, 79, 26);
		
		Label lblPrice = new Label(shlEditProduct, SWT.NONE);
		lblPrice.setText("Price:");
		lblPrice.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrice.setBounds(60, 184, 42, 26);
		
		txtProdName = new Text(shlEditProduct, SWT.BORDER);
		txtProdName.setBounds(126, 26, 120, 26);
		
		txtBrand = new Text(shlEditProduct, SWT.BORDER);
		txtBrand.setBounds(126, 120, 120, 26);
		
		txtPackaging = new Text(shlEditProduct, SWT.BORDER);
		txtPackaging.setBounds(126, 152, 120, 26);
		
		Spinner spinPrice = new Spinner(shlEditProduct, SWT.BORDER);
		spinPrice.setBounds(126, 186, 120, 22);
		
		Combo cmbCategory = new Combo(shlEditProduct, SWT.NONE);
		cmbCategory.setItems(new String[] {"A", "B", "C", "D"});
		cmbCategory.setBounds(126, 56, 120, 23);
		
		
		Combo cmbSubtype = new Combo(shlEditProduct, SWT.NONE);
		cmbSubtype.setItems(new String[] {"AA", "AB", "AC", "AD"});
		cmbSubtype.setBounds(126, 91, 120, 23);
		
//		System.out.println("ProductID: " +prodID);
		int prodID = ProductManage.getProdID();
		int index = ProductManage.getIndex();
		
//		txtProdName = txtProdName.setText(string);
		
		buttonSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				String strProdName = txtProdName.getText();
//				String strCategory = cmbCategory.getText();
//				String strSubtype = cmbSubtype.getText();
//				String strBrand = txtBrand.getText();
//				String strPackaging = txtPackaging.getText();
//				int nPrice = spinPrice.getSelection();
//				Product.addProduct(strProdName, strCategory, strSubtype, strBrand, strPackaging, nPrice);
				
			}
		});
	}
}