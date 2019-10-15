package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import Controller.ProductController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditProduct extends JPanel {
	private JTextField txtProductCode;
	private JTextField txtProductName;
	private JTextField txtProductDiscription;
	private JTextField txtProductPrice;
	private JTextField txtWarrantyFactor;
	private JTextField txtRemark;
	private JTextField txtQuntity;
	private JButton btnEdit;
	private JComboBox cmProductGroup;
	private ProductController productController;
	private JButton btnSearch;
	private JButton btnClear;
	

	/**
	 * Create the panel.
	 */
	
	
	public JComboBox getCmProductGroup() {
		return cmProductGroup;
	}

	public JTextField getTxtProductName() {
		return txtProductName;
	}

	public JTextField getTxtProductDiscription() {
		return txtProductDiscription;
	}

	public JTextField getTxtProductPrice() {
		return txtProductPrice;
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

	public JTextField getTxtProductCode() {
		return txtProductCode;
	}
	
	public void setTxtProductCode(String txtProductCode) {
		this.txtProductCode.setText(txtProductCode) ;
	}

	public void setTxtProductName(String txtProductName) {
		this.txtProductName.setText(txtProductName);;
	}

	public void setTxtProductDiscription(String txtProductDiscription) {
		this.txtProductDiscription.setText(txtProductDiscription);
	}

	public void setTxtProductPrice(String txtProductPrice) {
		this.txtProductPrice.setText(txtProductPrice);
	}

	public void setTxtWarrantyFactor(String txtWarrantyFactor) {
		this.txtWarrantyFactor.setText(txtWarrantyFactor);
	}

	public void setTxtRemark(String txtRemark) {
		this.txtRemark.setText(txtRemark);
	}

	public void setTxtQuntity(String txtQuntity) {
		this.txtQuntity.setText(txtQuntity);
	}

	public void setCmProductGroup(String cmProductGroup) {
		this.cmProductGroup.setSelectedItem ( cmProductGroup);
	}
	
	public void setEditableFalse()
	{
		txtProductName.setEditable(false);
		txtProductDiscription.setEditable(false);
		cmProductGroup.setEnabled(false);
		txtProductPrice.setEditable(false);
		txtWarrantyFactor.setEditable(false);
		txtRemark.setEditable(false);
		txtQuntity.setEditable(false);
		btnEdit.setEnabled(false);
	}

	public void setEditableTrue()
	{
		txtProductCode.setEditable(true);
		txtProductName.setEditable(true);
		txtProductDiscription.setEditable(true);
		cmProductGroup.setEnabled(true);
		txtProductPrice.setEditable(true);
		txtWarrantyFactor.setEditable(true);
		txtRemark.setEditable(true);
		txtQuntity.setEditable(true);
		btnEdit.setEnabled(true);
	}
	
	public void clearFields()
	{
		txtProductCode.setText(null);
		txtProductName.setText(null);
		txtProductDiscription.setText(null);
		cmProductGroup.setSelectedIndex(0);;
		txtProductPrice.setText(null);
		txtWarrantyFactor.setText(null);
		txtRemark.setText(null);
		txtQuntity.setText(null);
	}
	
	public EditProduct() {
		setLayout(null);
		
		JLabel lblTitleEdit = new JLabel("\u05E2\u05E8\u05D9\u05DB\u05EA \u05DE\u05D5\u05E6\u05E8");
		lblTitleEdit.setBounds(406, 11, 108, 22);
		lblTitleEdit.setVerticalAlignment(SwingConstants.CENTER);
		lblTitleEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblTitleEdit);
		
		JLabel lblProductCode = new JLabel("\u05E7\u05D5\u05D3 \u05DE\u05D5\u05E6\u05E8:");
		lblProductCode.setBounds(783, 100, 71, 17);
		lblProductCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblProductCode);
		
		txtProductCode = new JTextField();
		txtProductCode.setColumns(10);
		txtProductCode.setBounds(504, 100, 223, 19);
		add(txtProductCode);
		
		JLabel lblProductName = new JLabel("\u05E9\u05DD \u05DE\u05D5\u05E6\u05E8:");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductName.setBounds(757, 131, 108, 24);
		add(lblProductName);
		
		txtProductName = new JTextField();
		txtProductName.setEditable(false);
		txtProductName.setColumns(10);
		txtProductName.setBounds(504, 135, 223, 19);
		add(txtProductName);
		
		txtProductDiscription = new JTextField();
		txtProductDiscription.setEditable(false);
		txtProductDiscription.setColumns(10);
		txtProductDiscription.setBounds(504, 170, 223, 19);
		add(txtProductDiscription);
		
		JLabel lblProductDiscription = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8 \u05DE\u05D5\u05E6\u05E8:");
		lblProductDiscription.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductDiscription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductDiscription.setBounds(757, 166, 108, 24);
		add(lblProductDiscription);
		
		JLabel lblProductGroup = new JLabel("\u05E9\u05D9\u05D9\u05DA \u05DC\u05E7\u05D1\u05D5\u05E6\u05D4:");
		lblProductGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductGroup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductGroup.setBounds(757, 201, 108, 24);
		add(lblProductGroup);
		
		cmProductGroup = new JComboBox();
		cmProductGroup.setEnabled(false);
		cmProductGroup.setModel(new DefaultComboBoxModel(new String[] {"\u05D1\u05D9\u05E8\u05D5\u05EA \u05DE\u05D4\u05D7\u05D1\u05D9\u05EA", "\u05D1\u05E7\u05D8\u05E0\u05D4", "\u05E2\u05D9\u05E7\u05E8\u05D9\u05D5\u05EA", "\u05E9\u05EA\u05D9\u05D4 \u05E7\u05E8\u05D4", "\u05E9\u05EA\u05D9\u05D4 \u05D7\u05DE\u05D4", "\u05D1\u05D9\u05E8\u05D5\u05EA \u05DE\u05D1\u05E7\u05D1\u05D5\u05E7", "\u05D5\u05D5\u05D3\u05E7\u05D4", "\u05D8\u05E7\u05D9\u05DC\u05D4", "\u05D5\u05D5\u05D9\u05E1\u05E7\u05D9", "\u05D2'\u05D9\u05DF", "\u05D1\u05E8\u05E0\u05D3\u05D9/\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7", "\u05E8\u05D5\u05DD"}));
		cmProductGroup.setBounds(504, 205, 223, 20);
		add(cmProductGroup);
		
		txtProductPrice = new JTextField();
		txtProductPrice.setEditable(false);
		txtProductPrice.setColumns(10);
		txtProductPrice.setBounds(504, 240, 223, 19);
		add(txtProductPrice);
		
		JLabel lblProductPrice = new JLabel("\u05DE\u05D7\u05D9\u05E8:");
		lblProductPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProductPrice.setBounds(757, 236, 108, 24);
		add(lblProductPrice);
		
		JLabel lblWarrantyFactor = new JLabel("\u05D9\u05D1\u05D5\u05D0\u05DF:");
		lblWarrantyFactor.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarrantyFactor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWarrantyFactor.setBounds(757, 271, 108, 24);
		add(lblWarrantyFactor);
		
		txtWarrantyFactor = new JTextField();
		txtWarrantyFactor.setEditable(false);
		txtWarrantyFactor.setColumns(10);
		txtWarrantyFactor.setBounds(504, 275, 223, 19);
		add(txtWarrantyFactor);
		
		txtRemark = new JTextField();
		txtRemark.setEditable(false);
		txtRemark.setColumns(10);
		txtRemark.setBounds(504, 310, 223, 19);
		add(txtRemark);
		
		JLabel lblRemark = new JLabel("\u05D4\u05E2\u05E8\u05D5\u05EA \u05DE\u05DB\u05D9\u05E8\u05D4:");
		lblRemark.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemark.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRemark.setBounds(757, 306, 108, 24);
		add(lblRemark);
		
		JLabel lblQuntity = new JLabel("\u05DB\u05DE\u05D5\u05EA:");
		lblQuntity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuntity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuntity.setBounds(757, 341, 108, 24);
		add(lblQuntity);
		
		txtQuntity = new JTextField();
		txtQuntity.setEditable(false);
		txtQuntity.setColumns(10);
		txtQuntity.setBounds(504, 345, 223, 19);
		add(txtQuntity);
		
		btnEdit = new JButton("\u05E2\u05E8\u05D5\u05DA");
		btnEdit.setEnabled(false);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(170, 189, 133, 46);
		add(btnEdit);
		
		btnClear = new JButton("\u05E0\u05E7\u05D4");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				setEditableFalse();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(170, 283, 133, 46);
		add(btnClear);
		
		btnSearch = new JButton("\u05D7\u05E4\u05E9");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(170, 99, 133, 46);
		add(btnSearch);
		
		productController = new ProductController(this);

	}
	
	public void SearchProductButtonListener(ActionListener listenerForButton)
	{
		btnSearch.addActionListener(listenerForButton);
	}
	
	public void EditProductButtonListener(ActionListener listenerForButton)
	{
		btnEdit.addActionListener(listenerForButton);
	}

}
