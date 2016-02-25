package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;

public class Home {

	protected Shell shlRareGlobalFood;
	private Table tableDelivery;
	private Table table;

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
		shlRareGlobalFood.setMinimumSize(new Point(500, 350));
		shlRareGlobalFood.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFood.setSize(450, 300);
		shlRareGlobalFood.setText("Rare Global Food Trading Corp.");
		
		Label lblTodayDate = new Label(shlRareGlobalFood, SWT.NONE);
		//Date based from machine time.
		lblTodayDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblTodayDate.setAlignment(SWT.CENTER);
		lblTodayDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTodayDate.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblTodayDate.setBounds(115, 10, 263, 23);
		lblTodayDate.setText("Satuday, February 20, 2016");
		
		Label lblOrdersTo = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrdersTo.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblOrdersTo.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrdersTo.setBounds(10, 49, 190, 15);
		lblOrdersTo.setText("Orders to be delievered today: ");
		
		tableDelivery = new Table(shlRareGlobalFood, SWT.BORDER | SWT.FULL_SELECTION);
		tableDelivery.setBounds(10, 68, 464, 109);
		tableDelivery.setHeaderVisible(true);
		tableDelivery.setLinesVisible(true);
		
		TableColumn tblclmnDeliveryStatus = new TableColumn(tableDelivery, SWT.NONE);
		tblclmnDeliveryStatus.setWidth(91);
		tblclmnDeliveryStatus.setText("Delivery Status");
		
		TableColumn tblclmnClient = new TableColumn(tableDelivery, SWT.NONE);
		tblclmnClient.setWidth(100);
		tblclmnClient.setText("Client");
		
		TableColumn tblclmnOrderReceiver = new TableColumn(tableDelivery, SWT.NONE);
		tblclmnOrderReceiver.setWidth(100);
		tblclmnOrderReceiver.setText("Order Receiver");
		
		TableColumn tblclmnNote = new TableColumn(tableDelivery, SWT.NONE);
		tblclmnNote.setWidth(100);
		tblclmnNote.setText("Note");
		
		TableColumn tblclmnDueDate = new TableColumn(tableDelivery, SWT.NONE);
		tblclmnDueDate.setWidth(100);
		tblclmnDueDate.setText("Due Date");
		
		Label lblProductsToBe = new Label(shlRareGlobalFood, SWT.NONE);
		lblProductsToBe.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductsToBe.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblProductsToBe.setBounds(10, 194, 240, 15);
		lblProductsToBe.setText("Products to be ordered from suppliers: ");
		
		table = new Table(shlRareGlobalFood, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 215, 464, 86);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnSupplyStatus = new TableColumn(table, SWT.NONE);
		tblclmnSupplyStatus.setWidth(114);
		tblclmnSupplyStatus.setText("Supply Status");
		
		TableColumn tblclmnProduct = new TableColumn(table, SWT.NONE);
		tblclmnProduct.setWidth(196);
		tblclmnProduct.setText("Product Name");
		
		TableColumn tblclmnAmount = new TableColumn(table, SWT.NONE);
		tblclmnAmount.setWidth(147);
		tblclmnAmount.setText("Amount");
		
		Label lblDate = new Label(shlRareGlobalFood, SWT.NONE);
		lblDate.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblDate.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblDate.setAlignment(SWT.RIGHT);
		lblDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDate.setBounds(267, 194, 90, 15);
		lblDate.setText("Delivery Date: ");
		
		Label lblDeliveryDate = new Label(shlRareGlobalFood, SWT.NONE);
		lblDeliveryDate.setAlignment(SWT.RIGHT);
		//2 days after machine time.
		lblDeliveryDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDeliveryDate.setBounds(363, 194, 111, 15);
		lblDeliveryDate.setText("February 22, 2016");
		
		Button btnAddOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddOrder.setBounds(399, 39, 75, 25);
		btnAddOrder.setText("Add Order");
		
		Button btnMarkAsDelivered = new Button(shlRareGlobalFood, SWT.NONE);
		//only enabled when a row in the table is selected.
		btnMarkAsDelivered.setEnabled(false);
		btnMarkAsDelivered.setBounds(293, 39, 100, 25);
		btnMarkAsDelivered.setText("Mark as Delivered");
		
		Button btnOrderDetails = new Button(shlRareGlobalFood, SWT.NONE);
		//only enabled when a row in the table is selected.
		btnOrderDetails.setEnabled(false);
		btnOrderDetails.setBounds(207, 39, 80, 25);
		btnOrderDetails.setText("Order Details");
	}
}
