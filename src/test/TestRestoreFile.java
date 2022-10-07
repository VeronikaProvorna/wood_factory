package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Wood;
import store.WoodDirectory;

public class TestRestoreFile {

	public static void main(String[] args) {
		WoodDirectory wd = null;
		File f =new File("wd.object");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois =new ObjectInputStream(fis);
			wd=(WoodDirectory)ois.readObject();
			ois.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(wd!=null) {
			for(Object w: wd.getArr())
				System.out.println(w.toString());
		}
	}
	}


