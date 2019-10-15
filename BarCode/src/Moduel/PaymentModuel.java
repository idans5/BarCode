package Moduel;

import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.FileFunction;
import Classes.dataBaseConfig;
import Windows.OrderManagement;

public class PaymentModuel {
	
	private Random rand;
	private final String filePayment = dataBaseConfig.getPaymentList();
	private Classes.Payment paymentInformation;
	private DefaultTableModel defualTableModel;

	//Dragging dynamically (1-999999) a transaction number
	private String getValidNumberTransaction() throws FileNotFoundException
	{
		rand = new Random();
		int low = 1;
		int high = 999999;
		int result = 0;
			do {
				result = rand.nextInt(high-low) + low;
			}
			while (FileFunction.SearchInFile(filePayment, Integer.toString(result)));
		
		return Integer.toString(result);
	}

	//Write into the database transaction
	public void writeInfoAboutPayments()
	{
		FileFunction.WriteToFile(filePayment, paymentInformation.getNumberOfTransaction());
		FileFunction.WriteToFile(filePayment, paymentInformation.getPaymentMethod());
		FileFunction.WriteToFile(filePayment, paymentInformation.getPaymentAmount());
		FileFunction.WriteToFile(filePayment, paymentInformation.getNumberOfPayments());
	}

	//Making a payment
	public boolean getPayment(String amoutToCharge, String numOfPayments, String CashOrCredit) throws FileNotFoundException
	{
		boolean result = true;
		if(amoutToCharge.equals(""))
		{
			JOptionPane.showMessageDialog(null,"יש להזין סכום לחיוב");
			result = false;
		}
		else
		{
			int charged = Integer.parseInt(amoutToCharge);
			if (OrderManagement.getTotalPrise() - charged >=0)
			{
				OrderManagement.setTotalPrise(OrderManagement.getTotalPrise() - charged);
				OrderManagement.setLabelTotalPrise(Integer.toString(OrderManagement.getTotalPrise()));
				paymentInformation = new Classes.Payment(getValidNumberTransaction(), CashOrCredit, amoutToCharge, numOfPayments);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"עודף" + (charged-OrderManagement.getTotalPrise()));
				paymentInformation = new Classes.Payment(getValidNumberTransaction(), CashOrCredit, Integer.toString(OrderManagement.getTotalPrise()), numOfPayments);
				OrderManagement.setTotalPrise(0);
				OrderManagement.setLabelTotalPrise("0");
			}
			writeInfoAboutPayments();
		}
		return result;
	}
	
	private String[] reverse(final String a[]) 
    { 
        String[] b = new String[a.length]; 
        int j = a.length; 
        for (int i = 0; i < a.length; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    } 
	
	public String getPaymentList(JTable tableTransactionReport)
	{
		defualTableModel = (DefaultTableModel) tableTransactionReport.getModel();
		StringBuilder str = new StringBuilder();
		String[] textToCopy = new String[4];
		int totalPrice = 0;
		for (int i=0;i<FileFunction.GetNumberOfLines(filePayment);i+=4)
		{
			str = FileFunction.ReadLineFromText(filePayment,i , i+3);
			textToCopy = str.toString().split("\n");
			textToCopy = reverse(textToCopy);
			totalPrice += Integer.parseInt(textToCopy[1]);
			defualTableModel.addRow(textToCopy);
		}
		return Integer.toString(totalPrice);
	}
	
}
