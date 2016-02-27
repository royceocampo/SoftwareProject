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

import classes.Product;

public class AddProduct {

	protected Shell shlAddProduct;
	private Text txtProdName;
	private Text txtBrand;
	private Text txtPackaging;

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
		shlAddProduct.setSize(339, 300);
		shlAddProduct.setText("Rare Global Food Trading Corp. Add Product");
		
		Button buttonSubmit = new Button(shlAddProduct, SWT.NONE);
		buttonSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Product.addProduct();
			}
		});
		buttonSubmit.setText("Submit");
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
		spinPrice.setBounds(126, 186, 120, 22);
		
		Combo comboCategory = new Combo(shlAddProduct, SWT.NONE);
		comboCategory.setBounds(126, 58, 120, 26);
		
		Combo comboSubtype = new Combo(shlAddProduct, SWT.NONE);
		comboSubtype.setBounds(126, 91, 120, 23);

	}
}