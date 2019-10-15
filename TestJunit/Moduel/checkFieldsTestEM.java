package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class checkFieldsTestEM {

	@Test
	void test() {
		EmployeeModuel junit = new EmployeeModuel();
		boolean result = junit.checkFields("moshe", "levi", "123456789", "0536659658", "10000");
		assertEquals(true, result);
	}

}
