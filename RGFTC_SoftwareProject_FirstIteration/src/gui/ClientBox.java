package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ClientBox extends Dialog {

	protected Object result;
	protected Shell shlClientName;
	private Text text;
	String s;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ClientBox(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlClientName.open();
		shlClientName.layout();
		Display display = getParent().getDisplay();
		while (!shlClientName.isDisposed()) {
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
		shlClientName = new Shell(getParent(), SWT.DIALOG_TRIM);
		shlClientName.setSize(145, 121);
		shlClientName.setText("Client Name");
		
		Composite composite = new Composite(shlClientName, SWT.NONE);
		composite.setBounds(0, 0, 140, 93);
		composite.setLayout(null);
		
		Label lblEnterClientName = new Label(composite, SWT.NONE);
		lblEnterClientName.setBounds(10, 10, 101, 15);
		lblEnterClientName.setText("Enter Client Name:");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(35, 28, 76, 21);
		
		Button btnSubmit = new Button(composite, SWT.NONE);
		btnSubmit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				s = text.getText();
				
				btnSubmit.getShell().close();
			}
		});
		btnSubmit.setBounds(36, 59, 75, 25);
		btnSubmit.setText("Submit");

	}
}
