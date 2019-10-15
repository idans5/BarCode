package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class searchLineEmployeeTestEM {

	@Test
	void test() throws FileNotFoundException {
		EmployeeModuel junit = new EmployeeModuel();
		int check =0;
		int result = junit.searchLineEmployee("305601833");
		assertNotEquals(check, result);
	}

}
