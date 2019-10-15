package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import Classes.Product;
import Moduel.ProductModuel;
import Panels.AddRemoveProduct;
import Panels.EditProduct;
import Panels.InventoryReports;
import Windows.ProductMenu;

public class ProductController {
	private ProductMenu productMenuView;
	private InventoryReports inventoryReports;
	private ProductModuel productModuel = new ProductModuel();
	private AddRemoveProduct addRemoveProduct;
	private String productCode;
	private EditProduct editProduct;
	
	public ProductController(EditProduct editProduct)
	{
		this.editProduct = editProduct;
		this.editProduct.EditProductButtonListener(new EditProductButtonListener());
		this.editProduct.SearchProductButtonListener(new SearchProductButtonListener());
	}
	
	public ProductController(ProductMenu productMenuView)
	{
		this.productMenuView = productMenuView;
		this.productMenuView.SearchButtonListener(new SearchButtonListener());
	}
	
	public ProductController(AddRemoveProduct addRemoveProduct) throws FileNotFoundException
	{
		this.addRemoveProduct = addRemoveProduct;
		productCode = productModuel.setRandomCode();
		this.addRemoveProduct.setTxtProductCode(productCode);
		this.addRemoveProduct.addProductButtonListener(new addProductButtonListener());
		this.addRemoveProduct.RemoveProductButtonListener(new RemoveProductButtonListener());
	}
	
	public ProductController(InventoryReports inventoryReports)
	{
		this.inventoryReports = inventoryReports;
		productModuel.getInventoryList(this.inventoryReports.getTableInventory());
	}
	
	class EditProductButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			productModuel.getFields(editProduct.getTxtProductCode().getText(), editProduct.getTxtProductName().getText(), editProduct.getTxtProductDiscription().getText(), 
					editProduct.getCmProductGroup().getSelectedItem().toString(), editProduct.getTxtProductPrice().getText(), editProduct.getTxtWarrantyFactor().getText(),editProduct.getTxtRemark().getText(), editProduct.getTxtQuntity().getText());
			try {
				productModuel.editProduct();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			editProduct.clearFields();
			editProduct.setEditableFalse();
		}
		
	}
	
	class SearchProductButtonListener implements ActionListener
	{
		private Product product;

		public void actionPerformed(ActionEvent arg0) {
			try {
				product = productModuel.searchProduct(editProduct.getTxtProductCode().getText());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editProduct.setEditableTrue();
			setFields();
		}
		
		public void setFields()
		{
			editProduct.setTxtProductCode(product.getProuductCode());
			editProduct.setTxtProductName(product.getItemName());
			editProduct.setTxtProductDiscription(product.getItemDescription());
			editProduct.setCmProductGroup(product.getItemgroup());
			editProduct.setTxtProductPrice(product.getCurrentPrice());
			editProduct.setTxtWarrantyFactor(product.getWarrantyFactor());
			editProduct.setTxtRemark(product.getRemarks());
			editProduct.setTxtQuntity(Integer.toString(product.getQuantity()));
		}
	}
	
	class RemoveProductButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			try {
				productModuel.removeProduct(addRemoveProduct.getTxtProductCodeRemove().getText());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addRemoveProduct.setTxtProductCodeRemove("");		
		}
		
	}
	
	
	class addProductButtonListener implements ActionListener
	{
		private Product product;
		public void actionPerformed(ActionEvent e) {
			if(productModuel.checkFieldsInAddRemoveProduct(addRemoveProduct.getTextProductName().getText(), addRemoveProduct.getTxtProductDescription().getText(), addRemoveProduct.getTxtCurrentPrice().getText(), 
					addRemoveProduct.getTxtWarrantyFactor().getText(),addRemoveProduct.getTxtRemark().getText(), addRemoveProduct.getTxtQuntity().getText()))
			{
				product = productModuel.getProduct(addRemoveProduct.getTxtProductCode().getText(), addRemoveProduct.getTextProductName().getText(), addRemoveProduct.getTxtProductDescription().getText(), 
						addRemoveProduct.getCmProductGroup().getSelectedItem().toString(), addRemoveProduct.getTxtCurrentPrice().getText(), addRemoveProduct.getTxtWarrantyFactor().getText(),addRemoveProduct.getTxtRemark().getText(), addRemoveProduct.getTxtQuntity().getText());
					try {
						productCode = productModuel.addProduct(product);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					addRemoveProduct.setTxtProductCode(productCode);
			}
			addRemoveProduct.clearFields();
		}

		
	}
	
	class SearchButtonListener implements ActionListener
	{
		private Product product; 
		public void actionPerformed(ActionEvent e) {
			try {
				product = productModuel.getProductFromDataBaseByName(productMenuView.getTextSearchTitleItemName().getText());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			if(product != null)
			{
				productMenuView.getFields(product);
			}
		}
		
	}
}
