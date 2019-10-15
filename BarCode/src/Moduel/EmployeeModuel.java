package Moduel;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Classes.Employe;
import Classes.FileFunction;
import Classes.dataBaseConfig;
import Windows.EmployeMenu;

public class EmployeeModuel {

	private final String fileEmployee = dataBaseConfig.getEmployeeFile();
	private final String fileConnectedEmployee = dataBaseConfig.getConnectedEmployeeFile();
	private final String employeeWorkingTimeFile = dataBaseConfig.getEmployeeWorkingTimeFile();
	private StringBuilder stringBuilder;
	private Employe employe;
	
	
	public Employe getEmploye() {
		return employe;
	}

	public Employe getEmploye(String firstName, String lastName, String sex, String id, String salary, String phoneNumber)
	{
		stringBuilder = new StringBuilder();
		stringBuilder.append(firstName + "\n");
		stringBuilder.append(lastName + "\n");
		stringBuilder.append(sex  + "\n");
		stringBuilder.append(id + "\n");
		stringBuilder.append(salary + "\n");
		stringBuilder.append(phoneNumber + "\n");
		employe = new Employe(stringBuilder);
		return employe;
	}

	public boolean searchEmploye(Employe employe) throws FileNotFoundException
	{
		boolean result = false;
		File file = new File(fileEmployee);
		if (file.exists() == true)
		{
			if (FileFunction.SearchInFile(fileEmployee, employe.getEmployeId()) == true)
			{
				result = true;
			}
			else 
			{
				result = false;
			}
		}
		else 
		{
			result = false;
		}
		return result;
	}
	
	public void addEmployee(Employe employe) throws FileNotFoundException
	{
		boolean result = searchEmploye(employe);
		if (result)
		{
			JOptionPane.showMessageDialog(null, "עובד קיים במערכת");
		}
		else 
		{
			FileFunction.WriteToFile(fileEmployee, employe.getEmployeFirstName());
			FileFunction.WriteToFile(fileEmployee, employe.getEmployeLastName());
			FileFunction.WriteToFile(fileEmployee, employe.getEmployeSex());
			FileFunction.WriteToFile(fileEmployee, employe.getEmployeId());
			FileFunction.WriteToFile(fileEmployee, employe.getEmployeSalary());
			FileFunction.WriteToFile(fileEmployee, employe.getEmployePhoneNumber());
			JOptionPane.showMessageDialog(null, "עובד הוסף בהצלחה");
		}
	}
	
	public void editEmployee(Employe employe)
	{
		FileFunction.WriteToFile(fileEmployee, employe.getEmployeFirstName());
		FileFunction.WriteToFile(fileEmployee, employe.getEmployeLastName());
		FileFunction.WriteToFile(fileEmployee, employe.getEmployeSex());
		FileFunction.WriteToFile(fileEmployee, employe.getEmployeId());
		FileFunction.WriteToFile(fileEmployee, employe.getEmployeSalary());
		FileFunction.WriteToFile(fileEmployee, employe.getEmployePhoneNumber());
		JOptionPane.showMessageDialog(null, "עובד נערך בהצלחה");
	}
	
	public void removeEmployee(String id) throws FileNotFoundException
	{
		int lineNumber = searchLineEmployee(id);
		FileFunction.DeleteFromText(fileEmployee, lineNumber-4, lineNumber+2);
	}
	
	public int searchLineEmployee(String id) throws FileNotFoundException
	{
		int lineNumber = FileFunction.SearchStringAndReturnLine(fileEmployee, id);
		return lineNumber;
	}
	
	public Employe getEmployeFromDataBase(int line)
	{
		stringBuilder = FileFunction.ReadLineFromText(fileEmployee, line-4, line+1);
		employe = new Employe(stringBuilder);
		return employe;
	}
	
