package io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class javaFIleList {
	static void javaFileList(String str,List<File> list){
		
		javaFileList(new File(str),list);
	}
	static void javaFileList(File file, List<File> list){
		File[] f=file.listFiles();
		for(int i=0;i<f.length;i++){
			if(f[i].isDirectory()){
				javaFileList(f[i],list);
			}
			else{
				list.add(f[i]);
			}
		}
	}
	public static void writeTo(List<File> list,String str){
		writeTo(list,new File(str));
	}
	public static void writeTo(List<File> list,File file){
		BufferedWriter bw=null;
		try{
			bw=new BufferedWriter(new FileWriter(file));
			for(File f:list){
				bw.write(f.getAbsolutePath()+"\r\n");
			}
		}catch(IOException e){
			System.out.println(e.toString());
			
		}finally{
			try{
				bw.close();
			}catch(IOException e){
				System.out.println("error");
			}
			}
	}
	public static void main(String[] args){
		List<File> list=new ArrayList<>();
		javaFileList("D:/CODE/JAVA/DEFAULT/src",list);
		System.out.println(list.size());
		int count=0;
		for(File file:list){
			System.out.println((count++)+file.getName());
		}
		writeTo(list,"././javalog.txt");
		
	}
}
