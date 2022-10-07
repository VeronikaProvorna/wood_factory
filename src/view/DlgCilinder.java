package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.Cilinder;
import model.Timber;
import model.Wood;
import store.WoodDirectory;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCilinder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCilinderLength;
	private JTextField textDiameter;
	private JComboBox comboBox;
    private Cilinder object=null;
    public Cilinder getObject() {
    	return object;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCilinder dialog = new DlgCilinder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCilinder() {
		setTitle("Cilinder information\r\n");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Wood selection", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setBounds(84, 154, 242, 56);
		contentPanel.add(comboBox);
		
		textCilinderLength = new JTextField();
		textCilinderLength.setBorder(new TitledBorder(null, "Length", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		textCilinderLength.setBounds(39, 38, 135, 70);
		contentPanel.add(textCilinderLength);
		textCilinderLength.setColumns(10);
		{
			textDiameter = new JTextField();
			textDiameter.setBorder(new TitledBorder(null, "Diameter", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			textDiameter.setBounds(240, 38, 135, 70);
			contentPanel.add(textDiameter);
			textDiameter.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							onOk();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage(),
									"ERROR",JOptionPane.ERROR_MESSAGE);
						}
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
	public void setWoodDirectory(WoodDirectory wd) {
		ComboBoxModel<Object> model=new DefaultComboBoxModel<>(wd.getArr());
		comboBox.setModel(model);
	}
	protected void onOk() throws Exception {
    	float diameter= Float.parseFloat(textDiameter.getText());
    	float length= Float.parseFloat(textCilinderLength.getText());
    	Wood wood=(Wood) comboBox.getSelectedItem();
    	object=new Cilinder(length,diameter, wood);
    	this.setVisible(false);
    }
	protected void onCancel() {
    	object=null;
    	this.setVisible(false);
    }
	protected void clear() {
		textCilinderLength.setText("");
		textDiameter.setText("");
    	object=null;
    }
	public JTextField getTextCilinderLength() {
		return textCilinderLength;
	}
	public JTextField getTextDiameter() {
		return textDiameter;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
