package Classes;

public class Order {
	
	private String tableNumber;
	private String tableTotalPrice;
	
	public Order(String tableNumber, String tableTotalPrice) {
		this.setTableNumber(tableNumber);
		this.setTableTotalPrice(tableTotalPrice);
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getTableTotalPrice() {
		return tableTotalPrice;
	}

	public void setTableTotalPrice(String tableTotalPrice) {
		this.tableTotalPrice = tableTotalPrice;
	}
	
}
