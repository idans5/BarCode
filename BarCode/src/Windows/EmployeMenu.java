package Windows;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingConstants;

import Classes.Employe;
import Moduel.EmployeeModuel;
import Moduel.PanelModuel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.Color;

public class EmployeMenu {

	private static JFrame frame;
	private static JLabel lblTime;
	private JButton btnEmploye_1,btnEmploye_2,btnEmploye_3,btnEmploye_4,btnEmploye_5,btnEmploye_6,btnEmploye_7,btnEmploye_8,btnEmploye_9,btnEmploye_10;
	private static JButton[] arrayOfButtons = new JButton[10];
	private static Employe employe;
	private JPanel menuPanel; 
	private JButton btnCurrentLocation;
	private static JLabel lblCurrentEmploye;
	private JTextField textPresent;
	private Vector<String> panelNames = new Vector<>();
	private PanelModuel panelModuel = new PanelModuel();
	private static EmployeeModuel employeeModuel = new EmployeeModuel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeMenu window = new EmployeMenu();
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
	public EmployeMenu() throws FileNotFoundException {
		initialize();
		CurrentTime currentTime = new CurrentTime();
		Thread threadCurrentTime =new Thread(currentTime);
		threadCurrentTime.start();	
		setButtonDisables();
		getEmployee();
		setPanels();
	}
	
	public static String getCurrentTimefromlbl()
	{
		return lblTime.getText();
	}
	
	public static Employe getCurrentEmployee()
	{
		employe = employeeModuel.getEmploye(lblCurrentEmploye.getText(),null,null,null,null,null);
		return employe;
	}
	
	public static boolean selectEmployee()
	{
		if(lblCurrentEmploye.getText().isEmpty())
			return false;
		return true;
	}
	
	private void setPanels() throws FileNotFoundException
	{
		panelNames.add("tablePanel");
		panelNames.add("barPanel");
		panelModuel.getPanelNames(panelNames);
		panelModuel.getPanels(menuPanel);
	}

	public static void setButtonDisables()
	{
		for (int i=0;i<arrayOfButtons.length;i++)
		{
			arrayOfButtons[i].setVisible(false);
		}
	}
	
	//Search if the employee is on the employee list if he is then the system displays it in the main menu as an employee logged on
	public static void getEmployee()
	{
		employeeModuel.setLoginEmployee(arrayOfButtons);
	}
	
	public static void CloseFrame()
	{
		frame.dispose();
	}
	
	private void openCostumersclubWindow() {
		CostumersClub.main(null);
	}
	
	private void openConnectedEmployee() {
		loginEmployee.main(null);
	}
	
	private void openDisconnectedEmployee()
	{
		disconnectEmployee.main(null);
	}
	
	private void openMangerWindow()
	{
		Login.Main(null);
		frame.dispose();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 979, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); 
		frame.setLocationRelativeTo(null); 
		
		menuPanel = new JPanel();
		menuPanel.setBounds(305, 11, 658, 635);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(new CardLayout(0, 0));
		
		lblTime = new JLabel("");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(81, 11, 117, 25);
		frame.getContentPane().add(lblTime);	
		
		lblCurrentEmploye = new JLabel("");
		lblCurrentEmploye.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentEmploye.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCurrentEmploye.setBounds(141, 39, 117, 25);
		frame.getContentPane().add(lblCurrentEmploye);
		
