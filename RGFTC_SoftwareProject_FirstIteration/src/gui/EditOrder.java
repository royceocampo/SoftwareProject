package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableTreeItem;
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

import managers.LineItem;
import managers.Order;
import managers.Product; //to check
import classes.LineItemManager;
import classes.OrderManager;
import classes.ProductManager;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;

public class EditOrder {

	protected Shell shlRareGlobalFood;
	protected Shell shell;
	private Text txtClientName;
	private Text txtQuantity;
	private Text txtPrice;
	private Text txtOrderReceiver;
	private Text txtYear;
	private Text txtOtherNotes;
	private Table tableCart;
	private float totalPrice = 0;
	private int orderID = 0;

	/**
	 * Launch the application.
	 * 
	 * @@ -41,9 +27,9 @@ public class ProductManage { public void open() {
	 * Display display = Display.getDefault(); createContents();
	 * shlRareGlobalFoods.open(); shlRareGlobalFoods.layout(); while
	 * (!shlRareGlobalFoods.isDisposed()) { shell.open(); shell.layout(); while
	 * (!shell.isDisposed()) { if (!display.readAndDispatch()) {
	 * display.sleep(); } @@ -54,106 +40,10 @@ public class ProductManage {
	 * Create contents of the window.
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
		shlRareGlobalFood.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlRareGlobalFood.setSize(699, 415);
		shlRareGlobalFood.setText("Rare Global Food Trading Corp.");

		String[] months = { "Month", "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };

		String[] days = { "Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
				"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };

		ArrayList<Product> productsList = new ProductManager().getAllProducts();
		int prodCount = new ProductManager().getProductsCount();
		if (prodCount == 0) {
			MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
			errorMessage.setText("Error");
			errorMessage.setMessage("No products listed.");
			errorMessage.open();
		}
		String[] products = new String[prodCount];

		for (int index = 0; index < prodCount; index++) {
			products[index] = productsList.get(index).getProductName();
		}

		Menu menu = new Menu(shlRareGlobalFood, SWT.BAR);
		shlRareGlobalFood.setMenuBar(menu);

		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Home ho = new Home();
				ho.open();
			}
		});
		mntmHome.setText("Home");

		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");

		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ProductManage pr = new ProductManage();
				pr.open();
			}
		});
		mntmProduct.setText("Product");

		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.setText("Inventory");

		Label lblOrderManagement = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrderManagement.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderManagement.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblOrderManagement.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblOrderManagement.setBounds(20, 10, 172, 28);
		lblOrderManagement.setText("MODIFY ORDER");

		Label lblClientName = new Label(shlRareGlobalFood, SWT.NONE);
		lblClientName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblClientName.setBounds(20, 62, 73, 15);
		lblClientName.setText("*Client Name:");

		txtClientName = new Text(shlRareGlobalFood, SWT.BORDER);
		txtClientName.setTextLimit(20);
		txtClientName.setBounds(108, 59, 172, 19);

		Label lblOrderReceiver = new Label(shlRareGlobalFood, SWT.NONE);
		lblOrderReceiver.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOrderReceiver.setBounds(20, 88, 87, 14);
		lblOrderReceiver.setText("*Order Receiver:");

		txtOrderReceiver = new Text(shlRareGlobalFood, SWT.BORDER);
		txtOrderReceiver.setTextLimit(20);
		txtOrderReceiver.setBounds(108, 84, 172, 19);

		Label lblDateDue = new Label(shlRareGlobalFood, SWT.NONE);
		lblDateDue.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDateDue.setBounds(20, 113, 60, 14);
		lblDateDue.setText("*Date Due:");
		Combo cmbMonthDue = new Combo(shlRareGlobalFood, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbMonthDue.setItems(months);
		cmbMonthDue.select(0);
		cmbMonthDue.setBounds(108, 110, 68, 23);
		Combo cmbDayDue = new Combo(shlRareGlobalFood, SWT.DROP_DOWN | SWT.READ_ONLY);
		cmbDayDue.setItems(days);
		cmbDayDue.select(0);
		cmbDayDue.setBounds(182, 110, 50, 23);

		txtYear = new Text(shlRareGlobalFood, SWT.BORDER);
		txtYear.setText("Year");
		txtYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtYear.setText("");
			}
		});
		txtYear.setTextLimit(4);
		txtYear.setBounds(240, 113, 40, 18);

		Label lblOtherNotes = new Label(shlRareGlobalFood, SWT.NONE);
		lblOtherNotes.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOtherNotes.setBounds(20, 141, 73, 14);
		lblOtherNotes.setText("Other Notes:");

		txtOtherNotes = new Text(shlRareGlobalFood, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		txtOtherNotes.setBounds(108, 139, 172, 194);

		Label lblProductOrdered = new Label(shlRareGlobalFood, SWT.NONE);
		lblProductOrdered.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductOrdered.setBounds(305, 39, 95, 14);
		lblProductOrdered.setText("*Product Ordered:");

		Combo cmbProductOrdered = new Combo(shlRareGlobalFood, SWT.READ_ONLY);
		cmbProductOrdered.setItems(products);
		cmbProductOrdered.setBounds(305, 59, 150, 23);
		cmbProductOrdered.select(0);

		Label lblQuantity = new Label(shlRareGlobalFood, SWT.NONE);
		lblQuantity.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblQuantity.setBounds(460, 39, 60, 14);
		lblQuantity.setText("*Qty (kilos)");

		txtQuantity = new Text(shlRareGlobalFood, SWT.BORDER);
		txtQuantity.setTextLimit(6);
		txtQuantity.setText("0.0");
		txtQuantity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtQuantity.setText("");
			}
		});
		txtQuantity.setBounds(460, 59, 65, 23);

		Label lblPrice = new Label(shlRareGlobalFood, SWT.NONE);
		lblPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblPrice.setBounds(530, 39, 46, 14);
		lblPrice.setText("*Price:");

		txtPrice = new Text(shlRareGlobalFood, SWT.BORDER);
		txtPrice.setTextLimit(6);
		txtPrice.setText("0.0");
		txtPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPrice.setText("");
			}
		});
		txtPrice.setBounds(530, 59, 65, 23);

		Label lblTotal = new Label(shlRareGlobalFood, SWT.NONE);
		lblTotal.setText("Total:");
		lblTotal.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTotal.setBounds(499, 250, 46, 20);
		lblTotal.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));

		Label lblTotalPrice = new Label(shlRareGlobalFood, SWT.NONE);
		lblTotalPrice.setAlignment(SWT.RIGHT);
		lblTotalPrice.setText("0.0");
		lblTotalPrice.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTotalPrice.setBounds(552, 250, 109, 20);
		lblTotalPrice.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));

		tableCart = new Table(shlRareGlobalFood, SWT.BORDER | SWT.FULL_SELECTION);
		tableCart.setLinesVisible(true);
		tableCart.setHeaderVisible(true);
		tableCart.setBounds(305, 99, 356, 133);

		TableColumn tblclmnId = new TableColumn(tableCart, SWT.NONE);
		tblclmnId.setResizable(false);
		tblclmnId.setWidth(25);
		tblclmnId.setText("ID");

		TableColumn tblclmnProduct = new TableColumn(tableCart, SWT.NONE);
		tblclmnProduct.setResizable(false);
		tblclmnProduct.setWidth(167);
		tblclmnProduct.setText("Product");

		TableColumn tblclmnQty = new TableColumn(tableCart, SWT.NONE);
		tblclmnQty.setResizable(false);
		tblclmnQty.setWidth(80);
		tblclmnQty.setText("Quantity");

		TableColumn tblclmnPrice = new TableColumn(tableCart, SWT.NONE);
		tblclmnPrice.setResizable(false);
		tblclmnPrice.setWidth(80);
		tblclmnPrice.setText("Price");

		// Get Order details.
		try {
			int index = viewOrder.getIndex();
			TableTreeItem item = viewOrder.getItem();
			TableTreeItem[] tableItems = viewOrder.getAllItems();
			int orderID = Integer.parseInt(tableItems[index].getText(0));
			this.orderID = orderID;
			Order orderToEdit = new OrderManager().getOrder(orderID);
			ArrayList<LineItem> storedList = new LineItemManager().getLineItems(orderID);

			// Store order data in local variables.
			String clientName = orderToEdit.getClientName();
			String orderReceiver = orderToEdit.getOrderReceiver();
			float totalPrice = orderToEdit.getPrice();
			String notes = orderToEdit.getNotes();
			Date dueDate = orderToEdit.getDeliveryDueDate();

			String numDueDate = dueDate.toString();
			String[] numDueDateParts = numDueDate.split("-");

			// Set the text fields with the details.
			txtClientName.setText(clientName);
			txtOrderReceiver.setText(orderReceiver);
			cmbMonthDue.select(Integer.parseInt(numDueDateParts[1]));
			cmbDayDue.select(Integer.parseInt(numDueDateParts[2]));
			txtYear.setText(numDueDateParts[0]);
			txtOtherNotes.setText(notes);
			lblTotalPrice.setText(Float.toString(totalPrice));

			// Populate the table with the orders.
			for (int currentIndex = 0; currentIndex < storedList.size(); currentIndex++) {
				
				int productID = storedList.get(currentIndex).getProductID();
				String productName = new ProductManager().getProduct(productID).getProductName();
				float productQuantity = storedList.get(currentIndex).getQuantity();
				float productPrice = storedList.get(currentIndex).getPricePerKilo();

				TableItem newOrder = new TableItem(tableCart, SWT.NONE);

				newOrder.setText(new String[] { Integer.toString(productID), productName,
						Float.toString(productQuantity), Float.toString(productPrice) });
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
			errorMessage.setText("Error");
			errorMessage.setMessage("Please select an order to edit.");
			errorMessage.open();
		}

		// Add Listeners
		Button btnAddToCart = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddToCart.addSelectionListener(new SelectionAdapter() {
			// add a listener to the button
			public void widgetSelected(SelectionEvent e) {

				String productOrder;
				float productQuantity = 0;
				float orderPrice = 0;
				float totalPrice = 0;

				// get data from input
				try {
					productOrder = cmbProductOrdered.getText();
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				try {
					if (txtQuantity.getText().length() > 0)
						productQuantity = Float.parseFloat(txtQuantity.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Only numbers are allowed.");
					errorMessage.open();
					return;
				}
				try {
					if (txtPrice.getText().length() > 0)
						orderPrice = Float.parseFloat(txtPrice.getText());
				} catch (Exception ex) {
					ex.printStackTrace();
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Only numbers are allowed.");
					errorMessage.open();
					return;
				}
				int productID = cmbProductOrdered.getSelectionIndex() + 1;
				// check null input
				if (productOrder.length() > 0 && Float.toString(productQuantity).length() > 0 && productQuantity > 0
						&& Float.toString(orderPrice).length() > 0 && orderPrice > 0) {
					TableItem newOrder = new TableItem(tableCart, SWT.NULL);
					newOrder.setText(0, Integer.toString(productID));
					newOrder.setText(1, productOrder);
					newOrder.setText(2, Float.toString(productQuantity));
					newOrder.setText(3, Float.toString(orderPrice));

					TableItem[] cartProducts = tableCart.getItems();

					for (int row = 0; row < cartProducts.length; row++) {
						String[] cartString = new String[4];
						for (int col = 0; col < 4; col++) {
							cartString[col] = cartProducts[row].getText(col);
						}

						totalPrice += Float.parseFloat(cartString[3]);
					}

					lblTotalPrice.setText(Float.toString(totalPrice));
					cmbProductOrdered.setText("");
					txtQuantity.setText("0.0");
					txtPrice.setText("0.0");
				} else if (productOrder.length() == 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("No products listed.");
					errorMessage.open();
				} else if (productQuantity <= 0 || orderPrice <= 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please give a valid number greater than 0.");
					errorMessage.open();
				} else {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please fill out all required fields.");
					errorMessage.open();

				}
			}
		});
		btnAddToCart.setBounds(601, 55, 60, 28);
		btnAddToCart.setText("Add");

		Button btnEditOrder = new Button(shlRareGlobalFood, SWT.NONE);
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
						productOrdered = contents[selectedIndex].getText(1);
						prodQty = contents[selectedIndex].getText(2);
						prodPrice = contents[selectedIndex].getText(3);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				if (contentCount == 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("There are no products in the cart.");
					errorMessage.open();
				} else if (selectedIndex != -1) {
					cmbProductOrdered.setText(productOrdered);
					txtQuantity.setText(prodQty);
					txtPrice.setText(prodPrice);

					tableCart.remove(selectedIndex);
					tableCart.redraw();

					TableItem[] cartProducts = tableCart.getItems();

					totalPrice = 0;
					for (int row = 0; row < cartProducts.length; row++) {
						String[] cartString = new String[4];
						for (int col = 0; col < 4; col++) {
							cartString[col] = cartProducts[row].getText(col);
						}

						totalPrice += Float.parseFloat(cartString[3]);
					}

					lblTotalPrice.setText(Float.toString(totalPrice));
				} else {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please select an item to edit.");
					errorMessage.open();
				}
			}
		});
		btnEditOrder.setText("Edit");
		btnEditOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnEditOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnEditOrder.setBounds(305, 247, 73, 28);
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

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
						TableItem[] cartProducts = tableCart.getItems();

						totalPrice = 0;
						for (int row = 0; row < cartProducts.length; row++) {
							String[] cartString = new String[4];
							for (int col = 0; col < 4; col++) {
								cartString[col] = cartProducts[row].getText(col);
								System.out.print(cartProducts[row].getText(col) + " ");
							}

							totalPrice += Float.parseFloat(cartString[3]);
						}

						lblTotalPrice.setText(Float.toString(totalPrice));
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					return;
				}
				if (contentCount == 0) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("There are no products in the cart.");
					errorMessage.open();
				} else if (selectedIndex == -1) {
					MessageBox errorMessage = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorMessage.setText("Error");
					errorMessage.setMessage("Please select an item to delete.");
					errorMessage.open();
				}
			}
		});
		btnDeleteOrder.setText("Delete");
		btnDeleteOrder.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION_TEXT));
		btnDeleteOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnDeleteOrder.setBounds(384, 247, 73, 28);

		Button btnAddOrder = new Button(shlRareGlobalFood, SWT.NONE);
		btnAddOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int contentCount = 0;
				String clientName = null;
				// String prodPrice;
				String orderReceiver = null;
				String monthDue;
				String dayDue;
				String yearDue = null;
				String otherNotes;
				String dueDate;
				DateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				Date utilDueDate;
				java.sql.Date sqlDueDate = null;
				Boolean isDelivered = null;

				try {
					contentCount = tableCart.getItemCount();
					clientName = txtClientName.getText();
					orderReceiver = txtOrderReceiver.getText();
					otherNotes = txtOtherNotes.getText();
					if (cmbMonthDue.getSelectionIndex() != 0 && cmbDayDue.getSelectionIndex() != 0
							&& txtYear.getText().length() > 0) {
						monthDue = cmbMonthDue.getText();
						dayDue = cmbDayDue.getText();
						if (Integer.parseInt(txtYear.getText()) > 0) {
							yearDue = txtYear.getText();
							dueDate = monthDue + " " + dayDue + ", " + yearDue;
							utilDueDate = dateFormat.parse(dueDate);
							sqlDueDate = new java.sql.Date(utilDueDate.getTime());
						}
					}

					TableItem[] cartProducts = tableCart.getItems();

					for (int row = 0; row < cartProducts.length; row++) {
						String[] cartString = new String[4];
						for (int col = 0; col < 4; col++) {
							cartString[col] = cartProducts[row].getText(col);
						}

						totalPrice += Float.parseFloat(cartString[3]);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please give a valid year beyond 2000.");
					errorBox.open();
					return;
				}
				if (clientName.length() == 0 || orderReceiver.length() == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please fill out all required fields.");
					errorBox.open();
				} else if (cmbMonthDue.getSelectionIndex() == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please select a month.");
					errorBox.open();
				} else if (cmbDayDue.getSelectionIndex() == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please select a day.");
					errorBox.open();
				} else if (txtYear.getText().length() == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please set the year.");
					errorBox.open();
				} else if (Integer.parseInt(yearDue) <= 2000) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please set the year beyond 2000.");
					errorBox.open();
				} else if (contentCount == 0) {
					MessageBox errorBox = new MessageBox(shlRareGlobalFood, SWT.Close);
					errorBox.setText("Error");
					errorBox.setMessage("Please add products to order.");
					errorBox.open();
				} else {
					MessageBox confirmBox = new MessageBox(shlRareGlobalFood, SWT.YES | SWT.NO);
					confirmBox.setText("Confirmation");
					confirmBox.setMessage("Are you sure with this update?");
					int buttonID = confirmBox.open();
					switch (buttonID) {
					case SWT.YES:
						TableItem[] cartItems = tableCart.getItems();
						
						new LineItemManager().deleteLineItem(orderID);

						Order newOrder = new Order(clientName, totalPrice, orderReceiver, sqlDueDate, isDelivered,
								otherNotes);
						new OrderManager().editOrder(orderID, newOrder);

						for (int row = 0; row < cartItems.length; row++) {
							String[] itemsString = new String[4];
							for (int col = 0; col < 4; col++) {
								itemsString[col] = cartItems[row].getText(col);
							}

							LineItem newLineItem = new LineItem(orderID, Integer.parseInt(itemsString[0]),
									Float.parseFloat(itemsString[3]), Float.parseFloat(itemsString[2]));
							LineItemManager manageLineItem = new LineItemManager();
							manageLineItem.addLineItem(newLineItem);
						}
						totalPrice = 0;
						lblTotalPrice.setText("0.0");
						tableCart.removeAll();
						tableCart.redraw();
						
						MessageBox successBox = new MessageBox(shlRareGlobalFood, SWT.Close);
						successBox.setText("Notification");
						successBox.setMessage("Successfully updated order.");
						successBox.open();
						
						shlRareGlobalFood.close();
						break;
					case SWT.NO:
						break;
					}
				}
			}
		});
		btnAddOrder.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		btnAddOrder.setBounds(563, 312, 95, 35);
		btnAddOrder.setText("Update");

	}
}
