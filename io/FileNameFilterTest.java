package io;
import java.io.*;
public class FileNameFilterTest {
	public static void main(String[] args){
		File file=new File("./src");
		String[] nameList=file.list((dir,name)->name.endsWith(".java")||new File(name).isDirectory());
		for(String name:nameList){
			System.out.println(name);
		}
	}
}
