package io;
/*
 *IO 总结：
 *字节流：   InputStream  OutputStream
 *      FileInputStream  FileOutputStream   ：对字节流文件进行读取
 *      BufferedInputStream  BufferedOutputStream   ：用于缓冲的字节流，可以提高字节流的效率
 *      DataInputStream   DataOutputStream    ：对基本数据类型进行读写
 *      ObjectInputStream  ObjectInputStream    ：对对象（要实现序列化、transient修饰的不能被实例化）进行读写操作
 *      ByteArrayInputStream  ByteArrayOutputStream   ：对字节数组进行读写，相当于可变长数组，不需要进行close操作
 *字符流：    Reader  Writer  
 *		FileReader  FileReader   ：对字符文件进行读写
 *		BufferedReader  BufferedWriter  ：用于对字符流进行缓冲，可以提高读写效率
 *		CharArrayReader CharArrayWriter    ：相当于可变长的字符串数组
 *		StringReader  StringWriter    ：字符串读写
 *
 *基本输入输出：  System.in   System.out
 *
 *键值对形式的IO存取类：Properties ：可用于配置文件
 *
 *其它类型的输入输出流：
 *PipedInputStream（PipedOutputStream）  PipedOutputStream （PipedInputStream）
 *			管道流：用于将输入输出流加入到管道流，用于多线程进行读写，防止死锁
 *
 *SequenceInputStream（Enumeration<? extends InputStream> e）   ：
 *			合并流：用于同时顺序读取多个输入流
 *
 *RandomAccessFile：
 *			随机读取文件：用于在文件的任意位置进行插入和读取操作
 *
 *PrintStream  PrintWriter ：
 *			打印流：用于高效的进行打印操作，可指定具体的编码
 *
 *LineNumberInputStream   LineNumberReader  
 *			带行号的的读取，可用于设置行号
 *
 ****转换流：InputStreamReader   OutputStreamWriter  
 *			用于字符流和字节流之间的转换，可指定特定的编码类型
 *			具体的字符编码见EncodeTest中。
 */
public class IOAllTest {
	public static void main(String[] args){
	
		System.out.println(Math.pow(2, 16));
		System.out.println(Character.BYTES);
	}
}
