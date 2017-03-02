package io;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ExceptionBlogTest {
	public static void main(String[] args){
		try{
			int[] arr=new int[2];
			System.out.println(arr[3]);
		}catch(IndexOutOfBoundsException e){
			try{
				PrintStream ps=new PrintStream("D:/CODE/JAVA/DEFAULT/test.txt");
				Date d=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
				String str=sdf.format(d);
				ps.print(str+"\r\n");
				e.printStackTrace(ps);
			}catch(IOException ex){
				System.out.println("error");
			}
		}
	}
}
