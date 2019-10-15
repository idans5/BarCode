package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class connectEmployeeTestEM {

	@Test
	void test() {
		EmployeeModuel junit = new EmployeeModuel();
		boolean result = junit.excuetDisconnectEmployee("305601833");
		assertEquals(false, result);
	}

}
