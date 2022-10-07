package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;

public class TestFile {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JFileChooser dialog = new JFileChooser();
		dialog.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Файли типу .txt";
			}
			
			@Override
			public boolean accept(File f) {
				if(f!=null) {
					return f.isDirectory() || f.toString().endsWith(".txt");
				}
				return false;
			}
		});
		dialog.showOpenDialog(null);
		File f =dialog.getSelectedFile();
		if(f != null) {
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			String name="\n Provorna V.K. KI-201\n";
			writer.write(name);
					for(int i=0;i<10;i++) {
				double x = Math.random();
				String s= String.valueOf(x);
				writer.write(s);
				writer.newLine();
			}
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		BufferedReader reader = null;
		if(f!=null) {
			try {
				reader = new BufferedReader(new FileReader(f));
				String s;
				while((s=reader.readLine())!=null) {
					System.out.println(s);
				}
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
