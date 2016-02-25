package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;

public class viewOrders {

	protected Shell shlRareGlobalFoods;
	private Text txtSearch;
	protected Shell shell;

	/**
	 * Launch the application.
@@ -41,9 +27,9 @@ public class ProductManage {
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRareGlobalFoods.open();
		shlRareGlobalFoods.layout();
		while (!shlRareGlobalFoods.isDisposed()) {
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
@@ -54,106 +40,10 @@ public class ProductManage {
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlRareGlobalFoods = new Shell();
		shlRareGlobalFoods.setMinimumSize(new Point(500, 200));
		shlRareGlobalFoods.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFoods.setSize(450, 324);
		shlRareGlobalFoods.setText("Rare Global Food Trading Corp.");
		
		Menu menu = new Menu(shlRareGlobalFoods, SWT.BAR);
		shlRareGlobalFoods.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.setText("Product");
		
		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.setText("Inventory");
		
		Label lblOrderManagement = new Label(shlRareGlobalFoods, SWT.NONE);
		lblOrderManagement.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderManagement.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblOrderManagement.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblOrderManagement.setBounds(10, 10, 249, 38);
		lblOrderManagement.setText("Order Management");
		
		Label lblViewBy = new Label(shlRareGlobalFoods, SWT.NONE);
		lblViewBy.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblViewBy.setBounds(20, 54, 55, 15);
		lblViewBy.setText("View By:");
		
		CCombo combo = new CCombo(shlRareGlobalFoods, SWT.BORDER);
		combo.setBounds(75, 50, 95, 21);
		
		CCombo combo_1 = new CCombo(shlRareGlobalFoods, SWT.BORDER);
		combo_1.setBounds(230, 50, 80, 21);
		
		TableTree tableTree = new TableTree(shlRareGlobalFoods, SWT.BORDER | SWT.FULL_SELECTION);
		tableTree.getTable().setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tableTree.setBounds(27, 87, 430, 117);
		
		TableColumn tblclmnProduct = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnProduct.setWidth(100);
		tblclmnProduct.setText("Product");
		
		TableColumn tblclmnCategory = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnCategory.setWidth(100);
		tblclmnCategory.setText("Category");
		
		TableColumn tblclmnSubtype = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnSubtype.setWidth(100);
		tblclmnSubtype.setText("SubType");
		
		TableColumn tblclmnBrand = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnBrand.setWidth(100);
		tblclmnBrand.setText("Brand");
		
		TableColumn tblclmnPackaging = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnPackaging.setWidth(100);
		tblclmnPackaging.setText("Packaging");
		
		TableColumn tblclmnPrice = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnBox = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnBox.setWidth(100);
		tblclmnBox.setText("Box");
		
		TableColumn tblclmnWeight = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnWeight.setWidth(100);
		tblclmnWeight.setText("Weight");
		
		Button btnAddOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAddOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnAddOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnAddOrder.setBounds(362, 223, 95, 35);
		btnAddOrder.setText("Add Order");
		btnAddOrder.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		
		Button btnEditOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnEditOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEditOrder.setText("Edit");
		btnEditOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEditOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnEditOrder.setBounds(27, 223, 95, 35);
		
		Button btnDeleteOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnDeleteOrder.setText("Delete");
		btnDeleteOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDeleteOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDeleteOrder.setBounds(135, 223, 95, 35);
		
		txtSearch = new Text(shlRareGlobalFoods, SWT.BORDER);
		txtSearch.setText("Search");
		txtSearch.setBounds(327, 50, 97, 21);
		
		Label lblFilterBy = new Label(shlRareGlobalFoods, SWT.NONE);
		lblFilterBy.setText("Filter By:");
		lblFilterBy.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblFilterBy.setBounds(175, 54, 55, 15);
		
		Button btnSearchOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnSearchOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnSearchOrder.setBounds(424, 47, 66, 28);
		btnSearchOrder.setText("Search");
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}
}