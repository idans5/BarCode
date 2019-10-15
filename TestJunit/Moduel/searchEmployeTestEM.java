package Moduel;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import Classes.Employe;

class searchEmployeTestEM {

	@Test
	void test() throws FileNotFoundException {
		EmployeeModuel junit = new EmployeeModuel();
		StringBuilder stringcheck = new StringBuilder();
		for(int i=0;i<6;i++)
		{
			stringcheck.append("305601833" + "\n");
		}
		Employe employecheck = new Employe(stringcheck);
		boolean result = junit.searchEmploye(employecheck);
		assertEquals(true, result);
	}

}
