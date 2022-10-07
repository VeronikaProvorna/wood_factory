package view;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.EventQueue;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.awt.Font;
import javax.swing.JLabel;

public class infoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					infoFrame frame = new infoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		public infoFrame() {
		setTitle("Developer information");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 519);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
			}
		};
		panel.setBounds(5, 5, 308, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Jlable = new JLabel("");
		Jlable.setBounds(0, 10, 298, 215);
		panel.add(Jlable);
		
		JTextArea txtrDeveloperProvornaVeronika = new JTextArea();
		txtrDeveloperProvornaVeronika.setBounds(5, 250, 308, 227);
		txtrDeveloperProvornaVeronika.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtrDeveloperProvornaVeronika.setText("Developer:\r\nProvorna Veronika Konstantinovna\r\nGroup: KI-201\r\nMail: provorna2003@gmail.com\r\n");
		contentPane.add(txtrDeveloperProvornaVeronika);
	}

}
