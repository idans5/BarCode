package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import Classes.ClubClient;

class searchClientTestCCM {

	@Test
	void test() throws FileNotFoundException {
		CostumersClubModuel junit = new CostumersClubModuel();
		StringBuilder stringcheck = new StringBuilder();
		for(int i=0;i<5;i++)
		{
			stringcheck.append("123456789" + "\n");
		}
		ClubClient clubcheck = new ClubClient(stringcheck);
		boolean result = junit.searchClient(clubcheck);
		assertEquals(true, result);
	}

}
