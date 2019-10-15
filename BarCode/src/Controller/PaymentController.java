package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Moduel.PaymentModuel;
import Panels.FinancialReport;
import Windows.Payment;

public class PaymentController {
	private Payment PaymentView;
    private PaymentModuel  paymentModuel = new PaymentModuel(); 
    private FinancialReport financialReport;
    
    public PaymentController(Payment PaymentView)
    {
    	this.PaymentView = PaymentView;
    	this.PaymentView.addButtonListener(new ButtonListener());
    }
    
    public PaymentController(FinancialReport financialReport)
    {
    	this.financialReport = financialReport;
		String getTotalPrice = paymentModuel.getPaymentList(financialReport.getTableTransactionReport());
		financialReport.setTextFieldTotalIncomeFromSales(getTotalPrice);
    }
    
    class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				if (paymentModuel.getPayment(PaymentView.getTxtAmountToCharge().getText(), PaymentView.getTxtNumOfPayments().getText(),PaymentView.getCashOrCredit()))
				{
					PaymentView.getFrame().dispose();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
    }
    
}
