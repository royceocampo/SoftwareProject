package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class OrderDetails extends Dialog {

	protected Object result;
	protected Shell shlOrderDetails;
	private Table table;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public OrderDetails(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlOrderDetails.open();
		shlOrderDetails.layout();
		Display display = getParent().getDisplay();
		while (!shlOrderDetails.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlOrderDetails = new Shell(getParent(), getStyle());
		shlOrderDetails.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlOrderDetails.setSize(345, 241);
		shlOrderDetails.setText("Order Details");
		
		Label lblName = new Label(shlOrderDetails, SWT.NONE);
		lblName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblName.setBounds(10, 10, 72, 15);
		lblName.setText("Client Name: ");
		
		Label lblClientName = new Label(shlOrderDetails, SWT.NONE);
		//get the client name of the selected row.
		lblClientName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblClientName.setBounds(88, 10, 55, 15);
		lblClientName.setText("KFC");
		
		table = new Table(shlOrderDetails, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 37, 319, 165);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnProductName = new TableColumn(table, SWT.NONE);
		tblclmnProductName.setWidth(110);
		tblclmnProductName.setText("Product Name");
		
		TableColumn tblclmnAmount = new TableColumn(table, SWT.NONE);
		tblclmnAmount.setWidth(100);
		tblclmnAmount.setText("Amount");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.NONE);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");

	}

}
