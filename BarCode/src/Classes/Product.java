package Classes;

public class Product {
	
	private String prouductCode;
	private String itemName;
	private String itemDescription;
	private String itemgroup;
	private String currentPrice;
	private String warrantyFactor;
	private String remarks;
	private int quantity; 
	
	public Product (StringBuilder builder) {
		String[] lines = builder.toString().split("\\n");
		this.setProuductCode(lines[0]);
		this.setItemName(lines[1]);
		this.setItemDescription(lines[2]);
		this.setItemgroup(lines[3]);
		this.setCurrentPrice((lines[4]));
		this.setWarrantyFactor((lines[5]));
		this.setRemarks((lines[6]));
		this.setQuantity(Integer.parseInt(lines[7]));
	}

	public String getProuductCode() {
		return prouductCode;
	}

	public void setProuductCode(String prouductCode) {
		this.prouductCode = prouductCode;
	}

	public String getItemgroup() {
		return itemgroup;
	}

	public void setItemgroup(String itemgroup) {
		this.itemgroup = itemgroup;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getWarrantyFactor() {
		return warrantyFactor;
	}

	public void setWarrantyFactor(String warrantyFactor) {
		this.warrantyFactor = warrantyFactor;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
