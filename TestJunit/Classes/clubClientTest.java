package Classes;
 
import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class clubClientTest {
	private ClubClient lstTest;
    private StringBuilder check = new StringBuilder();
    
    @Before
    public void init() {
    	check.append("123456789" + "\n");
    	check.append("Muli" + "\n");
    	check.append("levi" + "\n");
    	check.append("0562236532" + "\n");
    	check.append("12/1/2019" + "\n");
    	lstTest = new ClubClient(check);
    }
 
    @Test
    public void testClientId() {
        assertEquals("Checking ClientId", "123456789", lstTest.getClientId());
    }
 
    @Test
    public void testFirstName() {
        assertEquals("Checking FirstName", "Muli", lstTest.getClientFirstName());
    }
 
    @Test
    public void testLastName() {
        assertEquals("Checking LastName", "levi", lstTest.getClientLastName());
    }
 
    @Test
    public void testPhoneNumber() {
        assertEquals("Checking PhoneNumber", "0562236532", lstTest.getClientPhoneNumber());
    }
    
    @Test
    public void testDateAdded() {
        assertEquals("Checking DateAdded","12/1/2019", lstTest.getClientDateAdded());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    }
}