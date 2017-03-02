package io;
import java.io.*;
public class FileDeleteTest {
	static void fileDel(String str){
		fileDel(new File(str));
	}
	static void fileDel(File file){
		File[] f=file.listFiles();
		for(int i=0;i<f.length;i++){
			if(f[i].isDirectory()){
				fileDel(f[i]);
			}
			else{
				f[i].delete();
			}
		}
		file.delete();
	}
	public static void main(String[] args){
		fileDel("D:/CODE/JAVA/DEFAULT/mkdirs");
	}
}
