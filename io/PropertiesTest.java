package io;

import java.util.Properties;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class PropertiesTest {
	public static void main(String[] args) throws IOException{
//		Properties pop=System.getProperties();
//		pop.list(System.out);
//		try {
//			pop.list(new PrintStream("D:/CODE/JAVA/DEFAULT/test.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		FileReader fr=new FileReader("D:/CODE/JAVA/DEFAULT/3.txt");
		FileWriter fw=new FileWriter("D:/CODE/JAVA/DEFAULT/3.txt",true);
		Properties pop=new Properties();
		pop.load(fr);
		System.out.println(pop);
		System.out.println(pop.getProperty("time"));
		fr.close();
		fw.close();
	}
}
