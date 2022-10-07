package test;

import java.io.File;

import javax.swing.JFileChooser;

public class FileTest {

	public static void main(String[] args) {
		JFileChooser dialog = new JFileChooser();
		dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		dialog.setDialogTitle("�������� �.�. ʲ-201");
		dialog.setApproveButtonText("³������");
		dialog.setMultiSelectionEnabled(true);
		dialog.showOpenDialog(null);
		File[] ff = dialog.getSelectedFiles();
		if(ff != null) {
			for (File f : ff) {
				System.out.println(f.getAbsolutePath());
			}
	}

}
}
