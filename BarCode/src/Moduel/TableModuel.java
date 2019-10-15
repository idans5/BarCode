package Moduel;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import Classes.FileFunction;
import Classes.Table;
import Classes.dataBaseConfig;
import Panels.TablePanel;
import Windows.EmployeMenu;
import Windows.OrderManagement;
import Windows.TableDiscription;

public class TableModuel {
	
	private final String busyTableFile =  dataBaseConfig.getBusyTableFile();
	private Table table;
	
	private void enterDicriptionTabelToDataBase()	
	{
		FileFunction.WriteToFile(busyTableFile, TablePanel.table.getNameOfTable());
		FileFunction.WriteToFile(busyTableFile, TablePanel.table.getNumberOfClientsInTable());
		FileFunction.WriteToFile(busyTableFile, TablePanel.table.getDiscriptionOfClient());
	}
	
	private boolean checkIfSomeOneSit()
	{
		int numLine = 0;
		try {
			numLine = FileFunction.SearchInFilefromFirstLineAndJump(busyTableFile,table.getNameOfTable(),2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			if(numLine!=0)
			{
				String DisOfTable;
				String NumOfClientInTable;
				DisOfTable = FileFunction.ReadLineFromTextToStirng(busyTableFile, numLine+2, numLine+2);
				NumOfClientInTable = FileFunction.ReadLineFromTextToStirng(busyTableFile, numLine+1, numLine+1);
				table.setDiscriptionOfClient(DisOfTable);
				table.setNumberOfClientsInTable(NumOfClientInTable);
				return false;
			}
	
		return true;
	}
	
	public Table pressTableButton(String numOfTable)
	{
		table = null;
		if(EmployeMenu.selectEmployee())
		{
			table = new Table(numOfTable, EmployeMenu.getCurrentEmployee(), null, null, "Tables");
			if(checkIfSomeOneSit())
			{	
				TableDiscription.main(null);
			}
			else
			{
				OrderManagement.main(null);
				OrderManagement.setTable(table);
				EmployeMenu.CloseFrame();
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "לא נבחר שם המלצר");
		}
		return table;
	}
	
	public void pressFinish(String clientDiscription, String numOfClientInTable) {
		TablePanel.table.setDiscriptionOfClient(clientDiscription);
		TablePanel.table.setNumberOfClientsInTable(numOfClientInTable);
		enterDicriptionTabelToDataBase();
		EmployeMenu.CloseFrame();
		OrderManagement.main(null);
		OrderManagement.setTable(TablePanel.table);
	}
}
