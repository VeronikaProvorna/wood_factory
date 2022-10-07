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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import model.Timber;
import model.Wood;
import store.WoodDirectory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTimber extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textTimberHeight;
	private JTextField textTimberWidth;
	private JTextField textTimberLength;
	private JComboBox comboBox;
	private Timber object = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTimber dialog = new DlgTimber();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTimber() {
		setModal(true);
		setTitle("Timber Information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textTimberHeight = new JTextField();
			textTimberHeight.setBorder(new TitledBorder(null, "Height", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textTimberHeight.setBounds(30, 29, 96, 61);
			contentPanel.add(textTimberHeight);
			textTimberHeight.setColumns(10);
		}
		{
			textTimberWidth = new JTextField();
			textTimberWidth.setBorder(new TitledBorder(null, "Width", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textTimberWidth.setBounds(170, 29, 96, 61);
			contentPanel.add(textTimberWidth);
			textTimberWidth.setColumns(10);
		}
		{
			textTimberLength = new JTextField();
			textTimberLength.setBorder(new TitledBorder(null, "Length", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textTimberLength.setBounds(308, 29, 96, 61);
			contentPanel.add(textTimberLength);
			textTimberLength.setColumns(10);
		}
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBorder(new TitledBorder(null, "Wood Selection", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(0, 0, 0)));
		comboBox.setBounds(61, 139, 314, 61);
		contentPanel.add(comboBox);
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
	public Timber getObject() {
		return object;
	}
	public void setWoodDirectory(WoodDirectory wd) {
		ComboBoxModel<Object> model=new DefaultComboBoxModel<>(wd.getArr());
		comboBox.setModel(model);
	}
	protected void onOk() throws Exception {
    	float height= Float.parseFloat(textTimberHeight.getText());
    	float width= Float.parseFloat(textTimberWidth.getText());
    	float length= Float.parseFloat(textTimberLength.getText());
    	Wood wood=(Wood) comboBox.getSelectedItem();
    	object=new Timber(wood, height, length, width);
    	this.setVisible(false);
    }
    protected void onCancel() {
    	object=null;
    	this.setVisible(false);
    }
    protected void clear() {
    	textTimberHeight.setText("");
    	textTimberWidth.setText("");
    	textTimberLength.setText("");
    	object=null;
    }
	public JTextField getTextTimberHeight() {
		return textTimberHeight;
	}
	public JTextField getTextTimberWidth() {
		return textTimberWidth;
	}
	public JTextField getTextTimberLength() {
		return textTimberLength;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
}
