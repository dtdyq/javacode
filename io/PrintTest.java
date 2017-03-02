package io;
/*
 * 打印流：
 * printStream
 *   构造函数：
 *   	file对象
 *   	字节输出流
 *   	字符串路径
 * printWriter
 *   构造函数：
 *   	file对象
 *   	字节输出流
 *   	字符串路径
 *      字符输出流
 * 
 */
import java.io.*;
public class PrintTest {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(System.out,true);
		String line=null;
		while((line=br.readLine())!=null){
			ps.println(line);
		}
		ps.write((char)14);
		br.close();
		ps.close();
	}
}






