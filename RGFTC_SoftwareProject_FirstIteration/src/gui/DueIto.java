package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;



import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class DueIto extends Dialog {

	protected Object result;
	protected Shell shlDueDate;
	protected Shell parentShell;
	int day,month,year;
	

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DueIto(Shell parent, int style) {
		super(parent, style);
		parentShell = parent;
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDueDate.open();
		shlDueDate.layout();
		Display display = getParent().getDisplay();
		while (!shlDueDate.isDisposed()) {
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
		shlDueDate = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlDueDate.setSize(132, 120);
		shlDueDate.setText("Due Date");
		shlDueDate.setLayout(null);
		Point parentPoint = parentShell.getLocation();
		Point parentSize = parentShell.getSize();
		Point shellSize = shlDueDate.getSize();
		int x = parentPoint.x + parentSize.x/2 - shellSize.x/2;
		int y = parentPoint.y + parentSize.y/2 - shellSize.y/2;
		shlDueDate.setLocation(x, y);
		Label lblEnterDueDate = new Label(shlDueDate, SWT.NONE);
		lblEnterDueDate.setBounds(10, 10, 81, 15);
		lblEnterDueDate.setText("Enter Due Date:");
		
		DateTime dateTime = new DateTime(shlDueDate, SWT.BORDER);
		dateTime.setBounds(20, 31, 80, 24);
		
		Button btnSubmit = new Button(shlDueDate, SWT.NONE);
		
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				day = dateTime.getDay();
				month = dateTime.getMonth();
				year = dateTime.getYear();
				//System.out.println(month);
				btnSubmit.getShell().close();
			}
		});
		btnSubmit.setBounds(30, 61, 55, 25);
		btnSubmit.setText("Submit");

	}

}
