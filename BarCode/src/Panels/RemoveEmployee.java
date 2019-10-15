package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import Controller.EmplotyeeController;

public class RemoveEmployee extends JPanel {
	private JTextField textFieldId;
	private JButton btnDeleteEmployee;
	private EmplotyeeController emplotyeeController;

	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	
	
	public void clearFields()
	{
		textFieldId.setText(null);
	}
	
	public JTextField getTextFieldId() {
		return textFieldId;
	}
	
	public RemoveEmployee() {
		setLayout(null);
		
		JLabel label = new JLabel("\u05DE\u05D7\u05D9\u05E7\u05EA \u05E2\u05D5\u05D1\u05D3");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(407, 10, 173, 35);
		add(label);
		
		JLabel label_1 = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(694, 128, 115, 35);
		add(label_1);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(407, 135, 279, 25);
		add(textFieldId);
		textFieldId.setColumns(10);
		
		btnDeleteEmployee = new JButton("\u05DE\u05D7\u05E7");
		btnDeleteEmployee.setBounds(218, 137, 85, 21);
		add(btnDeleteEmployee);
		emplotyeeController = new EmplotyeeController(this);
	}
	
	public void removeEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnDeleteEmployee.addActionListener(listenerForButton);
	}
}
