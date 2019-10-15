package Classes;

import static org.junit.Assert.assertEquals;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class employeTest {
	private Employe lstTest;
    private StringBuilder check = new StringBuilder();
    
    @Before
    public void init() {
    	check.append("Muli" + "\n");
    	check.append("levi" + "\n");
    	check.append("זכר" + "\n");
    	check.append("123456789" + "\n");
    	check.append("10000" + "\n");
    	check.append("0503323265" + "\n");
    	lstTest = new Employe(check);
    }
 
    @Test
    public void testFirstName() {
        assertEquals("Checking First Name", "Muli", lstTest.getEmployeFirstName());
    }
 
    @Test
    public void testLastName() {
        assertEquals("Checking Last Name", "levi", lstTest.getEmployeLastName());
    }
 
    @Test
    public void testEmployeSex() {
        assertEquals("Checking Employe Sex", "זכר", lstTest.getEmployeSex());
    }
 
    @Test
    public void testEmployeId() {
        assertEquals("Checking Employe Id", "123456789" , lstTest.getEmployeId());
    }
    
    @Test
    public void testSalary() {
        assertEquals("Checking Salary", "10000", lstTest.getEmployeSalary());
    }
    
    @Test
    public void testPhoneNumber() {
        assertEquals("Checking PhoneNumber","0503323265", lstTest.getEmployePhoneNumber());
    }
 
    @After
    public void destroy() {
    	lstTest = null;
    }
}