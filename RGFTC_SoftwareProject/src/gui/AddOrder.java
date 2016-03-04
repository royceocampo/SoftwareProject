package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;

import classes.Order;
import services.OrderManager;

public class AddOrder {

	protected Shell shlRareGlobalFood;
	protected Shell shell;
	private Text txtClientName;
	private Text txtQuantity;
	private Text txtPrice;
	private Text txtOrderReceiver;
	private Text txtYear;
	private Text txtOtherNotes;
	private Table tableCart;

	/**
	 * Launch the application.
	 * 
	 * @@ -41,9 +27,9 @@ public class ProductManage { public void open() {
	 *    Display display = Display.getDefault(); createContents();
	 *    shlRareGlobalFoods.open(); shlRareGlobalFoods.layout(); while
	 *    (!shlRareGlobalFoods.isDisposed()) { shell.open(); shell.layout();
	 *    while (!shell.isDisposed()) { if (!display.readAndDispatch()) {
	 *    display.sleep(); }
	 * @@ -54,106 +40,10 @@ public class ProductManage { Create contents of the
	 *    window.
	 * @wbp.parser.entryPoint
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

	protected void createContents() {
		shlRareGlobalFood = new Shell();
		shlRareGlobalFood.setMinimumSize(new Point(700, 415));
		shlRareGlobalFood.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFood.setSize(699, 415);
		shlRareGlobalFood.setText("Rare Global Food Trading Corp.");

		String[] months = { "Month", "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October",
				"November", "December" };

		String[] days = { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31" };

		Menu menu = new Menu(shlRareGlobalFood, SWT.BAR);
		shlRareGlobalFood.setMenuBar(menu);

		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.setText("Home");

		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");

		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.setText("Product");

		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.setText("Inventory");

		Label lblOrderManagement = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrderManagement.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderManagement.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_DARK_RED));
		lblOrderManagement.setFont(SWTResourceManager.getFont("Segoe UI", 18,
				SWT.NORMAL));
		lblOrderManagement.setBounds(20, 10, 139, 28);
		lblOrderManagement.setText("ADD ORDER");

		Label lblClientName = new Label(shlRareGlobalFood, SWT.NONE);
		lblClientName.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblClientName.setBounds(20, 62, 73, 15);
		lblClientName.setText("*Client Name:");

		txtClientName = new Text(shlRareGlobalFood, SWT.BORDER);
		txtClientName.setTextLimit(20);
		txtClientName.setBounds(108, 59, 172, 19);

		Label lblOrderReceiver = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrderReceiver.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderReceiver.setBounds(20, 88, 87, 14);
		lblOrderReceiver.setText("*Order Receiver:");

		txtOrderReceiver = new Text(shlRareGlobalFood, SWT.BORDER);
		txtOrderReceiver.setTextLimit(20);
		txtOrderReceiver.setBounds(108, 84, 172, 19);

		Label lblDateDue = new Label(shlRareGlobalFood, SWT.NONE);
		lblDateDue.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDateDue.setBounds(20, 113, 60, 14);
		lblDateDue.setText("*Date Due:");
		Combo cmbMonthDue = new Combo(shlRareGlobalFood, SWT.DROP_DOWN
				| SWT.READ_ONLY);
		cmbMonthDue.setItems(months);
		cmbMonthDue.select(0);
		cmbMonthDue.setBounds(108, 110, 68, 23);
		Combo cmbDayDue = new Combo(shlRareGlobalFood, SWT.DROP_DOWN
				| SWT.READ_ONLY);
		cmbDayDue.setItems(days);
		cmbDayDue.select(0);
		cmbDayDue.setBounds(182, 110, 50, 23);

		txtYear = new Text(shlRareGlobalFood, SWT.BORDER);
		txtYear.setTextLimit(4);
		txtYear.setBounds(240, 113, 40, 18);

		Label lblOtherNotes = new Label(shlRareGlobalFood, SWT.NONE);
		lblOtherNotes.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOtherNotes.setBounds(20, 141, 73, 14);
		lblOtherNotes.setText("Other Notes:");

		txtOtherNotes = new Text(shlRareGlobalFood, SWT.BORDER | SWT.MULTI
				| SWT.WRAP | SWT.V_SCROLL);
		txtOtherNotes.setBounds(108, 139, 172, 194);

		Label lblProductOrdered = new Label(shlRareGlobalFood, SWT.NONE);
		lblProductOrdered.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductOrdered.setBounds(305, 39, 95, 14);
		lblProductOrdered.setText("*Product Ordered:");

		Combo cmbProductOrdered = new Combo(shlRareGlobalFood, SWT.NONE);
		cmbProductOrdered.setBounds(305, 59, 150, 23);

		Label lblQuantity = new Label(shlRareGlobalFood, SWT.NONE);
		lblQuantity.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblQuantity.setBounds(460, 39, 60, 14);
		lblQuantity.setText("*Qty (kilos)");

		txtQuantity = new Text(shlRareGlobalFood, SWT.BORDER);
		txtQuantity.setTextLimit(6);
		txtQuantity.setText("0.0");
		txtQuantity.setBounds(460, 59, 65, 23);

		Label lblPrice = new Label(shlRareGlobalFood, SWT.NONE);
		lblPrice.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrice.setBounds(530, 39, 46, 14);
		lblPrice.setText("*Price:");

		txtPrice = new Text(shlRareGlobalFood, SWT.BORDER);
		txtPrice.setTextLimit(6);
		txtPrice.setText("0.0");
		txtPrice.setBounds(530, 59, 65, 23);

		Button btnAddToCart = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddToCart.addSelectionListener(new SelectionAdapter() {
			// add a listener to the button
			public void widgetSelected(SelectionEvent e) {

				String productOrder;
				float productQuantity = 0;
				float orderPrice = 0;

				// get data from input
				try {
					productOrder = cmbProductOrdered.getText();
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				try {
					if (txtQuantity.getText().length() > 0)
						productQuantity = Float.parseFloat(txtQuantity
								.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Only numbers are allowed");
					errorMessage.open();
					return;
				}
				try {
					if (txtPrice.getText().length() > 0)
						orderPrice = Float.parseFloat(txtPrice.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Only numbers are allowed");
					errorMessage.open();
					return;
				}

				// check null input
				if (productOrder.length() > 0
						&& Float.toString(productQuantity).length() > 0
						&& productQuantity > 0
						&& Float.toString(orderPrice).length() > 0
						&& orderPrice > 0) {
					TableItem newOrder = new TableItem(tableCart, SWT.NULL);
					newOrder.setText(0, productOrder);
					newOrder.setText(1, Float.toString(productQuantity));
					newOrder.setText(2, Float.toString(orderPrice));

					cmbProductOrdered.setText("");
					txtQuantity.setText("0.0");
					txtPrice.setText("0.0");
				} else if (productQuantity <= 0 || orderPrice <= 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage
							.setMessage("Please give a valid number greater than 0.");
					errorMessage.open();
				} else {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please fill out all fields.");
					errorMessage.open();

				}
			}
		});
		btnAddToCart.setBounds(601, 55, 60, 28);
		btnAddToCart.setText("Add");

		tableCart = new Table(shlRareGlobalFood, SWT.BORDER
				| SWT.FULL_SELECTION);
		tableCart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] contents = tableCart.getItems();
				String clientName = contents[tableCart.getSelectionIndex()]
						.getText(0);
				String productOrdered = contents[tableCart.getSelectionIndex()]
						.getText(1);
				String prodQty = contents[tableCart.getSelectionIndex()]
						.getText(2);
				String prodPrice = contents[tableCart.getSelectionIndex()]
						.getText(3);
				System.out.println(clientName + " " + productOrdered + " "
						+ prodQty + " " + prodPrice);
			}
		});
		tableCart.setLinesVisible(true);
		tableCart.setHeaderVisible(true);
		tableCart.setBounds(305, 99, 356, 133);

		TableColumn tblclmnProduct = new TableColumn(tableCart, SWT.NONE);
		tblclmnProduct.setResizable(false);
		tblclmnProduct.setWidth(192);
		tblclmnProduct.setText("Product");

		TableColumn tblclmnQty = new TableColumn(tableCart, SWT.NONE);
		tblclmnQty.setResizable(false);
		tblclmnQty.setWidth(80);
		tblclmnQty.setText("Quantity");

		TableColumn tblclmnPrice = new TableColumn(tableCart, SWT.NONE);
		tblclmnPrice.setResizable(false);
		tblclmnPrice.setWidth(80);
		tblclmnPrice.setText("Price");
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

		Button btnEditOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnEditOrder.setEnabled(true);
		btnEditOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] contents = null;
				int contentCount = 0;
				int selectedIndex;
				String productOrdered = null;
				String prodQty = null;
				String prodPrice = null;

				try {
					contents = tableCart.getItems();
					contentCount = tableCart.getItemCount();
					selectedIndex = tableCart.getSelectionIndex();
					if (selectedIndex != -1) {
						productOrdered = contents[selectedIndex].getText(0);
						prodQty = contents[selectedIndex].getText(1);
						prodPrice = contents[selectedIndex].getText(2);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				if (contentCount == 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("There are no orders to edit.");
					errorMessage.open();
				} else if (selectedIndex != -1) {
					cmbProductOrdered.setText(productOrdered);
					txtQuantity.setText(prodQty);
					txtPrice.setText(prodPrice);

					tableCart.remove(selectedIndex);
					tableCart.redraw();
				} else {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please select an item to edit.");
					errorMessage.open();
				}
			}
		});
		btnEditOrder.setText("Edit");
		btnEditOrder.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEditOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11,
				SWT.NORMAL));
		btnEditOrder.setBounds(503, 247, 73, 28);

		Button btnDeleteOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnDeleteOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int contentCount = 0;
				int selectedIndex;
				try {
					contentCount = tableCart.getItemCount();
					selectedIndex = tableCart.getSelectionIndex();
					if (selectedIndex != -1) {
						tableCart.remove(selectedIndex);
						tableCart.redraw();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				if (contentCount == 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("There are no orders to delete.");
					errorMessage.open();
				} else if (selectedIndex == -1) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please select an item to delete.");
					errorMessage.open();
				}
			}
		});
		btnDeleteOrder.setText("Delete");
		btnDeleteOrder.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDeleteOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11,
				SWT.NORMAL));
		btnDeleteOrder.setBounds(587, 247, 73, 28);

		Button btnAddOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int contentCount = 0;
				String clientName;
				String prodPrice;
				String orderReceiver;
				String monthDue;
				String dayDue;
				String yearDue;
				String otherNotes;
				String dueDate;
				DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy",
						Locale.ENGLISH);
				Date utilDueDate;
				java.sql.Date sqlDueDate = null;

				try {
					contentCount = tableCart.getItemCount();
					clientName = txtClientName.getText();
					// prodPrice =
					// orders[tableCart.getSelectionIndex()].getText(2);
					orderReceiver = txtOrderReceiver.getText();
					otherNotes = txtOtherNotes.getText();
					if (cmbMonthDue.getSelectionIndex() != 0
							&& cmbDayDue.getSelectionIndex() != 0
							&& Integer.parseInt(txtYear.getText()) > 2010) {
						monthDue = cmbMonthDue.getText();
						dayDue = cmbDayDue.getText();
						yearDue = txtYear.getText();
						dueDate = monthDue + " " + dayDue + ", " + yearDue;
						utilDueDate = dateFormat.parse(dueDate);
						sqlDueDate = new java.sql.Date(utilDueDate.getTime());
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				/*
				 * Order newOrder = new Order(clientName,
				 * Float.parseFloat(prodPrice), orderReceiver, sqlDueDate,
				 * otherNotes); OrderManager manageOrder = new OrderManager();
				 * manageOrder.addOrder(newOrder);
				 */

