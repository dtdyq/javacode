package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	public static boolean copy(File f1,File f2){
		if(f1.isDirectory()||f2.isDirectory()){
			return false;
		}
		InputStream is=null;
		OutputStream os=null;
		try {
			is=new FileInputStream(f1);
			os=new FileOutputStream(f2,true);
			int len=0;
			byte[] b=new byte[4];
			while((len=is.read(b))!=-1){
				os.write(b,0,len);
				os.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}catch (IOException e) {
			System.out.println("io error");
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("文件关闭错误");
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println("文件关闭错误");
				}
			}
		}
		return true;
	}
	public static boolean copy(String str1,String str2){
		return copy(new File(str1),new File(str2));
	}
	public static void main(String[] args) {
		String copy="D:/CODE/JAVA/test/22.txt";
		String paste="D:/CODE/JAVA/test/copy.txt";
		copy(copy,paste);
		File f1=new File(copy);
		File f2=new File(paste);
		copy(f1,f2);
		
	}

}
