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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;

public class addOrder {

	protected Shell shlRareGlobalFoods;
	protected Shell shell;
	private Text txtClientName;
	private Text quantity;
	private Text price;
	private Text orderReceiver;
	private Text year;
	private Text otherNotes;
	private Table cart;

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
		shlRareGlobalFoods.setSize(500, 360);
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
		lblOrderManagement.setBounds(10, 10, 249, 28);
		lblOrderManagement.setText("ADD ORDER");
		
		Label lblClientName = new Label(shlRareGlobalFoods, SWT.NONE);
		lblClientName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblClientName.setBounds(20, 45, 73, 15);
		lblClientName.setText("Client Name:");
		
		
		Button btnAddOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAddOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnAddOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnAddOrder.setBounds(333, 281, 95, 35);
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
		btnEditOrder.setBounds(310, 198, 73, 28);
		
		Button btnDeleteOrder = new Button(shlRareGlobalFoods, SWT.NONE);
		btnDeleteOrder.setText("Delete");
		btnDeleteOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDeleteOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDeleteOrder.setBounds(379, 198, 73, 28);
		
		Label lblOrder = new Label(shlRareGlobalFoods, SWT.NONE);
		lblOrder.setText("Order:");
		lblOrder.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrder.setBounds(20, 70, 55, 15);
		
		txtClientName = new Text(shlRareGlobalFoods, SWT.BORDER);
		txtClientName.setBounds(96, 44, 95, 19);
		
		Label lblProductOrdered = new Label(shlRareGlobalFoods, SWT.NONE);
		lblProductOrdered.setBounds(30, 91, 95, 14);
		lblProductOrdered.setText("Product Ordered:");
		
		Label lblQuantity = new Label(shlRareGlobalFoods, SWT.NONE);
		lblQuantity.setBounds(30, 119, 60, 14);
		lblQuantity.setText("Quantity:");
		
		quantity = new Text(shlRareGlobalFoods, SWT.BORDER);
		quantity.setBounds(85, 116, 48, 19);
		
		Label lblKilos = new Label(shlRareGlobalFoods, SWT.NONE);
		lblKilos.setBounds(143, 119, 60, 14);
		lblKilos.setText("kilos");
		
		Combo productOrdered = new Combo(shlRareGlobalFoods, SWT.NONE);
		productOrdered.setBounds(128, 87, 103, 22);
		
		Label lblPrice = new Label(shlRareGlobalFoods, SWT.NONE);
		lblPrice.setBounds(30, 148, 60, 14);
		lblPrice.setText("Price:");
		
		price = new Text(shlRareGlobalFoods, SWT.BORDER);
		price.setBounds(66, 145, 64, 19);
		
		Button btnAddToCart = new Button(shlRareGlobalFoods, SWT.NONE);
		btnAddToCart.setBounds(62, 171, 95, 28);
		btnAddToCart.setText("Add to Cart");
		
		Label lblOrderReceiver = new Label(shlRareGlobalFoods, SWT.NONE);
		lblOrderReceiver.setBounds(20, 205, 87, 14);
		lblOrderReceiver.setText("Order Receiver:");
		
		orderReceiver = new Text(shlRareGlobalFoods, SWT.BORDER);
		orderReceiver.setBounds(108, 202, 95, 19);
		
		Label lblDateDue = new Label(shlRareGlobalFoods, SWT.NONE);
		lblDateDue.setBounds(20, 225, 60, 14);
		lblDateDue.setText("Date Due:");
		
		Combo monthDue = new Combo(shlRareGlobalFoods, SWT.NONE);
		monthDue.setBounds(79, 225, 73, 22);
		
		Combo dayDue = new Combo(shlRareGlobalFoods, SWT.NONE);
		dayDue.setBounds(154, 225, 49, 22);
		
		year = new Text(shlRareGlobalFoods, SWT.BORDER);
		year.setBounds(209, 225, 62, 19);
		
		Label lblOtherNotes = new Label(shlRareGlobalFoods, SWT.NONE);
		lblOtherNotes.setBounds(20, 255, 60, 14);
		lblOtherNotes.setText("Other Notes:");
		
		otherNotes = new Text(shlRareGlobalFoods, SWT.BORDER);
		otherNotes.setBounds(85, 252, 186, 64);
		
		cart = new Table(shlRareGlobalFoods, SWT.NONE);
		cart.setBounds(305, 59, 152, 133);
		
		Label lblCart = new Label(shlRareGlobalFoods, SWT.NONE);
		lblCart.setText("Cart");
		lblCart.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblCart.setFont(SWTResourceManager.getFont(".Helvetica Neue DeskInterface", 14, SWT.NORMAL));
		lblCart.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblCart.setBounds(363, 36, 118, 19);
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}
}