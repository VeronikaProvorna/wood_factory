package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProtocolFrame extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProtocolFrame frame = new ProtocolFrame();
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
	public ProtocolFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader inputFile = new FileReader("LogProvorna.txt");
				    BufferedReader bufferReader=new BufferedReader(inputFile);
				    String value;
				    while((value=bufferReader.readLine())!=null) {
				    	textArea.append(value + "\n");
				    }
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		setTitle("Protocol");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBounds(10, 10, 416, 243);
		contentPane.add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		contentPanel.add(textArea, BorderLayout.CENTER);
	}
	public JTextArea getTextArea() {
		return textArea;
	}
}
