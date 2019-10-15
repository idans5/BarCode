package Classes;

public class dataBaseConfig {
	private static String employeeFile =  "BarCode\\src\\dataBase\\employee.txt";
	private static String connectedEmployeeFile = "BarCode\\src\\dataBase\\connectedEmployee.txt";
	private static String productListFile =  "BarCode\\src\\dataBase\\productList.txt";
	private static String busyTableFile =  "BarCode\\src\\dataBase\\busyTable.txt";
	private static String tableList = "BarCode\\src\\dataBase\\Tables\\";
	private static String paymentList = "BarCode\\src\\dataBase\\PaymentList.txt";
	private static String orderList = "BarCode\\src\\dataBase\\OrderList.txt";

	private static String employeeWorkingTimeFile = "BarCode\\src\\dataBase\\employeeWorkingTime.txt";

	private static String costumersClubfile = "BarCode\\src\\dataBase\\costumersClub.txt";

	
	public static String getEmployeeFile() {
		return employeeFile;
	}
	
	public static String getConnectedEmployeeFile() {
		return connectedEmployeeFile;
	}
			
	public static String getProductListFile() {
		return productListFile;
	}
	
	public static String getBusyTableFile() {
		return busyTableFile;
	}

	public static String getTableList() {
		return tableList;
	}

	public static void setTableList(String tableList) {
		dataBaseConfig.tableList = tableList;
	}

	public static String getPaymentList() {
		return paymentList;
	}

	public static void setPaymentList(String paymentList) {
		dataBaseConfig.paymentList = paymentList;
	}

	public static String getOrderList() {
		return orderList;
	}

	public static void setOrderList(String orderList) {
		dataBaseConfig.orderList = orderList;
	}


	public static String getEmployeeWorkingTimeFile() {
		return employeeWorkingTimeFile;
	}

	public static void setEmployeeWorkingTimeFile(String employeeWorkingTimeFile) {
		dataBaseConfig.employeeWorkingTimeFile = employeeWorkingTimeFile;
	}
	public static String getCostumersClubfile() {
		return costumersClubfile;
	}

	public static void setCostumersClubfile(String costumersClubfile) {
		dataBaseConfig.costumersClubfile = costumersClubfile;

	}
	
}
