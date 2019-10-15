package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.ProductController;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddRemoveProduct extends JPanel {
	private JTextField txtProductCode;
	private JTextField textProductName;
	private JTextField txtProductDescription;
	private JTextField txtCurrentPrice;
	private JTextField txtWarrantyFactor;
	private JTextField txtRemark;
	private JTextField txtQuntity;
	private JTextField txtProductCodeRemove;
	private JComboBox cmProductGroup;
	private JButton btnAddProduct;
	private ProductController productController;
	private JButton btnRemoveProduct;
	
		
	public void clearFields()
	{
		textProductName.setText(null);
		txtProductDescription.setText(null);
		cmProductGroup.setSelectedIndex(0);
		txtCurrentPrice.setText(null);
		txtWarrantyFactor.setText(null);
		txtRemark.setText(null);
		txtQuntity.setText(null);
	}
	
	public JComboBox getCmProductGroup() {
		return cmProductGroup;
	}
	
	public void setTxtProductCode(String txtProductCode) {
		this.txtProductCode.setText(txtProductCode);
	}

	public void setTxtProductCodeRemove(String txtProductCodeRemove) {
		this.txtProductCodeRemove.setText(txtProductCodeRemove);
	}

	public JTextField getTxtProductCode() {
		return txtProductCode;
	}

	public JTextField getTextProductName() {
		return textProductName;
	}

	public JTextField getTxtProductDescription() {
		return txtProductDescription;
	}

	public JTextField getTxtCurrentPrice() {
		return txtCurrentPrice;
	}

	public JTextField getTxtWarrantyFactor() {
		return txtWarrantyFactor;
	}

	public JTextField getTxtRemark() {
		return txtRemark;
	}

	public JTextField getTxtQuntity() {
		return txtQuntity;
	}

	public JTextField getTxtProductCodeRemove() {
		return txtProductCodeRemove;
	}
	
	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	public AddRemoveProduct() throws FileNotFoundException {
		
		setLayout(null);
		JLabel lblTitleAdd = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05DE\u05D5\u05E6\u05E8");
		lblTitleAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitleAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleAdd.setVerticalAlignment(SwingConstants.CENTER);
		lblTitleAdd.setBounds(387, 11, 128, 21);
		add(lblTitleAdd);
		
		btnAddProduct = new JButton("\u05D4\u05D5\u05E1\u05E3");
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddProduct.setBounds(330, 103, 133, 46);
		add(btnAddProduct);
		
		JLabel lblProductCode = new JLabel("\u05E7\u05D5\u05D3 \u05DE\u05D5\u05E6\u05E8:");
		lblProductCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductCode.setBounds(777, 80, 108, 24);
		add(lblProductCode);
		
		txtProductCode = new JTextField();
		txtProductCode.setEditable(false);
		txtProductCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtProductCode.setColumns(10);
		txtProductCode.setBounds(524, 84, 223, 19);
		add(txtProductCode);
		
		JLabel lblProductName = new JLabel("\u05E9\u05DD \u05DE\u05D5\u05E6\u05E8:");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(777, 115, 108, 24);
		add(lblProductName);
		
		textProductName = new JTextField();
		textProductName.setColumns(10);
		textProductName.setBounds(524, 119, 223, 19);
		add(textProductName);
		
		JLabel lblProductDescription = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8 \u05DE\u05D5\u05E6\u05E8:");
		lblProductDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductDescription.setBounds(777, 150, 108, 24);
		add(lblProductDescription);
		
		txtProductDescription = new JTextField();
		txtProductDescription.setColumns(10);
		txtProductDescription.setBounds(524, 154, 223, 19);
		add(txtProductDescription);
		
		JLabel lblProductGroup = new JLabel("\u05E9\u05D9\u05D9\u05DA \u05DC\u05E7\u05D1\u05D5\u05E6\u05D4:");
		lblProductGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductGroup.setBounds(777, 185, 108, 24);
		add(lblProductGroup);
		
		cmProductGroup = new JComboBox();
		cmProductGroup.setModel(new DefaultComboBoxModel(new String[] {"\u05D1\u05D9\u05E8\u05D5\u05EA \u05DE\u05D4\u05D7\u05D1\u05D9\u05EA", "\u05D1\u05E7\u05D8\u05E0\u05D4", "\u05E2\u05D9\u05E7\u05E8\u05D9\u05D5\u05EA", "\u05E9\u05EA\u05D9\u05D4 \u05E7\u05E8\u05D4", "\u05E9\u05EA\u05D9\u05D4 \u05D7\u05DE\u05D4", "\u05D1\u05D9\u05E8\u05D5\u05EA \u05DE\u05D1\u05E7\u05D1\u05D5\u05E7", "\u05D5\u05D5\u05D3\u05E7\u05D4", "\u05D8\u05E7\u05D9\u05DC\u05D4", "\u05D5\u05D5\u05D9\u05E1\u05E7\u05D9", "\u05D2'\u05D9\u05DF", "\u05D1\u05E8\u05E0\u05D3\u05D9/\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7", "\u05E8\u05D5\u05DD"}));
		cmProductGroup.setBounds(524, 189, 223, 20);
		add(cmProductGroup);
		
		JLabel lblCurrentPrice = new JLabel("\u05DE\u05D7\u05D9\u05E8:");
		lblCurrentPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentPrice.setBounds(777, 220, 108, 24);
		add(lblCurrentPrice);
		
		txtCurrentPrice = new JTextField();
		txtCurrentPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtCurrentPrice.setColumns(10);
		txtCurrentPrice.setBounds(524, 224, 223, 19);
		add(txtCurrentPrice);
		
		JLabel lblWarrantyFactor = new JLabel("\u05D9\u05D1\u05D5\u05D0\u05DF:");
		lblWarrantyFactor.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarrantyFactor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWarrantyFactor.setBounds(777, 255, 108, 24);
		add(lblWarrantyFactor);
		
		txtWarrantyFactor = new JTextField();
		txtWarrantyFactor.setColumns(10);
		txtWarrantyFactor.setBounds(524, 259, 223, 19);
		add(txtWarrantyFactor);
		
		JLabel lblRemark = new JLabel("\u05D4\u05E2\u05E8\u05D5\u05EA \u05DE\u05DB\u05D9\u05E8\u05D4:");
		lblRemark.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemark.setBounds(777, 290, 108, 24);
		add(lblRemark);
		
		txtRemark = new JTextField();
		txtRemark.setColumns(10);
		txtRemark.setBounds(524, 294, 223, 19);
		add(txtRemark);
		
		JLabel lblQuntity = new JLabel("\u05DB\u05DE\u05D5\u05EA:");
		lblQuntity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuntity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuntity.setBounds(777, 325, 108, 24);
		add(lblQuntity);
		
		txtQuntity = new JTextField();
		txtQuntity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtQuntity.setColumns(10);
		txtQuntity.setBounds(524, 324, 223, 19);
		add(txtQuntity);
		
		btnRemoveProduct = new JButton("\u05D4\u05E1\u05E8\u05D4");
		btnRemoveProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveProduct.setBounds(177, 427, 133, 46);
		add(btnRemoveProduct);
		
		JLabel lblProductCodeRemove = new JLabel("\u05E7\u05D5\u05D3 \u05DE\u05D5\u05E6\u05E8:");
		lblProductCodeRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCodeRemove.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductCodeRemove.setBounds(777, 439, 108, 24);
		add(lblProductCodeRemove);
		
		txtProductCodeRemove = new JTextField();
		txtProductCodeRemove.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtProductCodeRemove.setColumns(10);
		txtProductCodeRemove.setBounds(524, 443, 223, 19);
		add(txtProductCodeRemove);
		
		JLabel lblTitleReomve = new JLabel("\u05D4\u05E1\u05E8 \u05DE\u05D5\u05E6\u05E8");
		lblTitleReomve.setVerticalAlignment(SwingConstants.CENTER);
		lblTitleReomve.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleReomve.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitleReomve.setBounds(401, 383, 128, 21);
		add(lblTitleReomve);
		
		JButton btnClear = new JButton("\u05E0\u05E7\u05D4 \u05E9\u05D3\u05D5\u05EA");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(330, 208, 133, 46);
		add(btnClear);
		
		JLabel lblSparate = new JLabel("=====================================================================================================================");
		lblSparate.setBounds(0, 360, 932, 14);
		add(lblSparate);
		
		productController = new ProductController(this);
	}
	
	public void addProductButtonListener(ActionListener listenerForButton)
	{
		btnAddProduct.addActionListener(listenerForButton);
	}
	
	public void RemoveProductButtonListener(ActionListener listenerForButton)
	{
		btnRemoveProduct.addActionListener(listenerForButton);
	}
}
