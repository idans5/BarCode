package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class reverseTestCCM {

	@Test
	void reversetest() {
		CostumersClubModuel junit = new CostumersClubModuel();
		String[] check = {"moshe" , "mali"};
		String[] resultCheck = {"mali" , "moshe"};
		String[] result = junit.reverse(check);
		assertArrayEquals(resultCheck, result);
	}

}
