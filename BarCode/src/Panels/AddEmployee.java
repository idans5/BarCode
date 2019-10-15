package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.EmplotyeeController;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddEmployee extends JPanel {	
	private JTextField txtFieldFirstName;
	private JTextField txtFieldLastName;
	private JTextField txtFieldId;
	private JTextField txtFieldSalary;
	private JTextField txtFieldPhoneNumber;
	private JButton btnClear;
	private JComboBox comboBoxSex;
	private EmplotyeeController emplotyeeController;
	private JButton btnAddEmployee;

	/**
	 * Create the panel.
	 */
	
	public void clearFields()
	{
		txtFieldFirstName.setText(null);
		txtFieldId.setText(null);
		txtFieldLastName.setText(null);
		txtFieldPhoneNumber.setText(null);
		txtFieldSalary.setText(null);
	}
	
	public JComboBox getComboBoxSex() {
		return comboBoxSex;
	}
	
	public JTextField getTxtFieldFirstName() {
		return txtFieldFirstName;
	}

	public JTextField getTxtFieldLastName() {
		return txtFieldLastName;
	}

	public JTextField getTxtFieldId() {
		return txtFieldId;
	}

	public JTextField getTxtFieldSalary() {
		return txtFieldSalary;
	}

	public JTextField getTxtFieldPhoneNumber() {
		return txtFieldPhoneNumber;
	}

	public AddEmployee() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05D5\u05E1\u05E4\u05EA \u05E2\u05D5\u05D1\u05D3");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(464, 10, 108, 34);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(805, 85, 108, 24);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(805, 135, 108, 24);
		add(label);
		
		JLabel label_1 = new JLabel("\u05DE\u05D9\u05DF:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(805, 182, 108, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(805, 228, 108, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u05E9\u05DB\u05E8:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(805, 283, 108, 24);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(805, 347, 108, 24);
		add(label_4);
		
		txtFieldFirstName = new JTextField();
		txtFieldFirstName.setBounds(493, 90, 223, 19);
		add(txtFieldFirstName);
		txtFieldFirstName.setColumns(10);
		
		txtFieldLastName = new JTextField();
		txtFieldLastName.setColumns(10);
		txtFieldLastName.setBounds(493, 140, 223, 19);
		add(txtFieldLastName);
		
		txtFieldId = new JTextField();
		txtFieldId.setColumns(10);
		txtFieldId.setBounds(493, 233, 223, 19);
		add(txtFieldId);
		
		txtFieldSalary = new JTextField();
		txtFieldSalary.setColumns(10);
		txtFieldSalary.setBounds(493, 288, 223, 19);
		add(txtFieldSalary);
		
		txtFieldPhoneNumber = new JTextField();
		txtFieldPhoneNumber.setColumns(10);
		txtFieldPhoneNumber.setBounds(493, 352, 223, 19);
		add(txtFieldPhoneNumber);
		
		btnAddEmployee = new JButton("\u05D4\u05D5\u05E1\u05E3");
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddEmployee.setBounds(137, 89, 133, 46);
		add(btnAddEmployee);
		
		btnClear = new JButton("\u05E0\u05E7\u05D4");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(137, 186, 133, 46);
		add(btnClear);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] {"\u05D6\u05DB\u05E8", "\u05E0\u05E7\u05D1\u05D4"}));
		comboBoxSex.setBounds(493, 186, 223, 21);
		add(comboBoxSex);
		
		emplotyeeController = new EmplotyeeController(this);
	}
	
	public void addEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnAddEmployee.addActionListener(listenerForButton);
	}
}
