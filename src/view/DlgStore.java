package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStore extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	MainView mv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStore dialog = new DlgStore();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStore() {
		setModal(true);
		setBounds(100, 100, 383, 193);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel labelStored = new JLabel("The information was stored!");
		labelStored.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelStored.setBounds(70, 20, 236, 72);
		contentPanel.add(labelStored);
		
		okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					onOkButton();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		okButton.setBounds(121, 88, 125, 37);
		contentPanel.add(okButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public void onOkButton() throws Exception {
		this.setVisible(false);
	}
	public JButton getOkButton() {
		return okButton;
	}
}
