package Moduel;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classes.FileFunction;
import Classes.Order;
import Classes.Product;
import Classes.dataBaseConfig;
import Windows.Discount;
import Windows.EmployeMenu;
import Windows.OrderManagement;

public class OrderManagmentModuel {

	private DefaultTableModel dm;
	private String tableName;
	private Order order;
	private Product product;
	private final String productListFile = dataBaseConfig.getProductListFile();
	private final String busyTable = dataBaseConfig.getBusyTableFile();
	private final String OrderList = dataBaseConfig.getOrderList();

	//Generates ten percent discount for club members
	public void discountForACustomerClub()
	{
		int desition = JOptionPane.showConfirmDialog(null,"האם אתה ביצעת שמירה של כל פרטיי השולחן?","יציאה",JOptionPane.YES_NO_OPTION);
		if(desition==0)
		{
			Discount.main(null);
		}				
	}
	
	//Searches for a specific product in the list of products you've already ordered at the table
	public void searchInOrder(JTable orderTable,String txtToSearch)
	{
		String search = txtToSearch;
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dm);
		orderTable.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(search));
	}
	
	//Changes the position (up or down) of a specific product in the list of products already ordered at the table
	public void moveItemInTable(String direction,JTable orderTable)
	{
		int index = orderTable.getSelectedRow();
		if (index != -1)
		{
			if (direction.equals("up"))
			{
				if(index > 0)	
				{
					dm.moveRow(index, index, index-1);
				}
			}	
			else
			{
				if(index < dm.getRowCount()-1)	
				{
					dm.moveRow(index, index, index+1);
				}
			}				
		}
		
	}
	
	//Deletes an existing product in the order table and updates the total price of the order
    public void deleteFromTable(JTable orderTable) throws FileNotFoundException
    {
    	int index = orderTable.getSelectedRow();
    	dm = (DefaultTableModel) orderTable.getModel();
    	if (index != -1)
    	{
    		Object ob = dm.getValueAt(index, 0);
    		String value = (ob.toString());
    		ob = dm.getValueAt(index, 1);
    		String quatinty = (ob.toString());
    		ob = dm.getValueAt(index, 4);
    		String productName = (ob.toString());
    		removeFromTable(productName, quatinty);
    		int minus = Integer.parseInt(value) * Integer.parseInt(quatinty);
    		int totalPrice = OrderManagement.getTotalPrise();
    		totalPrice = totalPrice - minus;
    		OrderManagement.setTotalPrise(totalPrice);
    		dm.removeRow(index);
    		
    	}
			
    }
	
    //Puts a new product in the order table and updates the total price of the order
    public void addProductToTable(JTable orderTable,String NameProduct) throws FileNotFoundException
    {   
    	dm = (DefaultTableModel) orderTable.getModel();
    	StringBuilder builder;
    	builder = searchProduct(NameProduct);
    	int totalPrice = 0;
    	product = new Product(builder);
    	if (Integer.toString(OrderManagement.getTotalPrise()).length() != 0)
		{
			totalPrice = OrderManagement.getTotalPrise();
		}
    	String[] productField = getFields(product);    		
		String productPrice = product.getCurrentPrice();
		
    	if(builder != null)
    	{
    		if(ChangeTheQuantityOfTheProductInInventoryMinusOne(product))
    		{
    			int line = isItemExistInTable(NameProduct);
    			if (line == -1)
    			{
    				dm.addRow(productField);  
    			}
    			else
    			{
    				int quantity = Integer.parseInt(dm.getValueAt(line, 1).toString());
    				quantity++;
    				dm.setValueAt(quantity, line, 1);
    			}
    			totalPrice = Integer.parseInt(productPrice)+totalPrice;
    			OrderManagement.setTotalPrise(totalPrice);
    		}
    		else
    		{
    			JOptionPane.showMessageDialog( null, "אי אפשר להוסיף את המוצר", "אוופס נגמר המלאי", JOptionPane.INFORMATION_MESSAGE);
    		}
      	}   
    	
    }
	
	//Erases all the details related to the table we are in
	public void erasesAllTableDetails()
	{
		int desition = JOptionPane.showConfirmDialog(null,"האם אתה בטוח שאתה רוצה למחוק את כל פרטיי השולחן?","יציאה",JOptionPane.YES_NO_OPTION);
		if(desition==0)
		{
			deleteTableTextFile();
			deleteTableFromDataBase(tableName);
			OrderManagement.getFrame().dispose();
			EmployeMenu.main(null);
			OrderManagement.getFrame().dispose();
		}		
	}
	
	 //Searches the product by its name in the inventory and returns all its fields
    public StringBuilder searchProduct(String FileNameFromTheUser) throws FileNotFoundException
	{
		int startLine,endLine ;
		StringBuilder builder ;
		startLine = FileFunction.SearchStringAndReturnLine(productListFile,FileNameFromTheUser);
		if(startLine == 0)
		{
			JOptionPane.showMessageDialog(null, "המוצר אינו נמצא במערכת");
			builder = null;
		}
		else 
		{
			startLine = startLine-2;
			endLine= startLine +7;
			builder = FileFunction.ReadLineFromText(productListFile, startLine, endLine);
		}
		return builder;
	}
	
	//Stores all ordered products into the database
	public void saveOrderInTextFile(JTable orderTable) throws FileNotFoundException
	{
		dm = (DefaultTableModel) orderTable.getModel();
		
		if (ifTableAllreadyExists())
		{
			deleteTableTextFile();
		}
		for (int i = 0;i<dm.getRowCount();i++)
		{
			for (int j = 0;j<dm.getColumnCount();j++)
			{
				FileFunction.WriteToFile(getTextFileName(), dm.getValueAt(i, j).toString());
			}
		}
		
		setInfoOrderList();
	}
	
	public void getOrderInfo() throws FileNotFoundException
	{
		int line = searchOrderList();
		if (line != 0)
		{
			StringBuilder strBuilder = FileFunction.ReadLineFromText(dataBaseConfig.getOrderList(), line-1, line);
			String[] textToCopy = strBuilder.toString().split("\n");
			order = new Order(textToCopy[0], textToCopy[1]);
			OrderManagement.setTotalPrise(Integer.parseInt(order.getTableTotalPrice()));
		}
	}
	
	//Imports all the products of the table and puts them in the table of the order
	public void importInfoProductListFromText(JTable orderTable,String tableName)
	{
		dm = (DefaultTableModel) orderTable.getModel();	
		this.tableName = tableName;
		if(ifTableAllreadyExists())
		{
			OrderManagement.setTotalPrise(0);
			StringBuilder str = new StringBuilder();
			String[] textToCopy = new String[5];
			for (int i=0;i<FileFunction.GetNumberOfLines(getTextFileName());i+=5)
			{
				str = FileFunction.ReadLineFromText( getTextFileName(),i , i+4);
				textToCopy = str.toString().split("\n");
				dm.addRow(textToCopy);
			}			
		}
	}
	
	//If the table already exists or needs to be created
	private boolean ifTableAllreadyExists()
	{
		File f = new File(getTextFileName());
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}
	
	private String getTextFileName()
	{
		String result = dataBaseConfig.getTableList() + "OrderListTableNumber" + tableName + ".txt";
		return result;
	}	
	
	//Look inside the database named "OrderList" and return a line number
	private int searchOrderList() throws FileNotFoundException
	{
		int line = 0;
		line = FileFunction.SearchStringAndReturnLine(dataBaseConfig.getOrderList(), "TableNumber" + tableName);
		
		return line;
	}
	
	
	private void deleteTableTextFile()
	{
		FileFunction.DeleteFromText(getTextFileName(),0,FileFunction.GetNumberOfLines(getTextFileName())+1);
	}
	
	//Updating the price into the database named "OrderList"
	private void setInfoOrderList() throws FileNotFoundException 
	{
		int line = searchOrderList();
		if (line == 0)
		{
			saveOrder();
		}
		else
		{
			updateOrderList(line);
		}
	}
	
	//Saves the price that shown on the table in database named "OrderList"
	private void saveOrder()
	{
		order = new Order(tableName, Integer.toString(OrderManagement.getTotalPrise()));
		FileFunction.WriteToFile(dataBaseConfig.getOrderList(), "TableNumber" + order.getTableNumber());
		FileFunction.WriteToFile(dataBaseConfig.getOrderList(), order.getTableTotalPrice());
	}
	
	//Delete the price and update new price into the database named "OrderList"
	private void updateOrderList(int line) throws FileNotFoundException
	{
		FileFunction.DeleteFromText(dataBaseConfig.getOrderList(), line-1, line+1);
		saveOrder();
	}
	
	private void deleteTableFromDataBase(String tableNumber)
	{
		try {
			int start,end;			
			start = FileFunction.SearchStringAndReturnLine(busyTable, tableNumber);
			
			if(start != 0)
			{
			start -= 1;
			end = start +3;
			FileFunction.DeleteFromText(busyTable, start, end);
			}
			
			start = FileFunction.SearchStringAndReturnLine(OrderList, tableNumber);
			
			if(start != 0)
			{
			start -= 1;
			end = start + 2;
			FileFunction.DeleteFromText(OrderList, start, end);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("OrderManagement/deleteTableFromDatabase");
		}
	}
	
    private String[] getFields(Product product)
    {
    	String[] productField = {product.getCurrentPrice(),"1",
    			product.getRemarks(),product.getItemDescription(),product.getItemName()};
    	return productField;
    }
    
    private boolean  ChangeTheQuantityOfTheProductInInventoryMinusOne(Product product) throws FileNotFoundException
    {
    	boolean ret = false;    	   	
    	int count = product.getQuantity();
    	count--;
    	if(count >= 0)
    	{
    		int lineNumber = FileFunction.SearchStringAndReturnLine(productListFile, product.getProuductCode());
    		FileFunction.DeleteFromText(productListFile, lineNumber-1, lineNumber+7);
    		FileFunction.WriteToFile(productListFile, product.getProuductCode());
			FileFunction.WriteToFile(productListFile, product.getItemName());
			FileFunction.WriteToFile(productListFile, product.getItemDescription());
			FileFunction.WriteToFile(productListFile, product.getItemgroup());
			FileFunction.WriteToFile(productListFile, product.getCurrentPrice());
			FileFunction.WriteToFile(productListFile, product.getWarrantyFactor());
			FileFunction.WriteToFile(productListFile, product.getRemarks());
			FileFunction.WriteToFile(productListFile,Integer.toString(count));
			ret = true;   		
    	}
    	return ret;
    }
    
    private int isItemExistInTable(String NameProduct)
    {
    	int result = -1;
    	for (int i = 0;i<dm.getRowCount();i++)
		{
    		if (dm.getValueAt(i, 4).toString().equals(NameProduct))
    		{
    			result = i;
    			break;
    		}
		}
    	return result;
    }
    
    private void removeFromTable(String productName, String quantity) throws FileNotFoundException
    {
    	int lineNumber = FileFunction.SearchStringAndReturnLine(productListFile, productName);
    	StringBuilder builder = FileFunction.ReadLineFromText(productListFile, lineNumber-2, lineNumber+5);
    	product = new Product(builder);
    	int total = product.getQuantity() + Integer.parseInt(quantity);
    	product.setQuantity(total);
    	FileFunction.DeleteFromText(productListFile, lineNumber-2, lineNumber+6);
		FileFunction.WriteToFile(productListFile, product.getProuductCode());
		FileFunction.WriteToFile(productListFile, product.getItemName());
		FileFunction.WriteToFile(productListFile, product.getItemDescription());
		FileFunction.WriteToFile(productListFile, product.getItemgroup());
		FileFunction.WriteToFile(productListFile, product.getCurrentPrice());
		FileFunction.WriteToFile(productListFile, product.getWarrantyFactor());
		FileFunction.WriteToFile(productListFile, product.getRemarks());
		FileFunction.WriteToFile(productListFile,Integer.toString(product.getQuantity()));
    }
}
