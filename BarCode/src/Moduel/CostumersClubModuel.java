package Moduel;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.ClubClient;
import Classes.FileFunction;
import Classes.dataBaseConfig;
import Windows.OrderManagement;

public class CostumersClubModuel {

	private static String fileClubClient = dataBaseConfig.getCostumersClubfile(); 
	private int count = 1;
	private StringBuilder stringBuilder;
	private ClubClient clubClient;
	private DefaultTableModel defualTableModel;
	
	protected String[] reverse(final String a[]) 
    { 
        String[] b = new String[a.length]; 
        int j = a.length; 
        for (int i = 0; i < a.length; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    } 
	
	public void getClubClientList(JTable tableClubClient)
	{
		defualTableModel = (DefaultTableModel) tableClubClient.getModel();
		StringBuilder str = new StringBuilder();
		String[] textToCopy = new String[5];
		for (int i=0;i<FileFunction.GetNumberOfLines(fileClubClient);i+=5)
		{
			str = FileFunction.ReadLineFromText(fileClubClient,i , i+4);
			textToCopy = str.toString().split("\n");
			textToCopy = reverse(textToCopy);
			defualTableModel.addRow(textToCopy);
		}			
	}
	
	public boolean checkFields(String FirstName, String LastName, String PhoneNumber, String IdClient)
	{
		boolean result = false;
		if (FirstName.length() < 2)
		{
			JOptionPane.showMessageDialog(null, "שם של לקוח לא יכול להכיל פחות מ2 תווים");
		}
		else if (IdClient.length() < 9)
		{
			JOptionPane.showMessageDialog(null, "תעודת זהות לא תקינה");
		}
		else if (LastName.length() < 2)
		{
			JOptionPane.showMessageDialog(null, "שם משפחה של לקוח לא יכול להכיל פחות מ2 תווים");
		}
		else if (PhoneNumber.length() < 10)
		{
			JOptionPane.showMessageDialog(null, "מספר פלאפון לא יכול להכיל פחות מ10 תווים");
		}
		else 
		{
			result = true;
		}
		return result;
			
	}
	
	public String getCurrentDate()
	{
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        return sdf.format(cal.getTime());
	}
	
	public ClubClient getClubClient(String IdClient,String FirstName,String LastName,String PhoneNumber,String DateAdded)
	{
		stringBuilder = new StringBuilder();
		stringBuilder.append(IdClient + "\n");
		stringBuilder.append(FirstName + "\n");
		stringBuilder.append(LastName + "\n");
		stringBuilder.append(PhoneNumber + "\n");
		stringBuilder.append(DateAdded + "\n");
		clubClient = new ClubClient(stringBuilder);
		return clubClient;
	}
	
	//Creates a new client for the customer club
	public void addClubClient(ClubClient clubClient) throws FileNotFoundException 
	{
		boolean result = searchClient(clubClient);
		if (result)
		{
			JOptionPane.showMessageDialog(null, "לקוח קיים במערכת");
		}
		else 
		{
			FileFunction.WriteToFile(fileClubClient, clubClient.getClientId());
			FileFunction.WriteToFile(fileClubClient, clubClient.getClientFirstName());
			FileFunction.WriteToFile(fileClubClient, clubClient.getClientLastName());
			FileFunction.WriteToFile(fileClubClient, clubClient.getClientPhoneNumber());
			FileFunction.WriteToFile(fileClubClient, clubClient.getClientDateAdded());
			JOptionPane.showMessageDialog(null, "לקוח הוסף בהצלחה");
		}
		
	}
	

	//Checks if the customer exists in the customer club list
	public boolean searchClient(ClubClient clubClient) throws FileNotFoundException {
		boolean result = false;
		File file = new File(fileClubClient);
		if (file.exists() == true)
		{
			if (FileFunction.SearchInFile(fileClubClient, clubClient.getClientId()) == true)
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
	
	//Deletes a client from the database of the customer club list
	private void deleteFromDataBase(JTable tableClubClient, int index)
	{
		try {
			int start,end;	
			String s = tableClubClient.getModel().getValueAt(index-1, 0).toString();
			start = FileFunction.SearchStringAndReturnLine(fileClubClient,s );
			
			if(start != 0)
			{
				end = start +5;
				FileFunction.DeleteFromText(fileClubClient, start, end);
			}			
			
		} catch (FileNotFoundException e) {
			System.out.println("OrderManagement/deleteTableFromDatabase");
		}
	}
	
	//Deletes a client from the db of the customer club list and also from the table
	public void deleteRow(JTable tableClubClient) 
	{
		if(count ==1)
		{
			DefaultTableModel model = (DefaultTableModel) tableClubClient.getModel();
			int selectedRow = tableClubClient.getSelectedRow();
			if(selectedRow != -1) {
				model.removeRow(selectedRow);
				deleteFromDataBase(tableClubClient, selectedRow);
			}
			count++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "ניתן להסיר לקוח אחד בכל פעם");
		}
		
	}

	//Checking the ID card and if the customer is on the customer club list gives him a 10 percent discount
	public static void checkTextIdAndDiscountPriceTenPercent(String textId) throws FileNotFoundException
	{
		int lineNumber = 0;
		if(textId.length() != 9)
		{
			JOptionPane.showMessageDialog(null, "תעודת זהות אינה חוקית");
		}
		
		else
		{
			lineNumber = FileFunction.SearchStringAndReturnLine(fileClubClient, textId);
			if(lineNumber != 0)
			{
				int changePrice = (int)OrderManagement.getTotalPrise();
				changePrice =(int) (changePrice * 0.9);
				String changePricestr = Integer.toString(changePrice);
			    OrderManagement.setLabelTotalPrise(changePricestr);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "התעודת זהות אינה נמצאת במועדון הלקוחות");
			}
		}
	}
}
