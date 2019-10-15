package Windows;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import Classes.Product;
import Controller.ProductController;
import javax.swing.JTextField;
import java.awt.Color;


public class ProductMenu {

	private JFrame frame;
	private JTextField textSearchTitleItemName;
	private JTextField txtItemName;
	private JTextField txtProductCode;
	private JTextField txtItemDescription;
	private JTextField txtGroupProduct;
	private JTextField txtCurrentPrice;
	private JTextField txtWarrantyFactor;
	private JTextField txtRemarks;
	private JTextField txtQuntity;
	private JLabel lblSearchPic;
	private JTextField textSearch;
	private JButton btnSearch;
	private ProductController productController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMenu window = new ProductMenu();
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
	public ProductMenu() throws FileNotFoundException   {
		initialize();
		productController = new ProductController(this);
	}
	
	public JTextField getTextSearchTitleItemName() {
		return textSearchTitleItemName;
	}
	
	public void getFields(Product product)
	{
		txtProductCode.setText(product.getProuductCode());  
		txtItemName.setText(product.getItemName());
		txtItemDescription.setText(product.getItemDescription());
		txtGroupProduct.setText(product.getItemgroup());
		txtCurrentPrice.setText(product.getCurrentPrice());
		txtWarrantyFactor.setText(product.getWarrantyFactor());
		txtRemarks.setText(product.getRemarks());
		txtQuntity.setText(Integer.toString(product.getQuantity()));
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05DE\u05D5\u05E6\u05E8\r\n");
		frame.setResizable(false);
		frame.setBounds(100, 100, 491, 507);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 
		
		JLabel lblTitleProductCode = new JLabel("\u05E7\u05D5\u05D3 \u05E4\u05E8\u05D9\u05D8:");
		lblTitleProductCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleProductCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleProductCode.setBounds(330, 133, 107, 34);
		frame.getContentPane().add(lblTitleProductCode);
		
		JLabel lblTitleItemName = new JLabel("\u05E9\u05DD \u05E4\u05E8\u05D9\u05D8:");
		lblTitleItemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleItemName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleItemName.setBounds(352, 89, 85, 33);
		frame.getContentPane().add(lblTitleItemName);
		
		JLabel lblTitleItemDescription = new JLabel("\u05EA\u05D9\u05D0\u05D5\u05E8 \u05E4\u05E8\u05D9\u05D8:");
		lblTitleItemDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleItemDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleItemDescription.setBounds(314, 177, 123, 33);
		frame.getContentPane().add(lblTitleItemDescription);
		
		JLabel lblTitleItemgroup = new JLabel("\u05E7\u05D1\u05D5\u05E6\u05EA \u05E4\u05E8\u05D9\u05D8\u05D9\u05DD:");
		lblTitleItemgroup.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleItemgroup.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleItemgroup.setBounds(335, 218, 102, 33);
		frame.getContentPane().add(lblTitleItemgroup);
		
		JLabel lblTitleCurrentPrice = new JLabel("\u05DE\u05D7\u05D9\u05E8 \u05E4\u05E8\u05D9\u05D8:");
		lblTitleCurrentPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleCurrentPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleCurrentPrice.setBounds(352, 260, 85, 33);
		frame.getContentPane().add(lblTitleCurrentPrice);
		
		JLabel lblTitleWarrantyFactor = new JLabel("\u05D9\u05D1\u05D5\u05D0\u05DF:");
		lblTitleWarrantyFactor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleWarrantyFactor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleWarrantyFactor.setBounds(335, 304, 102, 33);
		frame.getContentPane().add(lblTitleWarrantyFactor);
		
		JLabel lblTitleRemarks = new JLabel("\u05D4\u05E2\u05E8\u05D5\u05EA:");
		lblTitleRemarks.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTitleRemarks.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleRemarks.setBounds(302, 351, 135, 33);
		frame.getContentPane().add(lblTitleRemarks);
		
		JLabel lblTitleItemNameSearch = new JLabel("\u05D4\u05DB\u05E0\u05E1 \u05E9\u05DD \u05E4\u05E8\u05D9\u05D8 \u05DC\u05D7\u05D9\u05E4\u05D5\u05E9:");
		lblTitleItemNameSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTitleItemNameSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleItemNameSearch.setToolTipText("");
		lblTitleItemNameSearch.setBounds(314, 21, 151, 44);
		frame.getContentPane().add(lblTitleItemNameSearch);
		
		textSearchTitleItemName = new JTextField();
		textSearchTitleItemName.setHorizontalAlignment(SwingConstants.RIGHT);
		textSearchTitleItemName.setBounds(147, 29, 157, 31);
		frame.getContentPane().add(textSearchTitleItemName);
		textSearchTitleItemName.setColumns(10);
		
		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(ProductMenu.class.getResource("/Image/Buttons/searchButton.png")));
		btnSearch.setBounds(35, 11, 85, 78);
		frame.getContentPane().add(btnSearch);
		
