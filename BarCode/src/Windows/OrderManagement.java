package Windows;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import java.awt.CardLayout;
import Classes.Employe;
import Classes.Table;
import Moduel.OrderManagmentModuel;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.UIManager;


public class OrderManagement {

	private static JFrame frame;
	private JButton btnDownOrder;
	private JPanel panelbeerbotle; 
	private JPanel panelBerrfrom;
	private JLayeredPane layeredPane;
	private JTextField text300mlGoldstarFromTheBarrel;
	private JTextField text500mlGoldstarFromTheBarrel;
	private JTextField textLiterGoldstarFromTheBarrel;
	private JTextField text300mlHeinekenFromTheBarrel;
	private JTextField tex500mlHeinekenFromTheBarrel;
	private JTextField textLiterHeinekenFromTheBarrel;
	private JTextField text300mlRedTuborgFromTheBarrel;
	private JTextField text500mlRedTuborgFromTheBarrel;
	private JTextField textLiterRedTuborgFromTheBarrel;
	private JTextField textFromABottleGoldstar;
	private JTextField textFromABottleHeineken;
	private JTextField texttextFromABottleTuborgRed;
	private JTextField textFromABottleStela;
	private JTextField textFromABottleWeihenstephan;
	private JTextField textFromABottleLeffeBrown;
	private JTextField textFromABottleBreezerWatermelon;
	private JTextField textFromABottleMaccabi;
	private JTextField textFromABottleShandywatermelon;
	private JPanel panelColdDrink;
	private JPanel panelHotDrink;
	private JPanel panelDessert;
	private JPanel panelVodka;
	private JPanel panelTequila;
	private JPanel panelWhiskey;
	private JPanel panelSnacks;
	private JPanel panelGin;
	private JTextField textTable;
	private JTextField textNumberOfClients;
	private JTextField textWaiter;
	private JTextField textComment;
	private JButton btnChooseTable;
	private static Table tableInformation = null ;
	private JTable orderTable;
	private DefaultTableModel dm;
	private JTextField textSearchInOrder;
	private static JLabel labelTotalPrise;
	private JPanel panelBrandy; 
	private JPanel panelRum;
	private JTextField txtfPickles;
	private JTextField txtfNachos;
	private JTextField txtfEdamame;
	private JTextField txtfClassicFries;
	private JTextField txtfSweetPotatoChips;
	private JTextField txtCrispySchnitzel;
	private JTextField txtfCongncCamus;
	private JTextField txtfBrandyArarat;
	private JTextField txtfTanqueray;
	private JTextField txtfGordos;
	private JTextField txtfGreyGoose;
	private JTextField txtfFinlandia;
	private JTextField txtArk;
	private JTextField txtVanGoghAsay;
	private JTextField txtToby;
	private JTextField txtVanGoghPineapple;
	private JTextField txtTea;
	private JTextField txtBlackCoffe;
	private JTextField txtRedlable;
	private JTextField txtBlackLable;
	private JTextField txtJohnnieWalker;
	private JTextField txtJb;
	private JTextField txtWater;
	private JTextField txtSpriteZero;
	private JTextField textSoda;
	private JTextField textSprite;
	private JTextField textLemoes;
	private JTextField textOranges;
	private JTextField textMango;
	private JTextField textCola;
	private JTextField textColaZero;
	private JTextField textCaptianMorgan;
	private JTextField textBacardi;
	private JTextField textHavanaClub;
	private JTextField textHamburger300g;
	private JTextField textHamburger120g;
	private JTextField textHamburger200g;
	private JTextField textChickenSteak;
	private JTextField textSteakSirloin;
	private JTextField textEntrecote;
	private JTextField textPizza;
	private JTextField textLambChops;
	private JTextField textMazkel;
	private JTextField textOlmkeGold;
	private JTextField textPatron;
	private JTextField textSilver;
	private JTextField textSearchProduct;
	private JTextField textRefrash;
	private JTextField textPrint;
	private JTextField textField;
	private JTextField textSave;
	private JTextField textField_1;
	private JTextField textUpProduct;
	private JTextField textDownProduct;
	private JTextField textExit;
	private JTextField textOpenMgira;
	private JTextField txtCloseOrder;
	private OrderManagmentModuel orderManagmentModuel = new OrderManagmentModuel();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					OrderManagement window = new OrderManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public OrderManagement() throws FileNotFoundException
	{
		initialize();
		setFields(tableInformation);
		importInfoProductListFromText();
		getOrderInfo();
	}
	//Searches for a specific product in the list of products you've already ordered at the table
	public void searchInOrder()
	{
		orderManagmentModuel.searchInOrder(orderTable, textSearchInOrder.getText().toLowerCase());
	}
	
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Create the application.
	 */
	public static void setTable(Table tableinfo)
	{
		tableInformation = tableinfo;
	}	
	
	//Changes the position (up or down) of a specific product in the list of products already ordered at the table
	private void moveItemInTable(String direction)
	{
		orderManagmentModuel.moveItemInTable(direction, orderTable);
	}
	
	public static JFrame getFrame() {
		return frame;
	}

	private void getOrderInfo() throws FileNotFoundException
	{
		orderManagmentModuel.getOrderInfo();
	}
	
	//Imports all the products of the table and puts them in the table of the order
	private void importInfoProductListFromText()
	{
		orderManagmentModuel.importInfoProductListFromText(orderTable, textTable.getText());

	}
	
	//Generates ten percent discount for club members
	private void discountForACustomerClub()
	{
		orderManagmentModuel.discountForACustomerClub();			
	}
	
    private void openDrawer()
    {
    	JOptionPane.showMessageDialog( null, "המגירה פתוחה", "פתיחת מגירה", JOptionPane.INFORMATION_MESSAGE);
    }
   
    //Puts a new product in the order table and updates the total price of the order
    private void addProductToTable(DefaultTableModel dm,String NameProduct) throws FileNotFoundException
    { 
    	orderManagmentModuel.addProductToTable(orderTable, NameProduct);
    }
   
    //Deletes an existing product in the order table and updates the total price of the order
    private void deleteFromTable() throws FileNotFoundException
    {
    	orderManagmentModuel.deleteFromTable(orderTable);
    }

    
    public static int getTotalPrise()
    {
    	if (labelTotalPrise.getText().length() <= 0)
    		return 0;
    	return Integer.parseInt(labelTotalPrise.getText());
    }
    
    public static void setTotalPrise(int num)
    {
    	labelTotalPrise.setText(Integer.toString(num));
    }
    
    public static void setLabelTotalPrise(String totalPrice)
    {
    	labelTotalPrise.setText(totalPrice);
    }

	
    
	private void setFields(Table table)
	{
		if (table != null)
		{
			Employe employe = table.getEmployee();
			textWaiter.setText(employe.getEmployeFirstName());
			textTable.setText(table.getNameOfTable());
			textNumberOfClients.setText(table.getNumberOfClientsInTable());
			textComment.setText(table.getDiscriptionOfClient());
		}
	}
	
	private void openProductMenu()
	{
		ProductMenu.main(null);
	}
	
	//Checks if the user is sure that he want to sign out
	private void confirmConfirmation()
	{
		int desition = JOptionPane.showConfirmDialog(null,"האם אתה בטוח שאתה רוצה לצאת מהתוכנה?","יציאה",JOptionPane.YES_NO_OPTION);
		if(desition==0)
		{
			frame.dispose();
		}
	}
	
	//Stores all ordered products into the database
	private void saveOrderInTextFile() throws FileNotFoundException
	{
		orderManagmentModuel.saveOrderInTextFile(orderTable);
	}
	
