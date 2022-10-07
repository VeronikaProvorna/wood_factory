package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import model.Waste;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgWaste extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textWasteWeight;
    private Waste object=null;
    public Waste getObject() {
    	return object;
    }
	public static void main(String[] args) {
		try {
			DlgWaste dialog = new DlgWaste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgWaste() {
		setModal(true);
		setTitle("Waste information");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textWasteWeight = new JTextField();
			textWasteWeight.setBorder(new TitledBorder(null, "Weight", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			textWasteWeight.setBounds(101, 77, 221, 64);
			contentPanel.add(textWasteWeight);
			textWasteWeight.setColumns(10);
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
    protected void onOk() throws Exception {
    	float weight=Float.parseFloat(textWasteWeight.getText());
        object=new Waste(weight);
        this.setVisible(false);
    }
    protected void onCancel() {
    	object=null;
    	this.setVisible(false);
    }
    public void clear() {
    	textWasteWeight.setText("");
    	object=null;
    }
	public JTextField getTextWasteWeight() {
		return textWasteWeight;
	}
}
