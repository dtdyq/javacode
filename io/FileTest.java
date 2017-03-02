package io;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		File src=new File("D:/CODE/JAVA/test");
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getPath());
		System.out.println(src.isDirectory());
		System.out.println("-------------------");
		File str=new File("2.txt");
		System.out.println(str.getName());
		System.out.println(str.getAbsolutePath());
		File f=new File("D:/CODE/JAVA/test/22.txt");
		try {
			
			f.createNewFile();
			System.out.println(f.length());
		} catch (IOException e) {
			System.out.println("file create error!");
		}
		System.out.println(str.exists());
		System.out.println(str.canRead());
		System.out.println(str.canWrite());
		System.out.println("--------------------");
		File strl=new File("D:/CODE/JAVA/test");
		System.out.println(strl.isAbsolute()?"是绝对路径":"非绝对路径");
		File file=new File("D:/CODE/JAVA/test/22.txt");
		System.out.println(file.isAbsolute()?"是绝对路径":"非绝对路径");
		if(strl.isFile()){
			System.out.println("strl文件");
		}
		else{
			System.out.println("strl是文件夹");
		}
		//要根据该目录下是否有文件来判断是否是文件，否则一律作为非文件处理
		if(file.isFile()){
			System.out.println("file文件");
		}
		else{
			System.out.println("file是文件夹");
		}
		try {
			File temp=File.createTempFile("temp", ".txt",new File("D:/CODE/JAVA/test"));
			temp.deleteOnExit();
			System.out.println(temp.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
