package Moduel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.FileFunction;
import Classes.Product;
import Classes.dataBaseConfig;

public class ProductModuel {
	
	private final String fileName = dataBaseConfig.getProductListFile();
	private DefaultTableModel defualTableModel;
	private Product product;
	private StringBuilder stringBuilder;
	private Random rand;
	private int line;

	
	//Searches the product by its name in the inventory and returns all its fields
	private StringBuilder searchProductAndReturnFileds(String ProductName) throws FileNotFoundException
	{
		int startLine,endLine;
		StringBuilder builder ;
		startLine = FileFunction.SearchStringAndReturnLine(fileName,ProductName)-1;
		if(startLine == 0)
		{
			JOptionPane.showMessageDialog(null, "המוצר אינו נמצא במערכת");
			builder = null;
		}
		else 
		{
			endLine = startLine +6;
			builder = FileFunction.ReadLineFromText(fileName, startLine-1, endLine);
		}
		return builder;
	}
	
	//Searches the product by its name in the inventory
	public Product getProductFromDataBaseByName(String SearchTitleItemName) throws FileNotFoundException
	{
		if (SearchTitleItemName.length()<1)
		{
			JOptionPane.showMessageDialog(null, "נא להכניס שם מוצר");
		}
		else 
		{
			StringBuilder builder = searchProductAndReturnFileds(SearchTitleItemName);
			if (builder!=null)
			{
				product = new Product(builder);
				return product;
			}
		}
		return null;
	}
	
