package Factory;

import java.io.FileNotFoundException;

import javax.swing.JPanel;

import Panels.AddEmployee;
import Panels.AddRemoveProduct;
import Panels.BarPanel;
import Panels.EditEmployee;
import Panels.EditProduct;
import Panels.FinancialReport;
import Panels.InventoryReports;
import Panels.RemoveEmployee;
import Panels.TablePanel;

public class panelFactory {
	
	public JPanel makePanelVisibl(String NameOfPanel)
	{
 
		if(NameOfPanel.equals("addEmployee")) {
			return new AddEmployee();
		}
		else if(NameOfPanel.equals("editEmployee")) {
			return new EditEmployee();
		}
		else if(NameOfPanel.equals("removeEmployee")) {
			return new RemoveEmployee();
		}
		else if(NameOfPanel.equals("addRemoveProduct")) {
			try {
				return new AddRemoveProduct();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(NameOfPanel.equals("inventoryReports")) {
			return new InventoryReports();
		}
		else if(NameOfPanel.equals("financialReport")) {
			return new FinancialReport();
		}
		else if(NameOfPanel.equals("editProduct")) {
			return new EditProduct();
		}
		else if(NameOfPanel.equals("barPanel")) {
			return new BarPanel();
		}
		else if(NameOfPanel.equals("tablePanel")) {
			return new TablePanel();
		}
		return null;
	}
}

