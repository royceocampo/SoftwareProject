package gui;

import java.util.ArrayList;

import managers.Inventory;
import managers.LineData;
import managers.Product;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import classes.InventoryManager;
import classes.ProductManager;

public class DepWith {

	protected Shell shlDepWith;
	private Text text_person;
	ProductManager productManager = new ProductManager();
	private ArrayList<Product> productList = productManager.getAllProduct();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DepWith window = new DepWith();
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
		shlDepWith.open();
		shlDepWith.layout();
		while (!shlDepWith.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDepWith = new Shell();
		shlDepWith.setSize(324, 317);
		shlDepWith.setText("Deposit or Withdraw");
		shlDepWith.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		
		Menu menu = new Menu(shlDepWith, SWT.BAR);
		shlDepWith.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				Home ho = new Home();
//				ho.open();
				shlDepWith.close();
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
				shlDepWith.close();
			}
		});
		mntmProduct.setText("Product");
		
		MenuItem mntmInventory = new MenuItem(menu, SWT.NONE);
		mntmInventory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				shlOrderManage.close();
			}
		});
		mntmInventory.setText("Inventory History");
		
		Label lblProductName = new Label(shlDepWith, SWT.NONE);
		lblProductName.setAlignment(SWT.RIGHT);
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setBounds(58, 18, 83, 15);
		lblProductName.setText("Product Name: ");
		
		Combo combo = new Combo(shlDepWith, SWT.NONE);
		combo.setBounds(169, 10, 112, 23);
		for(int i=0; i<productList.size(); i++){
			combo.add(productList.get(i).getProductName());
		}
		
		Label lblNumberOfBoxes = new Label(shlDepWith, SWT.NONE);
		lblNumberOfBoxes.setAlignment(SWT.RIGHT);
		lblNumberOfBoxes.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNumberOfBoxes.setBounds(44, 55, 97, 15);
		lblNumberOfBoxes.setText("Number of Boxes: ");
		
		Spinner spinner = new Spinner(shlDepWith, SWT.BORDER);
		spinner.setMaximum(1000000);
		spinner.setBounds(169, 52, 112, 22);
		
		Label lblDepositOrWithdraw = new Label(shlDepWith, SWT.NONE);
		lblDepositOrWithdraw.setAlignment(SWT.RIGHT);
		lblDepositOrWithdraw.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDepositOrWithdraw.setBounds(22, 113, 119, 15);
		lblDepositOrWithdraw.setText("Deposit or Withdraw: ");
		
		Button btnSubmit = new Button(shlDepWith, SWT.NONE);
		btnSubmit.setBounds(128, 260, 75, 25);
		btnSubmit.setText("Submit");
		
		DateTime transDate = new DateTime(shlDepWith, SWT.BORDER);
		transDate.setBounds(169, 170, 80, 24);
		
		Label lblDate = new Label(shlDepWith, SWT.NONE);
		lblDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDate.setAlignment(SWT.RIGHT);
		lblDate.setBounds(86, 173, 55, 15);
		lblDate.setText("Date:");
		
		Label lblPersonInCharge = new Label(shlDepWith, SWT.NONE);
		lblPersonInCharge.setAlignment(SWT.RIGHT);
		lblPersonInCharge.setBounds(29, 213, 112, 14);
		lblPersonInCharge.setText("Person in Charge:");
		
		text_person = new Text(shlDepWith, SWT.BORDER);
		text_person.setBounds(169, 210, 112, 25);
		
		Button btnDeposit = new Button(shlDepWith, SWT.RADIO);
		btnDeposit.setBounds(169, 97, 91, 18);
		btnDeposit.setText("Deposit");
		
		Button btnWithdrawal = new Button(shlDepWith, SWT.RADIO);
		btnWithdrawal.setBounds(169, 124, 91, 18);
		btnWithdrawal.setText("Withdrawal");

		Label label = new Label(shlDepWith, SWT.NONE);
		label.setBounds(147, 18, 10, 14);
		label.setText("*");
		label.setVisible(false);
		
		Label label_1 = new Label(shlDepWith, SWT.NONE);
		label_1.setText("*");
		label_1.setBounds(147, 55, 10, 14);
		label_1.setVisible(false);
		
		Label label_2 = new Label(shlDepWith, SWT.NONE);
		label_2.setText("*");
		label_2.setBounds(147, 113, 10, 14);
		label_2.setVisible(false);
		
		Label label_3 = new Label(shlDepWith, SWT.NONE);
		label_3.setText("*");
		label_3.setBounds(147, 170, 10, 14);
		label_3.setVisible(false);
		
		Label label_4 = new Label(shlDepWith, SWT.NONE);
		label_4.setText("*");
		label_4.setBounds(147, 213, 10, 14);
		label_4.setVisible(false);
		
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String check="";
				boolean error4 = false;
				label.setVisible(false);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(false);
				boolean error = true;
				boolean error1 = false;
				int quantity = 0;
				try {
					quantity = Integer.parseInt(spinner.getText());
				} catch (Exception e2) {
					// TODO: handle exception
					error1 = true;
				}

				for(int i=0; i<productList.size(); i++){
					if(combo.getText().equals(productList.get(i).getProductName())){
						error = false;
					}
				}

				if(!btnDeposit.getSelection() && !btnWithdrawal.getSelection()){
					check = "DW";
				}
				else {
					check = "none";
				}
				
				if(combo.getText().equals("") || text_person.getText().equals("")){
					MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Required fields have no input.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}

					if(combo.getText().equals("")){
						label.setVisible(true);
					} if(text_person.getText().equals("")) {
						label_4.setVisible(true);
					}
					error4 = true;
				} if(quantity <= 0){
					MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Please give a valid number greater than 0 for number of boxes.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}
					label_1.setVisible(true);
					error4 = true
				} 
				if(check.equals("DW")){
					MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Check either Withdraw or Deposit.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}
					label_2.setVisible(true);
					error4 = true;
				}
				else if(error){
					MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Product you want does not exist.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}
				} else if(error1){
					MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
					msg.setText("Error");
					msg.setMessage("Quantity is not a valid number.");
					int buttonID = msg.open();
//					String valString = "SWT.OK";
					switch (buttonID){
					case SWT.NO:
						break;
					}
				} else if (!error4){
					String date = transDate.getYear()+"-"+(transDate.getMonth()+1)+"-"+transDate.getDay();
					Inventory inventory = new Inventory();
					InventoryManager inventoryManager = new InventoryManager();
					inventory.setPerson(text_person.getText());
					inventory.setProduct(combo.getText());
					inventory.setQuantity(Integer.parseInt(spinner.getText()));
					inventory.setDate(date);
					inventory.setProductID(1);
					// String check;

					if(btnDeposit.getSelection()){
						check = inventoryManager.addInventory(inventory, btnDeposit.getText());
					} else if(btnWithdrawal.getSelection()){
						check = inventoryManager.addInventory(inventory, btnWithdrawal.getText());
					} else {
						check = "DW";
					}

					if(check.equals("No")){
						MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
						msg.setText("Error");
						msg.setMessage("Product you want does not exist.");
						int buttonID = msg.open();
//						String valString = "SWT.OK";
						switch (buttonID){
						case SWT.NO:
							break;
						}
					} else if(check.equals("Overflow")){
						MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
						msg.setText("Error");
						msg.setMessage(combo.getText() + " has less stock than the desired withdrawal amount.");
						int buttonID = msg.open();
//						String valString = "SWT.OK";
						switch (buttonID){
						case SWT.NO:
							break;
						}
						label_1.setVisible(true);
					} else {
						MessageBox msg = new MessageBox(shlDepWith, SWT.ICON_ERROR | SWT.OK);
						msg.setText("Success");
						msg.setMessage("Succesful.");
						int buttonID = msg.open();
//						String valString = "SWT.OK";
						switch (buttonID){
						case SWT.NO:
							break;
						}
						combo.setText("");
						spinner.setSelection(0);
						btnDeposit.setSelection(false);
						btnWithdrawal.setSelection(false);
						text_person.setText("");
					}
				
				}
				
				
				
			}
		});
	}
}
