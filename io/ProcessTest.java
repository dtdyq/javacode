package io;

import java.io.*;
import java.util.Scanner;

public class ProcessTest {
	public static void main(String[] args) throws IOException{
		Process p=Runtime.getRuntime().exec("javac");
		BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		String buf=null;
		while((buf=br.readLine())!=null){
			System.out.println(buf);
		}
	}
}
/*
 * cannot understand
 */
class WriteToProcess{
	public static void main(String[] args) throws IOException{
		Process p=Runtime.getRuntime().exec("java D:\\CODE\\JAVA\\DEFAULT\\bin\\io\\ReadStandard");
		PrintStream ps=new PrintStream(p.getOutputStream());
		ps.println("ÆÕÍ¨×Ö·û´®");
		ps.println(new WriteToProcess());
	}
}
class ReadStandard{
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("===");
		Scanner sc=new Scanner(System.in);
		PrintStream ps=new PrintStream(new FileOutputStream("D:\\CODE\\JAVA\\DEFAULT\\2.txt"));
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			ps.println("input:  "+sc.next());
		}
		sc.close();
		ps.close();
	}
}



















