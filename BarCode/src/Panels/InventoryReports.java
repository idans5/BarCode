package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ProductController;

import javax.swing.JScrollPane;

public class InventoryReports extends JPanel {
	
	private JTable tableInventory;
	private ProductController productController;
	
	/**
	 * Create the panel.
	 */
	
	public JTable getTableInventory() {
		return tableInventory;
	}

	public InventoryReports() {
		setLayout(null);
		
		JLabel label = new JLabel("\u05D3\u05D5\u05D7 \u05DE\u05DC\u05D0\u05D9");
		label.setBounds(413, 24, 170, 52);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 109, 893, 380);
		add(scrollPane);
		
		tableInventory = new JTable();
		scrollPane.setViewportView(tableInventory);
		tableInventory.setSurrendersFocusOnKeystroke(true);
		tableInventory.setFillsViewportHeight(true);
		tableInventory.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u05DB\u05DE\u05D5\u05EA", "\u05D4\u05E2\u05E8\u05D5\u05EA", "\u05D9\u05D1\u05D5\u05D0\u05DF", "\u05DE\u05D7\u05D9\u05E8 \u05DE\u05D5\u05E6\u05E8", "\u05E7\u05D1\u05D5\u05E6\u05EA \u05DE\u05D5\u05E6\u05E8", "\u05EA\u05D9\u05D0\u05D5\u05E8 \u05DE\u05D5\u05E6\u05E8", "\u05E9\u05DD \u05DE\u05D5\u05E6\u05E8", "\u05E7\u05D5\u05D3 \u05DE\u05D5\u05E6\u05E8"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableInventory.getColumnModel().getColumn(0).setResizable(false);
		tableInventory.getColumnModel().getColumn(0).setPreferredWidth(48);
		tableInventory.getColumnModel().getColumn(1).setResizable(false);
		tableInventory.getColumnModel().getColumn(1).setPreferredWidth(57);
		tableInventory.getColumnModel().getColumn(2).setResizable(false);
		tableInventory.getColumnModel().getColumn(2).setPreferredWidth(49);
		tableInventory.getColumnModel().getColumn(3).setResizable(false);
		tableInventory.getColumnModel().getColumn(3).setPreferredWidth(63);
		tableInventory.getColumnModel().getColumn(4).setResizable(false);
		tableInventory.getColumnModel().getColumn(5).setResizable(false);
		tableInventory.getColumnModel().getColumn(5).setPreferredWidth(106);
		tableInventory.getColumnModel().getColumn(6).setResizable(false);
		tableInventory.getColumnModel().getColumn(6).setPreferredWidth(74);
		tableInventory.getColumnModel().getColumn(7).setResizable(false);
		
		productController = new ProductController(this);
	}
	
}
