package io;
import java.io.*;
public class EncodeTest {
	public static void write() throws IOException{
		OutputStreamWriter os=new OutputStreamWriter(
				new FileOutputStream("D:/CODE/JAVA/DEFAULT/3.txt"),"utf-8");
		os.write("����һ���ĵ�");
		os.close();
	}
	public static void read() throws IOException{
		InputStreamReader is=new InputStreamReader(
				new FileInputStream("D:/CODE/JAVA/DEFAULT/3.txt"),"utf-8"
				);
		char[] buf=new char[1024/4];
		is.read(buf);
		System.out.println(new String(buf));
		is.close();
	}
	public static void main(String[] args) throws IOException{
		write();
		read();
		String str="���";
		byte[] b=str.getBytes("utf-8");
		for(byte i :b)
			System.out.println(Integer.toBinaryString(i));
	}
}
