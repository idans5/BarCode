package Windows;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.EmplotyeeController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;

public class loginEmployee {

	private JFrame frame;
	private JTextField txtfieldID;
	private EmplotyeeController emplotyeeController;
	private JButton btnConnect;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginEmployee window = new loginEmployee();
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
	public loginEmployee() {
		initialize();
		emplotyeeController = new EmplotyeeController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtfieldID() {
		return txtfieldID;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 206);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel label = new JLabel("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA \u05DC\u05DE\u05E2\u05E8\u05DB\u05EA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(0, 10, 541, 44);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(325, 65, 168, 34);
		frame.getContentPane().add(label_1);
		
		txtfieldID = new JTextField();
		txtfieldID.setBounds(84, 72, 247, 24);
		frame.getContentPane().add(txtfieldID);
		txtfieldID.setColumns(10);
		
		btnConnect = new JButton("\u05DC\u05D7\u05E5 \u05DC\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		btnConnect.setForeground(new Color(255, 255, 255));
		btnConnect.setBackground(new Color(51, 153, 51));
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConnect.setBounds(100, 123, 343, 24);
		frame.getContentPane().add(btnConnect);
	}
	
	public void connectButtonListener(ActionListener listenerForButton)
	{
		btnConnect.addActionListener(listenerForButton);
	}
}
