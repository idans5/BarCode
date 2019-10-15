package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import Controller.CostumersClubController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;



public class Discount {

	private JFrame frame;
	private JTextField textId;
	private JButton btnExecute;
	private CostumersClubController costumersClubController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Discount window = new Discount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JTextField getTextId() {
		return textId;
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Discount() {
		initialize();
		costumersClubController = new CostumersClubController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 448, 201);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);		
		
		JLabel lblNewLabel = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(261, 41, 133, 33);
		frame.getContentPane().add(lblNewLabel);
		
		textId = new JTextField();
		textId.setHorizontalAlignment(SwingConstants.RIGHT);
		textId.setBounds(104, 49, 152, 22);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		btnExecute = new JButton("\u05D1\u05E6\u05E2");

		btnExecute.setBounds(163, 87, 118, 33);
		frame.getContentPane().add(btnExecute);
		
		JLabel lblNewLabel_1 = new JLabel("\u05DC\u05D0 \u05DC\u05E9\u05DB\u05D5\u05D7 \u05D4\u05E0\u05D7\u05D4 \u05E2\u05D5\u05E9\u05D9\u05DD \u05E8\u05E7 \u05E9\u05E1\u05D5\u05D2\u05E8\u05D9\u05DD \u05E9\u05D5\u05DC\u05D7\u05DF");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(104, 13, 290, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}
	
	
	public void getDiscount(ActionListener listenerForButton)
	{
		btnExecute.addActionListener(listenerForButton);
	}
}
