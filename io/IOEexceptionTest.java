package io;
import java.io.*;
/*
 * 续写文件
 */
public class IOEexceptionTest {
	public static void main(String[] args){
		FileWriter fw=null;
		try{
			fw=new FileWriter("././WriterTest.txt",true);
			//在windows系统中，换行要使用\r和\n;
			fw.write("083\r\n2956739");
			//写入字符串中的字符，1代表读取字符的起始位置，8代表写入的字符数
			fw.write("abcdefghijk", 1, 8);
			String str=fw.getEncoding();
			System.out.println(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			try{
				fw.flush();
				fw.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
}
