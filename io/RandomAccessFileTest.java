package io;
/**
 * 
 * @author dtdyq
 *RandomAccessFile 该类不属于IO体系中的子类，而是直接继承自Object
 *具备读和写的能力
 *可对文件的任意位置访问，进行读写操作
 *
 *其内部封装的是字节流（输入流和输出流）
 *
 *：：该类只能操作文件
 *：：而且需要有固定的格式
 *如果操作模式为只读的话，则会操作已存在的文件，否则抛出异常
 *如果操作模式为读写的话：如果操作的文件不存在，则会创建文件，如果文件存在，也不会覆盖文件
 */
import java.io.*;
public class RandomAccessFileTest {
	public static void writeFile() throws IOException{
		RandomAccessFile raf=new RandomAccessFile("D:/CODE/JAVA/DEFAULT/3.txt","rw");
		raf.write("hahahaha".getBytes());
		raf.seek(100);
		raf.write("hahahaha".getBytes());
		raf.close();
	}
	public static void main(String[] args) throws IOException{
		writeFile();
	}
}
