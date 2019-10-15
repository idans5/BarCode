package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Moduel.PanelModuel;
import Windows.ManagerMenu;

public class PanelController {
	
	private ManagerMenu managerMenuView;
	private PanelModuel panelModuel = new PanelModuel();
	
	
	public PanelController(ManagerMenu managerMenuView) throws FileNotFoundException
	{
		this.managerMenuView = managerMenuView;
		panelModuel.getPanelNames(managerMenuView.getPanelNames());
		panelModuel.getPanels(managerMenuView.getPanelManagerMenu());
		this.managerMenuView.addEmployeeButtonListener(new addEmployeeButtonListener());
		this.managerMenuView.RemoveEmployeeButtonListener(new RemoveEmployeeButtonListener());
		this.managerMenuView.EditEmployeeButtonListener(new EditEmployeeButtonListener());
		this.managerMenuView.EditProductButtonListener(new EditProductButtonListener());
		this.managerMenuView.FinanceButtonListener(new FinanceButtonListener());
		this.managerMenuView.InventoryReportsButtonListener(new InventoryReportsButtonListener());
		this.managerMenuView.AddRemoveProductButtonListener(new AddRemoveProductButtonListener());
	}
	
	class addEmployeeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("addEmployee");
		}
		
	}
	
	class EditEmployeeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("editEmployee");
		}
		
	}
	
	class RemoveEmployeeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("removeEmployee");
		}
		
	}
	
	class EditProductButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("editProduct");
		}
		
	}
	
	class FinanceButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("financialReport");
		}
		
	}
	
	class InventoryReportsButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("inventoryReports");
		}
		
	}
	
	class AddRemoveProductButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			panelModuel.setPanelsVisibleFalse();
			panelModuel.setPanelTrue("addRemoveProduct");
		}
		
	}
	
}
