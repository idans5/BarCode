package Windows;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import Controller.CostumersClubController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class CostumersClub {

	private JFrame frame;
	private JTable tableClubClient;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhoneNumber;
	private JTextField txtDateAdded;
	private JTextField txtIdClient;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField txtDelete;
	private CostumersClubController costumersClubController;
	private JButton btnAdd;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostumersClub window = new CostumersClub();
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
	public CostumersClub() {
		initialize();
		costumersClubController = new CostumersClubController(this);
		txtDateAdded.setText(costumersClubController.getCurrentDate());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public JTable getTableClubClient() {
		return tableClubClient;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTextField getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public JTextField getTxtDateAdded() {
		return txtDateAdded;
	}

	public JTextField getTxtIdClient() {
		return txtIdClient;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTxtDelete() {
		return txtDelete;
	}
	
	public void clearFields() {
		txtFirstName.setText(null);
		txtIdClient.setText(null);
		txtLastName.setText(null);
		txtPhoneNumber.setText(null);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u05DE\u05D5\u05E2\u05D3\u05D5\u05DF \u05D4\u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		frame.setBounds(100, 100, 503, 545);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 459, 217);
		frame.getContentPane().add(scrollPane);
		
		tableClubClient = new JTable();
		tableClubClient.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05E6\u05D8\u05E8\u05E4\u05D5\u05EA", "\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF", "\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4", "\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9", "\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			} 
		});
		tableClubClient.getColumnModel().getColumn(0).setResizable(false);
		tableClubClient.getColumnModel().getColumn(0).setPreferredWidth(106);
		tableClubClient.getColumnModel().getColumn(1).setResizable(false);
		tableClubClient.getColumnModel().getColumn(1).setPreferredWidth(93);
		tableClubClient.getColumnModel().getColumn(2).setResizable(false);
		tableClubClient.getColumnModel().getColumn(2).setPreferredWidth(91);
		tableClubClient.getColumnModel().getColumn(3).setResizable(false);
		tableClubClient.getColumnModel().getColumn(3).setPreferredWidth(79);
		tableClubClient.getColumnModel().getColumn(4).setResizable(false);
		tableClubClient.getColumnModel().getColumn(4).setPreferredWidth(93);
		scrollPane.setViewportView(tableClubClient);
		
		JLabel lblFirstName = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D8\u05D9:");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(349, 310, 75, 22);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("\u05E9\u05DD \u05DE\u05E9\u05E4\u05D7\u05D4:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(349, 343, 75, 22);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblId = new JLabel("\u05EA\u05E2\u05D5\u05D3\u05EA \u05D6\u05D4\u05D5\u05EA:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblId.setBounds(349, 277, 86, 22);
		frame.getContentPane().add(lblId);
		
		JLabel lblPhoneNumber = new JLabel("\u05DE\u05E1\u05E4\u05E8 \u05E4\u05DC\u05D0\u05E4\u05D5\u05DF:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(349, 376, 89, 22);
		frame.getContentPane().add(lblPhoneNumber);
		
		JLabel lblDateAdded = new JLabel("\u05EA\u05D0\u05E8\u05D9\u05DA \u05D4\u05E6\u05D8\u05E8\u05E4\u05D5\u05EA:");
		lblDateAdded.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateAdded.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateAdded.setBounds(349, 409, 106, 22);
		frame.getContentPane().add(lblDateAdded);
		
		txtIdClient = new JTextField();
		txtIdClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtIdClient.setBounds(253, 281, 86, 20);
		frame.getContentPane().add(txtIdClient);
		txtIdClient.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(253, 312, 86, 20);
		frame.getContentPane().add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(253, 345, 86, 20);
		frame.getContentPane().add(txtLastName);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(253, 378, 86, 20);
		frame.getContentPane().add(txtPhoneNumber);
		
		txtDateAdded = new JTextField();
		txtDateAdded.setBackground(Color.WHITE);
		txtDateAdded.setEditable(false);
		txtDateAdded.setColumns(10);
		txtDateAdded.setBounds(253, 411, 86, 20);
		frame.getContentPane().add(txtDateAdded);
		
		
		btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(CostumersClub.class.getResource("/Image/Buttons/thumb_up-512.png")));
		btnAdd.setBounds(118, 300, 64, 65);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnBack.setIcon(new ImageIcon(CostumersClub.class.getResource("/Image/Buttons/Back.png")));
		btnBack.setBounds(10, 447, 50, 50);
		frame.getContentPane().add(btnBack);
		
		textField = new JTextField();
		textField.setText("\u05D4\u05D5\u05E1\u05E4\u05D4");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(118, 363, 64, 22);
		frame.getContentPane().add(textField);
		
		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(CostumersClub.class.getResource("/Image/Buttons/deletButton.jpg")));
		btnDelete.setBounds(29, 300, 64, 65);
		frame.getContentPane().add(btnDelete);
		
		txtDelete = new JTextField();
		txtDelete.setText("\u05DE\u05D7\u05D9\u05E7\u05D4");
		txtDelete.setHorizontalAlignment(SwingConstants.CENTER);
		txtDelete.setEditable(false);
		txtDelete.setColumns(10);
		txtDelete.setBackground(Color.WHITE);
		txtDelete.setBounds(29, 364, 64, 22);
		frame.getContentPane().add(txtDelete);
		
	}
	
	public void addButtonListener(ActionListener listenerForButton)
	{
		btnAdd.addActionListener(listenerForButton);
	}
	
	public void addButtonRemoveListener(ActionListener listenerForButton)
	{
		btnDelete.addActionListener(listenerForButton);
	}
}
