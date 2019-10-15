package Windows;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;


import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login {

	private JFrame frame;
	private JTextField userNameField;
	private JPasswordField passwordField;
	private JTextField textClear;
	private JTextField textBack;
	private JTextField textLogin;

	/**
	 * Launch the application.
	 */
	public static void Main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	//Asks the user to enter a user name and password and checks if the data is correct if he does not display an appropriate message
	private void LoginUser()
	{
		String username = userNameField.getText(); 
		@SuppressWarnings("deprecation")
		String password = passwordField.getText();
		
		if (username.equals("admin") && password.equals("admin"))
			{
				frame.dispose();
				ManagerMenu.main(null);
			}
		else 
			JOptionPane.showMessageDialog(null, "Bad");
	}
	
	private void ClearFiled()
	{
		userNameField.setText(null);
		passwordField.setText(null);
	}
	
	private void BackToEmployeeMenu()
	{
		EmployeMenu.main(null);
		frame.dispose();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 548, 284);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/Image/Buttons/loginButton.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginUser();
			}
		});
		btnLogin.setBounds(241, 162, 75, 54);
		frame.getContentPane().add(btnLogin);
		
		userNameField = new JTextField();
		userNameField.setBounds(204, 88, 147, 26);
		frame.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(204, 125, 147, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnClear = new JButton("");
		btnClear.setIcon(new ImageIcon(Login.class.getResource("/Image/Buttons/CleanMyMac-1-icon.png")));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClearFiled();
			}
		});
		btnClear.setBounds(92, 88, 55, 54);
		frame.getContentPane().add(btnClear);
		
		JLabel lblUsername = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05EA\u05DE\u05E9:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(361, 87, 106, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("\u05E1\u05D9\u05E1\u05DE\u05D4:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(361, 123, 93, 25);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLoginToProgram = new JLabel("\u05DE\u05E1\u05DA \u05DB\u05E0\u05D9\u05E1\u05D4 \u05DC\u05DE\u05E0\u05D4\u05DC");
		lblLoginToProgram.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginToProgram.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginToProgram.setBounds(135, 23, 267, 26);
		frame.getContentPane().add(lblLoginToProgram);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(Login.class.getResource("/Image/Buttons/Back.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackToEmployeeMenu();
			}
		});
		btnBack.setBounds(10, 10, 46, 45);
		frame.getContentPane().add(btnBack);
		
		textClear = new JTextField();
		textClear.setText("\u05E0\u05E7\u05D4");
		textClear.setHorizontalAlignment(SwingConstants.CENTER);
		textClear.setEditable(false);
		textClear.setColumns(10);
		textClear.setBackground(Color.WHITE);
		textClear.setBounds(92, 142, 55, 22);
		frame.getContentPane().add(textClear);
		
		textBack = new JTextField();
		textBack.setText("\u05D7\u05D6\u05D5\u05E8");
		textBack.setHorizontalAlignment(SwingConstants.CENTER);
		textBack.setEditable(false);
		textBack.setColumns(10);
		textBack.setBackground(Color.WHITE);
		textBack.setBounds(10, 54, 46, 22);
		frame.getContentPane().add(textBack);
		
		textLogin = new JTextField();
		textLogin.setText("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		textLogin.setHorizontalAlignment(SwingConstants.CENTER);
		textLogin.setEditable(false);
		textLogin.setColumns(10);
		textLogin.setBackground(Color.WHITE);
		textLogin.setBounds(241, 212, 75, 22);
		frame.getContentPane().add(textLogin);
	}
}
