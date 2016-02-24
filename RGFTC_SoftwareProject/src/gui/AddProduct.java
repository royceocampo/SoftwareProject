package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Combo;

public class AddProduct {

	protected Shell shlRareGlobalFood;
	private Text text;
	private Text text_1;
	private Text text_2;

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
		shlRareGlobalFood.open();
		shlRareGlobalFood.layout();
		while (!shlRareGlobalFood.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRareGlobalFood = new Shell();
		shlRareGlobalFood.setMinimumSize(new Point(200, 50));
		shlRareGlobalFood.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFood.setSize(339, 300);
		shlRareGlobalFood.setText("Rare Global Food Trading Corp. Add Product");
		
		Button button = new Button(shlRareGlobalFood, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("Submit");
		button.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		button.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		button.setBounds(126, 214, 120, 37);
		
		Label lblProductName = new Label(shlRareGlobalFood, SWT.NONE);
		lblProductName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setBounds(10, 24, 110, 26);
		lblProductName.setText("Product Name:");
		
		Label lblCategory = new Label(shlRareGlobalFood, SWT.NONE);
		lblCategory.setText("Category:");
		lblCategory.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblCategory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCategory.setBounds(46, 56, 71, 26);
		
		Label lblSubtype = new Label(shlRareGlobalFood, SWT.NONE);
		lblSubtype.setText("Subtype:");
		lblSubtype.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblSubtype.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblSubtype.setBounds(46, 88, 60, 26);
		
		Label lblBrand = new Label(shlRareGlobalFood, SWT.NONE);
		lblBrand.setText("Brand:");
		lblBrand.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblBrand.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblBrand.setBounds(60, 120, 60, 26);
		
		Label lblPackaging = new Label(shlRareGlobalFood, SWT.NONE);
		lblPackaging.setText("Packaging:");
		lblPackaging.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPackaging.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPackaging.setBounds(31, 152, 79, 26);
		
		Label lblPrice = new Label(shlRareGlobalFood, SWT.NONE);
		lblPrice.setText("Price:");
		lblPrice.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrice.setBounds(60, 184, 42, 26);
		
		text = new Text(shlRareGlobalFood, SWT.BORDER);
		text.setBounds(126, 26, 120, 26);
		
		text_1 = new Text(shlRareGlobalFood, SWT.BORDER);
		text_1.setBounds(126, 120, 120, 26);
		
		text_2 = new Text(shlRareGlobalFood, SWT.BORDER);
		text_2.setBounds(126, 152, 120, 26);
		
		Spinner spinner = new Spinner(shlRareGlobalFood, SWT.BORDER);
		spinner.setBounds(126, 186, 120, 22);
		
		Combo combo = new Combo(shlRareGlobalFood, SWT.NONE);
		combo.setBounds(126, 58, 120, 26);
		
		Combo combo_1 = new Combo(shlRareGlobalFood, SWT.NONE);
		combo_1.setBounds(126, 91, 120, 23);

	}
}