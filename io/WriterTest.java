package io;
/**
 * 
 * @author dtdyq
 *字符流：
 *Writer Rrader
 *字节流  ：
 *InputStream OutputStream
 */
import java.io.*;
public class WriterTest {
	public static void main(String[] args){
		FileWriter fw=null;
		FileReader fr=null;
		try{
			//如果同一目录下有同名文件，则被覆盖
			//
			fw=new FileWriter(".\\.\\WriterTest.txt",true);
			fw.write("文本文件呢");
			fw.flush();
			fw.close();
		}catch(IOException e){
			System.out.println("open error");
		}
		try{
			fr=new FileReader(".\\.\\WriterTest.txt");
			//int k=fr.read();
			char[] ch=new char[3];
			fr.read(ch);
			//System.out.println(k);
			System.out.println(new String(ch));
			System.out.println("=======================");
			int c=fr.read();
			System.out.println(c);
		}catch(FileNotFoundException e){
			System.out.println("error");
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
}