				if (clientName.length() == 0 && orderReceiver.length() == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please fill out all required fields.");
					errorBox.open();
				} else if (contentCount == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood,
							SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("There are no orders.");
					errorBox.open();
				}

				else {
					MessageBox confirmBox = new MessageBox(shlRareGlobalFood,
							SWT.YES | SWT.NO);
					confirmBox.setText("Confirmation");
					confirmBox.setMessage("Are you sure with this order?");
					int buttonID = confirmBox.open();
					switch (buttonID) {
					case SWT.YES:
						TableItem[] cartItems = tableCart.getItems();

						for (int row = 0; row < cartItems.length; row++) {
							String[] itemsString = new String[3];
							for (int col = 0; col < 3; col++) {
								itemsString[col] = cartItems[row].getText(col);
								System.out.print(cartItems[row].getText(col)
										+ " ");
							}
							Order newOrder = new Order(clientName, Float
									.parseFloat(itemsString[2]), orderReceiver,
									sqlDueDate, otherNotes);
							OrderManager manageOrder = new OrderManager();
							manageOrder.addOrder(newOrder);
						}
						tableCart.clearAll();
						break;
					case SWT.NO:
						break;
					}
				}
			}
		});
		btnAddOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11,
				SWT.NORMAL));
		btnAddOrder.setForeground(SWTResourceManager
				.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnAddOrder.setBounds(563, 312, 95, 35);
		btnAddOrder.setText("Add Order");
		btnAddOrder.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

	}
}
