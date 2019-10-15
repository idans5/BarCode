package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class excuetDisconnectEmployeeTestEM {
	//Disconnect employee from the system
	@Test
	void test() {
		EmployeeModuel junit = new EmployeeModuel();
		boolean result = junit.excuetDisconnectEmployee("206229924");
		assertEquals(false, result);
	}

}
