package gui;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

public class DepositOrWithdraw extends Dialog {

	protected Object result;
	protected Shell shlDepositOrWithdraw;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public DepositOrWithdraw(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlDepositOrWithdraw.open();
		shlDepositOrWithdraw.layout();
		Display display = getParent().getDisplay();
		while (!shlDepositOrWithdraw.isDisposed()) {
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
		shlDepositOrWithdraw = new Shell(getParent(), getStyle());
		shlDepositOrWithdraw.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shlDepositOrWithdraw.setSize(325, 264);
		shlDepositOrWithdraw.setText("Deposit or Withdraw");
		
		Label lblProductName = new Label(shlDepositOrWithdraw, SWT.NONE);
		lblProductName.setAlignment(SWT.RIGHT);
		lblProductName.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblProductName.setBounds(58, 18, 83, 15);
		lblProductName.setText("Product Name: ");
		
		Combo combo = new Combo(shlDepositOrWithdraw, SWT.NONE);
		combo.setBounds(169, 10, 112, 23);
		
		Label lblNumberOfBoxes = new Label(shlDepositOrWithdraw, SWT.NONE);
		lblNumberOfBoxes.setAlignment(SWT.RIGHT);
		lblNumberOfBoxes.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNumberOfBoxes.setBounds(44, 55, 97, 15);
		lblNumberOfBoxes.setText("Number of Boxes: ");
		
		Spinner spinner = new Spinner(shlDepositOrWithdraw, SWT.BORDER);
		spinner.setBounds(169, 52, 112, 22);
		
		Label lblWeight = new Label(shlDepositOrWithdraw, SWT.NONE);
		lblWeight.setAlignment(SWT.RIGHT);
		lblWeight.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblWeight.setBounds(58, 96, 83, 15);
		lblWeight.setText("Weight (KG): ");
		
		text = new Text(shlDepositOrWithdraw, SWT.BORDER);
		text.setBounds(169, 90, 112, 21);
		
		Label lblDepositOrWithdraw = new Label(shlDepositOrWithdraw, SWT.NONE);
		lblDepositOrWithdraw.setAlignment(SWT.RIGHT);
		lblDepositOrWithdraw.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDepositOrWithdraw.setBounds(22, 137, 119, 15);
		lblDepositOrWithdraw.setText("Deposit or Withdraw: ");
		
		Combo combo_1 = new Combo(shlDepositOrWithdraw, SWT.NONE);
		combo_1.setBounds(169, 129, 112, 23);
		
		Button btnSubmit = new Button(shlDepositOrWithdraw, SWT.NONE);
		btnSubmit.setBounds(124, 200, 75, 25);
		btnSubmit.setText("Submit");
		
		DateTime transDate = new DateTime(shlDepositOrWithdraw, SWT.BORDER);
		transDate.setBounds(169, 164, 80, 24);
		
		Label lblDate = new Label(shlDepositOrWithdraw, SWT.NONE);
		lblDate.setBackground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblDate.setAlignment(SWT.RIGHT);
		lblDate.setBounds(86, 173, 55, 15);
		lblDate.setText("Date:");

	}
}