	private String[] reverse(final String a[]) 
    { 
        String[] b = new String[a.length]; 
        int j = a.length; 
        for (int i = 0; i < a.length; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    } 
	
	public void getInventoryList(JTable tableInventory)
	{
		defualTableModel = (DefaultTableModel) tableInventory.getModel();
		StringBuilder str = new StringBuilder();
		String[] textToCopy = new String[8];
		for (int i=0;i<FileFunction.GetNumberOfLines(fileName);i+=8)
		{
			str = FileFunction.ReadLineFromText(fileName,i , i+7);
			textToCopy = str.toString().split("\n");
			textToCopy = reverse(textToCopy);
			defualTableModel.addRow(textToCopy);
		}			
	}

	public Product getProduct(String productCode,String ProductName, String ProductDescription, String ProductGroup, String CurrentPrice, String WarrantyFactor, String Remark, String Quntity)
	{
		stringBuilder = new StringBuilder();
		stringBuilder.append(productCode + "\n");
		stringBuilder.append(ProductName + "\n");
		stringBuilder.append(ProductDescription + "\n");
		stringBuilder.append(ProductGroup + "\n");
		stringBuilder.append(CurrentPrice + "\n");
		stringBuilder.append(WarrantyFactor + "\n");
		stringBuilder.append(Remark + "\n");
		stringBuilder.append(Quntity + "\n");
		product = new Product(stringBuilder);
		return product;
	}
	
	public boolean checkFieldsInAddRemoveProduct(String ProductName, String ProductDescription, String CurrentPrice, String WarrantyFactor, String Remark, String Quntity)
	{
		boolean result = false;
		if (ProductName.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס שם מוצר");
		}
		else if (ProductDescription.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס תיאור מוצר");
		}		
		else if (CurrentPrice.length()==0 || Integer.parseInt(CurrentPrice)<1)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס מחיר");
		}
		else if (WarrantyFactor.length()== 0)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס יבואן");
		}
		else if (Remark.length()== 0)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס הערות יבואן, במידה ואין נא לרשום 0");
		}
		else if (Quntity.length()== 0 || Integer.parseInt(Quntity)<1)
		{
			JOptionPane.showMessageDialog(null, "חובה להכניס כמות");
		}
		else 
		{
			result = true;
		}
		return result;
			
	}
	
	public void removeProduct(String productCode) throws FileNotFoundException
	{
		if (productCode.isEmpty() || productCode.length()<5)
		{
			JOptionPane.showMessageDialog(null, "קוד מוצר לא תקין");
		}
		else
		{
			int lineNumber = FileFunction.SearchStringAndReturnLine(fileName, productCode);
			if (lineNumber == 0)
			{
				JOptionPane.showMessageDialog(null, "מוצר לא קיים במערכת");
			}
			else 
			{
				FileFunction.DeleteFromText(fileName, lineNumber-1, lineNumber+7);
				JOptionPane.showMessageDialog(null, "מוצר נמחק בהצלחה");
			}
		}
	}
	
	private boolean searchIfProductExistsInDataBase(Product product) throws FileNotFoundException
	{
		boolean result = false;
		File file = new File(fileName);
		if (file.exists() == true)
		{
			if (FileFunction.SearchInFile(fileName, product.getProuductCode()) == true)
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
			result = true;
		}
		return result;
	}
	
	public String addProduct(Product product) throws FileNotFoundException
	{
			String randnum;
			boolean result = searchIfProductExistsInDataBase(product);
			if (result)
			{
				JOptionPane.showMessageDialog(null, "מוצר קיים במערכת");
			}
			else 
			{
				FileFunction.WriteToFile(fileName, product.getProuductCode());
				FileFunction.WriteToFile(fileName, product.getItemName());
				FileFunction.WriteToFile(fileName, product.getItemDescription());
				FileFunction.WriteToFile(fileName, product.getItemgroup());
				FileFunction.WriteToFile(fileName, product.getCurrentPrice());
				FileFunction.WriteToFile(fileName, product.getWarrantyFactor());
				FileFunction.WriteToFile(fileName, product.getRemarks());
				FileFunction.WriteToFile(fileName,Integer.toString(product.getQuantity()));
				JOptionPane.showMessageDialog(null, "מוצר הוסף בהצלחה");
				randnum = setRandomCode();
				return randnum;
			}
			return null;
	}

	public String setRandomCode() throws FileNotFoundException
	{
		rand = new Random();
		int low = 10000;
		int high = 99999;
		int result;
		do {
			result = rand.nextInt(high-low) + low;
		}
		while (FileFunction.SearchInFile(fileName, Integer.toString(result)));
		return Integer.toString(result);
	}

	
	public Product searchProduct(String ProductCode) throws FileNotFoundException
	{
		product = null;
		if (Integer.parseInt(ProductCode)>8999)
		{
			line = FileFunction.SearchStringAndReturnLine(fileName, ProductCode);
			if (line != 0)
			{
				stringBuilder = FileFunction.ReadLineFromText(fileName, line-1, line+6);
				product = new Product(stringBuilder);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "מוצר אינו קיים");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "קוד מוצר לא תקין");
		}
		return product;
	}
	
	public void getFields(String productCode,String ProductName, String ProductDescription, String ProductGroup, String CurrentPrice, String WarrantyFactor, String Remark, String Quntity)
	{
		product.setProuductCode(productCode);
		product.setItemName(ProductName);
		product.setItemDescription(ProductDescription);
		product.setItemgroup(ProductGroup);
		product.setCurrentPrice(CurrentPrice);
		product.setWarrantyFactor(WarrantyFactor);
		product.setRemarks(Remark);
		product.setQuantity(Integer.parseInt(Quntity));
	}
	
	
	private void deleteProduct()
	{
		FileFunction.DeleteFromText(fileName, line-1, line+7);
	}
	
	private void addProduct()
	{
		FileFunction.WriteToFile(fileName, product.getProuductCode());
		FileFunction.WriteToFile(fileName, product.getItemName());
		FileFunction.WriteToFile(fileName, product.getItemDescription());
		FileFunction.WriteToFile(fileName, product.getItemgroup());
		FileFunction.WriteToFile(fileName, product.getCurrentPrice());
		FileFunction.WriteToFile(fileName, product.getWarrantyFactor());
		FileFunction.WriteToFile(fileName, product.getRemarks());
		FileFunction.WriteToFile(fileName, Integer.toString(product.getQuantity()));
	}
	
	public void editProduct() throws FileNotFoundException
	{
		deleteProduct();
		addProduct();
		JOptionPane.showMessageDialog(null, "מוצר נערך בהצלחה");
	}
}
