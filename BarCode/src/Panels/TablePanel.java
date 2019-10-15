package Panels;
import javax.swing.JPanel;

import Classes.Table;
import Moduel.TableModuel;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class TablePanel extends JPanel {
	private JButton btnTableNum11;
	public static Table table ;
	private static TableModuel tableModuel = new TableModuel();
	
	
	protected static void pressTableButton(String numOfTable)
	{
		table = tableModuel.pressTableButton(numOfTable);
	}
	
	/**
	 * Create the panel.
	 */
	public TablePanel() {
		setLayout(null);
		
		btnTableNum11 = new JButton("11");
		btnTableNum11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum11.getText());
			}
		});
		btnTableNum11.setBounds(248, 95, 69, 49);
		add(btnTableNum11);
		
		JButton btnTableNum10 = new JButton("10");
		btnTableNum10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum10.getText());
			}
		});
		btnTableNum10.setBounds(15, 395, 55, 49);
		add(btnTableNum10);
		
		JButton btnTableNum9 = new JButton("9");
		btnTableNum9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pressTableButton(btnTableNum9.getText());
		   }
		});
		btnTableNum9.setBounds(85, 395, 55, 49);
		add(btnTableNum9);
		
		JButton btnTableNum8 = new JButton("8");
		btnTableNum8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum8.getText());
			   }
			});
		btnTableNum8.setBounds(156, 395, 55, 49);
		add(btnTableNum8);
		
		JButton btnTableNum7 = new JButton("7");
		btnTableNum7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum7.getText());
			   }
			});
		btnTableNum7.setBounds(445, 395, 53, 49);
		add(btnTableNum7);
		
		JButton btnTableNum6 = new JButton("6");
		btnTableNum6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum6.getText());
			   }
			});
		btnTableNum6.setBounds(513, 395, 55, 49);
		add(btnTableNum6);
		
		JButton btnTableNum5 = new JButton("5");
		btnTableNum5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum5.getText());
			   }
			});
		btnTableNum5.setBounds(584, 395, 53, 49);
		add(btnTableNum5);
		
		JButton btnTableNum12 = new JButton("12");
		btnTableNum12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum12.getText());
			   }
			});
		btnTableNum12.setBounds(37, 490, 69, 49);
		add(btnTableNum12);
		
		JButton btnTableNum13 = new JButton("13");
		btnTableNum13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum13.getText());
			   }
			});
		btnTableNum13.setBounds(142, 489, 69, 49);
		add(btnTableNum13);
		
		JButton btnTableNum14 = new JButton("14");
		btnTableNum14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum14.getText());
			   }
			});
		btnTableNum14.setBounds(298, 489, 69, 49);
		add(btnTableNum14);
		
		JButton btnTableNum15 = new JButton("15");
		btnTableNum15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum15.getText());
			   }
			});
		btnTableNum15.setBounds(445, 489, 69, 49);
		add(btnTableNum15);
		
		JButton btnTableNum16 = new JButton("16");
		btnTableNum16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum16.getText());
			   }
			});
		btnTableNum16.setBounds(559, 488, 69, 49);
		add(btnTableNum16);
		
		JButton btnTableNum4 = new JButton("4");
		btnTableNum4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pressTableButton(btnTableNum4.getText());
			}
		});
		btnTableNum4.setBounds(354, 63, 55, 49);
		add(btnTableNum4);
		
		JButton btnTableNum3 = new JButton("3");
		btnTableNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum3.getText());
			   }
			});
		btnTableNum3.setBounds(429, 63, 55, 49);
		add(btnTableNum3);
		
		JButton btnTableNum2 = new JButton("2");
		btnTableNum2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum2.getText());
			   }
			});
		btnTableNum2.setBounds(510, 63, 55, 49);
		add(btnTableNum2);
		
		JButton btnTableNum1 = new JButton("1");
		btnTableNum1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressTableButton(btnTableNum1.getText());
			   }
			});
		btnTableNum1.setBounds(584, 63, 55, 49);
		add(btnTableNum1);
		
		
		JLabel showImage = new JLabel("");
		showImage.setIcon(new ImageIcon(TablePanel.class.getResource("/Image/Table.JPG")));
		showImage.setBounds(0, 0, 658, 635);
		add(showImage);
	}
}
