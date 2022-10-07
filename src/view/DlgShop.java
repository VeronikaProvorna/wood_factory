package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import store.ProductStore;
import store.WasteStore;
import store.WoodDirectory;
import threads.CilinderShop;
import threads.TimberShop;
import threads.WasteShop;
import threads.WoodLock;

import javax.swing.JScrollBar;

public class DlgShop extends JDialog {
    WoodDirectory wd=MainView.wd;
    ProductStore ps=MainView.ps;
    WasteStore ws=MainView.ws;
	private final JPanel contentPanel = new JPanel();
	JTextField textFieldCil;
	JTextField textFieldTim;
	private static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgShop dialog = new DlgShop();
			dialog.setDefaultCloseOperation(2);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgShop() {
		setBounds(100, 100, 589, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldCil = new JTextField();
		textFieldCil.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldCil.setBorder(new TitledBorder(null, "Count of cilinders", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textFieldCil.setBounds(25, 51, 117, 45);
		contentPanel.add(textFieldCil);
		textFieldCil.setColumns(10);
		
		textFieldTim = new JTextField();
		textFieldTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldTim.setBorder(new TitledBorder(null, "Count of timber", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textFieldTim.setColumns(10);
		textFieldTim.setBounds(429, 51, 117, 45);
		contentPanel.add(textFieldTim);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 555, 276);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Label label = new Label("Input the values:");
		label.setFont(new Font("Dialog", Font.PLAIN, 14));
		label.setBounds(218, 24, 142, 34);
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onOk();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public ProductStore onOk() {
		WoodLock wk = new WoodLock();
		int tim=Integer.parseInt(textFieldTim.getText());
		int cil=Integer.parseInt(textFieldCil.getText());
		Date data=new Date();
		TimberShop timShop=new TimberShop("timberShop", wd, ps, ws, wk, tim);
		CilinderShop cilShop=new CilinderShop("cylinderShop", wd, ps, ws, wk, cil);
        WasteShop wasteShop = new WasteShop("wasteShop", ps, ws, wk, timShop, cilShop);
		this.textArea.append("Date of start: "+data+"\n");
       Thread tshop1= new Thread((Runnable)timShop);
       Thread tshop2= new Thread((Runnable)cilShop);
       Thread tshop3 = new Thread((Runnable) wasteShop);
       tshop1.start();
       tshop2.start();
       tshop3.start();
       
       return ps;
	}
	protected void onCancel() {
		this.setVisible(false);
	}
	public JTextField getTextFieldCil() {
		return textFieldCil;
	}
	public JTextField getTextFieldTim() {
		return textFieldTim;
	}
	public static JTextArea getTextArea() {
		return textArea;
	}
}
