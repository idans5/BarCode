package Classes;

import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class orderTest {
	private Order lstTest;
    
    @Before
    public void init() {
    	lstTest = new Order("15","500");
    }
 
    @Test
    public void testTableNumber() {
        assertEquals("Checking Table Number", "15", lstTest.getTableNumber());
    }
 
    @Test
    public void testTotalPrice() {
        assertEquals("Checking Tota lPrice", "500", lstTest.getTableTotalPrice());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    }
}