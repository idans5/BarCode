import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.*;
import Windows.EmployeMenu;

public class SplashScreen extends JWindow {

    static boolean isRegistered;
    private JProgressBar progressBar = new JProgressBar();
    private int count;
    private Timer timer1;

    public SplashScreen() {
    	setBackground(new Color(255, 255, 255));
    	setForeground(new Color(255, 255, 255));
    	getContentPane().setForeground(new Color(255, 255, 255));

        Container container = getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 10, 694, 368);
        panel.setLayout(null);
        container.add(panel);

        JLabel lblWelcomeTo = new JLabel("Welcome To");
        lblWelcomeTo.setForeground(Color.WHITE);
        lblWelcomeTo.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcomeTo.setFont(new Font("Forte", Font.BOLD, 75));
        lblWelcomeTo.setBounds(0, 75, 694, 61);
        panel.add(lblWelcomeTo);
        
        JLabel lblBarcode = new JLabel("BarCode");
        lblBarcode.setBackground(Color.BLACK);
        lblBarcode.setForeground(new Color(204, 0, 0));
        lblBarcode.setHorizontalAlignment(SwingConstants.CENTER);
        lblBarcode.setFont(new Font("Algerian", Font.BOLD, 75));
        lblBarcode.setBounds(0, 182, 694, 71);
        panel.add(lblBarcode);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/Image/SplashPic.jpg")));
        lblNewLabel.setBounds(0, 0, 694, 368);
        panel.add(lblNewLabel);
        progressBar.setStringPainted(true);

        progressBar.setMaximum(50);
        progressBar.setBounds(77, 389, 553, 31);
        container.add(progressBar);
        loadProgressBar();
        setSize(714, 452);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void callFrame() throws HeadlessException {	      	
    	EmployeMenu.main(null);
    	dispose();
    }
    private void loadProgressBar() {
        ActionListener al = new ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                if (count == 60) {         
                    timer1.stop();
                    callFrame();
                }

            }

        };
        timer1 = new Timer(90, al);
        timer1.start();
    }
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen window = new SplashScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
};