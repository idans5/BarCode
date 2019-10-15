package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Moduel.TableModuel;
import Windows.TableDiscription;

public class TableController {
	private TableDiscription tableDiscriptionView;
	private TableModuel tableModuel = new TableModuel();
	
	public TableController(TableDiscription tableDiscriptionView)
	{
		this.tableDiscriptionView = tableDiscriptionView;
		this.tableDiscriptionView.FinishButtonListener(new FinishButtonListener());
	}
	
	class FinishButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			tableModuel.pressFinish(tableDiscriptionView.getTxtClientDiscription().getText(), tableDiscriptionView.getTxtNumOfClientInTable().getText());
			tableDiscriptionView.getFrame().dispose();
		}
		
	}
}
