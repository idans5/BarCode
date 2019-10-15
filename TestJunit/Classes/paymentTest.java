package Classes;

import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class paymentTest {
	private Payment lstTest;
    
    @Before
    public void init() {
    	lstTest = new Payment("5","10","20","25");
    }
 
    @Test
    public void testNumberOfTransactionr() {
        assertEquals("Checking Number Of Transaction", "5", lstTest.getNumberOfTransaction());
    }
 
    @Test
    public void testPaymentMethod() {
        assertEquals("Checking Payment Method", "10", lstTest.getPaymentMethod());
    }
    
    @Test
    public void testPaymentAmount() {
        assertEquals("Checking Payment Amount", "20", lstTest.getPaymentAmount());
    }
    
    @Test
    public void testNumberOfPayments() {
        assertEquals("Checking Number Of Payments", "25", lstTest.getNumberOfPayments());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    }
}