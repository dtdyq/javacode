package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			RandomAccessFile file=new RandomAccessFile(new File("D:/CODE/JAVA/test/copy.txt"), "r");
			byte[] b=new byte[1024];
			try {
				file.read(b);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(new String(b));
		} catch (FileNotFoundException e) {
			System.out.println("error");
		}

	}

}
