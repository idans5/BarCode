package Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import Classes.Employe;
import Moduel.EmployeeModuel;
import Panels.AddEmployee;
import Panels.EditEmployee;
import Panels.FinancialReport;
import Panels.RemoveEmployee;
import Windows.EmployeMenu;
import Windows.ManagerMenu;
import Windows.disconnectEmployee;
import Windows.loginEmployee;

public class EmplotyeeController {
	
	private disconnectEmployee disconnectEmployeeView;
	private EmployeeModuel employeeModuel = new EmployeeModuel();
	private loginEmployee loginEmployeeView;
	private AddEmployee addEmployee;
	private ManagerMenu mangerMenu;
	private RemoveEmployee removeEmployee;
	private EditEmployee editEmployee;
	private Employe employe;
	private FinancialReport financialReport;
	
	public EmplotyeeController(FinancialReport financialReport)
	{
		this.financialReport = financialReport;
		financialReport.setTextFieldSalaryExpenses(employeeModuel.getSalaryExpenses());
	}
	
	public EmplotyeeController(EditEmployee editEmployee)
	{
		this.editEmployee = editEmployee;
		this.editEmployee.EditEmployeeButtonListener(new EditEmployeeButtonListener());
		this.editEmployee.SearchEmployeeButtonListener(new SearchEmployeeButtonListener());
	}
	
	public EmplotyeeController(disconnectEmployee disconnectEmployeeView)
	{
		this.disconnectEmployeeView = disconnectEmployeeView;
		disconnectEmployeeView.disconnectButtonListener(new disconnectButtonListener());
	}
	
	public EmplotyeeController(loginEmployee loginEmployeeView)
	{
		this.loginEmployeeView = loginEmployeeView;
		loginEmployeeView.connectButtonListener(new connectButtonListener());
	}
	
	public EmplotyeeController(AddEmployee addEmployee)
	{
		this.addEmployee = addEmployee;
		this.addEmployee.addEmployeeButtonListener(new addEmployeeButtonListener());
	}
	
	public EmplotyeeController(ManagerMenu mangerMenu)
	{
		this.mangerMenu = mangerMenu;
		this.mangerMenu.ExitAllEmployeeButtonListener(new ExitAllEmployeeButtonListener());
	}
	
	public EmplotyeeController(RemoveEmployee removeEmployee) 
	{
		this.removeEmployee = removeEmployee;
		this.removeEmployee.removeEmployeeButtonListener(new removeEmployeeButtonListener());
	}
	
	class EditEmployeeButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			try {
				employeeModuel.removeEmployee(editEmployee.getTxtFieldId().getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			getFields();
			employeeModuel.editEmployee(employe);
			editEmployee.clearFields();
			editEmployee.setEditableFalse();
		}
		
		public void getFields()
		{
			employe.setEmployeFirstName(editEmployee.getTxtFieldFirstName().getText());
			employe.setEmployeLastName(editEmployee.getTxtFieldLastName().getText());
			employe.setEmployePhoneNumber(editEmployee.getTxtFieldPhone().getText());
			employe.setEmployeSalary(editEmployee.getTxtFieldSalary().getText());
			employe.setEmployeSex(editEmployee.getComboBoxSex().getSelectedItem().toString());
			employe.setEmployeId(editEmployee.getTxtFieldId().getText());
		}
	}
	
	class SearchEmployeeButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			try {
				if (employeeModuel.searchEmployeeById(editEmployee.getTxtFieldId().getText()))
				{
					editEmployee.setEditableTrue();
					setFields();
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}
		
		public void setFields()
		{
			employe = employeeModuel.getEmploye();
			editEmployee.setTxtFieldFirstName(employe.getEmployeFirstName());
			editEmployee.setTxtFieldLastName(employe.getEmployeLastName());
			editEmployee.setTxtFieldPhone(employe.getEmployePhoneNumber());
			editEmployee.setTxtFieldSalary(employe.getEmployeSalary());
			if (employe.getEmployeSex().length() == 3)
			{
				editEmployee.setComboBoxSex(0);
			}
			else
			{
				editEmployee.setComboBoxSex(1);
			}
		}
		
	}
	class removeEmployeeButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			
			if (removeEmployee.getTextFieldId().getText().isEmpty() || removeEmployee.getTextFieldId().getText().length() != 9)
			{
				JOptionPane.showMessageDialog(null, "חובה להכניס תעודת זהות תקינה");
			}
			else
			{
				try {
					if (employeeModuel.searchLineEmployee(removeEmployee.getTextFieldId().getText()) == 0)
					{
						JOptionPane.showMessageDialog(null, "עובד לא קיים במערכת");
					}
					else 
					{
						employeeModuel.removeEmployee(removeEmployee.getTextFieldId().getText());
						JOptionPane.showMessageDialog(null, "עובד נמחק בהצלחה מהמערכת");
					}
				} catch (HeadlessException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				removeEmployee.clearFields();
			}
			
		}
		
	}
	
	class ExitAllEmployeeButtonListener implements ActionListener
	{
		//Disconnects all employees from the system, does not delete them !!
		public void actionPerformed(ActionEvent e) {
			employeeModuel.exitAllEmployees();
		}
		
	}
	
	class disconnectButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			//Disconnect employee from the system
			if (employeeModuel.excuetDisconnectEmployee(disconnectEmployeeView.getTxtFieldID().getText()))
			{
				disconnectEmployeeView.getFrame().dispose();
				EmployeMenu.setButtonDisables();
				EmployeMenu.getEmployee();
			}
		}
		
	}
	
	class connectButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) {
			if (employeeModuel.connectEmployee(loginEmployeeView.getTxtfieldID().getText()))
			{
				loginEmployeeView.getFrame().dispose();
				EmployeMenu.getEmployee();
			}
			else
			{
				loginEmployeeView.getTxtfieldID().setText(null);
			}
			
		}
		
	}
	
	class addEmployeeButtonListener implements ActionListener
	{
		
		private Employe employe;

		public void actionPerformed(ActionEvent arg0) {
			boolean checkFields = employeeModuel.checkFields(addEmployee.getTxtFieldFirstName().getText(),addEmployee.getTxtFieldLastName().getText(), 
					addEmployee.getTxtFieldId().getText(), addEmployee.getTxtFieldPhoneNumber().getText(), addEmployee.getTxtFieldSalary().getText());
			if (checkFields)
			{
				employe = employeeModuel.getEmploye(addEmployee.getTxtFieldFirstName().getText(), addEmployee.getTxtFieldLastName().getText(),
						addEmployee.getComboBoxSex().getSelectedItem().toString(), addEmployee.getTxtFieldId().getText(),
						addEmployee.getTxtFieldSalary().getText(), addEmployee.getTxtFieldPhoneNumber().getText());
				try {
					employeeModuel.addEmployee(employe);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				addEmployee.clearFields();
			}
		}
		
	}
}
