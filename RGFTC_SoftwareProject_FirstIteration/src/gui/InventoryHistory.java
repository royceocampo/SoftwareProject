package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InventoryHistory {

	protected Shell shlInventoryHistory;
	private Table tableInHis;
	private Table tableTotal;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			InventoryHistory window = new InventoryHistory();
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
		shlInventoryHistory.open();
		shlInventoryHistory.layout();
		while (!shlInventoryHistory.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlInventoryHistory = new Shell();
		shlInventoryHistory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlInventoryHistory.setMinimumSize(new Point(500, 320));
		shlInventoryHistory.setSize(500, 320);
		shlInventoryHistory.setText("Rare Global Food Trading Corp.");
		shlInventoryHistory.setLayout(null);
		
		Menu menu = new Menu(shlInventoryHistory, SWT.BAR);
		shlInventoryHistory.setMenuBar(menu);
		
		MenuItem mntmHome = new MenuItem(menu, SWT.NONE);
		mntmHome.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlInventoryHistory.close();
			}
		});
		mntmHome.setText("Home");
		
		MenuItem mntmOrder = new MenuItem(menu, SWT.NONE);
		mntmOrder.setText("Order");
		
		MenuItem mntmProduct = new MenuItem(menu, SWT.NONE);
		mntmProduct.setText("Product");
		
		MenuItem mntmInventoryHistory = new MenuItem(menu, SWT.NONE);
		mntmInventoryHistory.setText("Inventory History");
		
		Label lblHead = new Label(shlInventoryHistory, SWT.NONE);
		lblHead.setBounds(5, 5, 183, 32);
		lblHead.setFont(SWTResourceManager.getFont("Segoe UI", 18, SWT.NORMAL));
		lblHead.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblHead.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblHead.setText("Inventory History");
		
		Label lblProductName = new Label(shlInventoryHistory, SWT.NONE);
		lblProductName.setBounds(15, 43, 83, 15);
		lblProductName.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setText("Product Name: ");
		
		Combo combo = new Combo(shlInventoryHistory, SWT.NONE);
		combo.setBounds(104, 40, 134, 23);
		
		Composite compositeTable = new Composite(shlInventoryHistory, SWT.BORDER);
		compositeTable.setBounds(15, 70, 459, 108);
		
		tableInHis = new Table(compositeTable, SWT.FULL_SELECTION);
		tableInHis.setBounds(0, 0, 455, 104);
		tableInHis.setHeaderVisible(true);
		tableInHis.setLinesVisible(true);
		
		TableColumn tblclmnPersonInCharge = new TableColumn(tableInHis, SWT.CENTER);
		tblclmnPersonInCharge.setResizable(false);
		tblclmnPersonInCharge.setWidth(108);
		tblclmnPersonInCharge.setText("Person in Charge");
		
		TableColumn tblclmnAction = new TableColumn(tableInHis, SWT.CENTER);
		tblclmnAction.setResizable(false);
		tblclmnAction.setWidth(79);
		tblclmnAction.setText("Action");
		
		TableColumn tblclmnBoxes = new TableColumn(tableInHis, SWT.CENTER);
		tblclmnBoxes.setResizable(false);
		tblclmnBoxes.setWidth(51);
		tblclmnBoxes.setText("Boxes");
		
		TableColumn tblclmnWeight = new TableColumn(tableInHis, SWT.CENTER);
		tblclmnWeight.setResizable(false);
		tblclmnWeight.setWidth(89);
		tblclmnWeight.setText("Weight");
		
		TableColumn tblclmnDate = new TableColumn(tableInHis, SWT.CENTER);
		tblclmnDate.setResizable(false);
		tblclmnDate.setWidth(127);
		tblclmnDate.setText("Date");
		
		Label lblTotal = new Label(shlInventoryHistory, SWT.NONE);
		lblTotal.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblTotal.setBounds(15, 184, 55, 15);
		lblTotal.setText("Total: ");
		
		tableTotal = new Table(shlInventoryHistory, SWT.BORDER | SWT.FULL_SELECTION);
		tableTotal.setEnabled(false);
		tableTotal.setBounds(15, 205, 398, 46);
		tableTotal.setHeaderVisible(true);
		tableTotal.setLinesVisible(true);
		
		TableColumn tblclmnDepositbox = new TableColumn(tableTotal, SWT.NONE);
		tblclmnDepositbox.setResizable(false);
		tblclmnDepositbox.setWidth(85);
		tblclmnDepositbox.setText("Deposit (Box)");
		
		TableColumn tblclmnWithdrawbox = new TableColumn(tableTotal, SWT.NONE);
		tblclmnWithdrawbox.setResizable(false);
		tblclmnWithdrawbox.setWidth(100);
		tblclmnWithdrawbox.setText("Withdraw (Box)");
		
		TableColumn tblclmnRemainingBox = new TableColumn(tableTotal, SWT.NONE);
		tblclmnRemainingBox.setResizable(false);
		tblclmnRemainingBox.setWidth(92);
		tblclmnRemainingBox.setText("Remaining Box");
		
		TableColumn tblclmnRemainingWeight = new TableColumn(tableTotal, SWT.NONE);
		tblclmnRemainingWeight.setResizable(false);
		tblclmnRemainingWeight.setWidth(115);
		tblclmnRemainingWeight.setText("Remaining Weight");
		
		Button btnDepositOrWithdraw = new Button(shlInventoryHistory, SWT.NONE);
		btnDepositOrWithdraw.setBounds(347, 5, 127, 25);
		btnDepositOrWithdraw.setText("Deposit or Withdraw");
		
		Button btnDeleteByDate = new Button(shlInventoryHistory, SWT.NONE);
		btnDeleteByDate.setBounds(347, 38, 127, 25);
		btnDeleteByDate.setText("Delete by Date Range");
		
		Button btnModify = new Button(shlInventoryHistory, SWT.NONE);
		//Is only enabled when a row in the table is selected.
		btnModify.setEnabled(false);
		btnModify.setBounds(266, 38, 75, 25);
		btnModify.setText("Modify");

	}
}
