package Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.EmplotyeeController;
import Controller.PanelController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ManagerMenu {

	private JFrame frame;
	private JPanel panelManagerMenu;
	private Vector<String> panelNames = new Vector<>();
	private PanelController panelController;
	private EmplotyeeController emplotyeeController;
	private JButton btnAddEmployee;
	private JButton btnRemoveEmployee;
	private JButton btnEditEmployee;
	private JButton btnExitAllEmployees;
	private JButton btnInventory;
	private JButton btnEditProduct;
	private JButton btnFinance;
	private JButton btnInventoryReports;
	private JButton btnBackToEmployeeMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMenu window = new ManagerMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public ManagerMenu() throws FileNotFoundException {
		initialize();
		getPanel();
		panelController = new PanelController(this);
		emplotyeeController = new EmplotyeeController(this);
	}
		
	public JPanel getPanelManagerMenu() {
		return panelManagerMenu;
	}

	public Vector<String> getPanelNames() {
		return panelNames;
	}

	private void getPanel() throws FileNotFoundException
	{
		panelNames.add("addEmployee");
		panelNames.add("removeEmployee");
		panelNames.add("addRemoveProduct");
		panelNames.add("editEmployee");
		panelNames.add("inventoryReports");
		panelNames.add("financialReport");
		panelNames.add("editProduct");
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1188, 671);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel lblManagerMenu = new JLabel("\u05EA\u05E4\u05E8\u05D9\u05D8 \u05DE\u05E0\u05D4\u05DC");
		lblManagerMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblManagerMenu.setBounds(483, 23, 194, 30);
		frame.getContentPane().add(lblManagerMenu);
		
		btnAddEmployee = new JButton("\u05D4\u05D5\u05E1\u05E3 \u05E2\u05D5\u05D1\u05D3");
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddEmployee.setBounds(42, 96, 131, 30);
		frame.getContentPane().add(btnAddEmployee);
		
		btnRemoveEmployee = new JButton("\u05DE\u05D7\u05E7 \u05E2\u05D5\u05D1\u05D3");
		btnRemoveEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemoveEmployee.setBounds(42, 152, 131, 30);
		frame.getContentPane().add(btnRemoveEmployee);
		
		btnEditEmployee = new JButton("\u05E2\u05E8\u05D9\u05DB\u05EA \u05E2\u05D5\u05D1\u05D3");
		btnEditEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditEmployee.setBounds(42, 208, 131, 30);
		frame.getContentPane().add(btnEditEmployee);
		
		btnExitAllEmployees = new JButton("\u05E0\u05EA\u05E7 \u05D0\u05EA \u05DB\u05DC \u05D4\u05E2\u05D5\u05D1\u05D3\u05D9\u05DD");
		btnExitAllEmployees.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnExitAllEmployees.setBounds(42, 264, 131, 30);
		frame.getContentPane().add(btnExitAllEmployees);
		
		btnInventory = new JButton("\u05D4\u05D5\u05E1\u05E3\\\u05D4\u05E1\u05E8 \u05DE\u05D5\u05E6\u05E8");
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInventory.setBounds(42, 319, 131, 30);
		frame.getContentPane().add(btnInventory);
		
		btnFinance = new JButton("\u05D3\u05D5\u05D7\u05D5\u05EA \u05DB\u05E1\u05E4\u05D9\u05D9\u05DD");
		btnFinance.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnFinance.setBounds(42, 431, 131, 30);
		frame.getContentPane().add(btnFinance);
		
		btnBackToEmployeeMenu = new JButton("\u05D7\u05D6\u05E8\u05D4 \u05DC\u05EA\u05E4\u05E8\u05D9\u05D8 \u05D4\u05E8\u05D0\u05E9\u05D9");
		btnBackToEmployeeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EmployeMenu.main(null);
			}
		});
		btnBackToEmployeeMenu.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnBackToEmployeeMenu.setBounds(42, 543, 131, 30);
		frame.getContentPane().add(btnBackToEmployeeMenu);
		
		panelManagerMenu = new JPanel();
		panelManagerMenu.setBounds(217, 75, 933, 549);
		frame.getContentPane().add(panelManagerMenu);
		
		btnInventoryReports = new JButton("\u05D3\u05D5\u05D7 \u05DE\u05DC\u05D0\u05D9");
		btnInventoryReports.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnInventoryReports.setBounds(42, 487, 131, 30);
		frame.getContentPane().add(btnInventoryReports);
		
		btnEditProduct = new JButton("\u05E2\u05E8\u05D5\u05DA \u05DE\u05D5\u05E6\u05E8");
		btnEditProduct.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditProduct.setBounds(42, 375, 131, 30);
		frame.getContentPane().add(btnEditProduct);
	}
	
	public void addEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnAddEmployee.addActionListener(listenerForButton);
	}
	
	public void RemoveEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnRemoveEmployee.addActionListener(listenerForButton);
	}
	
	public void EditEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnEditEmployee.addActionListener(listenerForButton);
	}
	
	public void ExitAllEmployeeButtonListener(ActionListener listenerForButton)
	{
		btnExitAllEmployees.addActionListener(listenerForButton);
	}
	
	public void AddRemoveProductButtonListener(ActionListener listenerForButton)
	{
		btnInventory.addActionListener(listenerForButton);
	}
	
	public void EditProductButtonListener(ActionListener listenerForButton)
	{
		btnEditProduct.addActionListener(listenerForButton);
	}
	
	public void FinanceButtonListener(ActionListener listenerForButton)
	{
		btnFinance.addActionListener(listenerForButton);
	}
	
	public void InventoryReportsButtonListener(ActionListener listenerForButton)
	{
		btnInventoryReports.addActionListener(listenerForButton);
	}
}
