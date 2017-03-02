package io;
/*
 * BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 * InputStreamReader 从字节转换到字符，读入的System.in属于字节流
 * Writer out=new BufferedWriter(new OutputStreamWriter(System.out));
 * OutputStreamWriter 从字符流转换到字节流，输出System.out属于标准字节输出流
 * 
 * 两个类用于从磁盘输入字节流转换为字符流，或将字符转换为字节流输出到磁盘
 * 
 * 流操作的基本规律：
 * 1、明确流的源和目的，即输入流和输出流
 * 		|--源：Reader InputStream
 * 		|--目的：Writer OutputStream
 * 2、操作的数据是字符流和字符流
 * 		|--字节流：InputStream  OutputStream
 * 		|--字符流：Reader  Writer
 * 3、明确要使用的具体具体的对象
 * 		|硬盘、控制台、键盘
 * 4、是否需要提高效率
 * 		|小的文件或次数少的读写，不需要考虑效率问题
 * 
 * ？？？疑问：
 * System.in和System.out为什么是字节输入输出流
 * 
 * 
 * ！！！编码方式只有转换流可以指定
 * 转换流：字节流和字符流之间转换的桥梁
 * 涉及到字符编码的转换和设置
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class InputStreamReaderTest {
	public static void main(String[] args) throws IOException{
		InputStream in=System.in;
		InputStreamReader ir=new InputStreamReader(in);
		BufferedReader br=new BufferedReader(ir);
		OutputStream os=System.out;
		OutputStreamWriter ow=new OutputStreamWriter(os);
		BufferedWriter bw=new BufferedWriter(ow);
		try{
			while(true){
				String str=br.readLine();
				if(str.equals("over")){
					break;
				}
				bw.write(str+"\r\n");
				bw.flush();
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		in.close();
		ir.close();
		br.close();
		os.close();
		ow.close();
		bw.close();
	}
}
