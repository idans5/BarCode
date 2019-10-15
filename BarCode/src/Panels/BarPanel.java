package Panels;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.SwingConstants;

import Classes.Table;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BarPanel extends JPanel {
	private Table table;
	
/**
 * Create the panel.
 */
	public BarPanel() {
		setLayout(null);
		
		JButton btnBarTableNum101 = new JButton("101");
		btnBarTableNum101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum101.getText());
			}
		});
		btnBarTableNum101.setBounds(182, 104, 56, 45);
		add(btnBarTableNum101);
		
		JButton btnBarTableNum102 = new JButton("102");
		btnBarTableNum102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum102.getText());
			}
		});
		btnBarTableNum102.setBounds(248, 104, 55, 45);
		add(btnBarTableNum102);
		
		JButton btnBarTableNum103 = new JButton("103");
		btnBarTableNum103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum103.getText());
			}
		});
		btnBarTableNum103.setBounds(312, 104, 56, 45);
		add(btnBarTableNum103);
		
		JButton btnBarTableNum104 = new JButton("104");
		btnBarTableNum104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum104.getText());
			}
		});
		btnBarTableNum104.setBounds(379, 104, 56, 45);
		add(btnBarTableNum104);
		
		JButton btnBarTableNum105 = new JButton("105");
		btnBarTableNum105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum105.getText());
			}
		});
		btnBarTableNum105.setBounds(445, 104, 56, 45);
		add(btnBarTableNum105);
		
		JButton btnBarTableNum106 = new JButton("106");
		btnBarTableNum106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum106.getText());
			}
		});
		btnBarTableNum106.setBounds(510, 156, 56, 50);
		add(btnBarTableNum106);
		
		JButton btnBarTableNum107 = new JButton("107");
		btnBarTableNum107.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum107.getText());
			}
		});
		btnBarTableNum107.setBounds(511, 214, 56, 50);
		add(btnBarTableNum107);
		
		JButton btnBarTableNum108 = new JButton("108");
		btnBarTableNum108.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum108.getText());
			}
		});
		btnBarTableNum108.setBounds(509, 273, 56, 51);
		add(btnBarTableNum108);
		
		JButton btnBarTableNum109 = new JButton("109");
		btnBarTableNum109.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum109.getText());
			}
		});
		btnBarTableNum109.setBounds(510, 330, 56, 50);
		add(btnBarTableNum109);
		
		JButton btnBarTableNum110 = new JButton("110");
		btnBarTableNum110.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum110.getText());
			}
		});
		btnBarTableNum110.setBounds(510, 388, 56, 51);
		add(btnBarTableNum110);
		
		JButton btnBarTableNum111 = new JButton("111");
		btnBarTableNum111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum111.getText());
			}
		});
		btnBarTableNum111.setBounds(510, 446, 56, 50);
		add(btnBarTableNum111);
		
		JButton btnBarTableNum112 = new JButton("112");
		btnBarTableNum112.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum112.getText());
			}
		});
		btnBarTableNum112.setBounds(444, 503, 56, 45);
		add(btnBarTableNum112);
		
		JButton btnBarTableNum113 = new JButton("113");
		btnBarTableNum113.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum113.getText());
			}
		});
		btnBarTableNum113.setBounds(379, 501, 56, 50);
		add(btnBarTableNum113);
		
		JButton btnBarTableNum114 = new JButton("114");
		btnBarTableNum114.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum114.getText());
			}
		});
		btnBarTableNum114.setBounds(311, 501, 56, 50);
		add(btnBarTableNum114);
		
		JButton btnBarTableNum115 = new JButton("115");
		btnBarTableNum115.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum115.getText());
			}
		});
		btnBarTableNum115.setBounds(245, 502, 55, 45);
		add(btnBarTableNum115);
		
		JButton btnBarTableNum116 = new JButton("116");
		btnBarTableNum116.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablePanel.pressTableButton(btnBarTableNum116.getText());
			}
		});
		btnBarTableNum116.setBounds(182, 503, 56, 45);
		add(btnBarTableNum116);
	
		JLabel showImage = new JLabel("");
		showImage.setHorizontalAlignment(SwingConstants.CENTER);
		showImage.setIcon(new ImageIcon(TablePanel.class.getResource("/Image/Bar.JPG")));
		showImage.setBounds(0, 48, 658, 534);
		add(showImage);
	}
}