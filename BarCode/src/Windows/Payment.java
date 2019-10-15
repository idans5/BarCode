package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.PaymentController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;

public class Payment {

	private JFrame frame;
	private JTextField txtAmountToCharge;
	private JLabel lblNumOfPayment;
	private JLabel lblCreditCradPic;
	private JTextField txtNumOfPayments;
	private static String cashOrCredit = null;
	private JButton btnCharge;
	private PaymentController paymentController;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window = new Payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setTxtAmountToCharge(String number) {
		this.txtAmountToCharge.setText(number);
	}

	public void setTxtNumOfPayments(String number) {
		this.txtNumOfPayments.setText(number);
	}

	public JTextField getTxtAmountToCharge() {
		return txtAmountToCharge;
	}
	public JFrame getFrame() {
		return frame;
	}
	public JTextField getTxtNumOfPayments() {
		return txtNumOfPayments;
	}

	public String getCashOrCredit() {
		return cashOrCredit;
	}
	
	public Payment() {
		initialize();
		if(cashOrCredit=="cash")
			setCreditCardThingFalse();
		paymentController = new PaymentController(this);
		
	}
	
	public static void setTable(String buttonInfo)
	{
		cashOrCredit = buttonInfo;
	}
	
	private void setCreditCardThingFalse()
	{
		txtNumOfPayments.setVisible(false);
		lblNumOfPayment.setVisible(false);
		lblCreditCradPic.setVisible(false);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u05D1\u05D9\u05E6\u05D5\u05E2 \u05D7\u05D9\u05D5\u05D1");
		frame.setBounds(100, 100, 453, 217);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel lblPayment = new JLabel("\u05EA\u05E9\u05DC\u05D5\u05DD");
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setFont(new Font("David", Font.BOLD, 20));
		lblPayment.setBounds(0, 0, 437, 20);
		frame.getContentPane().add(lblPayment);
		
		JLabel lblAmountToCharge = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E1\u05DB\u05D5\u05DD \u05DC\u05D7\u05D9\u05D5\u05D1:");
		lblAmountToCharge.setForeground(new Color(204, 0, 0));
		lblAmountToCharge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmountToCharge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountToCharge.setBounds(265, 47, 137, 20);
		frame.getContentPane().add(lblAmountToCharge);
		
		txtAmountToCharge = new JTextField();
		txtAmountToCharge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtAmountToCharge.setBounds(154, 49, 101, 20);
		frame.getContentPane().add(txtAmountToCharge);
		txtAmountToCharge.setColumns(10);
		
		btnCharge = new JButton("\u05D1\u05E6\u05E2 \u05D7\u05D9\u05D5\u05D1");
		btnCharge.setBounds(174, 136, 99, 31);
		frame.getContentPane().add(btnCharge);
		
		lblNumOfPayment = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05EA\u05E9\u05DC\u05D5\u05DE\u05D9\u05DD:");
		lblNumOfPayment.setForeground(new Color(204, 0, 0));
		lblNumOfPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumOfPayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumOfPayment.setBounds(265, 84, 127, 20);
		frame.getContentPane().add(lblNumOfPayment);
		
		lblCreditCradPic = new JLabel("");
		lblCreditCradPic.setIcon(new ImageIcon(Payment.class.getResource("/Image/CreditCard.jpeg")));
		lblCreditCradPic.setBounds(10, 35, 120, 69);
		frame.getContentPane().add(lblCreditCradPic);
		
		JLabel lblCashPic = new JLabel("");
		lblCashPic.setIcon(new ImageIcon(Payment.class.getResource("/Image/cash.jpeg")));
		lblCashPic.setBounds(10, 35, 120, 69);
		frame.getContentPane().add(lblCashPic);
		
		txtNumOfPayments = new JTextField();
		txtNumOfPayments.setText("1");
		txtNumOfPayments.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				int num = Integer.parseInt(txtNumOfPayments.getText());
				if (num > 10 || num < 1)
				{
					JOptionPane.showMessageDialog(null,"äëğñ îñôø áéï 1 ì 10 áìáã");
					txtNumOfPayments.setText("1");
					txtAmountToCharge.setText("");
				}
			}
		});
		txtNumOfPayments.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtNumOfPayments.setColumns(10);
		txtNumOfPayments.setBounds(154, 86, 101, 20);
		frame.getContentPane().add(txtNumOfPayments);
		
	}
	
	
	public void addButtonListener(ActionListener listenerForButton)
	{
		btnCharge.addActionListener(listenerForButton);
	}

}
