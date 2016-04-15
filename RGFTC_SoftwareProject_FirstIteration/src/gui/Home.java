package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.GetLine;
import managers.LineData;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Home {

	protected Shell shlRareGlobalFood;
	private TableTree tableDelivery;
	private TableTree table;
	public static int productManage = 0;
	public static int viewOrder = 0;
	public static int depWith = 0;
	viewOrder vOrder = new viewOrder();
	DepWith dw = new DepWith();
	ProductManage pm = new ProductManage();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Home window = new Home();
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
		shlRareGlobalFood.setMinimumSize(new Point(500, 360));
		shlRareGlobalFood.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFood.setSize(450, 300);
		shlRareGlobalFood.setText("Rare Global Food Trading Corp.");
		
		Label lblTodayDate = new Label(shlRareGlobalFood, SWT.NONE);
		//Date based from machine time.
		lblTodayDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblTodayDate.setAlignment(SWT.CENTER);
		lblTodayDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTodayDate.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTodayDate.setBounds(116, 10, 263, 23);
		DateFormat df = new SimpleDateFormat("E, MM / d / Y");
		DateFormat df2 = new SimpleDateFormat("Y-MM-dd");
		DateFormat df3 = new SimpleDateFormat("MM / d / Y");
		
		Calendar dateobj = Calendar.getInstance();
		Calendar dateobj2 = Calendar.getInstance();
		
		dateobj2.add(Calendar.DAY_OF_YEAR, 2);

		lblTodayDate.setText(df.format(dateobj.getTime()));
		
		Label lblOrdersTo = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrdersTo.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblOrdersTo.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrdersTo.setBounds(10, 49, 190, 15);
		lblOrdersTo.setText("Orders to be delievered today: ");
		
		tableDelivery = new TableTree(shlRareGlobalFood, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		tableDelivery.setBounds(10, 68, 464, 109);
		tableDelivery.getTable().setHeaderVisible(true);
		tableDelivery.getTable().setLinesVisible(true);
		
		TableColumn tblclmnDeliveryStatus = new TableColumn(tableDelivery.getTable(), SWT.NONE);
		tblclmnDeliveryStatus.setWidth(91);
		tblclmnDeliveryStatus.setText("Delivery Status");
		
		TableColumn tblclmnClient = new TableColumn(tableDelivery.getTable(), SWT.NONE);
		tblclmnClient.setWidth(100);
		tblclmnClient.setText("Client");
		
		TableColumn tblclmnOrderReceiver = new TableColumn(tableDelivery.getTable(), SWT.NONE);
		tblclmnOrderReceiver.setWidth(100);
		tblclmnOrderReceiver.setText("Order Receiver");
		
		TableColumn tblclmnNote = new TableColumn(tableDelivery.getTable(), SWT.NONE);
		tblclmnNote.setWidth(100);
		tblclmnNote.setText("Note");
		
		TableColumn tblclmnDueDate = new TableColumn(tableDelivery.getTable(), SWT.NONE);
		tblclmnDueDate.setWidth(100);
		tblclmnDueDate.setText("Due Date");
		
		Label lblProductsToBe = new Label(shlRareGlobalFood, SWT.NONE);
		lblProductsToBe.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductsToBe.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblProductsToBe.setBounds(10, 183, 240, 15);
		lblProductsToBe.setText("Products to be ordered from suppliers: ");
		
		table = new TableTree(shlRareGlobalFood, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 204, 464, 86);
		table.getTable().setHeaderVisible(true);
		table.getTable().setLinesVisible(true);
		
		TableColumn tblclmnSupplyStatus = new TableColumn(table.getTable(), SWT.NONE);
		tblclmnSupplyStatus.setWidth(114);
		tblclmnSupplyStatus.setText("Supply Status");
		
		TableColumn tblclmnClientName = new TableColumn(table.getTable(), SWT.NONE);
		tblclmnClientName.setWidth(196);
		tblclmnClientName.setText("Client Name");
		
		TableColumn tblclmnProduct = new TableColumn(table.getTable(), SWT.NONE);
		tblclmnProduct.setWidth(196);
		tblclmnProduct.setText("Product Name");
		
		TableColumn tblclmnAmount = new TableColumn(table.getTable(), SWT.NONE);
		tblclmnAmount.setWidth(147);
		tblclmnAmount.setText("Amount");
		
		Label lblDate = new Label(shlRareGlobalFood, SWT.NONE);
		lblDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblDate.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblDate.setAlignment(SWT.RIGHT);
		lblDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDate.setBounds(267, 183, 90, 15);
		lblDate.setText("Delivery Date: ");
		
		Label lblDeliveryDate = new Label(shlRareGlobalFood, SWT.NONE);
		lblDeliveryDate.setAlignment(SWT.RIGHT);
		//2 days after machine time.
		lblDeliveryDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDeliveryDate.setBounds(363, 183, 111, 15);
		
		lblDeliveryDate.setText(df3.format(dateobj2.getTime()));
		
		GetLine gl = new GetLine();
		ArrayList<LineData> l = gl.getLineDelivery(df2.format(dateobj.getTime()));
		
		for(int i = 0; i < l.size()  ;i++ ){
			
			TableTreeItem parent = new TableTreeItem(tableDelivery,SWT.NONE);
			parent.setText(1, l.get(i).getClientName());
			parent.setText(2, "Hello");
			parent.setText(3, l.get(i).getDeliveryNotes());
			if(l.get(i).getStatus()==1){
				parent.setText(0, "Delivered");
			}
			else{
				parent.setText(0, " Not Delivered");
			}
			parent.setText(4, l.get(i).getDeliveryDueDate());
			
			
		}
		
		ArrayList<LineData> l2 = gl.getLineDelivery(df2.format(dateobj2.getTime()));
		for(int i = 0; i < l2.size()  ;i++ ){
			
			TableTreeItem parent = new TableTreeItem(table,SWT.NONE);
			if(l2.get(i).getStatus()==1){
				parent.setText(0, "Delivered");
			}
			else{
				parent.setText(0, " Not Delivered");
			}
			parent.setText(1, l2.get(i).getClientName());
			parent.setText(2, l2.get(i).getProductName());
			parent.setText(3, Integer.toString(l2.get(i).getQuantity()));
			
			
		}
		
		Button btnAddOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddOrder ao = new AddOrder();
				ao.open();
			}
		});
		btnAddOrder.setBounds(399, 39, 75, 25);
		btnAddOrder.setText("Add Order");
		
		Button btnMarkAsDelivered = new Button(shlRareGlobalFood, SWT.NONE);
		//only enabled when a row in the table is selected.
		btnMarkAsDelivered.setEnabled(false);
		btnMarkAsDelivered.setBounds(293, 39, 100, 25);
		btnMarkAsDelivered.setText("Mark as Delivered");
		
		Menu menu = new Menu(shlRareGlobalFood, SWT.BAR);
		shlRareGlobalFood.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
				open();
			}
		});
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				pm.close();
				dw.close();
				vOrder.open();
			}
		});
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				vOrder.close();				
				dw.close();
				pm.open();
			}
		});
		mntmProduct.setText("Product");
		
		MenuItem mntmInventoryHistory = new MenuItem(menu, SWT.NONE);
		mntmInventoryHistory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				vOrder.close();
				pm.close();
				dw.open();
			}
		});
		mntmInventoryHistory.setText("Deposit or Withdraw");
	}
	public void close(){
		try {
			shlRareGlobalFood.dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
