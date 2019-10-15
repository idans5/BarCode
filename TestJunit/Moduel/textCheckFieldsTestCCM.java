package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class textCheckFieldsTestCCM {

	@Test
	void test() {
		CostumersClubModuel junit = new CostumersClubModuel();
		boolean result = junit.checkFields("moshe", "levi", "0526656235", "123456789");
		assertEquals(true, result);
	}

}
