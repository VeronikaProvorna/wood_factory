package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import model.Wood;
import store.WoodDirectory;

public class TestStoreFile {

	public static void main(String[] args) {
		WoodDirectory wd = new WoodDirectory();
		wd.add(new Wood("Oak",4,3f));
		File f =new File("wd.object");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			oos.writeObject(wd);
			oos.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