	private String getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        return sdf.format(cal.getTime());
	}
	
	//Disconnect employee from the system
	public boolean excuetDisconnectEmployee(String id)
	{
		int lineNumber = 0 ; 
		boolean result = true;
		try {
			if ((lineNumber = FileFunction.SearchStringAndReturnLine(fileConnectedEmployee, id)) == 0)
			{
				JOptionPane.showMessageDialog(null, "עובד אינו בתוך המערכת");
				result = false;
			}
			else
			{
				FileFunction.DeleteFromText(fileConnectedEmployee, lineNumber-4, lineNumber+2);
				FileFunction.WriteToFile(employeeWorkingTimeFile, "Disconnected");
				FileFunction.WriteToFile(employeeWorkingTimeFile, id);
				FileFunction.WriteToFile(employeeWorkingTimeFile, getCurrentDate());
				FileFunction.WriteToFile(employeeWorkingTimeFile, EmployeMenu.getCurrentTimefromlbl());	
			}
		} catch (FileNotFoundException e1) {
			System.out.println("Error: Catch");
		}
		
		return result;
	}
	
	public boolean connectEmployee(String id)
	{
		
		File file = new File(fileConnectedEmployee);
		File file2 = new File(employeeWorkingTimeFile);
		int lineNumber = 0;
		boolean result = true;
		try {
			if(id.length() != 9)
			{
				JOptionPane.showMessageDialog(null, "תעודת זהות אינה חוקית");
				result = false;
			}
			else if ((lineNumber = FileFunction.SearchStringAndReturnLine(fileEmployee, id)) != 0)
			{
				if ((file.exists() == false) ||(file2.exists() == false)|| (FileFunction.SearchInFile(fileConnectedEmployee, id) == false))
				{
					int startLine = lineNumber-4;
					int endLine = lineNumber+1;
					StringBuilder builder ;
					builder = FileFunction.ReadLineFromText(fileEmployee, startLine, endLine);
					employe = new Employe(builder);
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployeFirstName());
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployeLastName());
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployeSex());
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployeId());
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployeSalary());
					FileFunction.WriteToFile(fileConnectedEmployee, employe.getEmployePhoneNumber());
					FileFunction.WriteToFile(employeeWorkingTimeFile, "Connected");
					FileFunction.WriteToFile(employeeWorkingTimeFile, employe.getEmployeId());
					FileFunction.WriteToFile(employeeWorkingTimeFile, getCurrentDate());
					FileFunction.WriteToFile(employeeWorkingTimeFile, EmployeMenu.getCurrentTimefromlbl());	
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "עובד מחובר כבר למערכת");
					result = false;
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "לא נמצא עובד המתאים לתעודת זהות");
				result = false;
			}
			} catch (FileNotFoundException e1) {
				System.out.println("Error:: loginEmployee/connect");
			}
		return result;
	}
	
	public boolean checkFields(String firstName, String lastName, String id, String phoneNumber, String salary)
	{
		boolean result = false;
		if (firstName.length() < 2)
		{
			JOptionPane.showMessageDialog(null, "שם של עובד לא יכול להכיל פחות מ2 תווים");
		}
		else if (id.length() != 9)
		{
			JOptionPane.showMessageDialog(null, "תעודת זהות לא תקינה");
		}
		else if (lastName.length() < 2)
		{
			JOptionPane.showMessageDialog(null, "שם משפחה של עובד לא יכול להכיל פחות מ2 תווים");
		}
		else if (phoneNumber.length() < 10)
		{
			JOptionPane.showMessageDialog(null, "מספר פלאפון לא יכול להכיל פחות מ10 תווים");
		}
		else if (salary.length()<0)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס גודל שכר");
		}
		else 
		{
			result = true;
		}
		return result;
			
	}
	
	public String getSalaryExpenses() 
	{
		int salaryExpenses = 0;
		for (int i=0;i<FileFunction.GetNumberOfLines(dataBaseConfig.getEmployeeFile());i+=6)
		{
			employe = new Employe(FileFunction.ReadLineFromText(dataBaseConfig.getEmployeeFile(),i , i+5));
			salaryExpenses += Integer.parseInt(employe.getEmployeSalary());
		}
		
		return Integer.toString(salaryExpenses);
	}
	
	public void setLoginEmployee(JButton[] arrayOfButtons)
	{
		int startLine = 0;
		int endLine = 5;
		StringBuilder builder ;
		int index = 0;
		
		for (int i=endLine;i<FileFunction.GetNumberOfLines(fileConnectedEmployee);i+=6)
		{
			builder = FileFunction.ReadLineFromText(fileConnectedEmployee, startLine, endLine);
			employe = new Employe(builder);
			arrayOfButtons[index].setVisible(true);
			arrayOfButtons[index].setText(employe.getEmployeFirstName());
			index++;
			startLine +=6;
			endLine +=6;
		}
	}
	

	//Disconnects all employees from the system, does not delete them !!
	public void exitAllEmployees()
	{
		if (FileFunction.GetNumberOfLines(fileConnectedEmployee)<1)
		{
			JOptionPane.showMessageDialog(null, "אין עובדים מחוברים");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "כל העובדים נותקו");
			FileFunction.DeleteFromText(fileConnectedEmployee ,0,FileFunction.GetNumberOfLines(fileConnectedEmployee)+1);
		}
	}
	
	public boolean searchEmployeeById(String id) throws FileNotFoundException
	{
		boolean result = false;
		if (id.length() == 9)
		{
			int line = searchLineEmployee(id);
			if (line != 0)
			{
				employe = getEmployeFromDataBase(line);
				result = true;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "עובד אינו קיים");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "תעודת זהות אינה תקינה");
		}
		
		return result;
	}
	
}
