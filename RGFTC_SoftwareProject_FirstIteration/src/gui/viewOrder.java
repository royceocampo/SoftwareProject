package gui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.GetLine;
import classes.GetOrders;
import classes.MarkManager;
import managers.LineData;
import managers.Order;

public class viewOrder {

	protected Shell shlOrderManage;
	private Text txtSearch;
	protected Shell shell;
	private Order o;

	private String date;
	private String name;
	private int total = 0;
	private GetOrders od = new GetOrders();
	private ArrayList<Order> ol = od.getOrder();
	private GetLine gl = new GetLine();
	
	private ArrayList<LineData> lp = gl.getLinePending();
	private ArrayList<LineData> la = gl.getLineAll();
	private ArrayList<LineData> ldc = gl.getLineDelivered();
	
	private ArrayList<TableTreeItem> item = new ArrayList<TableTreeItem>();
	
	
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
	public static void main(String[] args) {
		try {
			viewOrder window = new viewOrder();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlOrderManage.open();
		shlOrderManage.layout();
		while (!shlOrderManage.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	protected void createContents() {
		shlOrderManage = new Shell();
		shlOrderManage.setMinimumSize(new Point(500, 200));
		shlOrderManage.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlOrderManage.setSize(738, 476);
		shlOrderManage.setText("Rare Global Food Trading Corp.");
		
		Menu menu = new Menu(shlOrderManage, SWT.BAR);
		shlOrderManage.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				Home ho = new Home();
//				ho.open();
				shlOrderManage.close();
			}
		});
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProductManage pm = new ProductManage();
				pm.open();
				shlOrderManage.close();
			}
		});
		mntmProduct.setText("Product");
		
		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.setText("Inventory");
		
		Label lblOrderManagement = new Label(shlOrderManage, SWT.NONE);
		lblOrderManagement.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderManagement.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblOrderManagement.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblOrderManagement.setBounds(10, 10, 249, 38);
		lblOrderManagement.setText("Order Management");
		
		CCombo combo_1 = new CCombo(shlOrderManage, SWT.BORDER);
		
		combo_1.setBounds(230, 50, 80, 21);
		
		combo_1.add(" ");
		combo_1.add("Due Date");
		combo_1.add("Client Name");
		combo_1.add("Pending");
		combo_1.add("View All");
		combo_1.add("Delivered Client");
		
		TableTree tableTree = new TableTree(shlOrderManage, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		//tableTree.getTable().setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		tableTree.setBounds(27, 87, 680, 250);
		tableTree.getTable().setHeaderVisible(true);
		tableTree.getTable().setLinesVisible(true);;
		
		TableColumn tblclmnPurchase = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnPurchase.setWidth(100);
		tblclmnPurchase.setText("Purchase ID");
		
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
		tblclmnBox.setText("Box or Kilo");
		
		TableColumn tblclmnWeight = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnWeight.setWidth(100);
		tblclmnWeight.setText("Weight");
		
		TableColumn tblclmnStatus = new TableColumn(tableTree.getTable(), SWT.NONE);
		tblclmnStatus.setWidth(100);
		tblclmnStatus.setText("Status");
		
		Button btnMarkOrder = new Button(shlOrderManage, SWT.NONE);
		btnMarkOrder.setText("Mark as Delivered");
		btnMarkOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnMarkOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnMarkOrder.setBounds(248, 362, 131, 30);
		btnMarkOrder.setVisible(false);
		btnMarkOrder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				MessageBox msg = new MessageBox(shlOrderManage, SWT.ICON_INFORMATION | SWT.OK);
				msg.setText("Success!");
				msg.setMessage("Marked as Delivered!");
				msg.open();
				for(int i = 0; i < item.size() ;i++ ){
					markProduct(Integer.parseInt(item.get(i).getText()));
				}
				item.clear();
			}
		});
		
		combo_1.addSelectionListener(new SelectionAdapter() {
			@SuppressWarnings({ "unused", "deprecation" })
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if(combo_1.getText().equals("Due Date")){
					tableTree.removeAll();
					//DueDateBoxs dd = new DueDateBoxs();
					DueIto dd = new DueIto(shlOrderManage, 1);
					dd.open();
					int dm = dd.month +1;
					date = dd.year + "-" + dm + "-" + dd.day;
					
					GetLine gl = new GetLine();
					ArrayList<LineData> l = gl.getLineDelivery(date);
					ArrayList<LineData> l1 = gl.getLineSum(date);
					
					boolean foundItems = false;
					
					for(int i = 0; i < l.size()  ;i++ ){
						
						TableTreeItem parent = new TableTreeItem(tableTree,SWT.NONE);
						parent.setText(0, Integer.toString(l.get(i).getPurchaseID()));
						parent.setText(1, l.get(i).getProductName());
						parent.setText(2, l.get(i).getCategory());
						parent.setText(3, l.get(i).getSubtype());
						parent.setText(4, l.get(i).getBrand());
						parent.setText(5, l.get(i).getPackaging());
						parent.setText(6, Float.toString(l.get(i).getPricePerKilo()));
						parent.setText(7, Integer.toString(l.get(i).getQuantity()));
						parent.setText(8, Integer.toString(l.get(i).getWeight()));
						if(l.get(i).getStatus()==1){
							parent.setText(9, "Delivered");
						}
						else{
							parent.setText(9, " Not Delivered");
						}
						foundItems = true;
						total += l.get(i).getQuantity();
						
					}
					for (int i = 0; i < l1.size(); i++){
						TableTreeItem parent1 = new TableTreeItem(tableTree,SWT.NONE);
						
							parent1.setText(5, l1.get(i).getProductName());
							parent1.setText(6, "Total");
							parent1.setText(7, Integer.toString(l1.get(i).getQuantity()));
							
						
					}
					 if(!foundItems)
					 {
						 Error er = new Error(shlOrderManage,1);
						 er.open();
					 }
			
				}
				
				else if(combo_1.getText().equals("Client Name")){
					tableTree.removeAll();
					ClientBox cc = new ClientBox(shlOrderManage,1);
					cc.open();
					GetLine gl = new GetLine();
					name = cc.s;
					ArrayList<LineData> la = gl.getLineClientName(name);
					ArrayList<LineData> l2= gl.getLineSumName(name);
					boolean foundClient = false;
					
					la = gl.getLineAll();
					
					
					for(int i = 0; i < la.size(); i++){	 
						TableTreeItem parent = new TableTreeItem(tableTree,SWT.NONE);
						parent.setText(0, Integer.toString(la.get(i).getPurchaseID()));
						parent.setText(1, la.get(i).getProductName());
						parent.setText(2, la.get(i).getCategory());
						parent.setText(3, la.get(i).getSubtype());
						parent.setText(4, la.get(i).getBrand());
						parent.setText(5, la.get(i).getPackaging());
						parent.setText(6, Float.toString(la.get(i).getPricePerKilo()));
						parent.setText(7, Integer.toString(la.get(i).getQuantity()));
						parent.setText(8, Integer.toString(la.get(i).getWeight()));
						if(la.get(i).getStatus()==1){
							parent.setText(9, "Delivered");
						}
						else{
							parent.setText(9, " Not Delivered");
						}
						foundClient = true;
						
					}
					for (int i = 0; i < l2.size(); i++){
						TableTreeItem parent1 = new TableTreeItem(tableTree,SWT.NONE);
							parent1.setText(5, l2.get(i).getProductName());
							parent1.setText(6, "Total");
							parent1.setText(7, Integer.toString(l2.get(i).getQuantity()));
							
						
					}
					
					 if(!foundClient)
					 {
						 Error er = new Error(shlOrderManage,1);
						 er.open();
					 }
				}
				else if(combo_1.getText().equals("Pending")){
					lp = gl.getLinePending();
					tableTree.removeAll();
					for(int i = 0; i < lp.size() ;i++ ){
						TableTreeItem parent = new TableTreeItem(tableTree,SWT.NONE);
						tableTree.addListener(SWT.Selection, new Listener() {
							
							@Override
							public void handleEvent(Event event) {
								// TODO Auto-generated method stub
								if(event.detail == SWT.CHECK){
									item.add((TableTreeItem) event.item);
									/*String string = event.detail == SWT.CHECK ? "Checked"
								            : "Selected";
								    System.out.println(event.item + " " + string);*/
									//System.out.println(item.size());
									boolean checkMark = false;
									for(int i = 0; i < item.size() ;i++ ){
										if(item.get(i).getChecked()){
											btnMarkOrder.setVisible(true);
											checkMark=true;
										}
									}

									if(!checkMark){
										btnMarkOrder.setVisible(false);
									}
								}
							}
						});
						parent.setText(0, Integer.toString(lp.get(i).getPurchaseID()));
						parent.setText(1, lp.get(i).getProductName());
						parent.setText(2, lp.get(i).getCategory());
						parent.setText(3, lp.get(i).getSubtype());
						parent.setText(4, lp.get(i).getBrand());
						parent.setText(5, lp.get(i).getPackaging());
						parent.setText(6, Float.toString(lp.get(i).getPricePerKilo()));
						parent.setText(7, Integer.toString(lp.get(i).getQuantity()));
						parent.setText(8, Integer.toString(lp.get(i).getWeight()));
						if(lp.get(i).getStatus()==1){
							parent.setText(9, "Delivered");
						}
						else{
							parent.setText(9, " Not Delivered");
						}
					}
					if(lp.size() == 0){
						MessageBox msg = new MessageBox(shlOrderManage, SWT.ICON_INFORMATION | SWT.OK);
						msg.setText("Success!");
						msg.setMessage("No client orders found!");
						msg.open();
					}
				}
				else if(combo_1.getText().equals("View All")){
					tableTree.removeAll();
					la = gl.getLineAll();
					for(int i = 0; i < la.size() ;i++ ){
						TableTreeItem parent = new TableTreeItem(tableTree,SWT.NONE);
						parent.setText(0, Integer.toString(la.get(i).getPurchaseID()));
						parent.setText(1, la.get(i).getProductName());
						parent.setText(2, la.get(i).getCategory());
						parent.setText(3, la.get(i).getSubtype());
						parent.setText(4, la.get(i).getBrand());
						parent.setText(5, la.get(i).getPackaging());
						parent.setText(6, Float.toString(la.get(i).getPricePerKilo()));
						parent.setText(7, Integer.toString(la.get(i).getQuantity()));
						parent.setText(8, Integer.toString(la.get(i).getWeight()));
						if(la.get(i).getStatus()==1){
							parent.setText(9, "Delivered");
						}
						else{
							parent.setText(9, " Not Delivered");
						}
					}
				}	
				else if(combo_1.getText().equals("Delivered Client")){
					tableTree.removeAll();
					ldc = gl.getLineDelivered();
					for(int i = 0; i < ldc.size() ;i++ ){
						TableTreeItem parent = new TableTreeItem(tableTree,SWT.NONE);
						parent.setText(0, Integer.toString(ldc.get(i).getPurchaseID()));
						parent.setText(1, ldc.get(i).getProductName());
						parent.setText(2, ldc.get(i).getCategory());
						parent.setText(3, ldc.get(i).getSubtype());
						parent.setText(4, ldc.get(i).getBrand());
						parent.setText(5, ldc.get(i).getPackaging());
						parent.setText(6, Float.toString(ldc.get(i).getPricePerKilo()));
						parent.setText(7, Integer.toString(ldc.get(i).getQuantity()));
						parent.setText(8, Integer.toString(ldc.get(i).getWeight()));
						if(ldc.get(i).getStatus()==1){
							parent.setText(9, "Delivered");
						}
						else{
							parent.setText(9, " Not Delivered");
						}
					}
				}
				else{
					System.out.println("ERROR");
				}
				
			}
		});
		
		Button btnAddOrder = new Button(shlOrderManage, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddOrder ao = new AddOrder();
				ao.open();
			}
		});
		btnAddOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnAddOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnAddOrder.setBounds(385, 360, 95, 35);
		btnAddOrder.setText("Add Order");
		btnAddOrder.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		
		Button btnEditOrder = new Button(shlOrderManage, SWT.NONE);
		btnEditOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEditOrder.setText("Edit");
		btnEditOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEditOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnEditOrder.setBounds(46, 360, 95, 35);
		
		Button btnDeleteOrder = new Button(shlOrderManage, SWT.NONE);
		btnDeleteOrder.setText("Delete");
		btnDeleteOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDeleteOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDeleteOrder.setBounds(147, 360, 95, 35);
		
		txtSearch = new Text(shlOrderManage, SWT.BORDER);
		txtSearch.setText("Search");
		txtSearch.setBounds(327, 50, 97, 21);
		
		Label lblFilterBy = new Label(shlOrderManage, SWT.NONE);
		lblFilterBy.setText("Filter By:");
		lblFilterBy.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblFilterBy.setBounds(175, 54, 55, 15);
		
		Button btnSearchOrder = new Button(shlOrderManage, SWT.NONE);
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
		
		shlOrderManage.setVisible(true);
		
	}
	
	protected void markProduct(int purchaseID) {
		try {
			MarkManager.markProduct(purchaseID);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		
}


