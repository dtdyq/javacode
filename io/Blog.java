package io;
import java.io.*;
import java.util.*;
public class Blog{
	private static final String strl="==============================\n";
	private static final String temp="-------------------\n";
	public static void main(String[] args) throws Exception{
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		BufferedWriter bw=new BufferedWriter(
				new FileWriter(
						new File("C:\\Users\\dtdyq\\Blog.txt"),true
						)
				);
		bw.write(strl);
		bw.newLine();
		bw.write(new Date().toString());
		bw.newLine();
		bw.write(temp);
		bw.newLine();
		while(in.hasNext()){
			String str=in.next();
			if(str=="^Z"){
				break;
			}
			bw.write(str);
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}