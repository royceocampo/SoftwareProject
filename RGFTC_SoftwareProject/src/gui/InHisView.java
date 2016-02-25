package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

public class InHisView extends Dialog {

	protected Object result;
	protected Shell shlViewInventoryHistory;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public InHisView(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlViewInventoryHistory.open();
		shlViewInventoryHistory.layout();
		Display display = getParent().getDisplay();
		while (!shlViewInventoryHistory.isDisposed()) {
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
		shlViewInventoryHistory = new Shell(getParent(), getStyle());
		shlViewInventoryHistory.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlViewInventoryHistory.setSize(275, 226);
		shlViewInventoryHistory.setText("View Inventory History");
		
		DateTime dateTimeView = new DateTime(shlViewInventoryHistory, SWT.BORDER);
		dateTimeView.setBounds(93, 26, 80, 24);
		
		Button btnViewByDate = new Button(shlViewInventoryHistory, SWT.NONE);
		btnViewByDate.setBounds(93, 66, 80, 25);
		btnViewByDate.setText("View by Date");
		
		Label lblOr = new Label(shlViewInventoryHistory, SWT.NONE);
		lblOr.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblOr.setAlignment(SWT.CENTER);
		lblOr.setBounds(103, 109, 55, 15);
		lblOr.setText("or");
		
		Button btnViewAll = new Button(shlViewInventoryHistory, SWT.NONE);
		btnViewAll.setBounds(93, 146, 80, 25);
		btnViewAll.setText("View All");

	}

}
