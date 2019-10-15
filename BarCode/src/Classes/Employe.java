package Classes;

public class Employe {
	
	private String employeFirstName;
	private String employeLastName;
	private String employeSex;
	private String employeId;
	private String employeSalary;
	private String employePhoneNumber;
	
	public Employe(StringBuilder builder) 
	{
		String[] lines = builder.toString().split("\\n");
		
		this.employeFirstName = lines[0];
		this.employeLastName = lines[1];
		this.employeSex = lines[2];
		this.employeId = lines[3];
		this.employeSalary = lines[4];
		this.employePhoneNumber = lines[5];
	}
	
	public String getEmployeFirstName() {
		return employeFirstName;
	}
	
	public void setEmployeFirstName(String employeFirstName) {
		this.employeFirstName = employeFirstName;
	}
	
	public String getEmployeLastName() {
		return employeLastName;
	}
	
	public void setEmployeLastName(String employeLastName) {
		this.employeLastName = employeLastName;
	}
	
	public String getEmployeSex() {
		return employeSex;
	}
	
	public void setEmployeSex(String employeSex) {
		this.employeSex = employeSex;
	}
	
	public String getEmployeId() {
		return employeId;
	}
	
	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}
	
	public String getEmployeSalary() {
		return employeSalary;
	}
	
	public void setEmployeSalary(String employeSalary) {
		this.employeSalary = employeSalary;
	}

	public String getEmployePhoneNumber() {
		return employePhoneNumber;
	}

	public void setEmployePhoneNumber(String employePhoneNumber) {
		this.employePhoneNumber = employePhoneNumber;
	}
	
}
