package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Classes.ClubClient;
import Moduel.CostumersClubModuel;
import Windows.CostumersClub;
import Windows.Discount;


public class CostumersClubController {
	private CostumersClub customersClubView;
    private CostumersClubModuel costumersClubModuel = new CostumersClubModuel();
    private ClubClient clubClient;
	private Discount discount;
    
    public CostumersClubController(CostumersClub customersClubView)
    {
    	this.customersClubView = customersClubView;
    	this.customersClubView.addButtonListener(new addButtonListner());
    	costumersClubModuel.getClubClientList(customersClubView.getTableClubClient());
    	this.customersClubView.addButtonRemoveListener(new ButtonRemoveListener());
    }
    
    public CostumersClubController(Discount discount) 
    {
		this.discount = discount;
		this.discount.getDiscount(new getDiscount());
	}
    
	//Checking the ID card and if the customer is on the customer club list gives him a 10 percent discount
    class getDiscount implements ActionListener
    {

		public void actionPerformed(ActionEvent e) {
			
			try {
				CostumersClubModuel.checkTextIdAndDiscountPriceTenPercent(discount.getTextId().getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			discount.getFrame().dispose();
		}
    	
    }
    
    public String getCurrentDate()
    {
    	return costumersClubModuel.getCurrentDate();
    }
    
    class addButtonListner implements ActionListener{
    	//Creates a new client for the customer club 	
		public void actionPerformed(ActionEvent e) {
			clubClient = costumersClubModuel.getClubClient(customersClubView.getTxtIdClient().getText(), customersClubView.getTxtFirstName().getText(), 
					customersClubView.getTxtLastName().getText(), customersClubView.getTxtPhoneNumber().getText(), customersClubView.getTxtDateAdded().getText());
			try {
				if(costumersClubModuel.checkFields(customersClubView.getTxtFirstName().getText(), customersClubView.getTxtLastName().getText(), 
	    				customersClubView.getTxtPhoneNumber().getText(), customersClubView.getTxtIdClient().getText()))
	    		{
	    			costumersClubModuel.addClubClient(clubClient);
	    		}
	    		customersClubView.clearFields();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
    }

    
    class ButtonRemoveListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			costumersClubModuel.deleteRow(customersClubView.getTableClubClient());
		}
    	
    }
}
