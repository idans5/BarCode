package Classes;

public class Payment 
{
	private String numberOfTransaction;
	private String paymentMethod;
	private String paymentAmount;
	private String numberOfPayments;
	
	public Payment(String numberOfTranasction, String paymentMethod, String paymentAmount, String numberOfPayments)
	{
		this.numberOfTransaction = numberOfTranasction;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.numberOfPayments = numberOfPayments;
	}
	
	public String getNumberOfTransaction() {
		return numberOfTransaction;
	}
	public void setNumberOfTransaction(String numberOfTransaction) {
		this.numberOfTransaction = numberOfTransaction;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getNumberOfPayments() {
		return numberOfPayments;
	}
	public void setNumberOfPayments(String numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}
	

	
}	
