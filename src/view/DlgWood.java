package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Wood;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgWood extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textWoodId;
	private JTextField textWoodName;
	private JTextField textWoodDensity;
    private Wood object=null;
    public Wood getObject() {
    	return object;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgWood dialog = new DlgWood();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWood() {
		setModal(true);
		setTitle("Wood Information");
		setBounds(100, 100, 364, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textWoodId = new JTextField();
			textWoodId.setBorder(new TitledBorder(null, "Id", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textWoodId.setBounds(26, 26, 103, 42);
			contentPanel.add(textWoodId);
			textWoodId.setColumns(10);
		}
		{
			textWoodName = new JTextField();
			textWoodName.setBorder(new TitledBorder(null, "Wood", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textWoodName.setBounds(156, 26, 156, 42);
			contentPanel.add(textWoodName);
			textWoodName.setColumns(10);
		}
		{
			textWoodDensity = new JTextField();
			textWoodDensity.setBorder(new TitledBorder(null, "Density", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			textWoodDensity.setBounds(33, 92, 96, 42);
			contentPanel.add(textWoodDensity);
			textWoodDensity.setColumns(10);
		}
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
    protected void onOk() {
    	int id=Integer.parseInt(textWoodId.getText());
    	String name=textWoodName.getText();
    	float density= Float.parseFloat(textWoodDensity.getText());
    	object=new Wood(name, id, density);
    	this.setVisible(false);
    }
    protected void onCancel() {
    	object=null;
    	this.setVisible(false);
    }
    protected void clear() {
    	textWoodId.setText("");
    	textWoodName.setText("");
    	textWoodDensity.setText("");
    	object=null;
    }
	public JTextField getTextWoodId() {
		return textWoodId;
	}
	public JTextField getTextWoodName() {
		return textWoodName;
	}
	public JTextField getTextWoodDensity() {
		return textWoodDensity;
	}
}
