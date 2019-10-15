package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.EmplotyeeController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditEmployee extends JPanel {
	private JTextField txtFieldFirstName;
	private JTextField txtFieldLastName;
	private JTextField txtFieldId;
	private JTextField txtFieldSalary;
	private JTextField txtFieldPhone;
	private JButton btnEdit;
	private JComboBox comboBoxSex;
	private EmplotyeeController emplotyeeController;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	
	public JComboBox getComboBoxSex() {
		return comboBoxSex;
	}

	public void setTxtFieldFirstName(String txtFieldFirstName) {
		this.txtFieldFirstName.setText(txtFieldFirstName);
	}

	public void setTxtFieldLastName(String txtFieldLastName) {
		this.txtFieldLastName.setText(txtFieldLastName);
	}

	public void setTxtFieldId(String txtFieldId) {
		this.txtFieldId.setText(txtFieldId);
	}

	public void setTxtFieldSalary(String txtFieldSalary) {
		this.txtFieldSalary.setText(txtFieldSalary);
	}

	public void setTxtFieldPhone(String txtFieldPhone) {
		this.txtFieldPhone.setText(txtFieldPhone);
	}

	public void setComboBoxSex(int comboBoxSex) {
		this.comboBoxSex.setSelectedIndex(comboBoxSex);
	}

	public JTextField getTxtFieldFirstName() {
		return txtFieldFirstName;
	}

	public JTextField getTxtFieldLastName() {
		return txtFieldLastName;
	}

	public JTextField getTxtFieldSalary() {
		return txtFieldSalary;
	}

	public JTextField getTxtFieldPhone() {
		return txtFieldPhone;
	}

	public JTextField getTxtFieldId() {
		return txtFieldId;
	}

	public void setEditableFalse()
	{
		txtFieldFirstName.setEditable(false);
		txtFieldLastName.setEditable(false);
		txtFieldPhone.setEditable(false);
		txtFieldSalary.setEditable(false);
		comboBoxSex.setEnabled(false);
		btnEdit.setEnabled(false);
	}
	
	public void setEditableTrue()
	{
		txtFieldFirstName.setEditable(true);
		txtFieldLastName.setEditable(true);
		txtFieldPhone.setEditable(true);
		txtFieldSalary.setEditable(true);
		comboBoxSex.setEnabled(true);	
		btnEdit.setEnabled(true);
	}
	
	public void clearFields()
	{
		txtFieldId.setText(null);
		txtFieldFirstName.setText(null);
		txtFieldLastName.setText(null);
		txtFieldPhone.setText(null);
		txtFieldSalary.setText(null);
	}
	
	public EditEmployee() {
		setLayout(null);
		
		JLabel lblEditEmployee = new JLabel("\u05E2\u05E8\u05D9\u05DB\u05EA \u05E2\u05D5\u05D1\u05D3");
		lblEditEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEditEmployee.setBounds(369, 10, 138, 39);
		add(lblEditEmployee);
		
		JLabel label = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(700, 155, 108, 24);
		add(label);
		
		JLabel label_1 = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(700, 189, 108, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u05DE\u05D9\u05DF:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(700, 223, 108, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(700, 121, 108, 24);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u05E9\u05DB\u05E8:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(700, 257, 108, 24);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(700, 291, 108, 24);
		add(label_5);
		
		txtFieldFirstName = new JTextField();
		txtFieldFirstName.setEditable(false);
		txtFieldFirstName.setColumns(10);
		txtFieldFirstName.setBounds(388, 160, 223, 19);
		add(txtFieldFirstName);
		
		txtFieldLastName = new JTextField();
		txtFieldLastName.setEditable(false);
		txtFieldLastName.setColumns(10);
		txtFieldLastName.setBounds(388, 194, 223, 19);
		add(txtFieldLastName);
		
		txtFieldId = new JTextField();
		txtFieldId.setColumns(10);
		txtFieldId.setBounds(388, 126, 223, 19);
		add(txtFieldId);
		
		txtFieldSalary = new JTextField();
		txtFieldSalary.setEditable(false);
		txtFieldSalary.setColumns(10);
		txtFieldSalary.setBounds(388, 262, 223, 19);
		add(txtFieldSalary);
		
		txtFieldPhone = new JTextField();
		txtFieldPhone.setEditable(false);
		txtFieldPhone.setColumns(10);
		txtFieldPhone.setBounds(388, 296, 223, 19);
		add(txtFieldPhone);
		
		btnSearch = new JButton("\u05D7\u05E4\u05E9");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(93, 121, 133, 46);
		add(btnSearch);
		
		JButton btnClear = new JButton("\u05E0\u05E7\u05D4");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				setEditableFalse();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(93, 279, 133, 46);
		add(btnClear);
		
		btnEdit = new JButton("\u05E2\u05E8\u05D5\u05DA");
		btnEdit.setEnabled(false);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEdit.setBounds(93, 204, 133, 46);
		add(btnEdit);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setEnabled(false);
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"\u05D6\u05DB\u05E8", "\u05E0\u05E7\u05D1\u05D4"}));
		comboBoxSex.setBounds(388, 227, 223, 21);
		add(comboBoxSex);

		emplotyeeController = new EmplotyeeController(this);
	}
	
	public void EditEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnEdit.addActionListener(listenerForButton);
	}
	
	public void SearchEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnSearch.addActionListener(listenerForButton);
	}
}
