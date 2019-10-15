package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.EmplotyeeController;
import Controller.PaymentController;

import javax.swing.JTextField;

public class FinancialReport extends JPanel {
	
	private JTable tableTransactionReport;
	private JTextField textFieldTotalIncomeFromSales;
	private JTextField textFieldSalaryExpenses;
	private JTextField textFieldFinalProfit;
	private PaymentController paymentController;
	private EmplotyeeController emplotyeeController;

	
	public void setTextFieldSalaryExpenses(String textFieldSalaryExpenses) {
		this.textFieldSalaryExpenses.setText(textFieldSalaryExpenses);
	}


	public JTable getTableTransactionReport() {
		return tableTransactionReport;
	}


	public void setTextFieldTotalIncomeFromSales(String textFieldTotalIncomeFromSales) {
		this.textFieldTotalIncomeFromSales.setText(textFieldTotalIncomeFromSales);
	}
	
	
	private void setFinalProfit()
	{
		int finalProfit = 0; 
		if (textFieldTotalIncomeFromSales.getText().length() != 0)
		{
			finalProfit += Integer.parseInt(textFieldTotalIncomeFromSales.getText());
		}
		if (textFieldSalaryExpenses.getText().length() != 0)
		{
			finalProfit -= Integer.parseInt(textFieldSalaryExpenses.getText());
		}
		
		textFieldFinalProfit.setText(Integer.toString(finalProfit));
	}
	
	/**
	 * Create the panel.
	 */
	public FinancialReport() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u05D3\u05D5\u05D7 \u05DB\u05E1\u05E4\u05D9\u05DD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(395, 29, 214, 57);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 111, 831, 204);
		add(scrollPane);
		
		tableTransactionReport = new JTable();
		tableTransactionReport.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05DE\u05E1\u05E4\u05E8 \u05EA\u05E9\u05DC\u05D5\u05DE\u05D9\u05DD", "\u05E1\u05DB\u05D5\u05DD \u05EA\u05E9\u05DC\u05D5\u05DD", "\u05E1\u05D5\u05D2 \u05EA\u05E9\u05DC\u05D5\u05DD", "\u05DE\u05E1\u05E4\u05E8 \u05E2\u05E1\u05E7\u05D4"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTransactionReport.getColumnModel().getColumn(0).setPreferredWidth(95);
		tableTransactionReport.getColumnModel().getColumn(1).setResizable(false);
		tableTransactionReport.getColumnModel().getColumn(1).setPreferredWidth(93);
		tableTransactionReport.getColumnModel().getColumn(2).setResizable(false);
		tableTransactionReport.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableTransactionReport.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(tableTransactionReport);
		
		JLabel lblNewLabel_1 = new JLabel("\u05E1\u05D4\"\u05DB \u05D4\u05DB\u05E0\u05E1\u05D4 \u05DE\u05DE\u05DB\u05D9\u05E8\u05D5\u05EA:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(242, 338, 172, 29);
		add(lblNewLabel_1);
		
		textFieldTotalIncomeFromSales = new JTextField();
		textFieldTotalIncomeFromSales.setEditable(false);
		textFieldTotalIncomeFromSales.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTotalIncomeFromSales.setBounds(103, 344, 129, 19);
		add(textFieldTotalIncomeFromSales);
		textFieldTotalIncomeFromSales.setColumns(10);
		
		JLabel label = new JLabel("\u05E1\u05D4\"\u05DB \u05D4\u05D5\u05E6\u05D0\u05D5\u05EA \u05E2\u05D5\u05D1\u05D3\u05D9\u05DD:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(720, 406, 172, 29);
		add(label);
		
		textFieldSalaryExpenses = new JTextField();
		textFieldSalaryExpenses.setEditable(false);
		textFieldSalaryExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSalaryExpenses.setColumns(10);
		textFieldSalaryExpenses.setBounds(581, 412, 129, 19);
		add(textFieldSalaryExpenses);
		
		JLabel label_1 = new JLabel("\u05E8\u05D5\u05D5\u05D7 \u05E1\u05D5\u05E4\u05D9:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(720, 455, 172, 29);
		add(label_1);
		
		textFieldFinalProfit = new JTextField();
		textFieldFinalProfit.setEditable(false);
		textFieldFinalProfit.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFinalProfit.setColumns(10);
		textFieldFinalProfit.setBounds(581, 461, 129, 19);
		add(textFieldFinalProfit);

		paymentController = new PaymentController(this);
		emplotyeeController = new EmplotyeeController(this);
		setFinalProfit();
	}
}
