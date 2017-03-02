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
		System.out.println(strl.isAbsolute()?"�Ǿ���·��":"�Ǿ���·��");
		File file=new File("D:/CODE/JAVA/test/22.txt");
		System.out.println(file.isAbsolute()?"�Ǿ���·��":"�Ǿ���·��");
		if(strl.isFile()){
			System.out.println("strl�ļ�");
		}
		else{
			System.out.println("strl���ļ���");
		}
		//Ҫ���ݸ�Ŀ¼���Ƿ����ļ����ж��Ƿ����ļ�������һ����Ϊ���ļ�����
		if(file.isFile()){
			System.out.println("file�ļ�");
		}
		else{
			System.out.println("file���ļ���");
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
