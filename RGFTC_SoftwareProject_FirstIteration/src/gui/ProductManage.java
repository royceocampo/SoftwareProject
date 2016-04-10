package gui;

import java.util.ArrayList;
import java.util.Collections;

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
	protected Shell shell;
	private Table prodTable;
	public static int prodID;
	public static int index;
	public static TableItem item;
	public static TableItem[] tblItems;
//	public static int i = 0;
	ArrayList <Integer> indexes = new ArrayList<Integer>();
	ArrayList <Integer> selected = new ArrayList<Integer>();
	ArrayList <Integer> range = new ArrayList<Integer>();
	public static int lowerBound = 0;
	public static int upperBound = 0;
	
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
		
		prodTable = new Table(shlProductManage, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.MULTI);
		prodTable.setBounds(27, 54, 680, 283);
		prodTable.setHeaderVisible(true);
		prodTable.setLinesVisible(true);
		
		TableColumn tblclmnProdID = new TableColumn(prodTable, SWT.NONE);
		tblclmnProdID.setText("ID");
		
		TableColumn tblclmnProduct = new TableColumn(prodTable, SWT.LEFT);
		tblclmnProduct.setWidth(144);
		tblclmnProduct.setText("Product");
		
		TableColumn tblclmnCategory = new TableColumn(prodTable, SWT.LEFT);
		tblclmnCategory.setWidth(105);
		tblclmnCategory.setText("Category");
		
		TableColumn tblclmnSubtype = new TableColumn(prodTable, SWT.LEFT);
		tblclmnSubtype.setWidth(129);
		tblclmnSubtype.setText("Subtype");
		
		TableColumn tblclmnBrand = new TableColumn(prodTable, SWT.LEFT);
		tblclmnBrand.setWidth(120);
		tblclmnBrand.setText("Brand");
		
		TableColumn tblclmnPackaging = new TableColumn(prodTable, SWT.LEFT);
		tblclmnPackaging.setWidth(96);
		tblclmnPackaging.setText("Packaging");
		
		TableColumn tblclmnPricekg = new TableColumn(prodTable, SWT.LEFT);
		tblclmnPricekg.setWidth(88);
		tblclmnPricekg.setText("Price/KG");
		
		TableColumn tblclmnBoxes = new TableColumn(prodTable, SWT.LEFT);
		tblclmnBoxes.setText("Boxes");
		
		TableColumn tblclmnWeight = new TableColumn(prodTable, SWT.LEFT);
		tblclmnWeight.setText("Weight");
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		if (ProductManager.getProductCount() > 0)
			ProductManager.displayProducts(prodTable);
		else{
			MessageBox messageBox = new MessageBox(shlProductManage, SWT.ICON_ERROR | SWT.OK);
			messageBox.setText("Error");
			messageBox.setMessage("No products found.");
			int buttonID = messageBox.open();
//			String valString = "SWT.OK";
			switch (buttonID){
			case SWT.OK:
				break;
			}
		}
			
		
		prodTable.addListener(SWT.MouseDown, new Listener(){
			public void handleEvent(Event event){
//				i++;
				if((event.stateMask & SWT.CTRL) != 0){
					Point pt = new Point(event.x, event.y);
					item = prodTable.getItem(pt);
					if(item != null) {
						btnDelete.setEnabled(true);
						index = prodTable.indexOf(item);
//						System.out.println("INDEX: "+index);
						indexes.add(index);
//						System.out.println(indexes.size());
//						System.out.println("Valie: " +Integer.valueOf(0));
						for (int j = 0; j < ProductManager.getProductCount(); j++){
//							System.out.println("Frequency of " +j+ " is " +Collections.frequency(indexes, j));
							if (Collections.frequency(indexes, j) % 2 == 0 && Collections.frequency(indexes, j) != 0){
//								System.out.println("clicked twice");
								if (selected.contains(Integer.valueOf(j))){
									selected.remove(Integer.valueOf(j));
								}
//								else if (selected.size()== 1){
//									selected.clear();
//								}
							}
							else if (Collections.frequency(indexes, j)% 2 != 0 && Collections.frequency(indexes, j) != 0){
//								System.out.println("clicked");
								if (!selected.contains(j))
									selected.add(Integer.valueOf(j));
							}
							else{
//								System.out.println("not clicked");
							}
						}
						if (selected.size() == 1){
//							System.out.println("NUMBER OF SELECTED ITEMS: "+selected.size());
							btnEdit.setEnabled(true);
							for (int k = 0; k < selected.size(); k++){
//								System.out.print(selected.get(k)+", ");
							}
							index = selected.get(0);
						}
						else if (selected.size()== 0 || selected.size() > 1){
//							System.out.println("NUMBER OF SELECTED ITEMS: "+selected.size());
							btnEdit.setEnabled(false);
//							for (int k = 0; k < selected.size(); k++){
////								System.out.print(selected.get(k)+", ");
//							}
						}
						tblItems = prodTable.getItems();
					}
				}
				
				else if ((event.stateMask & SWT.SHIFT) != 0){ //SHIFT + CLICK
//					selected.clear();
					Point pt = new Point(event.x, event.y);
					item = prodTable.getItem(pt);
					if(item != null) {
						btnEdit.setEnabled(false);
						btnDelete.setEnabled(true);
						index = prodTable.indexOf(item);
//						System.out.println("INDEX: "+index);
//						indexes.add(Integer.valueOf(index));
						range.add(Integer.valueOf(index));
						
						if (range.size() == 2){
							lowerBound = Collections.min(range);
							System.out.println("Lower bound: "+lowerBound);
							upperBound = Collections.max(range);
							System.out.println("Upper bound: "+upperBound);
						}
						else{
							if((index < lowerBound || index > lowerBound) && index < upperBound ){
								range.remove(Integer.valueOf(lowerBound));
								lowerBound = index;
								range.add(Integer.valueOf(lowerBound));
							}
							else if ((index < upperBound || index > upperBound) && index < lowerBound){
								range.remove(Integer.valueOf(upperBound));
								upperBound = index;
								range.add(Integer.valueOf(upperBound));
							}
						}
						for (int l = lowerBound; l <= upperBound; l++){
							if (!selected.contains(Integer.valueOf(l))){
								selected.add(Integer.valueOf(l));
							}
							if (!indexes.contains(Integer.valueOf(l))){
								indexes.add(Integer.valueOf(l));
							}
						}
//						System.out.println("Range Size: "+range.size());
//						System.out.println("Index size: "+indexes.size());
//						for (int m = 0; m < selected.size(); m++){
//							System.out.print(selected.get(Integer.valueOf(m))+ ", ");
//						}
//						System.out.println("");
					}
				}
				
				else{ //meaning that it is not a CTRL+CLICK
					Point pt = new Point(event.x, event.y);
					item = prodTable.getItem(pt);
					if(item != null) {
						btnEdit.setEnabled(true);
						btnDelete.setEnabled(true);
						index = prodTable.indexOf(item);
//						System.out.println("INDEX: "+index);
						indexes.add(Integer.valueOf(index));
						selected.add(Integer.valueOf(index));
						range.add(Integer.valueOf(index));
						if (selected.size()>0){
							selected.clear();
						}
						
						tblItems = prodTable.getItems();
					}
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
				indexes.clear();
				selected.clear();
				range.clear();
			}
		});
		
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				System.out.println(prodID);
				
				for (int k = 0; k < selected.size(); k++){
					System.out.print(selected.get(k)+", ");
				}
				
				MessageBox messageBox = new MessageBox(shlProductManage, SWT.ICON_QUESTION
			            | SWT.YES | SWT.NO);
			        messageBox.setMessage("Delete this item?");
			        messageBox.setText("Confirm Delete");
			        int response = messageBox.open();
			        if (response == SWT.YES){
//			        	System.out.println("number of items to delete: " +selected.size());
			        	for (int l = 0; l < selected.size(); l++ ){
			        		tblItems = prodTable.getItems();
			        		String prodStr = tblItems[selected.get(l)].getText(0).toString();
			        		
			        		try{
								prodID = Integer.parseInt(prodStr);
							}
							catch(Exception ex){
								System.out.println("No record selected");
							}
//			        		System.out.println(prodID);
			        		ProductManager.deleteProduct(prodID);
			        		
			        	}
			        	
			        	
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
							indexes.clear();
							selected.clear();
							range.clear();
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