package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

import classes.Product;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddProduct {

	private JFrame frame;
	private JLabel lblProductName;
	private JLabel lblCategory;
	private JLabel lblSubtype;
	private JLabel lblBrand;
	private JLabel lblPackaging;
	private JLabel lblPrice;
	
	public static JTextField txtProdName;
	public static JComboBox cmbCategory;
	public static JComboBox cmbSubtype;
	public static JTextField txtBrand;
	public static JTextField txtPackaging;
	public static JSpinner spinPrice;
	
	
	
	public JTextField getTxtProdName() {
		return txtProdName;
	}

	public void setTxtProdName(JTextField txtProdName) {
		this.txtProdName = txtProdName;
	}

	public JComboBox getCmbCategory() {
		return cmbCategory;
	}

	public void setCmbCategory(JComboBox cmbCategory) {
		this.cmbCategory = cmbCategory;
	}

	public JComboBox getCmbSubtype() {
		return cmbSubtype;
	}

	public void setCmbSubtype(JComboBox cmbSubtype) {
		this.cmbSubtype = cmbSubtype;
	}

	public JTextField getTxtBrand() {
		return txtBrand;
	}

	public void setTxtBrand(JTextField txtBrand) {
		this.txtBrand = txtBrand;
	}

	public JTextField getTxtPackaging() {
		return txtPackaging;
	}

	public void setTxtPackaging(JTextField txtPackaging) {
		this.txtPackaging = txtPackaging;
	}

	public JSpinner getSpinPrice() {
		return spinPrice;
	}

	public void setSpinPrice(JSpinner spinPrice) {
		this.spinPrice = spinPrice;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct window = new AddProduct();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 337, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblProductName = new JLabel("Product Name:");
		lblProductName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblCategory = new JLabel("Category:");
		lblCategory.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblSubtype = new JLabel("Subtype:");
		lblSubtype.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblPackaging = new JLabel("Packaging:");
		lblPackaging.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product.addProduct();
			}
		});
		
		txtProdName = new JTextField();
		txtProdName.setColumns(10);
		
		cmbCategory = new JComboBox();
//		cmbCategory.addItem("Meat");
//		cmbCategory.addItem("Fish");
		cmbCategory.addItem("Meat");
		cmbCategory.addItem("Fish");
		
		cmbSubtype = new JComboBox();
//		cmbCategory.addItemListener(new ItemListener() {
//			public void itemStateChanged(ItemEvent evt) {
//				if (ItemEvent.DESELECTED == evt.getStateChange()){
//					String desValue = evt.getItem().toString();
//				}
//				else if (ItemEvent.SELECTED == evt.getItem().toString()){
//					cmbSubtype.removeAllItems();
//					
//				}
//			}
//		});
		cmbSubtype.addItem("Subtype ONE");
		cmbSubtype.addItem("Subtype TWO");
		cmbSubtype.addItem("Subtype TRI");
		
		txtBrand = new JTextField();
		txtBrand.setColumns(10);
		
		txtPackaging = new JTextField();
		txtPackaging.setColumns(10);
		
		spinPrice = new JSpinner();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSubtype, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbSubtype, 0, 112, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbCategory, 0, 112, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtProdName, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPackaging, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtBrand, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
								.addComponent(txtPackaging, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
								.addComponent(spinPrice, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))))
					.addContainerGap(70, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtProdName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategory, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbCategory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSubtype, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbSubtype, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBrand, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPackaging, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPackaging, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
