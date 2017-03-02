package io;
import java.io.*;
public class Buffered {

	public static void main(String[] args) {
		File file=new File("D:/CODE/JAVA/ALGORITHMS/data/routes.txt");
		BufferedReader bis;
		try{
				bis=new BufferedReader(
						new FileReader(file)
						);
		String str=null;
		while((str=bis.readLine())!=null){
			System.out.println(str);
		}
		}catch(IOException e){
			System.out.println("io");
		}
		
	}

}
