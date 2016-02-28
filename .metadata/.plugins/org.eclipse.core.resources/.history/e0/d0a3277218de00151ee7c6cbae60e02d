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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;

public class ProductManage {

	protected Shell shlProductManage;
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
		shlProductManage = new Shell();
		shlProductManage.setMinimumSize(new Point(500, 200));
		shlProductManage.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlProductManage.setSize(450, 324);
		shlProductManage.setText("Rare Global Food Trading Corp.");
		
		Menu menu = new Menu(shlProductManage, SWT.BAR);
		shlProductManage.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.setText("Product");
		
		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.setText("Inventory History");
		
		Label lblProductInventory = new Label(shlProductManage, SWT.NONE);
		lblProductInventory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductInventory.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblProductInventory.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblProductInventory.setBounds(10, 10, 249, 38);
		lblProductInventory.setText("Product Management");
		
		Label lblViewBy = new Label(shlProductManage, SWT.NONE);
		lblViewBy.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblViewBy.setBounds(10, 54, 55, 15);
		lblViewBy.setText("View By:");
		
		CCombo combo = new CCombo(shlProductManage, SWT.BORDER);
		combo.setBounds(71, 54, 106, 21);
		
		CCombo combo_1 = new CCombo(shlProductManage, SWT.BORDER);
		combo_1.setBounds(183, 54, 106, 21);
		
		TableTree tableTree = new TableTree(shlProductManage, SWT.BORDER | SWT.FULL_SELECTION);
		tableTree.getTable().setLinesVisible(true);
		tableTree.getTable().setHeaderVisible(true);
		tableTree.setBounds(27, 87, 397, 117);
		
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
		
		Button btnNewButton = new Button(shlProductManage, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnNewButton.setBounds(27, 223, 95, 21);
		btnNewButton.setText("Add Product");
		
		Button btnEdit = new Button(shlProductManage, SWT.NONE);
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEdit.setText("Edit");
		btnEdit.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEdit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnEdit.setBounds(143, 223, 95, 21);
		
		Button btnDelete = new Button(shlProductManage, SWT.NONE);
		btnDelete.setText("Delete");
		btnDelete.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDelete.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDelete.setBounds(255, 223, 95, 21);
		
		txtSearch = new Text(shlProductManage, SWT.BORDER);
		txtSearch.setText("Search");
		txtSearch.setBounds(297, 54, 127, 21);
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}

}