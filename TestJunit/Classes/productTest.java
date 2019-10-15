package Classes;

import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class productTest {
	private Product lstTest;
    private StringBuilder check = new StringBuilder();
    
    @Before
    public void init() {
    	check.append("12" + "\n");
    	check.append("beer" + "\n");
    	check.append("מכירה מוקדמת" + "\n");
    	check.append("בירות מהחבית" + "\n");
    	check.append("26" + "\n");
    	check.append("משה משקאות" + "\n");
    	check.append("למכור בבודדים" + "\n");
    	check.append("66" + "\n");
    	lstTest = new Product(check);
    }
 
    @Test
    public void testProuductCode() {
        assertEquals("Checking Prouduct Code", "12", lstTest.getProuductCode());
    }
 
    @Test
    public void testItemName() {
        assertEquals("Checking Item Name", "beer", lstTest.getItemName());
    }
 
    @Test
    public void testItemDescription() {
        assertEquals("Checking Item Description", "מכירה מוקדמת", lstTest.getItemDescription());
    }
 
    @Test
    public void testItemgroup() {
        assertEquals("Checking Itemgroup", "בירות מהחבית" , lstTest.getItemgroup());
    }
    
    @Test
    public void testCurrentPrice() {
        assertEquals("Checking Current Price", "26", lstTest.getCurrentPrice());
    }
    
    @Test
    public void testWarrantyFactor() {
        assertEquals("Checking Warranty Factor","משה משקאות", lstTest.getWarrantyFactor());
    }
    
    @Test
    public void testRemarks() {
        assertEquals("Checking Remarks","למכור בבודדים", lstTest.getRemarks());
    }
    
    @Test
    public void testQuantity() {
        assertEquals("Checking Quantity",66, lstTest.getQuantity());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    }
}