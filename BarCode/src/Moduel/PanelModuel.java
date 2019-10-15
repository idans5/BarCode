package Moduel;

import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.JPanel;

import Factory.panelFactory;

public class PanelModuel {

	private Vector<String> panelNames = new Vector<>();
	private panelFactory factory = new panelFactory();
	private Vector<JPanel> panelVector=new Vector<>();
	
	public void setPanelsVisibleFalse()
	{
		for (int i=0;i<panelVector.size();i++)
		{
			panelVector.get(i).setVisible(false);
		}
	}

	public void getPanels(JPanel menuPanel) throws FileNotFoundException 
	{
		for (int i=0;i<panelNames.size();i++)
		{
			panelVector.add(factory.makePanelVisibl(panelNames.get(i)));
		}
		menuPanel.setLayout(new CardLayout(0, 0));
		addPanels(menuPanel);
		setPanelsVisibleFalse();
	}
	
	private void addPanels(JPanel menuPanel)
	{
		for (int i=0;i<panelVector.size();i++)
		{
			menuPanel.add(panelVector.get(i));
		}
	}
	
	public void getPanelNames(Vector<String> names)
	{
		for (int i=0;i<names.size();i++)
		{
			panelNames.add(names.get(i));
		}
	}
	
	public void setPanelTrue(String panelName)
	{
		for (int i=0;i<panelNames.size();i++)
		{
			if (panelName == panelNames.get(i))
			{
				panelVector.get(i).setVisible(true);
				break;
			}
		}
	}
}
