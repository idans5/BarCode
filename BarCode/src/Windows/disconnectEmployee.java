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

public class disconnectEmployee {

	private JFrame frame;
	private JTextField txtFieldID;
	private EmplotyeeController emplotyeeController;
	private JButton btnDisconnect;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					disconnectEmployee window = new disconnectEmployee();
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
	public disconnectEmployee() {
		initialize();
		emplotyeeController = new EmplotyeeController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtFieldID() {
		return txtFieldID;
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel label = new JLabel("\u05D4\u05EA\u05E0\u05EA\u05E7 \u05DE\u05D4\u05DE\u05E2\u05E8\u05DB\u05EA");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(0, 11, 593, 44);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(371, 71, 168, 34);
		frame.getContentPane().add(label_1);
		
		txtFieldID = new JTextField();
		txtFieldID.setColumns(10);
		txtFieldID.setBounds(127, 78, 247, 24);
		frame.getContentPane().add(txtFieldID);
		
		btnDisconnect = new JButton("\u05DC\u05D7\u05E5 \u05DC\u05D4\u05EA\u05E0\u05EA\u05E7");
		btnDisconnect.setForeground(new Color(255, 255, 255));
		btnDisconnect.setBackground(new Color(204, 0, 0));
		btnDisconnect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDisconnect.setBounds(127, 143, 343, 24);
		frame.getContentPane().add(btnDisconnect);
	}
	
	public void disconnectButtonListener(ActionListener listenerForButton)
	{
		btnDisconnect.addActionListener(listenerForButton);
	}
}
