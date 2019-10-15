package Classes;

public class Table {
	
	private String nameOfTable;  //only Numbers
	private Employe employee;
	private String discriptionOfClient;
	private String numberOfClientsInTable;
	private String areaOfTable;
	
	
	public Table(String nameOfTable, Employe employee, String discriptionOfClient,
			String numberOfClientsInTable, String areaOfTable) 
	{
		this.setNameOfTable(nameOfTable);
		this.setEmployee(employee);
		this.discriptionOfClient = discriptionOfClient;
		this.numberOfClientsInTable = numberOfClientsInTable;
		this.areaOfTable = areaOfTable;
	}

	public String getNameOfTable() {
		return nameOfTable;
	}

	public void setNameOfTable(String nameOfTable) {
		this.nameOfTable = nameOfTable;
	}

	public String getDiscriptionOfClient() {
		return discriptionOfClient;
	}

	public void setDiscriptionOfClient(String discriptionOfClient) {
		this.discriptionOfClient = discriptionOfClient;
	}

	public String getAreaOfTable() {
		return areaOfTable;
	}

	public void setAreaOfTable(String areaOfTable) {
		this.areaOfTable = areaOfTable;
	}

	public String getNumberOfClientsInTable() {
		return numberOfClientsInTable;
	}

	public void setNumberOfClientsInTable(String numberOfClientsInTable) {
		this.numberOfClientsInTable = numberOfClientsInTable;
	}

	public Employe getEmployee() {
		return employee;
	}

	public void setEmployee(Employe employee) {
		this.employee = employee;
	}

}
