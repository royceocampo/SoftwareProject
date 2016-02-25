package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;

public class InHisDeletebyDate extends Dialog {

	protected Object result;
	protected Shell shlDeleteByDate;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public InHisDeletebyDate(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDeleteByDate.open();
		shlDeleteByDate.layout();
		Display display = getParent().getDisplay();
		while (!shlDeleteByDate.isDisposed()) {
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
		shlDeleteByDate = new Shell(getParent(), getStyle());
		shlDeleteByDate.setMinimumSize(new Point(100, 29));
		shlDeleteByDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlDeleteByDate.setSize(275, 225);
		shlDeleteByDate.setText("Delete by Date Range");
		
		Label lblStart = new Label(shlDeleteByDate, SWT.RIGHT);
		lblStart.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblStart.setBounds(46, 45, 55, 15);
		lblStart.setText("Start: ");
		
		DateTime dateTimeStart = new DateTime(shlDeleteByDate, SWT.BORDER);
		dateTimeStart.setBounds(107, 36, 97, 24);
		
		Label lblEnd = new Label(shlDeleteByDate, SWT.RIGHT);
		lblEnd.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblEnd.setBounds(46, 99, 55, 15);
		lblEnd.setText("End: ");
		
		DateTime dateTimeEnd = new DateTime(shlDeleteByDate, SWT.BORDER);
		dateTimeEnd.setBounds(107, 90, 97, 24);
		
		Button btnSubmit = new Button(shlDeleteByDate, SWT.NONE);
		btnSubmit.setBounds(93, 150, 75, 25);
		btnSubmit.setText("Submit");

	}
}