		txtItemName = new JTextField();
		txtItemName.setHorizontalAlignment(SwingConstants.RIGHT);
		txtItemName.setBackground(Color.WHITE);
		txtItemName.setEditable(false);
		txtItemName.setBounds(218, 95, 129, 20);
		frame.getContentPane().add(txtItemName);
		txtItemName.setColumns(10);
		
		txtProductCode = new JTextField();
		txtProductCode.setHorizontalAlignment(SwingConstants.RIGHT);
		txtProductCode.setBackground(Color.WHITE);
		txtProductCode.setEditable(false);
		txtProductCode.setColumns(10);
		txtProductCode.setBounds(218, 140, 129, 20);
		frame.getContentPane().add(txtProductCode);
		
		txtItemDescription = new JTextField();
		txtItemDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		txtItemDescription.setBackground(Color.WHITE);
		txtItemDescription.setEditable(false);
		txtItemDescription.setColumns(10);
		txtItemDescription.setBounds(147, 183, 201, 20);
		frame.getContentPane().add(txtItemDescription);
		
		txtGroupProduct = new JTextField();
		txtGroupProduct.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGroupProduct.setBackground(Color.WHITE);
		txtGroupProduct.setEditable(false);
		txtGroupProduct.setColumns(10);
		txtGroupProduct.setBounds(218, 224, 129, 20);
		frame.getContentPane().add(txtGroupProduct);
		
		txtRemarks = new JTextField();
		txtRemarks.setHorizontalAlignment(SwingConstants.RIGHT);
		txtRemarks.setBackground(Color.WHITE);
		txtRemarks.setEditable(false);
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(146, 357, 201, 20);
		frame.getContentPane().add(txtRemarks);
		
		txtCurrentPrice = new JTextField();
		txtCurrentPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCurrentPrice.setBackground(Color.WHITE);
		txtCurrentPrice.setEditable(false);
		txtCurrentPrice.setColumns(10);
		txtCurrentPrice.setBounds(218, 266, 129, 20);
		frame.getContentPane().add(txtCurrentPrice);
		
		txtWarrantyFactor = new JTextField();
		txtWarrantyFactor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWarrantyFactor.setBackground(Color.WHITE);
		txtWarrantyFactor.setEditable(false);
		txtWarrantyFactor.setColumns(10);
		txtWarrantyFactor.setBounds(218, 310, 129, 20);
		frame.getContentPane().add(txtWarrantyFactor);
		
		JLabel lblQuntity = new JLabel("\u05DB\u05DE\u05D5\u05EA:");
		lblQuntity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuntity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuntity.setBounds(302, 395, 135, 33);
		frame.getContentPane().add(lblQuntity);
		
		txtQuntity = new JTextField();
		txtQuntity.setHorizontalAlignment(SwingConstants.RIGHT);
		txtQuntity.setEditable(false);
		txtQuntity.setColumns(10);
		txtQuntity.setBackground(Color.WHITE);
		txtQuntity.setBounds(218, 401, 129, 20);
		frame.getContentPane().add(txtQuntity);
		
		lblSearchPic = new JLabel("");
		lblSearchPic.setIcon(new ImageIcon(ProductMenu.class.getResource("/Image/search.jpg")));
		lblSearchPic.setBounds(21, 218, 151, 128);
		frame.getContentPane().add(lblSearchPic);
		
		textSearch = new JTextField();
		textSearch.setText("\u05D7\u05D9\u05E4\u05D5\u05E9 \u05DE\u05D5\u05E6\u05E8");
		textSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textSearch.setEditable(false);
		textSearch.setColumns(10);
		textSearch.setBackground(Color.WHITE);
		textSearch.setBounds(35, 89, 85, 22);
		frame.getContentPane().add(textSearch);
						
	}
	public void SearchButtonListener(ActionListener listenerForButton)
	{
		btnSearch.addActionListener(listenerForButton);
	}
}
