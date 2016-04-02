package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.ProductManager;

public class ProductManage {

	protected Shell shlProductManage;
	private Text txtSearch;
	protected Shell shell;
	private Table prodTable;
	public static int prodID;
	public static int index;
	public static TableItem item;
	public static TableItem[] tblItems;
	public static int i = 0;

	
	public static int getProdID() {
		return prodID;
	}

	public static void setProdID(int prodID) {
		ProductManage.prodID = prodID;
	}
	
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		ProductManage.index = index;
	}
	
	public static TableItem getItem() {
		return item;
	}

	public static void setItem(TableItem item) {
		ProductManage.item = item;
	}
	
	public static TableItem[] getTblItems() {
		return tblItems;
	}

	public static void setTblItems(TableItem[] tblItems) {
		ProductManage.tblItems = tblItems;
	}

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
		shlProductManage.setSize(738, 476);
		shlProductManage.setText("Rare Global Food Trading Corp.");
		
		Menu menu = new Menu(shlProductManage, SWT.BAR);
		shlProductManage.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlProductManage.close();
			}
		});
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewOrder vo = new viewOrder();
				vo.open();
				shlProductManage.close();
			}
		});
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.setText("Product");
		
		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				InventoryHistory ih = new InventoryHistory();
//				ih.open();
//				shlProductManage.close();
			}
		});
		mntmInventory.setText("Inventory History");
		
		Label lblProductInventory = new Label(shlProductManage, SWT.NONE);
		lblProductInventory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductInventory.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblProductInventory.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblProductInventory.setBounds(10, 10, 249, 38);
		lblProductInventory.setText("Product Management");
		
		Label lblViewBy = new Label(shlProductManage, SWT.NONE);
		lblViewBy.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblViewBy.setBounds(151, 54, 55, 15);
		lblViewBy.setText("View By:");
		
		CCombo combo = new CCombo(shlProductManage, SWT.BORDER);
		combo.setBounds(212, 54, 106, 21);
		
		CCombo combo_1 = new CCombo(shlProductManage, SWT.BORDER);
		combo_1.setBounds(339, 54, 106, 21);
		
		Button btnAddProduct = new Button(shlProductManage, SWT.NONE);
		btnAddProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddProduct window = new AddProduct();
				window.open();
				prodTable.removeAll();
				ProductManager.displayProducts(prodTable);
			}
		});
		btnAddProduct.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnAddProduct.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnAddProduct.setBounds(385, 360, 95, 35);
		btnAddProduct.setText("Add Product");
		
		Button btnEdit = new Button(shlProductManage, SWT.NONE);
		
		btnEdit.setText("Edit");
		btnEdit.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEdit.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnEdit.setBounds(46, 360, 95, 35);
		btnEdit.setEnabled(false);
		
		Button btnDelete = new Button(shlProductManage, SWT.NONE);

		btnDelete.setText("Delete");
		btnDelete.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDelete.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDelete.setBounds(147, 360, 95, 35);
		btnDelete.setEnabled(false);
		
		txtSearch = new Text(shlProductManage, SWT.BORDER);
		txtSearch.setText("Search");
		txtSearch.setBounds(467, 54, 127, 21);
		
		prodTable = new Table(shlProductManage, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI);
		prodTable.setBounds(27, 87, 680, 250);
		prodTable.setHeaderVisible(true);
		prodTable.setLinesVisible(true);
		
		TableColumn tblclmnProdID = new TableColumn(prodTable, SWT.NONE);
		tblclmnProdID.setText("ID");
		
		TableColumn tblclmnProduct = new TableColumn(prodTable, SWT.CENTER);
		tblclmnProduct.setWidth(125);
		tblclmnProduct.setText("Product");
		
		TableColumn tblclmnCategory = new TableColumn(prodTable, SWT.CENTER);
		tblclmnCategory.setWidth(94);
		tblclmnCategory.setText("Category");
		
		TableColumn tblclmnSubtype = new TableColumn(prodTable, SWT.CENTER);
		tblclmnSubtype.setWidth(84);
		tblclmnSubtype.setText("Subtype");
		
		TableColumn tblclmnBrand = new TableColumn(prodTable, SWT.CENTER);
		tblclmnBrand.setWidth(87);
		tblclmnBrand.setText("Brand");
		
		TableColumn tblclmnPackaging = new TableColumn(prodTable, SWT.CENTER);
		tblclmnPackaging.setWidth(96);
		tblclmnPackaging.setText("Packaging");
		
		TableColumn tblclmnPricekg = new TableColumn(prodTable, SWT.CENTER);
		tblclmnPricekg.setWidth(88);
		tblclmnPricekg.setText("Price/KG");
		
		TableColumn tblclmnNewColumn = new TableColumn(prodTable, SWT.CENTER);
		tblclmnNewColumn.setWidth(49);
		tblclmnNewColumn.setText("Boxes");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(prodTable, SWT.CENTER);
		tblclmnNewColumn_1.setWidth(54);
		tblclmnNewColumn_1.setText("Weight");
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		ProductManager.displayProducts(prodTable);
		
		prodTable.addListener(SWT.MouseDown, new Listener(){
			public void handleEvent(Event event){
				i++;
				Point pt = new Point(event.x, event.y);
				item = prodTable.getItem(pt);
				if(item != null) {
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
					index = prodTable.indexOf(item);
//					System.out.println("INDEX: "+index);
					tblItems = prodTable.getItems();
//					System.out.println(tblItems[index].getText(0));
//					System.out.println(i);
					String prodStr = tblItems[index].getText(0).toString();
					try{
						prodID = Integer.parseInt(prodStr);
					}
					catch(Exception e){
						System.out.println("No record selected");
					}
					
					
					try{
						if (i > 1){
//							System.out.println("Edit must be disabled");
							btnEdit.setEnabled(false);
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
//					System.out.println("Product ID (ProdManage):"+prodID);
				}
			}
		});
		
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				System.out.println("Prod ID = " + prodID);
				EditProduct ep = new EditProduct();
				ep.open();
				prodTable.removeAll();
				ProductManager.displayProducts(prodTable);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
			}
		});
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(prodID);
				MessageBox messageBox = new MessageBox(shlProductManage, SWT.ICON_QUESTION
			            | SWT.YES | SWT.NO);
			        messageBox.setMessage("Delete this item?");
			        messageBox.setText("Confirm Delete");
			        int response = messageBox.open();
			        if (response == SWT.YES){
			        	ProductManager.deleteProduct(prodID);
			        	MessageBox msg = new MessageBox(shlProductManage, SWT.ICON_INFORMATION | SWT.OK);
			        	msg.setText("Success!");
						msg.setMessage("Product deleted successfully!");
						int buttonID = msg.open();
						switch (buttonID){
						case SWT.OK:
							prodTable.remove(prodTable.getSelectionIndices());
//							ProductManager.displayProducts(prodTable);
							btnEdit.setEnabled(false);
							btnDelete.setEnabled(false);
						}
			        }
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