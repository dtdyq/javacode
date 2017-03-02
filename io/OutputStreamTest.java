package io;

/*字符流：
 * Reader
 * Writer
 * FileReader
 * FileWriter
 * LineNumberReader
 * 字节流：
 * OutputStream
 * InputStream
 * FileInputStream
 * FileOutputStream
 * read会把读取的一个字节的流转换为四字节的int型
 * write会把int强转为byte型，只留下最后一个字节
 */
import java.io.*;
public class OutputStreamTest {
	static void fileReader()throws Exception{
		FileInputStream fis=new FileInputStream("D:/CODE/JAVA/DEFAULT/2.txt");
		int b;
		while((b=fis.read())!=-1){
			System.out.println((char)b);
		}
		fis.close();
	}
	static void fileReader2() throws Exception{
		FileInputStream fis=new FileInputStream("D:/CODE/JAVA/DEFAULT/2.txt");
		byte[] b=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			System.out.println(new String(b,0,len));
		}
		fis.close();
	}
	static void fileReader3()throws Exception{
		FileInputStream fis=new FileInputStream("D:/code/java/default/2.txt");
		//返回文件的字节数
		int count=fis.available();
		System.out.println(count);
		fis.close();
	}
	public static void main(String[] args) throws Exception{
		fileReader2();
		fileReader3();
	}
}