		btnEmploye_1 = new JButton("");
		btnEmploye_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_1.getText());
			}
		});
		btnEmploye_1.setBounds(21, 76, 100, 34);
		frame.getContentPane().add(btnEmploye_1);
		arrayOfButtons[0]=btnEmploye_1;
		
		btnEmploye_2 = new JButton("");
		btnEmploye_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_2.getText());
			}
		});
		btnEmploye_2.setBounds(158, 76, 100, 34);
		frame.getContentPane().add(btnEmploye_2);
		arrayOfButtons[1]=btnEmploye_2;
		
		btnEmploye_3 = new JButton("");
		btnEmploye_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_3.getText());
			}
		});
		btnEmploye_3.setBounds(21, 120, 100, 34);
		frame.getContentPane().add(btnEmploye_3);
		arrayOfButtons[2]=btnEmploye_3;
		
		btnEmploye_4 = new JButton("");
		btnEmploye_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_4.getText());
			}
		});
		btnEmploye_4.setBounds(158, 120, 100, 34);
		frame.getContentPane().add(btnEmploye_4);
		arrayOfButtons[3]=btnEmploye_4;
		
		btnEmploye_5 = new JButton("");
		btnEmploye_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_5.getText());
			}
		});
		btnEmploye_5.setBounds(21, 164, 100, 34);
		frame.getContentPane().add(btnEmploye_5);
		arrayOfButtons[4]=btnEmploye_5;
		
		btnEmploye_6 = new JButton("");
		btnEmploye_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_6.getText());
			}
		});
		btnEmploye_6.setBounds(158, 164, 100, 34);
		frame.getContentPane().add(btnEmploye_6);
		arrayOfButtons[5]=btnEmploye_6;
		
		btnEmploye_7 = new JButton("");
		btnEmploye_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_7.getText());
			}
		});
		btnEmploye_7.setBounds(21, 208, 100, 34);
		frame.getContentPane().add(btnEmploye_7);
		arrayOfButtons[6]=btnEmploye_7;
		
		btnEmploye_8 = new JButton("");
		btnEmploye_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_8.getText());
			}
		});
		btnEmploye_8.setBounds(158, 208, 100, 34);
		frame.getContentPane().add(btnEmploye_8);
		arrayOfButtons[7]=btnEmploye_8;
		
		btnEmploye_9 = new JButton("");
		btnEmploye_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_9.getText());
			}
		});
		btnEmploye_9.setBounds(21, 252, 100, 34);
		frame.getContentPane().add(btnEmploye_9);
		arrayOfButtons[8]=btnEmploye_9;
		
		btnEmploye_10 = new JButton("");
		btnEmploye_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCurrentEmploye.setText(btnEmploye_10.getText());
			}
		});
		btnEmploye_10.setBounds(158, 252, 100, 34);
		frame.getContentPane().add(btnEmploye_10);
		arrayOfButtons[9]=btnEmploye_10;
		
		JButton btnManagerLogin = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA \u05DC\u05DE\u05E0\u05D4\u05DC");
		btnManagerLogin.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnManagerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMangerWindow();
			}
		});
		btnManagerLogin.setBounds(10, 584, 111, 62);
		frame.getContentPane().add(btnManagerLogin);
		
		JButton btnOpenDrawer = new JButton("\u05E4\u05EA\u05D7 \u05DE\u05D2\u05D9\u05E8\u05D4");
		btnOpenDrawer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "המגירה נפתחת....");
			}
		});
		btnOpenDrawer.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnOpenDrawer.setBounds(167, 584, 111, 62);
		frame.getContentPane().add(btnOpenDrawer);
		
		JButton btnBar = new JButton("\u05D1\u05E8");
		btnBar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCurrentLocation.setText("בר");
				panelModuel.setPanelsVisibleFalse();
				panelModuel.setPanelTrue("barPanel");
			}
		});
		btnBar.setBounds(10, 487, 111, 62);
		frame.getContentPane().add(btnBar);
		
		JButton btnTables = new JButton("\u05E9\u05D5\u05DC\u05D7\u05E0\u05D5\u05EA");
		btnTables.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCurrentLocation.setText("שולחנות");
				panelModuel.setPanelsVisibleFalse();
				panelModuel.setPanelTrue("tablePanel");
			}
		});
		btnTables.setBounds(167, 487, 111, 62);
		frame.getContentPane().add(btnTables);
		
		JButton btnCostumersClub = new JButton("\u05DE\u05D5\u05E2\u05D3\u05D5\u05DF \u05DC\u05E7\u05D5\u05D7\u05D5\u05EA");
		btnCostumersClub.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCostumersClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCostumersclubWindow();
			}

		});
		btnCostumersClub.setBounds(10, 395, 111, 62);
		frame.getContentPane().add(btnCostumersClub);
		
		btnCurrentLocation = new JButton("\u05E9\u05D5\u05DC\u05D7\u05E0\u05D5\u05EA");
		btnCurrentLocation.setEnabled(false);
		btnCurrentLocation.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCurrentLocation.setBounds(167, 412, 111, 45);
		frame.getContentPane().add(btnCurrentLocation);
		
		JButton btnConnectToTheSystem = new JButton("\u05D4\u05EA\u05D7\u05D1\u05E8\u05D5\u05EA");
		btnConnectToTheSystem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnConnectToTheSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openConnectedEmployee();
			}
		});
		btnConnectToTheSystem.setBounds(10, 310, 111, 62);
		frame.getContentPane().add(btnConnectToTheSystem);
		
		JButton btnDisconnectFromTheSystem = new JButton("\u05D4\u05EA\u05E0\u05EA\u05E7");
		btnDisconnectFromTheSystem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDisconnectFromTheSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDisconnectedEmployee();
			}
		});
		btnDisconnectFromTheSystem.setBounds(167, 310, 111, 62);
		frame.getContentPane().add(btnDisconnectFromTheSystem);
		
		textPresent = new JTextField();
		textPresent.setText("\u05DE\u05E6\u05D9\u05D2");
		textPresent.setHorizontalAlignment(SwingConstants.CENTER);
		textPresent.setEditable(false);
		textPresent.setColumns(10);
		textPresent.setBackground(Color.WHITE);
		textPresent.setBounds(167, 395, 111, 22);
		frame.getContentPane().add(textPresent);
	}
	public class CurrentTime implements Runnable {
		
		public void run()  {
			while(true)
			{
				getCurrentDate();
				 try {
			        	TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		private void getCurrentDate()
		{
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	         lblTime.setText(sdf.format(cal.getTime()));
		}
	}
	

}