	private void openPayment(String PaymentMethod)
	{
		Payment.setTable(PaymentMethod);
		Payment.main(null);
	} 
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1267, 824);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JButton btnSaveInvitation = new JButton("");
		btnSaveInvitation.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/save.png")));
		btnSaveInvitation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					saveOrderInTextFile();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		btnSaveInvitation.setBounds(463, 584, 70, 70);
		frame.getContentPane().add(btnSaveInvitation);
		
		JButton buttonPrintAccount = new JButton("");
		buttonPrintAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( null, "הקבלה נשלחה להדפסה", "הדפסה", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		buttonPrintAccount.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/print1.jpeg")));
		buttonPrintAccount.setBounds(576, 584, 70, 70);
		frame.getContentPane().add(buttonPrintAccount);
		
		JButton buttonCreditCard = new JButton("\u05D0\u05E9\u05E8\u05D0\u05D9");
		buttonCreditCard.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openPayment("CreditCard");
			}
		});
		buttonCreditCard.setBounds(822, 605, 73, 64);
		frame.getContentPane().add(buttonCreditCard);
		
		JButton buttonCash = new JButton("\u05DE\u05D6\u05D5\u05DE\u05DF");
		buttonCash.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openPayment("cash");
			}
		});
		buttonCash.setBounds(740, 605, 70, 64);
		frame.getContentPane().add(buttonCash);
		
		JButton buttonDiscount = new JButton("\u05D4\u05E0\u05D7\u05D4");
		buttonDiscount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				discountForACustomerClub();
			}
		});
		buttonDiscount.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonDiscount.setBounds(658, 605, 70, 64);
		frame.getContentPane().add(buttonDiscount);
		
		JButton buttonOpenDrawer = new JButton("");
		buttonOpenDrawer.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/OpenMagiraButton.jpeg")));
		buttonOpenDrawer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDrawer();
			}
		});
		buttonOpenDrawer.setBounds(97, 648, 70, 64);
		frame.getContentPane().add(buttonOpenDrawer);
		
		JButton buttonExit = new JButton("");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmConfirmation();				
			}
		});
		buttonExit.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/ExitButton.jpg")));
		buttonExit.setBounds(10, 648, 70, 64);
		frame.getContentPane().add(buttonExit);
		
		JButton btnSnacks = new JButton("\u05D1\u05E7\u05D8\u05E0\u05D4");
		btnSnacks.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSnacks.setBounds(1127, 45, 110, 77);
		btnSnacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelSnacks);
			}
		});
		frame.getContentPane().add(btnSnacks);
		
		JButton buttonDessert = new JButton("\u05E2\u05D9\u05E7\u05E8\u05D9\u05D5\u05EA");
		buttonDessert.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelDessert);
			}
		});
		buttonDessert.setBounds(1005, 45, 110, 77);
		frame.getContentPane().add(buttonDessert);
		
		JButton buttonColdDrink = new JButton("\u05E9\u05EA\u05D9\u05D9\u05D4 \u05E7\u05E8\u05D4");
		buttonColdDrink.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonColdDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelColdDrink);
			}
		});
		buttonColdDrink.setBounds(1127, 135, 110, 77);
		frame.getContentPane().add(buttonColdDrink);
		
		JButton buttonHotDrink = new JButton("\u05E9\u05EA\u05D9\u05D9\u05D4 \u05D7\u05DE\u05D4");
		buttonHotDrink.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonHotDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelHotDrink);
			}
		});
		buttonHotDrink.setBounds(1005, 135, 110, 77);
		frame.getContentPane().add(buttonHotDrink);
		
		JButton buttonBeerFromTheBarrel = new JButton("\u05D1\u05D9\u05E8\u05D5\u05EA \u05D7\u05D1\u05D9\u05EA");
		buttonBeerFromTheBarrel.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonBeerFromTheBarrel.setBounds(1127, 222, 110, 77);
		buttonBeerFromTheBarrel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelBerrfrom);
			}
		});
		frame.getContentPane().add(buttonBeerFromTheBarrel);
		
		JButton buttonBeerBottle = new JButton("\u05D1\u05D9\u05E8\u05D5\u05EA \u05D1\u05E7\u05D1\u05D5\u05E7");
		buttonBeerBottle.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonBeerBottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelbeerbotle);
			}
		});
		buttonBeerBottle.setBounds(1005, 222, 110, 77);
		frame.getContentPane().add(buttonBeerBottle);
		
		JButton buttonVodka = new JButton("\u05D5\u05D5\u05D3\u05E7\u05D4");
		buttonVodka.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonVodka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelVodka);
			}
		});
		buttonVodka.setBounds(1127, 308, 110, 77);
		frame.getContentPane().add(buttonVodka);
		
		JButton buttonTequila = new JButton("\u05D8\u05E7\u05D9\u05DC\u05D4");
		buttonTequila.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonTequila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelTequila);
			}
		});
		buttonTequila.setBounds(1005, 308, 110, 77);
		frame.getContentPane().add(buttonTequila);
		
		JButton buttonWhiskey = new JButton("\u05D5\u05D5\u05D9\u05E1\u05E7\u05D9");
		buttonWhiskey.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonWhiskey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelWhiskey);
			}
		});
		buttonWhiskey.setBounds(1127, 398, 110, 77);
		frame.getContentPane().add(buttonWhiskey);
		
		JButton buttonGin = new JButton("\u05D2'\u05D9\u05DF");
		buttonGin.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonGin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelGin);
			}
		});
		buttonGin.setBounds(1005, 398, 110, 77);
		frame.getContentPane().add(buttonGin);
		
		JButton buttonBrandleyAndCognac = new JButton("\u05D1\u05E8\u05E0\u05D3\u05D9/\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7");
		buttonBrandleyAndCognac.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonBrandleyAndCognac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelBrandy);
			}
		});
		buttonBrandleyAndCognac.setBounds(1127, 488, 110, 77);
		frame.getContentPane().add(buttonBrandleyAndCognac);
		
		JButton buttonRum = new JButton("\u05E8\u05D5\u05DD");
		buttonRum.setFont(new Font("Tahoma", Font.BOLD, 11));
		buttonRum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelRum);
			}
		});
		buttonRum.setBounds(1005, 488, 110, 77);
		frame.getContentPane().add(buttonRum);
		
		JButton btnRefreshType = new JButton("");
		btnRefreshType.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/updateButton.jpeg")));
		btnRefreshType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog( null, "המערכת עודכנה", "רענון מערכת", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRefreshType.setBounds(1148, 584, 78, 78);
		frame.getContentPane().add(btnRefreshType);
		
		JButton buttonSearch = new JButton("");
		buttonSearch.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/searchButton.png")));
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openProductMenu();		
			}
		});
		buttonSearch.setBounds(1053, 584, 85, 78);
		frame.getContentPane().add(buttonSearch);
		
		JButton buttonUpOrder = new JButton("");
		buttonUpOrder.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/Up.png")));
		buttonUpOrder.setFont(new Font("Tahoma", Font.PLAIN, 10));
		buttonUpOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				moveItemInTable("up");
			}
		});
		buttonUpOrder.setBounds(386, 584, 67, 70);
		frame.getContentPane().add(buttonUpOrder);
		
		btnDownOrder = new JButton("");
		btnDownOrder.setForeground(Color.BLACK);
		btnDownOrder.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/Down.jpg")));
		btnDownOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				moveItemInTable("down");
				}
		});
		btnDownOrder.setBounds(309, 584, 67, 70);
		frame.getContentPane().add(btnDownOrder);
		
		labelTotalPrise = new JLabel();
		labelTotalPrise.setBackground(Color.WHITE);
		labelTotalPrise.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelTotalPrise.setHorizontalAlignment(SwingConstants.CENTER);
		labelTotalPrise.setBounds(10, 584, 92, 43);
		frame.getContentPane().add(labelTotalPrise);
		
		JLabel lblTotalPayment = new JLabel("\u05E1\u05D4\"\u05DB \u05DC\u05EA\u05E9\u05DC\u05D5\u05DD:");
		lblTotalPayment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPayment.setBackground(Color.WHITE);
		lblTotalPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPayment.setBounds(86, 589, 124, 38);
		frame.getContentPane().add(lblTotalPayment);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(576, 59, 384, 490);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelBerrfrom = new JPanel();
		layeredPane.add(panelBerrfrom, "name_335424401665300");
		panelBerrfrom.setLayout(null);
		
		JButton btnGoldstarFromTheBarrel300ml = new JButton("");
		Image imgGoldstarFromTheBarrel300ml = new ImageIcon(this.getClass().getResource("/Image/Goldstar-beer.jpg")).getImage();
		btnGoldstarFromTheBarrel300ml.setIcon(new ImageIcon(imgGoldstarFromTheBarrel300ml));
		btnGoldstarFromTheBarrel300ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,text300mlGoldstarFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGoldstarFromTheBarrel300ml.setBounds(266, 80, 112, 79);
		panelBerrfrom.add(btnGoldstarFromTheBarrel300ml);
		
		JLabel labelBeerFromTheBarrel = new JLabel("\u05D1\u05D9\u05E8\u05D5\u05EA \u05DE\u05D4\u05D7\u05D1\u05D9\u05EA");
		labelBeerFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		labelBeerFromTheBarrel.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelBeerFromTheBarrel.setBounds(249, 27, 135, 35);
		panelBerrfrom.add(labelBeerFromTheBarrel);
		
		JButton btnGoldstarFromTheBarrel500ml = new JButton("");
		Image imgGoldstarFromTheBarrel500ml = new ImageIcon(this.getClass().getResource("/Image/Goldstar-beer.jpg")).getImage();
		btnGoldstarFromTheBarrel500ml.setIcon(new ImageIcon(imgGoldstarFromTheBarrel500ml));
		btnGoldstarFromTheBarrel500ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,text500mlGoldstarFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGoldstarFromTheBarrel500ml.setBounds(142, 80, 112, 79);
		panelBerrfrom.add(btnGoldstarFromTheBarrel500ml);
		
		JButton btnGoldstarFromTheBarrelLiter = new JButton("");
		Image imgGoldstarFromTheBarrelLiter = new ImageIcon(this.getClass().getResource("/Image/Goldstar-beer.jpg")).getImage();
		btnGoldstarFromTheBarrelLiter.setIcon(new ImageIcon(imgGoldstarFromTheBarrelLiter));
		btnGoldstarFromTheBarrelLiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textLiterGoldstarFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGoldstarFromTheBarrelLiter.setBounds(18, 80, 112, 79);
		panelBerrfrom.add(btnGoldstarFromTheBarrelLiter);
		
		text300mlGoldstarFromTheBarrel = new JTextField();
		text300mlGoldstarFromTheBarrel.setBackground(Color.WHITE);
		text300mlGoldstarFromTheBarrel.setEditable(false);
		text300mlGoldstarFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		text300mlGoldstarFromTheBarrel.setText("\u05E9\u05DC\u05D9\u05E9 \u05D2\u05D5\u05DC\u05D3\u05E1\u05D8\u05D0\u05E8");
		text300mlGoldstarFromTheBarrel.setBounds(266, 158, 112, 22);
		panelBerrfrom.add(text300mlGoldstarFromTheBarrel);
		text300mlGoldstarFromTheBarrel.setColumns(10);
		
		text500mlGoldstarFromTheBarrel = new JTextField();
		text500mlGoldstarFromTheBarrel.setEditable(false);
		text500mlGoldstarFromTheBarrel.setBackground(Color.WHITE);
		text500mlGoldstarFromTheBarrel.setText("\u05D7\u05E6\u05D9 \u05D2\u05D5\u05DC\u05D3\u05E1\u05D8\u05D0\u05E8");
		text500mlGoldstarFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		text500mlGoldstarFromTheBarrel.setColumns(10);
		text500mlGoldstarFromTheBarrel.setBounds(142, 158, 112, 22);
		panelBerrfrom.add(text500mlGoldstarFromTheBarrel);
		
		textLiterGoldstarFromTheBarrel = new JTextField();
		textLiterGoldstarFromTheBarrel.setBackground(Color.WHITE);
		textLiterGoldstarFromTheBarrel.setEditable(false);
		textLiterGoldstarFromTheBarrel.setText("\u05DC\u05D9\u05D8\u05E8 \u05D2\u05D5\u05DC\u05D3\u05E1\u05D8\u05D0\u05E8");
		textLiterGoldstarFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		textLiterGoldstarFromTheBarrel.setColumns(10);
		textLiterGoldstarFromTheBarrel.setBounds(18, 158, 112, 22);
		panelBerrfrom.add(textLiterGoldstarFromTheBarrel);
		
		JButton btnHeinekenFromTheBarrel300ml = new JButton("");
		Image imgHeinekenFromTheBarrel300ml = new ImageIcon(this.getClass().getResource("/Image/Heineken-beer.png")).getImage();
		btnHeinekenFromTheBarrel300ml.setIcon(new ImageIcon(imgHeinekenFromTheBarrel300ml));
		btnHeinekenFromTheBarrel300ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,text300mlHeinekenFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHeinekenFromTheBarrel300ml.setBounds(266, 211, 112, 79);
		panelBerrfrom.add(btnHeinekenFromTheBarrel300ml);
		
		JButton btnHeinekenFromTheBarrel500ml = new JButton("");
		Image imgHeinekenFromTheBarrel500ml = new ImageIcon(this.getClass().getResource("/Image/Heineken-beer.png")).getImage();
		btnHeinekenFromTheBarrel500ml.setIcon(new ImageIcon(imgHeinekenFromTheBarrel500ml));
		btnHeinekenFromTheBarrel500ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,tex500mlHeinekenFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHeinekenFromTheBarrel500ml.setBounds(142, 211, 112, 79);
		panelBerrfrom.add(btnHeinekenFromTheBarrel500ml);
		
		JButton btnHeinekenFromTheBarrelLiter = new JButton("");
		Image imgHeinekenFromTheBarrelLiter = new ImageIcon(this.getClass().getResource("/Image/Heineken-beer.png")).getImage();
		btnHeinekenFromTheBarrelLiter.setIcon(new ImageIcon(imgHeinekenFromTheBarrelLiter));
		btnHeinekenFromTheBarrelLiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textLiterHeinekenFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHeinekenFromTheBarrelLiter.setBounds(18, 211, 112, 79);
		panelBerrfrom.add(btnHeinekenFromTheBarrelLiter);
		
		text300mlHeinekenFromTheBarrel = new JTextField();
		text300mlHeinekenFromTheBarrel.setBackground(Color.WHITE);
		text300mlHeinekenFromTheBarrel.setEditable(false);
		text300mlHeinekenFromTheBarrel.setText("\u05E9\u05DC\u05D9\u05E9 \u05D4\u05D9\u05D9\u05E0\u05D9\u05E7\u05DF");
		text300mlHeinekenFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		text300mlHeinekenFromTheBarrel.setColumns(10);
		text300mlHeinekenFromTheBarrel.setBounds(266, 290, 112, 22);
		panelBerrfrom.add(text300mlHeinekenFromTheBarrel);
		
		tex500mlHeinekenFromTheBarrel = new JTextField();
		tex500mlHeinekenFromTheBarrel.setBackground(Color.WHITE);
		tex500mlHeinekenFromTheBarrel.setEditable(false);
		tex500mlHeinekenFromTheBarrel.setText("\u05D7\u05E6\u05D9 \u05D4\u05D9\u05D9\u05E0\u05D9\u05E7\u05DF");
		tex500mlHeinekenFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		tex500mlHeinekenFromTheBarrel.setColumns(10);
		tex500mlHeinekenFromTheBarrel.setBounds(142, 290, 112, 22);
		panelBerrfrom.add(tex500mlHeinekenFromTheBarrel);
		
		textLiterHeinekenFromTheBarrel = new JTextField();
		textLiterHeinekenFromTheBarrel.setBackground(Color.WHITE);
		textLiterHeinekenFromTheBarrel.setEditable(false);
		textLiterHeinekenFromTheBarrel.setText("\u05DC\u05D9\u05D8\u05E8 \u05D4\u05D9\u05D9\u05E0\u05D9\u05E7\u05DF");
		textLiterHeinekenFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		textLiterHeinekenFromTheBarrel.setColumns(10);
		textLiterHeinekenFromTheBarrel.setBounds(18, 290, 112, 22);
		panelBerrfrom.add(textLiterHeinekenFromTheBarrel);
		
		JButton btnRedTuborgFromTheBarrel300ml = new JButton("");
		Image imgTuborgFromTheBarrel300ml = new ImageIcon(this.getClass().getResource("/Image/Tuborg-beer.jpg")).getImage();
		btnRedTuborgFromTheBarrel300ml.setIcon(new ImageIcon(imgTuborgFromTheBarrel300ml));
		btnRedTuborgFromTheBarrel300ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,text300mlRedTuborgFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRedTuborgFromTheBarrel300ml.setBounds(266, 345, 112, 79);
		panelBerrfrom.add(btnRedTuborgFromTheBarrel300ml);
		
		JButton btnRedTuborgFromTheBarrel500ml = new JButton("");
		btnRedTuborgFromTheBarrel500ml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,text500mlRedTuborgFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgTuborgFromTheBarrel500ml = new ImageIcon(this.getClass().getResource("/Image/Tuborg-beer.jpg")).getImage();
		btnRedTuborgFromTheBarrel500ml.setIcon(new ImageIcon(imgTuborgFromTheBarrel500ml));
		btnRedTuborgFromTheBarrel500ml.setBounds(142, 345, 112, 79);
		panelBerrfrom.add(btnRedTuborgFromTheBarrel500ml);
		
		JButton btnRedTuborgFromTheBarrelLiter = new JButton("");
		btnRedTuborgFromTheBarrelLiter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,textLiterRedTuborgFromTheBarrel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgTuborgFromTheBarrelLiter = new ImageIcon(this.getClass().getResource("/Image/Tuborg-beer.jpg")).getImage();
		btnRedTuborgFromTheBarrelLiter.setIcon(new ImageIcon(imgTuborgFromTheBarrelLiter));
		btnRedTuborgFromTheBarrelLiter.setBounds(18, 345, 112, 79);
		panelBerrfrom.add(btnRedTuborgFromTheBarrelLiter);
		
		text300mlRedTuborgFromTheBarrel = new JTextField();
		text300mlRedTuborgFromTheBarrel.setBackground(Color.WHITE);
		text300mlRedTuborgFromTheBarrel.setEditable(false);
		text300mlRedTuborgFromTheBarrel.setText("\u05E9\u05DC\u05D9\u05E9 \u05D8\u05D5\u05D1\u05D5\u05E8\u05D2");
		text300mlRedTuborgFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		text300mlRedTuborgFromTheBarrel.setColumns(10);
		text300mlRedTuborgFromTheBarrel.setBounds(266, 429, 112, 22);
		panelBerrfrom.add(text300mlRedTuborgFromTheBarrel);
		
		text500mlRedTuborgFromTheBarrel = new JTextField();
		text500mlRedTuborgFromTheBarrel.setBackground(Color.WHITE);
		text500mlRedTuborgFromTheBarrel.setEditable(false);
		text500mlRedTuborgFromTheBarrel.setText("\u05D7\u05E6\u05D9 \u05D8\u05D5\u05D1\u05D5\u05E8\u05D2");
		text500mlRedTuborgFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		text500mlRedTuborgFromTheBarrel.setColumns(10);
		text500mlRedTuborgFromTheBarrel.setBounds(142, 429, 112, 22);
		panelBerrfrom.add(text500mlRedTuborgFromTheBarrel);
		
		textLiterRedTuborgFromTheBarrel = new JTextField();
		textLiterRedTuborgFromTheBarrel.setBackground(Color.WHITE);
		textLiterRedTuborgFromTheBarrel.setEditable(false);
		textLiterRedTuborgFromTheBarrel.setText("\u05DC\u05D9\u05D8\u05E8 \u05D8\u05D5\u05D1\u05D5\u05E8\u05D2");
		textLiterRedTuborgFromTheBarrel.setHorizontalAlignment(SwingConstants.CENTER);
		textLiterRedTuborgFromTheBarrel.setColumns(10);
		textLiterRedTuborgFromTheBarrel.setBounds(18, 429, 112, 22);
		panelBerrfrom.add(textLiterRedTuborgFromTheBarrel);
		
		panelbeerbotle = new JPanel();
		layeredPane.add(panelbeerbotle, "name_335672234842900");
		panelbeerbotle.setLayout(null);
		
		JLabel labelBeerFromABottle = new JLabel("\u05D1\u05D9\u05E8\u05D5\u05EA / \u05D1\u05E7\u05D1\u05D5\u05E7");
		labelBeerFromABottle.setHorizontalAlignment(SwingConstants.CENTER);
		labelBeerFromABottle.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelBeerFromABottle.setBounds(249, 27, 135, 35);
		panelbeerbotle.add(labelBeerFromABottle);
		
		JButton btnGoldstarFromABottle = new JButton("");
		Image imgGoldstarFromABottle = new ImageIcon(this.getClass().getResource("/Image/Goldstar-beer.jpg")).getImage();
		btnGoldstarFromABottle.setIcon(new ImageIcon(imgGoldstarFromABottle));
		btnGoldstarFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,textFromABottleGoldstar.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGoldstarFromABottle.setBounds(266, 79, 112, 79);
		panelbeerbotle.add(btnGoldstarFromABottle);
		
		textFromABottleGoldstar = new JTextField();
		textFromABottleGoldstar.setBackground(Color.WHITE);
		textFromABottleGoldstar.setEditable(false);
		textFromABottleGoldstar.setText("\u05D2\u05D5\u05DC\u05D3\u05E1\u05D8\u05D0\u05E8 \u05D1\u05E7\u05D1\u05D5\u05E7");
		textFromABottleGoldstar.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleGoldstar.setColumns(10);
		textFromABottleGoldstar.setBounds(266, 158, 112, 22);
		panelbeerbotle.add(textFromABottleGoldstar);
		
		JButton btnHeinekenFromABottle = new JButton("");
		btnHeinekenFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleHeineken.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgHeinekenFromABottle = new ImageIcon(this.getClass().getResource("/Image/Heineken-beer.png")).getImage();
		btnHeinekenFromABottle.setIcon(new ImageIcon(imgHeinekenFromABottle));
		btnHeinekenFromABottle.setBounds(142, 79, 112, 79);
		panelbeerbotle.add(btnHeinekenFromABottle);
		
		JButton btnHRedTuborgFromABottle = new JButton("");
		btnHRedTuborgFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,texttextFromABottleTuborgRed.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgTuborgFromABottle = new ImageIcon(this.getClass().getResource("/Image/Tuborg-beer.jpg")).getImage();
		btnHRedTuborgFromABottle.setIcon(new ImageIcon(imgTuborgFromABottle));
		btnHRedTuborgFromABottle.setBounds(12, 79, 112, 79);
		panelbeerbotle.add(btnHRedTuborgFromABottle);
		
		textFromABottleHeineken = new JTextField();
		textFromABottleHeineken.setBackground(Color.WHITE);
		textFromABottleHeineken.setEditable(false);
		textFromABottleHeineken.setText("\u05D4\u05D9\u05D9\u05E0\u05D9\u05E7\u05DF \u05D1\u05E7\u05D1\u05D5\u05E7");
		textFromABottleHeineken.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleHeineken.setColumns(10);
		textFromABottleHeineken.setBounds(142, 158, 112, 22);
		panelbeerbotle.add(textFromABottleHeineken);
		
		texttextFromABottleTuborgRed = new JTextField();
		texttextFromABottleTuborgRed.setBackground(Color.WHITE);
		texttextFromABottleTuborgRed.setEditable(false);
		texttextFromABottleTuborgRed.setText("\u05D8\u05D5\u05D1\u05D5\u05E8\u05D2 \u05D0\u05D3\u05D5\u05DD");
		texttextFromABottleTuborgRed.setHorizontalAlignment(SwingConstants.CENTER);
		texttextFromABottleTuborgRed.setColumns(10);
		texttextFromABottleTuborgRed.setBounds(12, 158, 112, 22);
		panelbeerbotle.add(texttextFromABottleTuborgRed);
		
		JButton btnStelaFromABottle = new JButton("");
		Image imgStelaFromABottle = new ImageIcon(this.getClass().getResource("/Image/Stela.jpg")).getImage();
		btnStelaFromABottle.setIcon(new ImageIcon(imgStelaFromABottle));
		btnStelaFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleStela.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStelaFromABottle.setBounds(266, 211, 112, 79);
		panelbeerbotle.add(btnStelaFromABottle);
		
		JButton btnWeihenstephanFromABottle = new JButton("");
		btnWeihenstephanFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleWeihenstephan.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgWeihenstephanFromABottle = new ImageIcon(this.getClass().getResource("/Image/Weihenstephan.png")).getImage();
		btnWeihenstephanFromABottle.setIcon(new ImageIcon(imgWeihenstephanFromABottle));
		btnWeihenstephanFromABottle.setBounds(142, 211, 112, 79);
		panelbeerbotle.add(btnWeihenstephanFromABottle);
		
		JButton btnLeffeBrownFromABottle = new JButton("");
		btnLeffeBrownFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleLeffeBrown.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgLeffeBrownFromABottle = new ImageIcon(this.getClass().getResource("/Image/LeffeBrown.jpg")).getImage();
		btnLeffeBrownFromABottle.setIcon(new ImageIcon(imgLeffeBrownFromABottle));
		btnLeffeBrownFromABottle.setBounds(12, 211, 112, 79);
		panelbeerbotle.add(btnLeffeBrownFromABottle);
		
		textFromABottleStela = new JTextField();
		textFromABottleStela.setEditable(false);
		textFromABottleStela.setBackground(Color.WHITE);
		textFromABottleStela.setText("\u05E1\u05D8\u05DC\u05D4");
		textFromABottleStela.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleStela.setColumns(10);
		textFromABottleStela.setBounds(266, 289, 112, 22);
		panelbeerbotle.add(textFromABottleStela);
		
		textFromABottleWeihenstephan = new JTextField();
		textFromABottleWeihenstephan.setBackground(Color.WHITE);
		textFromABottleWeihenstephan.setEditable(false);
		textFromABottleWeihenstephan.setText("\u05D5\u05D5\u05D9\u05E0\u05E9\u05D8\u05E4\u05DF");
		textFromABottleWeihenstephan.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleWeihenstephan.setColumns(10);
		textFromABottleWeihenstephan.setBounds(142, 289, 112, 22);
		panelbeerbotle.add(textFromABottleWeihenstephan);
		
		textFromABottleLeffeBrown = new JTextField();
		textFromABottleLeffeBrown.setBackground(Color.WHITE);
		textFromABottleLeffeBrown.setEditable(false);
		textFromABottleLeffeBrown.setText("\u05DC\u05E3 \u05D1\u05E8\u05D0\u05D5\u05DF");
		textFromABottleLeffeBrown.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleLeffeBrown.setColumns(10);
		textFromABottleLeffeBrown.setBounds(12, 289, 112, 22);
		panelbeerbotle.add(textFromABottleLeffeBrown);
		
		JButton btnBreezerWatermelonFromABottle = new JButton("");
		btnBreezerWatermelonFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleBreezerWatermelon.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgWBreezerWatermelonFromABottle = new ImageIcon(this.getClass().getResource("/Image/Breezerwatermelon.png")).getImage();
		btnBreezerWatermelonFromABottle.setIcon(new ImageIcon(imgWBreezerWatermelonFromABottle));
		btnBreezerWatermelonFromABottle.setBounds(266, 345, 112, 79);
		panelbeerbotle.add(btnBreezerWatermelonFromABottle);
		
		JButton btnMaccabiFromABottle = new JButton("");
		btnMaccabiFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleMaccabi.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgWMaccabiFromABottle = new ImageIcon(this.getClass().getResource("/Image/Maccabi.jpg")).getImage();
		btnMaccabiFromABottle.setIcon(new ImageIcon(imgWMaccabiFromABottle));
		btnMaccabiFromABottle.setBounds(142, 345, 112, 79);
		panelbeerbotle.add(btnMaccabiFromABottle);
		
		JButton btnShandywatermelonFromABottle = new JButton("");
		btnShandywatermelonFromABottle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textFromABottleShandywatermelon.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		Image imgShandywatemelonFromABottle = new ImageIcon(this.getClass().getResource("/Image/Shandywatermelon.jpg")).getImage();
		btnShandywatermelonFromABottle.setIcon(new ImageIcon(imgShandywatemelonFromABottle));
		btnShandywatermelonFromABottle.setBounds(18, 345, 112, 79);
		panelbeerbotle.add(btnShandywatermelonFromABottle);
		
		textFromABottleBreezerWatermelon = new JTextField();
		textFromABottleBreezerWatermelon.setBackground(Color.WHITE);
		textFromABottleBreezerWatermelon.setEditable(false);
		textFromABottleBreezerWatermelon.setText("\u05D1\u05E8\u05D9\u05D6\u05E8 \u05D0\u05D1\u05D8\u05D9\u05D7");
		textFromABottleBreezerWatermelon.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleBreezerWatermelon.setColumns(10);
		textFromABottleBreezerWatermelon.setBounds(266, 421, 112, 22);
		panelbeerbotle.add(textFromABottleBreezerWatermelon);
		
		textFromABottleMaccabi = new JTextField();
		textFromABottleMaccabi.setBackground(Color.WHITE);
		textFromABottleMaccabi.setEditable(false);
		textFromABottleMaccabi.setText("\u05DE\u05DB\u05D1\u05D9");
		textFromABottleMaccabi.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleMaccabi.setColumns(10);
		textFromABottleMaccabi.setBounds(142, 421, 112, 22);
		panelbeerbotle.add(textFromABottleMaccabi);
		
		textFromABottleShandywatermelon = new JTextField();
		textFromABottleShandywatermelon.setBackground(Color.WHITE);
		textFromABottleShandywatermelon.setEditable(false);
		textFromABottleShandywatermelon.setText("\u05E9\u05E0\u05D3\u05D9 \u05D0\u05D1\u05D8\u05D9\u05D7");
		textFromABottleShandywatermelon.setHorizontalAlignment(SwingConstants.CENTER);
		textFromABottleShandywatermelon.setColumns(10);
		textFromABottleShandywatermelon.setBounds(18, 421, 112, 22);
		panelbeerbotle.add(textFromABottleShandywatermelon);
		
		panelColdDrink = new JPanel();
		layeredPane.add(panelColdDrink, "name_128842864698400");
		panelColdDrink.setLayout(null);
		
		JButton btnColaZero = new JButton("");
		btnColaZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textColaZero.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnColaZero.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05E7\u05D5\u05DC\u05D4 \u05D6\u05D9\u05E8\u05D5.jpg")));
		btnColaZero.setBounds(21, 79, 112, 79);
		panelColdDrink.add(btnColaZero);
		
		JButton btnCola = new JButton("");
		btnCola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textCola.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCola.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05E7\u05D5\u05DC\u05D4.jpg")));
		btnCola.setBounds(144, 79, 112, 79);
		panelColdDrink.add(btnCola);
		
		JButton btnMango = new JButton("");
		btnMango.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textMango.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMango.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05D1\u05E7\u05D1\u05D5\u05E7 \u05DE\u05E0\u05D2\u05D5.jpg")));
		btnMango.setBounds(266, 79, 112, 79);
		panelColdDrink.add(btnMango);
		
		JButton btnOranges = new JButton("");
		btnOranges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textOranges.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOranges.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05D1\u05E7\u05D1\u05D5\u05E7 \u05EA\u05E4\u05D5\u05D6\u05D9\u05DD.jpg")));
		btnOranges.setBounds(21, 211, 112, 79);
		panelColdDrink.add(btnOranges);
		
		JButton btnLemoes = new JButton("");
		btnLemoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textLemoes.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLemoes.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05DC\u05D9\u05DE\u05D5\u05E0\u05D3\u05D4.jpg")));
		btnLemoes.setBounds(144, 211, 112, 79);
		panelColdDrink.add(btnLemoes);
		
		JButton btnSprite = new JButton("");
		btnSprite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textSprite.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSprite.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05E1\u05E4\u05E8\u05D9\u05D9\u05D8.png")));
		btnSprite.setBounds(266, 211, 112, 79);
		panelColdDrink.add(btnSprite);
		
		JButton btnSoda = new JButton("");
		btnSoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textSoda.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSoda.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05E1\u05D5\u05D3\u05D4.jpg")));
		btnSoda.setBounds(21, 345, 112, 79);
		panelColdDrink.add(btnSoda);
		
		JButton btnSpriteZero = new JButton("");
		btnSpriteZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtSpriteZero.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSpriteZero.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05E1\u05E4\u05E8\u05D9\u05D9\u05D8 \u05D6\u05D9\u05E8\u05D5.jpg")));
		btnSpriteZero.setBounds(144, 345, 112, 79);
		panelColdDrink.add(btnSpriteZero);
		
		JButton btnWater = new JButton("");
		btnWater.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/ColdDrinks/\u05D1\u05E7\u05D1\u05D5\u05E7 \u05DE\u05D9\u05DD.png")));
		btnWater.setBackground(Color.WHITE);
		btnWater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,txtWater.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnWater.setBounds(266, 345, 112, 79);
		panelColdDrink.add(btnWater);
		
		panelHotDrink = new JPanel();
		layeredPane.add(panelHotDrink, "name_129164412684400");
		panelHotDrink.setLayout(null);
		
		JButton btnBlackCoffe = new JButton("");
		btnBlackCoffe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtBlackCoffe.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBlackCoffe.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/HotDrink/\u05E7\u05E4\u05D4 \u05E9\u05D7\u05D5\u05E8.jpg")));
		btnBlackCoffe.setBounds(142, 79, 112, 79);
		panelHotDrink.add(btnBlackCoffe);
		
		JButton btnTea = new JButton("");
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,txtTea.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTea.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/HotDrink/\u05EA\u05D4.jpg")));
		btnTea.setBounds(266, 79, 112, 79);
		panelHotDrink.add(btnTea);
		
		txtTea = new JTextField();
		txtTea.setText("\u05EA\u05D4");
		txtTea.setHorizontalAlignment(SwingConstants.CENTER);
		txtTea.setEditable(false);
		txtTea.setColumns(10);
		txtTea.setBackground(Color.WHITE);
		txtTea.setBounds(266, 156, 112, 22);
		panelHotDrink.add(txtTea);
		
		txtBlackCoffe = new JTextField();
		txtBlackCoffe.setText("\u05E7\u05E4\u05D4 \u05E9\u05D7\u05D5\u05E8");
		txtBlackCoffe.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlackCoffe.setEditable(false);
		txtBlackCoffe.setColumns(10);
		txtBlackCoffe.setBackground(Color.WHITE);
		txtBlackCoffe.setBounds(142, 156, 112, 22);
		panelHotDrink.add(txtBlackCoffe);
		
		JLabel labelHotDrink = new JLabel("\u05E9\u05EA\u05D9\u05D9\u05D4 \u05D7\u05DE\u05D4");
		labelHotDrink.setHorizontalAlignment(SwingConstants.CENTER);
		labelHotDrink.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelHotDrink.setBounds(249, 27, 135, 35);
		panelHotDrink.add(labelHotDrink);
		
		panelDessert = new JPanel();
		layeredPane.add(panelDessert, "name_129257948890800");
		panelDessert.setLayout(null);
		
		JButton btnHamburger120g = new JButton("");
		btnHamburger120g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textHamburger120g.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHamburger120g.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8.jpg")));
		btnHamburger120g.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnHamburger120g.setBounds(266, 79, 112, 79);
		panelDessert.add(btnHamburger120g);
		
		JButton btnHamburger200g = new JButton("");
		btnHamburger200g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textHamburger200g.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHamburger200g.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8.jpg")));
		btnHamburger200g.setBounds(136, 79, 112, 79);
		panelDessert.add(btnHamburger200g);
		
		JButton btnHamburger300g = new JButton("");
		btnHamburger300g.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addProductToTable(dm,textHamburger300g.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHamburger300g.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8.jpg")));
		btnHamburger300g.setBounds(12, 79, 112, 79);
		panelDessert.add(btnHamburger300g);
		
		JButton btnChickenSteak = new JButton("");
		btnChickenSteak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textChickenSteak.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnChickenSteak.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05E4\u05E8\u05D2\u05D9\u05EA.jpg")));
		btnChickenSteak.setBounds(136, 211, 112, 79);
		panelDessert.add(btnChickenSteak);
		
		JButton btnEntrecote = new JButton("");
		btnEntrecote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textEntrecote.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEntrecote.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05D0\u05E0\u05D8\u05E8\u05D9\u05E7\u05D5\u05D8.jpg")));
		btnEntrecote.setBounds(12, 211, 112, 79);
		panelDessert.add(btnEntrecote);
		
		JButton btnSteakSirloin = new JButton("");
		btnSteakSirloin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textSteakSirloin.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSteakSirloin.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05E1\u05D9\u05E0\u05D8\u05D4.jpg")));
		btnSteakSirloin.setBounds(266, 211, 112, 79);
		panelDessert.add(btnSteakSirloin);
		
		JButton btnLambChops = new JButton("");
		btnLambChops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textLambChops.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLambChops.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05E6\u05DC\u05E2\u05D5\u05EA \u05D8\u05DC\u05D4.jpg")));
		btnLambChops.setBounds(136, 345, 112, 79);
		panelDessert.add(btnLambChops);
		
		JButton btnPizza = new JButton("");
		btnPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textPizza.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPizza.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/MainDishes/\u05E4\u05D9\u05E6\u05D4.jpg")));
		btnPizza.setBounds(266, 345, 112, 79);
		panelDessert.add(btnPizza);
		
		textHamburger300g = new JTextField();
		textHamburger300g.setText("\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8 300");
		textHamburger300g.setHorizontalAlignment(SwingConstants.CENTER);
		textHamburger300g.setEditable(false);
		textHamburger300g.setColumns(10);
		textHamburger300g.setBackground(Color.WHITE);
		textHamburger300g.setBounds(12, 160, 112, 22);
		panelDessert.add(textHamburger300g);
		
		textHamburger120g = new JTextField();
		textHamburger120g.setText("\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8 120");
		textHamburger120g.setHorizontalAlignment(SwingConstants.CENTER);
		textHamburger120g.setEditable(false);
		textHamburger120g.setColumns(10);
		textHamburger120g.setBackground(Color.WHITE);
		textHamburger120g.setBounds(266, 160, 112, 22);
		panelDessert.add(textHamburger120g);
		
		textHamburger200g = new JTextField();
		textHamburger200g.setText("\u05D4\u05DE\u05D1\u05D5\u05E8\u05D2\u05E8 200");
		textHamburger200g.setHorizontalAlignment(SwingConstants.CENTER);
		textHamburger200g.setEditable(false);
		textHamburger200g.setColumns(10);
		textHamburger200g.setBackground(Color.WHITE);
		textHamburger200g.setBounds(136, 160, 112, 22);
		panelDessert.add(textHamburger200g);
		
		textChickenSteak = new JTextField();
		textChickenSteak.setText("\u05E1\u05D8\u05D9\u05D9\u05E7 \u05E4\u05E8\u05D2\u05D9\u05EA");
		textChickenSteak.setHorizontalAlignment(SwingConstants.CENTER);
		textChickenSteak.setEditable(false);
		textChickenSteak.setColumns(10);
		textChickenSteak.setBackground(Color.WHITE);
		textChickenSteak.setBounds(136, 291, 112, 22);
		panelDessert.add(textChickenSteak);
		
		textSteakSirloin = new JTextField();
		textSteakSirloin.setText("\u05E1\u05D8\u05D9\u05D9\u05E7 \u05E1\u05D9\u05E0\u05D8\u05D4");
		textSteakSirloin.setHorizontalAlignment(SwingConstants.CENTER);
		textSteakSirloin.setEditable(false);
		textSteakSirloin.setColumns(10);
		textSteakSirloin.setBackground(Color.WHITE);
		textSteakSirloin.setBounds(266, 291, 112, 22);
		panelDessert.add(textSteakSirloin);
		
		textEntrecote = new JTextField();
		textEntrecote.setText("\u05E1\u05D8\u05D9\u05D9\u05E7 \u05D0\u05E0\u05D8\u05E8\u05D9\u05E7\u05D5\u05D8");
		textEntrecote.setHorizontalAlignment(SwingConstants.CENTER);
		textEntrecote.setEditable(false);
		textEntrecote.setColumns(10);
		textEntrecote.setBackground(Color.WHITE);
		textEntrecote.setBounds(12, 291, 112, 22);
		panelDessert.add(textEntrecote);
		
		textPizza = new JTextField();
		textPizza.setText("\u05E4\u05D9\u05E6\u05D4");
		textPizza.setHorizontalAlignment(SwingConstants.CENTER);
		textPizza.setEditable(false);
		textPizza.setColumns(10);
		textPizza.setBackground(Color.WHITE);
		textPizza.setBounds(266, 431, 112, 22);
		panelDessert.add(textPizza);
		
		textLambChops = new JTextField();
		textLambChops.setText("\u05E6\u05DC\u05E2\u05D5\u05EA \u05D8\u05DC\u05D4");
		textLambChops.setHorizontalAlignment(SwingConstants.CENTER);
		textLambChops.setEditable(false);
		textLambChops.setColumns(10);
		textLambChops.setBackground(Color.WHITE);
		textLambChops.setBounds(136, 431, 112, 22);
		panelDessert.add(textLambChops);
		
		JLabel labelDessert = new JLabel("\u05E2\u05D9\u05E7\u05E8\u05D9\u05D5\u05EA");
		labelDessert.setHorizontalAlignment(SwingConstants.CENTER);
		labelDessert.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelDessert.setBounds(249, 27, 135, 35);
		panelDessert.add(labelDessert);
		
		panelVodka = new JPanel();
		layeredPane.add(panelVodka, "name_129982612973200");
		panelVodka.setLayout(null);
		
		JButton btnFinlandia = new JButton("");
		btnFinlandia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfFinlandia.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnFinlandia.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05E4\u05D9\u05E0\u05DC\u05E0\u05D3\u05D9\u05D4.jpg")));
		btnFinlandia.setBounds(142, 79, 112, 79);
		panelVodka.add(btnFinlandia);
		
		JButton btnGreyGoose = new JButton("");
		btnGreyGoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfGreyGoose.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGreyGoose.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05D2\u05E8\u05D9\u05D9 \u05D2\u05D5\u05E1.jpg")));
		btnGreyGoose.setBounds(266, 79, 112, 79);
		panelVodka.add(btnGreyGoose);
		
		JButton btnVanGoghAsay = new JButton("");
		btnVanGoghAsay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtVanGoghAsay.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVanGoghAsay.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05D5\u05D0\u05DF \u05D2\u05D5\u05DA \u05D0\u05E1\u05D0\u05D9.jpg")));
		btnVanGoghAsay.setBounds(12, 79, 112, 79);
		panelVodka.add(btnVanGoghAsay);
		
		JButton btnArak = new JButton("");
		btnArak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtArk.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnArak.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05E2\u05E8\u05E7.jpg")));
		btnArak.setBounds(266, 211, 112, 79);
		panelVodka.add(btnArak);
		
		JButton btnVanGoghPineapple = new JButton("");
		btnVanGoghPineapple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtVanGoghPineapple.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVanGoghPineapple.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05D5\u05D0\u05DF \u05D2\u05D5\u05DA \u05D0\u05E0\u05E0\u05E1.png")));
		btnVanGoghPineapple.setBounds(12, 211, 112, 79);
		panelVodka.add(btnVanGoghPineapple);
		
		JButton btnToby = new JButton("");
		btnToby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtToby.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnToby.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Vodka/\u05D8\u05D5\u05D1\u05D9 60.jpg")));
		btnToby.setBounds(142, 211, 112, 79);
		panelVodka.add(btnToby);
		
		txtfGreyGoose = new JTextField();
		txtfGreyGoose.setBackground(Color.WHITE);
		txtfGreyGoose.setEditable(false);
		txtfGreyGoose.setText("\u05D2\u05E8\u05D9\u05D9\u05D2\u05D5\u05E1");
		txtfGreyGoose.setHorizontalAlignment(SwingConstants.CENTER);
		txtfGreyGoose.setColumns(10);
		txtfGreyGoose.setBounds(266, 156, 112, 22);
		panelVodka.add(txtfGreyGoose);
		
		txtfFinlandia = new JTextField();
		txtfFinlandia.setBackground(Color.WHITE);
		txtfFinlandia.setEditable(false);
		txtfFinlandia.setText("\u05E4\u05D9\u05E0\u05DC\u05E0\u05D3\u05D9\u05D4");
		txtfFinlandia.setHorizontalAlignment(SwingConstants.CENTER);
		txtfFinlandia.setColumns(10);
		txtfFinlandia.setBounds(142, 156, 112, 22);
		panelVodka.add(txtfFinlandia);
		
		txtArk = new JTextField();
		txtArk.setText("\u05E2\u05E8\u05E7");
		txtArk.setHorizontalAlignment(SwingConstants.CENTER);
		txtArk.setEditable(false);
		txtArk.setColumns(10);
		txtArk.setBackground(Color.WHITE);
		txtArk.setBounds(266, 291, 112, 22);
		panelVodka.add(txtArk);
		
		txtVanGoghAsay = new JTextField();
		txtVanGoghAsay.setText("\u05D5\u05D0\u05DF \u05D2\u05D5\u05DA \u05D0\u05E1\u05D0\u05D9");
		txtVanGoghAsay.setHorizontalAlignment(SwingConstants.CENTER);
		txtVanGoghAsay.setEditable(false);
		txtVanGoghAsay.setColumns(10);
		txtVanGoghAsay.setBackground(Color.WHITE);
		txtVanGoghAsay.setBounds(12, 156, 112, 22);
		panelVodka.add(txtVanGoghAsay);
		
		txtToby = new JTextField();
		txtToby.setText("\u05D8\u05D5\u05D1\u05D9 60");
		txtToby.setHorizontalAlignment(SwingConstants.CENTER);
		txtToby.setEditable(false);
		txtToby.setColumns(10);
		txtToby.setBackground(Color.WHITE);
		txtToby.setBounds(142, 291, 112, 22);
		panelVodka.add(txtToby);
		
		txtVanGoghPineapple = new JTextField();
		txtVanGoghPineapple.setText("\u05D5\u05D0\u05DF \u05D2\u05D5\u05DA \u05D0\u05E0\u05E0\u05E1");
		txtVanGoghPineapple.setHorizontalAlignment(SwingConstants.CENTER);
		txtVanGoghPineapple.setEditable(false);
		txtVanGoghPineapple.setColumns(10);
		txtVanGoghPineapple.setBackground(Color.WHITE);
		txtVanGoghPineapple.setBounds(12, 291, 112, 22);
		panelVodka.add(txtVanGoghPineapple);
		
		JLabel labelVodka = new JLabel("\u05D5\u05D5\u05D3\u05E7\u05D4");
		labelVodka.setHorizontalAlignment(SwingConstants.CENTER);
		labelVodka.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelVodka.setBounds(249, 27, 135, 35);
		panelVodka.add(labelVodka);
		
		panelTequila = new JPanel();
		layeredPane.add(panelTequila, "name_130296799059100");
		panelTequila.setLayout(null);
		
		JButton btnOlmkeGold = new JButton("");
		btnOlmkeGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textOlmkeGold.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnOlmkeGold.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Tequila/\u05D8\u05E7\u05D9\u05DC\u05D4 \u05D0\u05D5\u05DC\u05DE\u05E7\u05D4.jpeg")));
		btnOlmkeGold.setBounds(142, 79, 112, 79);
		panelTequila.add(btnOlmkeGold);
		
		JButton btnMazkel = new JButton("");
		btnMazkel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textMazkel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMazkel.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Tequila/\u05DE\u05D6\u05E7\u05DC.jpg")));
		btnMazkel.setBounds(266, 79, 112, 79);
		panelTequila.add(btnMazkel);
		
		JButton btnSilver = new JButton("");
		btnSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textSilver.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSilver.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Tequila/\u05D8\u05E7\u05D9\u05DC\u05D4 \u05E1\u05D9\u05DC\u05D1\u05E8.jpg")));
		btnSilver.setBounds(266, 211, 112, 79);
		panelTequila.add(btnSilver);
		
		JButton btnPatron = new JButton("");
		btnPatron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textPatron.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPatron.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Tequila/\u05D8\u05E7\u05D9\u05DC\u05D4 \u05E4\u05D8\u05E8\u05D5\u05DF.jpg")));
		btnPatron.setBounds(18, 79, 112, 79);
		panelTequila.add(btnPatron);
		
		textMazkel = new JTextField();
		textMazkel.setText("\u05DE\u05D6\u05E7\u05DC");
		textMazkel.setHorizontalAlignment(SwingConstants.CENTER);
		textMazkel.setEditable(false);
		textMazkel.setColumns(10);
		textMazkel.setBackground(Color.WHITE);
		textMazkel.setBounds(266, 157, 112, 22);
		panelTequila.add(textMazkel);
		
		textOlmkeGold = new JTextField();
		textOlmkeGold.setText("\u05D0\u05D5\u05DC\u05DE\u05E7 \u05D2\u05D5\u05DC\u05D3");
		textOlmkeGold.setHorizontalAlignment(SwingConstants.CENTER);
		textOlmkeGold.setEditable(false);
		textOlmkeGold.setColumns(10);
		textOlmkeGold.setBackground(Color.WHITE);
		textOlmkeGold.setBounds(142, 157, 112, 22);
		panelTequila.add(textOlmkeGold);
		
		textPatron = new JTextField();
		textPatron.setText("\u05E4\u05D0\u05D8\u05E8\u05D5\u05DF");
		textPatron.setHorizontalAlignment(SwingConstants.CENTER);
		textPatron.setEditable(false);
		textPatron.setColumns(10);
		textPatron.setBackground(Color.WHITE);
		textPatron.setBounds(18, 157, 112, 22);
		panelTequila.add(textPatron);
		
		textSilver = new JTextField();
		textSilver.setText("\u05E1\u05D9\u05DC\u05D1\u05E8");
		textSilver.setHorizontalAlignment(SwingConstants.CENTER);
		textSilver.setEditable(false);
		textSilver.setColumns(10);
		textSilver.setBackground(Color.WHITE);
		textSilver.setBounds(266, 284, 112, 22);
		panelTequila.add(textSilver);
		
		JLabel labelTeqila = new JLabel("\u05D8\u05E7\u05D9\u05DC\u05D4");
		labelTeqila.setHorizontalAlignment(SwingConstants.CENTER);
		labelTeqila.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelTeqila.setBounds(249, 27, 135, 35);
		panelTequila.add(labelTeqila);
		
		panelWhiskey = new JPanel();
		layeredPane.add(panelWhiskey, "name_130559077003500");
		panelWhiskey.setLayout(null);
		
		JButton btnBlackLable = new JButton("");
		btnBlackLable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtBlackLable.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBlackLable.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Wiskey/\u05D1\u05DC\u05D0\u05E7 \u05DC\u05D9\u05D9\u05D1\u05DC.jpg")));
		btnBlackLable.setBounds(142, 79, 112, 79);
		panelWhiskey.add(btnBlackLable);
		
		JButton btnRedlable = new JButton("");
		btnRedlable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtRedlable.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRedlable.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Wiskey/\u05E8\u05D3 \u05DC\u05D9\u05D9\u05D1\u05DC.jpg")));
		btnRedlable.setBounds(266, 79, 112, 79);
		panelWhiskey.add(btnRedlable);
		
		JButton btnJb = new JButton("");
		btnJb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtJb.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJb.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Wiskey/\u05D5\u05D5\u05D9\u05E1\u05E7\u05D9 jb.jpeg")));
		btnJb.setBounds(266, 211, 112, 79);
		panelWhiskey.add(btnJb);
		
		JButton btnJohnnieWalker = new JButton("");
		btnJohnnieWalker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtJohnnieWalker.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnJohnnieWalker.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Wiskey/\u05D2\u05D5\u05E0\u05D9 \u05D5\u05D5\u05E7\u05E8.png")));
		btnJohnnieWalker.setBounds(18, 79, 112, 79);
		panelWhiskey.add(btnJohnnieWalker);
		
		txtRedlable = new JTextField();
		txtRedlable.setText("\u05E8\u05D3 \u05DC\u05D9\u05D9\u05D1\u05DC");
		txtRedlable.setHorizontalAlignment(SwingConstants.CENTER);
		txtRedlable.setEditable(false);
		txtRedlable.setColumns(10);
		txtRedlable.setBackground(Color.WHITE);
		txtRedlable.setBounds(266, 153, 112, 22);
		panelWhiskey.add(txtRedlable);
		
		txtBlackLable = new JTextField();
		txtBlackLable.setText("\u05D1\u05DC\u05D0\u05E7 \u05DC\u05D9\u05D9\u05D1\u05DC");
		txtBlackLable.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlackLable.setEditable(false);
		txtBlackLable.setColumns(10);
		txtBlackLable.setBackground(Color.WHITE);
		txtBlackLable.setBounds(142, 153, 112, 22);
		panelWhiskey.add(txtBlackLable);
		
		txtJohnnieWalker = new JTextField();
		txtJohnnieWalker.setText("\u05D2'\u05D5\u05E0\u05D9 \u05D5\u05D5\u05E7\u05E8");
		txtJohnnieWalker.setHorizontalAlignment(SwingConstants.CENTER);
		txtJohnnieWalker.setEditable(false);
		txtJohnnieWalker.setColumns(10);
		txtJohnnieWalker.setBackground(Color.WHITE);
		txtJohnnieWalker.setBounds(18, 153, 112, 22);
		panelWhiskey.add(txtJohnnieWalker);
		
		txtJb = new JTextField();
		txtJb.setText("\u05D2'\u05D1");
		txtJb.setHorizontalAlignment(SwingConstants.CENTER);
		txtJb.setEditable(false);
		txtJb.setColumns(10);
		txtJb.setBackground(Color.WHITE);
		txtJb.setBounds(266, 285, 112, 22);
		panelWhiskey.add(txtJb);
		
		JLabel labelWhiskey = new JLabel("\u05D5\u05D5\u05D9\u05E1\u05E7\u05D9");
		labelWhiskey.setHorizontalAlignment(SwingConstants.CENTER);
		labelWhiskey.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelWhiskey.setBounds(249, 27, 135, 35);
		panelWhiskey.add(labelWhiskey);
		
		panelSnacks = new JPanel();
		layeredPane.add(panelSnacks, "name_132245235634699");
		panelSnacks.setLayout(null);
		
		
		JButton btnPickles = new JButton("");
		btnPickles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfPickles.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPickles.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05D7\u05DE\u05D5\u05E6\u05D9\u05DD-1.png")));
		btnPickles.setBounds(142, 79, 112, 79);
		panelSnacks.add(btnPickles);
		
		JButton btnNachos = new JButton("");
		btnNachos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfNachos.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNachos.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05E0\u05D0\u05E6\u05D5\u05E1.jpg")));
		btnNachos.setBounds(266, 79, 112, 79);
		panelSnacks.add(btnNachos);
		
		JButton btnEdamame = new JButton("");
		btnEdamame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfEdamame.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEdamame.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05D0\u05D3\u05DE\u05DE\u05D4.jpg")));
		btnEdamame.setBounds(18, 79, 112, 79);
		panelSnacks.add(btnEdamame);
		
		JButton btnClassicFries = new JButton("");
		btnClassicFries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfClassicFries.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnClassicFries.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05E6\u05D9\u05E4\u05E1.jpg")));
		btnClassicFries.setBounds(266, 211, 112, 79);
		panelSnacks.add(btnClassicFries);
		
		JButton btnSweetPotatoChips = new JButton("");
		btnSweetPotatoChips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfSweetPotatoChips.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSweetPotatoChips.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05D4\u05D5\u05DD \u05E4\u05E8\u05D9\u05D9\u05D6.jpg")));
		btnSweetPotatoChips.setBounds(18, 211, 112, 79);
		panelSnacks.add(btnSweetPotatoChips);
		
		JButton btnCrispySchnitzel = new JButton("");
		btnCrispySchnitzel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtCrispySchnitzel.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCrispySchnitzel.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/snacks/\u05E9\u05E0\u05D9\u05E6\u05DC.png")));
		btnCrispySchnitzel.setBounds(142, 211, 112, 79);
		panelSnacks.add(btnCrispySchnitzel);
		
		txtfPickles = new JTextField();
		txtfPickles.setBackground(Color.WHITE);
		txtfPickles.setEditable(false);
		txtfPickles.setText("\u05D7\u05DE\u05D5\u05E6\u05D9\u05DD");
		txtfPickles.setHorizontalAlignment(SwingConstants.CENTER);
		txtfPickles.setColumns(10);
		txtfPickles.setBounds(142, 156, 112, 22);
		panelSnacks.add(txtfPickles);
		
		txtfNachos = new JTextField();
		txtfNachos.setEditable(false);
		txtfNachos.setBackground(Color.WHITE);
		txtfNachos.setText("\u05E0\u05D0\u05E6'\u05D5\u05E1");
		txtfNachos.setHorizontalAlignment(SwingConstants.CENTER);
		txtfNachos.setColumns(10);
		txtfNachos.setBounds(266, 156, 112, 22);
		panelSnacks.add(txtfNachos);
		
		txtfEdamame = new JTextField();
		txtfEdamame.setBackground(Color.WHITE);
		txtfEdamame.setEditable(false);
		txtfEdamame.setText("\u05D0\u05D3\u05DE\u05DE\u05D4");
		txtfEdamame.setHorizontalAlignment(SwingConstants.CENTER);
		txtfEdamame.setColumns(10);
		txtfEdamame.setBounds(18, 156, 112, 22);
		panelSnacks.add(txtfEdamame);
		
		txtfClassicFries = new JTextField();
		txtfClassicFries.setBackground(Color.WHITE);
		txtfClassicFries.setEditable(false);
		txtfClassicFries.setText("\u05E6'\u05D9\u05E4\u05E1");
		txtfClassicFries.setHorizontalAlignment(SwingConstants.CENTER);
		txtfClassicFries.setColumns(10);
		txtfClassicFries.setBounds(266, 289, 112, 22);
		panelSnacks.add(txtfClassicFries);
		
		txtfSweetPotatoChips = new JTextField();
		txtfSweetPotatoChips.setBackground(Color.WHITE);
		txtfSweetPotatoChips.setEditable(false);
		txtfSweetPotatoChips.setText("\u05D4\u05D5\u05DD \u05E4\u05E8\u05D9\u05D9\u05D6");
		txtfSweetPotatoChips.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSweetPotatoChips.setColumns(10);
		txtfSweetPotatoChips.setBounds(18, 289, 112, 22);
		panelSnacks.add(txtfSweetPotatoChips);
		
		txtCrispySchnitzel = new JTextField();
		txtCrispySchnitzel.setBackground(Color.WHITE);
		txtCrispySchnitzel.setEditable(false);
		txtCrispySchnitzel.setText("\u05E9\u05E0\u05D9\u05E6\u05DC\u05D5\u05E0\u05D9\u05DD");
		txtCrispySchnitzel.setHorizontalAlignment(SwingConstants.CENTER);
		txtCrispySchnitzel.setColumns(10);
		txtCrispySchnitzel.setBounds(142, 289, 112, 22);
		panelSnacks.add(txtCrispySchnitzel);
		
		JLabel labelSnacks = new JLabel("\u05D1\u05E7\u05D8\u05E0\u05D4");
		labelSnacks.setHorizontalAlignment(SwingConstants.CENTER);
		labelSnacks.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelSnacks.setBounds(249, 27, 135, 35);
		panelSnacks.add(labelSnacks);
		
		panelGin = new JPanel();
		layeredPane.add(panelGin, "name_1520049836319518");
		panelGin.setLayout(null);
		
		JButton btnGordons = new JButton("");
		btnGordons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfGordos.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnGordons.setForeground(Color.BLACK);
		btnGordons.setBackground(UIManager.getColor("Button.background"));
		btnGordons.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Gin/\u05D2\u05D9\u05DF \u05D2\u05D5\u05E8\u05D3\u05D5\u05E0\u05E1.png")));
		btnGordons.setBounds(142, 79, 112, 79);
		panelGin.add(btnGordons);
		
		JButton btnTanqueray = new JButton("");
		btnTanqueray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfTanqueray.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTanqueray.setBackground(new Color(255, 255, 255));
		btnTanqueray.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Gin/\u05D2\u05D9\u05DF \u05D8\u05E0\u05E7\u05D9\u05D5\u05E8\u05D0\u05D9.jpg")));
		btnTanqueray.setBounds(266, 79, 112, 79);
		panelGin.add(btnTanqueray);
		
		txtfTanqueray = new JTextField();
		txtfTanqueray.setBackground(Color.WHITE);
		txtfTanqueray.setEditable(false);
		txtfTanqueray.setText("\u05D8\u05E0\u05E7\u05D0\u05D5\u05E8\u05D9");
		txtfTanqueray.setHorizontalAlignment(SwingConstants.CENTER);
		txtfTanqueray.setColumns(10);
		txtfTanqueray.setBounds(266, 156, 112, 22);
		panelGin.add(txtfTanqueray);
		
		txtfGordos = new JTextField();
		txtfGordos.setBackground(Color.WHITE);
		txtfGordos.setEditable(false);
		txtfGordos.setText("\u05D2\u05D5\u05E8\u05D3\u05D5\u05E1");
		txtfGordos.setHorizontalAlignment(SwingConstants.CENTER);
		txtfGordos.setColumns(10);
		txtfGordos.setBounds(142, 156, 112, 22);
		panelGin.add(txtfGordos);
		
		JLabel labelGin = new JLabel("\u05D2'\u05D9\u05DF");
		labelGin.setHorizontalAlignment(SwingConstants.CENTER);
		labelGin.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelGin.setBounds(249, 27, 135, 35);
		panelGin.add(labelGin);
		
		panelBrandy = new JPanel();
		layeredPane.add(panelBrandy, "name_1520515877694412");
		panelBrandy.setLayout(null);
		
		JButton btnBrandyArarat = new JButton("");
		btnBrandyArarat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfBrandyArarat.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBrandyArarat.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Brandy/\u05D1\u05E8\u05E0\u05D3\u05D9 \u05D0\u05E8\u05D0\u05E8\u05D8.jpg")));
		btnBrandyArarat.setBounds(142, 79, 112, 79);
		panelBrandy.add(btnBrandyArarat);
		
		JButton btnCognacCamus = new JButton("");
		btnCognacCamus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,txtfCongncCamus.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCognacCamus.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Brandy/\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7 \u05E7\u05D0\u05DE\u05D5\u05E1.jpeg")));
		btnCognacCamus.setBounds(266, 79, 112, 79);
		panelBrandy.add(btnCognacCamus);
		
		txtfCongncCamus = new JTextField();
		txtfCongncCamus.setBackground(Color.WHITE);
		txtfCongncCamus.setEditable(false);
		txtfCongncCamus.setText("\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7 \u05E7\u05DE\u05D5\u05E1");
		txtfCongncCamus.setHorizontalAlignment(SwingConstants.CENTER);
		txtfCongncCamus.setColumns(10);
		txtfCongncCamus.setBounds(266, 155, 112, 22);
		panelBrandy.add(txtfCongncCamus);
		
		txtfBrandyArarat = new JTextField();
		txtfBrandyArarat.setBackground(Color.WHITE);
		txtfBrandyArarat.setEditable(false);
		txtfBrandyArarat.setText("\u05D1\u05E8\u05E0\u05D3\u05D9 \u05D0\u05E8\u05D0\u05E8\u05EA");
		txtfBrandyArarat.setHorizontalAlignment(SwingConstants.CENTER);
		txtfBrandyArarat.setColumns(10);
		txtfBrandyArarat.setBounds(142, 155, 112, 22);
		panelBrandy.add(txtfBrandyArarat);
		
		JLabel labelBrandy = new JLabel("\u05D1\u05E8\u05E0\u05D3\u05D9/\u05E7\u05D5\u05E0\u05D9\u05D0\u05E7");
		labelBrandy.setHorizontalAlignment(SwingConstants.CENTER);
		labelBrandy.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelBrandy.setBounds(249, 27, 135, 35);
		panelBrandy.add(labelBrandy);
		
		panelRum = new JPanel();
		layeredPane.add(panelRum, "name_1520892232948770");
		panelRum.setLayout(null);
		
		JButton btnBacardi = new JButton("");
		btnBacardi.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Rum/\u05E8\u05D5\u05DD \u05D1\u05E7\u05D0\u05E8\u05D3\u05D9.jpg")));
		btnBacardi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textBacardi.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBacardi.setBounds(142, 79, 112, 79);
		panelRum.add(btnBacardi);
		
		JButton buttonCaptianMorgan = new JButton("");
		buttonCaptianMorgan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textCaptianMorgan.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonCaptianMorgan.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Rum/\u05E8\u05D5\u05DD \u05E7\u05E4\u05D8\u05DF \u05DE\u05D5\u05E8\u05D2\u05DF.jpg")));
		buttonCaptianMorgan.setBounds(266, 79, 112, 79);
		panelRum.add(buttonCaptianMorgan);
		
		JButton btnHavanaClub = new JButton("");
		btnHavanaClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductToTable(dm,textHavanaClub.getText());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnHavanaClub.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Rum/\u05E8\u05D5\u05DD \u05D4\u05D5\u05D5\u05D0\u05E0\u05D4 \u05E7\u05DC\u05D0\u05D1.jpeg")));
		btnHavanaClub.setBounds(18, 79, 112, 79);
		panelRum.add(btnHavanaClub);
		
		textCaptianMorgan = new JTextField();
		textCaptianMorgan.setText("\u05E7\u05E4\u05D8\u05DF \u05DE\u05D5\u05E8\u05D2\u05DF");
		textCaptianMorgan.setHorizontalAlignment(SwingConstants.CENTER);
		textCaptianMorgan.setEditable(false);
		textCaptianMorgan.setColumns(10);
		textCaptianMorgan.setBackground(Color.WHITE);
		textCaptianMorgan.setBounds(266, 155, 112, 22);
		panelRum.add(textCaptianMorgan);

 		textBacardi = new JTextField();
		textBacardi.setText("\u05D1\u05E7\u05D0\u05E8\u05D3\u05D9");
		textBacardi.setHorizontalAlignment(SwingConstants.CENTER);
		textBacardi.setEditable(false);
		textBacardi.setColumns(10);
		textBacardi.setBackground(Color.WHITE);
		textBacardi.setBounds(142, 155, 112, 22);
		panelRum.add(textBacardi);

 		textHavanaClub = new JTextField();
		textHavanaClub.setText("\u05D0\u05D5\u05D5\u05E0\u05D4 \u05E7\u05DC\u05D0\u05D1");
		textHavanaClub.setHorizontalAlignment(SwingConstants.CENTER);
		textHavanaClub.setEditable(false);
		textHavanaClub.setColumns(10);
		textHavanaClub.setBackground(Color.WHITE);
		textHavanaClub.setBounds(18, 155, 112, 22);
		panelRum.add(textHavanaClub);
		
		JLabel labelRum = new JLabel("\u05E8\u05D5\u05DD");
		labelRum.setHorizontalAlignment(SwingConstants.CENTER);
		labelRum.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelRum.setBounds(249, 27, 135, 35);
		panelRum.add(labelRum);
		
		JLabel lblTable = new JLabel("\u05E9\u05D5\u05DC\u05D7\u05DF");
		lblTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblTable.setBounds(423, 45, 82, 30);
		frame.getContentPane().add(lblTable);
		
		textTable = new JTextField();
		textTable.setHorizontalAlignment(SwingConstants.CENTER);
		textTable.setBackground(SystemColor.window);
		textTable.setEditable(false);
		textTable.setBounds(433, 72, 58, 30);
		frame.getContentPane().add(textTable);
		textTable.setColumns(10);
		
		txtWater = new JTextField();
		txtWater.setText("\u05DE\u05D9\u05DD");
		txtWater.setHorizontalAlignment(SwingConstants.CENTER);
		txtWater.setEditable(false);
		txtWater.setColumns(10);
		txtWater.setBackground(Color.WHITE);
		txtWater.setBounds(266, 422, 112, 22);
		panelColdDrink.add(txtWater);

 		txtSpriteZero = new JTextField();
		txtSpriteZero.setText("\u05E1\u05E4\u05E8\u05D9\u05D8 \u05D6\u05D9\u05E8\u05D5");
		txtSpriteZero.setHorizontalAlignment(SwingConstants.CENTER);
		txtSpriteZero.setEditable(false);
		txtSpriteZero.setColumns(10);
		txtSpriteZero.setBackground(Color.WHITE);
		txtSpriteZero.setBounds(144, 422, 112, 22);
		panelColdDrink.add(txtSpriteZero);

 		textSoda = new JTextField();
		textSoda.setEditable(false);
		textSoda.setText("\u05E1\u05D5\u05D3\u05D4");
		textSoda.setHorizontalAlignment(SwingConstants.CENTER);
		textSoda.setColumns(10);
		textSoda.setBackground(Color.WHITE);
		textSoda.setBounds(21, 422, 112, 22);
		panelColdDrink.add(textSoda);

 		textSprite = new JTextField();
		textSprite.setText("\u05E1\u05E4\u05E8\u05D9\u05D8");
		textSprite.setHorizontalAlignment(SwingConstants.CENTER);
		textSprite.setEditable(false);
		textSprite.setColumns(10);
		textSprite.setBackground(Color.WHITE);
		textSprite.setBounds(266, 286, 112, 22);
		panelColdDrink.add(textSprite);

 		textLemoes = new JTextField();
		textLemoes.setText("\u05DC\u05D9\u05DE\u05D5\u05E0\u05D3\u05D4");
		textLemoes.setHorizontalAlignment(SwingConstants.CENTER);
		textLemoes.setEditable(false);
		textLemoes.setColumns(10);
		textLemoes.setBackground(Color.WHITE);
		textLemoes.setBounds(144, 286, 112, 22);
		panelColdDrink.add(textLemoes);

 		textOranges = new JTextField();
		textOranges.setText("\u05EA\u05E4\u05D5\u05D6\u05D9\u05DD");
		textOranges.setHorizontalAlignment(SwingConstants.CENTER);
		textOranges.setEditable(false);
		textOranges.setColumns(10);
		textOranges.setBackground(Color.WHITE);
		textOranges.setBounds(21, 286, 112, 22);
		panelColdDrink.add(textOranges);

 		textMango = new JTextField();
		textMango.setText("\u05DE\u05E0\u05D2\u05D5");
		textMango.setHorizontalAlignment(SwingConstants.CENTER);
		textMango.setEditable(false);
		textMango.setColumns(10);
		textMango.setBackground(Color.WHITE);
		textMango.setBounds(266, 153, 112, 22);
		panelColdDrink.add(textMango);

 		textCola = new JTextField();
		textCola.setText("\u05E7\u05D5\u05DC\u05D4");
		textCola.setHorizontalAlignment(SwingConstants.CENTER);
		textCola.setEditable(false);
		textCola.setColumns(10);
		textCola.setBackground(Color.WHITE);
		textCola.setBounds(144, 153, 112, 22);
		panelColdDrink.add(textCola);

 		textColaZero = new JTextField();
		textColaZero.setText("\u05E7\u05D5\u05DC\u05D4 \u05D6\u05D9\u05E8\u05D5");
		textColaZero.setHorizontalAlignment(SwingConstants.CENTER);
		textColaZero.setEditable(false);
		textColaZero.setColumns(10);
		textColaZero.setBackground(Color.WHITE);
		textColaZero.setBounds(21, 153, 112, 22);
		panelColdDrink.add(textColaZero);
		
		JLabel labelColdDrink = new JLabel("\u05E9\u05EA\u05D9\u05D9\u05D4 \u05E7\u05E8\u05D4");
		labelColdDrink.setHorizontalAlignment(SwingConstants.CENTER);
		labelColdDrink.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelColdDrink.setBounds(249, 27, 135, 35);
		panelColdDrink.add(labelColdDrink);
		
		textNumberOfClients = new JTextField();
		textNumberOfClients.setHorizontalAlignment(SwingConstants.CENTER);
		textNumberOfClients.setEditable(false);
		textNumberOfClients.setColumns(10);
		textNumberOfClients.setBackground(Color.WHITE);
		textNumberOfClients.setBounds(353, 72, 67, 30);
		frame.getContentPane().add(textNumberOfClients);
		
		textWaiter = new JTextField();
		textWaiter.setHorizontalAlignment(SwingConstants.CENTER);
		textWaiter.setEditable(false);
		textWaiter.setColumns(10);
		textWaiter.setBackground(Color.WHITE);
		textWaiter.setBounds(258, 72, 83, 30);
		frame.getContentPane().add(textWaiter);
		
		textComment = new JTextField();
		textComment.setHorizontalAlignment(SwingConstants.CENTER);
		textComment.setEditable(false);
		textComment.setColumns(10);
		textComment.setBackground(Color.WHITE);
		textComment.setBounds(122, 72, 124, 30);
		frame.getContentPane().add(textComment);
		
		btnChooseTable = new JButton("\u05D1\u05D7\u05E8 \u05E9\u05D5\u05DC\u05D7\u05DF");
		btnChooseTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				EmployeMenu.main(null);
			}
		});
		btnChooseTable.setBounds(12, 29, 107, 73);
		frame.getContentPane().add(btnChooseTable);
		
		JLabel label = new JLabel("\u05E1\u05D5\u05E2\u05D3\u05D9\u05DD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(343, 45, 82, 30);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u05DE\u05DC\u05E6\u05E8");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(259, 45, 82, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u05D4\u05E2\u05E8\u05D5\u05EA");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(139, 45, 82, 30);
		frame.getContentPane().add(label_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 115, 526, 458);
		frame.getContentPane().add(scrollPane);
		
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05DE\u05D7\u05D9\u05E8", "\u05DB\u05DE\u05D5\u05EA/\u05DE\u05E9\u05E7\u05DC", "\u05D4\u05E2\u05E8\u05D4", "\u05EA\u05D9\u05D0\u05D5\u05E8", "\u05E9\u05DD \u05DE\u05D5\u05E6\u05E8"
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
		orderTable.getColumnModel().getColumn(0).setResizable(false);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(54);
		orderTable.getColumnModel().getColumn(1).setResizable(false);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(101);
		orderTable.getColumnModel().getColumn(2).setResizable(false);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(155);
		orderTable.getColumnModel().getColumn(3).setResizable(false);
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(162);
		orderTable.getColumnModel().getColumn(4).setResizable(false);
		orderTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane.setViewportView(orderTable);
		
		textSearchInOrder = new JTextField();
		textSearchInOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		textSearchInOrder.setBounds(258, 703, 124, 29);
		frame.getContentPane().add(textSearchInOrder);
		textSearchInOrder.setColumns(10);
		
		JButton btnSearchInOrder = new JButton("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05D1\u05D4\u05D6\u05DE\u05E0\u05D4");
		btnSearchInOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchInOrder();
			}
		});
		btnSearchInOrder.setBounds(411, 703, 122, 28);
		frame.getContentPane().add(btnSearchInOrder);
		
		JButton btndelete = new JButton("");
		btndelete.setIcon(new ImageIcon(OrderManagement.class.getResource("/Image/Buttons/deletButton.jpg")));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					deleteFromTable();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		});
		btndelete.setBounds(219, 584, 80, 70);
		frame.getContentPane().add(btndelete);
		
		textSearchProduct = new JTextField();
		textSearchProduct.setText("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05DE\u05D5\u05E6\u05E8");
		textSearchProduct.setHorizontalAlignment(SwingConstants.CENTER);
		textSearchProduct.setEditable(false);
		textSearchProduct.setColumns(10);
		textSearchProduct.setBackground(Color.WHITE);
		textSearchProduct.setBounds(1053, 660, 85, 22);
		frame.getContentPane().add(textSearchProduct);
		
		textRefrash = new JTextField();
		textRefrash.setText("\u05E8\u05E2\u05E0\u05DF \u05DE\u05E2\u05E8\u05DB\u05EA");
		textRefrash.setHorizontalAlignment(SwingConstants.CENTER);
		textRefrash.setEditable(false);
		textRefrash.setColumns(10);
		textRefrash.setBackground(Color.WHITE);
		textRefrash.setBounds(1150, 661, 78, 22);
		frame.getContentPane().add(textRefrash);
		
		textPrint = new JTextField();
		textPrint.setText("\u05D4\u05D3\u05E4\u05E1 \u05E7\u05D1\u05DC\u05D4");
		textPrint.setHorizontalAlignment(SwingConstants.CENTER);
		textPrint.setEditable(false);
		textPrint.setColumns(10);
		textPrint.setBackground(Color.WHITE);
		textPrint.setBounds(576, 653, 70, 22);
		frame.getContentPane().add(textPrint);
		
		textField = new JTextField();
		textField.setText("\u05D0\u05D6\u05D5\u05E8 \u05EA\u05E9\u05DC\u05D5\u05DD");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(658, 584, 236, 22);
		frame.getContentPane().add(textField);
		
		textSave = new JTextField();
		textSave.setText("\u05E9\u05DE\u05D5\u05E8 \u05D4\u05D6\u05DE\u05E0\u05D4");
		textSave.setHorizontalAlignment(SwingConstants.CENTER);
		textSave.setEditable(false);
		textSave.setColumns(10);
		textSave.setBackground(Color.WHITE);
		textSave.setBounds(463, 653, 70, 22);
		frame.getContentPane().add(textSave);
		
		textField_1 = new JTextField();
		textField_1.setText("\u05DE\u05D7\u05E7 \u05DE\u05D4\u05E7\u05D1\u05DC\u05D4");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(219, 653, 80, 22);
		frame.getContentPane().add(textField_1);
		
		textUpProduct = new JTextField();
		textUpProduct.setText("\u05E2\u05DC\u05D4 \u05DE\u05D5\u05E6\u05E8");
		textUpProduct.setHorizontalAlignment(SwingConstants.CENTER);
		textUpProduct.setEditable(false);
		textUpProduct.setColumns(10);
		textUpProduct.setBackground(Color.WHITE);
		textUpProduct.setBounds(386, 653, 67, 22);
		frame.getContentPane().add(textUpProduct);
		
		textDownProduct = new JTextField();
		textDownProduct.setText("\u05D4\u05D5\u05E8\u05D3 \u05DE\u05D5\u05E6\u05E8");
		textDownProduct.setHorizontalAlignment(SwingConstants.CENTER);
		textDownProduct.setEditable(false);
		textDownProduct.setColumns(10);
		textDownProduct.setBackground(Color.WHITE);
		textDownProduct.setBounds(309, 653, 67, 22);
		frame.getContentPane().add(textDownProduct);
		
		textExit = new JTextField();
		textExit.setText("\u05D9\u05E6\u05D9\u05D0\u05D4");
		textExit.setHorizontalAlignment(SwingConstants.CENTER);
		textExit.setEditable(false);
		textExit.setColumns(10);
		textExit.setBackground(Color.WHITE);
		textExit.setBounds(10, 710, 70, 22);
		frame.getContentPane().add(textExit);
		
		textOpenMgira = new JTextField();
		textOpenMgira.setText("\u05E4\u05EA\u05D7 \u05DE\u05D2\u05D9\u05E8\u05D4");
		textOpenMgira.setHorizontalAlignment(SwingConstants.CENTER);
		textOpenMgira.setEditable(false);
		textOpenMgira.setColumns(10);
		textOpenMgira.setBackground(Color.WHITE);
		textOpenMgira.setBounds(97, 711, 70, 22);
		frame.getContentPane().add(textOpenMgira);
		
		JButton btnCloseOrder = new JButton("\u05E1\u05D2\u05D5\u05E8 \u05E9\u05D5\u05DC\u05D7\u05DF");
		btnCloseOrder.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCloseOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				orderManagmentModuel.erasesAllTableDetails();			
			}
		});
		btnCloseOrder.setBounds(907, 605, 104, 64);
		frame.getContentPane().add(btnCloseOrder);
		
		txtCloseOrder = new JTextField();
		txtCloseOrder.setText("\u05DC\u05E1\u05D9\u05D5\u05DD");
		txtCloseOrder.setHorizontalAlignment(SwingConstants.CENTER);
		txtCloseOrder.setEditable(false);
		txtCloseOrder.setColumns(10);
		txtCloseOrder.setBackground(Color.WHITE);
		txtCloseOrder.setBounds(907, 584, 104, 22);
		frame.getContentPane().add(txtCloseOrder);
		
	}
}
