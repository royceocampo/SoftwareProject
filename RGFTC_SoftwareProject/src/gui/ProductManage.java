package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.ProductManager;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.ScrolledComposite;

public class ProductManage {

	protected Shell shlProductManage;
	private Text txtSearch;
	protected Shell shell;
	private Table prodTable;

	public static void main(String[] args){
		try{
			ProductManage window = new ProductManage();
			window.open();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	 
	

//@@ -54,106 +40,10 @@ public class ProductManage {
//	 * Create contents of the window.
//	 * @wbp.parser.entryPoint
	/**
	 * @wbp.parser.entryPoint
	 */
	@SuppressWarnings("deprecation")
	protected void createContents() {
		shlProductManage = new Shell();
		
		shlProductManage.setMinimumSize(new Point(500, 200));
		shlProductManage.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlProductManage.setSize(479, 324);
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
		
		Button btnNewButton = new Button(shlProductManage, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddProduct window = new AddProduct();
				window.open();
			}
		});
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
		
		prodTable = new Table(shlProductManage, SWT.BORDER | SWT.FULL_SELECTION);
		prodTable.setBounds(10, 81, 464, 132);
		prodTable.setHeaderVisible(true);
		prodTable.setLinesVisible(true);
		
		TableColumn tblclmnProduct = new TableColumn(prodTable, SWT.NONE);
		tblclmnProduct.setWidth(125);
		tblclmnProduct.setText("Product");
		
		TableColumn tblclmnCategory = new TableColumn(prodTable, SWT.NONE);
		tblclmnCategory.setWidth(72);
		tblclmnCategory.setText("Category");
		
		TableColumn tblclmnSubtype = new TableColumn(prodTable, SWT.NONE);
		tblclmnSubtype.setWidth(64);
		tblclmnSubtype.setText("Subtype");
		
		TableColumn tblclmnBrand = new TableColumn(prodTable, SWT.NONE);
		tblclmnBrand.setWidth(76);
		tblclmnBrand.setText("Brand");
		
		TableColumn tblclmnPackaging = new TableColumn(prodTable, SWT.NONE);
		tblclmnPackaging.setWidth(74);
		tblclmnPackaging.setText("Packaging");
		
		TableColumn tblclmnPricekg = new TableColumn(prodTable, SWT.NONE);
		tblclmnPricekg.setWidth(61);
		tblclmnPricekg.setText("Price/KG");
		
		TableColumn tblclmnNewColumn = new TableColumn(prodTable, SWT.NONE);
		tblclmnNewColumn.setWidth(49);
		tblclmnNewColumn.setText("Boxes");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(prodTable, SWT.NONE);
		tblclmnNewColumn_1.setWidth(54);
		tblclmnNewColumn_1.setText("Weight");
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		shlProductManage.addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent e) {
				ProductManager.displayProducts(prodTable);
			}
		});
	}
	
	 //* Launch the application.
//@@ -41,9 +27,9 @@ public class ProductManage {
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlProductManage.open();
		shlProductManage.layout();
//		ProductManager.displayProducts(tableTree);
//		while (!shlProductManage.isDisposed()) {
//		shell.open();
//		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
//		}
	}
}