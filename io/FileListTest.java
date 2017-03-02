package io;
/**
 * 列出文件夹中的所有文件
 */
import java.io.*;
public class FileListTest {
	public static void fList(String str,int level){
		fList(new File(str),level);
	}
	public static void fList(File file,int level){
		System.out.println(level(level)+file.getName());
		File[] ff=file.listFiles();
		for(int f=0;f<ff.length;f++){
			if(ff[f].isDirectory()){
				fList(ff[f],level+1);
			}
			else{
				System.out.println(level(level+1)+ff[f].getName());
			}
		}
	}
	private static String level(int l){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<l;i++){
			sb.append("    ");
		}
		return sb.toString();
	}
	public static void main(String[] args){
		fList("D:/apache",0);
	}
}

