package Classes;

import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class tableTest {
	private Table lstTest;
	private Employe checkTest;
	
    private StringBuilder check = new StringBuilder();
    
    @Before
    public void init() {
    	check.append("Muli" + "\n");
    	check.append("levi" + "\n");
    	check.append("זכר" + "\n");
    	check.append("123456789" + "\n");
    	check.append("10000" + "\n");
    	check.append("0503323265" + "\n");
    	checkTest = new Employe(check);
    	lstTest = new Table("5",checkTest , "גבוה","8","בר");
    }
 
    @Test
    public void testNameOfTable() {
        assertEquals("Checking Name Of Table", "5", lstTest.getNameOfTable());
    }
 
    @Test
    public void testDiscriptionOfClient() {
        assertEquals("Checking Discription Of Client", "גבוה", lstTest.getDiscriptionOfClient());
    }
    
    @Test
    public void testNumberOfClientsInTable() {
        assertEquals("Checking Number Of Clients In Table", "8", lstTest.getNumberOfClientsInTable());
    }
    
    @Test
    public void testAreaOfTable() {
        assertEquals("Checking Area Of Table", "בר", lstTest.getAreaOfTable());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    	checkTest = null;
    }
}