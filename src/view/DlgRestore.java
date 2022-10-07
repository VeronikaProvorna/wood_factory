package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import store.ProductStore;
import store.WoodDirectory;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class DlgRestore extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextArea textAreaRestore;
	private JButton restoreButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRestore dialog = new DlgRestore();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRestore() {
		setModal(true);
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Restore");
		setBounds(100, 100, 554, 540);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textAreaRestore = new JTextArea();
			textAreaRestore.setBounds(10, 124, 520, 334);
			contentPanel.add(textAreaRestore);
		}
		{
			textField = new JTextField();
			textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Input file to restore(object file)", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
			textField.setBounds(10, 32, 520, 47);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			restoreButton = new JButton("Restore");
			restoreButton.setBounds(419, 89, 111, 25);
			contentPanel.add(restoreButton);
			restoreButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onRestore();
				}
			});
			restoreButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
			restoreButton.setActionCommand("OK");
			getRootPane().setDefaultButton(restoreButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
    protected void onRestore() {
    	String s = textField.getText();
		WoodDirectory wd = null;
		ProductStore pd = null;
		File f = new File(s);
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			wd = (WoodDirectory) ois.readObject();
			pd = (ProductStore) ois.readObject();
			ois.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(wd != null) {
			for(Object w : wd.getArr())
				textAreaRestore.append(w.toString());
				textAreaRestore.append("\n");
		}
		if(pd != null) {
			for(Object p : pd.getArr())
				textAreaRestore.append(p.toString());
				textAreaRestore.append("\n");
		}
    }
    protected void onCancel() {
    	setVisible(false);
    }
	public JTextArea getTextAreaRestore() {
		return textAreaRestore;
	}
	public JButton getRestoreButton() {
		return restoreButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void clear() {
		textAreaRestore.setText("");
		textField.setText("");

	}

}
