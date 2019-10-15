package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.TableController;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Panels.TablePanel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TableDiscription extends TablePanel {

	private JFrame frame;
	private JTextField txtNumOfClientInTable;
	private JTextField txtClientDiscription;
	private JTextField textFinish;
	private JTextField textCancel;
	private TableController tableController;
	private JButton btnFinish;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableDiscription window = new TableDiscription();
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
	public TableDiscription() {
		initialize();
		tableController = new TableController(this);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public JTextField getTxtNumOfClientInTable() {
		return txtNumOfClientInTable;
	}

	public JTextField getTxtClientDiscription() {
		return txtClientDiscription;
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u05EA\u05D9\u05D0\u05D5\u05E8 \u05E9\u05D5\u05DC\u05D7\u05DF");
		frame.setResizable(false);
		frame.setBounds(100, 100, 354, 220);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel lblnumOfClients = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E1\u05D5\u05E2\u05D3\u05D9\u05DD:");
		lblnumOfClients.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnumOfClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblnumOfClients.setBounds(223, 22, 105, 14);
		frame.getContentPane().add(lblnumOfClients);
		
		txtNumOfClientInTable = new JTextField();
		txtNumOfClientInTable.setBounds(163, 21, 58, 20);
		frame.getContentPane().add(txtNumOfClientInTable);
		txtNumOfClientInTable.setColumns(10);
		
		JLabel label = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8 \u05DC\u05E7\u05D5\u05D7:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(233, 63, 105, 19);
		frame.getContentPane().add(label);
		
		txtClientDiscription = new JTextField();
		txtClientDiscription.setBounds(30, 64, 207, 20);
		frame.getContentPane().add(txtClientDiscription);
		txtClientDiscription.setColumns(10);
		
		btnFinish = new JButton("");
		btnFinish.setBackground(new Color(255, 255, 255));
		btnFinish.setIcon(new ImageIcon(TableDiscription.class.getResource("/Image/Buttons/thumb_up-512.png")));
		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFinish.setBounds(193, 102, 70, 57);
		frame.getContentPane().add(btnFinish);
		
		JButton btnCancel = new JButton("");
		btnCancel.setBackground(new Color(255, 255, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setIcon(new ImageIcon(TableDiscription.class.getResource("/Image/Buttons/CanselButton.png")));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(66, 102, 70, 57);
		frame.getContentPane().add(btnCancel);
		
		textFinish = new JTextField();
		textFinish.setText("\u05D0\u05E9\u05E8");
		textFinish.setHorizontalAlignment(SwingConstants.CENTER);
		textFinish.setEditable(false);
		textFinish.setColumns(10);
		textFinish.setBackground(Color.WHITE);
		textFinish.setBounds(193, 158, 70, 22);
		frame.getContentPane().add(textFinish);
		
		textCancel = new JTextField();
		textCancel.setText("\u05D1\u05D8\u05DC");
		textCancel.setHorizontalAlignment(SwingConstants.CENTER);
		textCancel.setEditable(false);
		textCancel.setColumns(10);
		textCancel.setBackground(Color.WHITE);
		textCancel.setBounds(66, 159, 70, 22);
		frame.getContentPane().add(textCancel);
	}
	
	public void FinishButtonListener(ActionListener listenerForButton) {
		btnFinish.addActionListener(listenerForButton);
	}
}
