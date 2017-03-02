package io;
/**
 * 
 * @author dtdyq
 *字节流：InputStream OutputStream
 *最常用对象：FileInputStream FileOutputStream
 *				可以逐字节的读取，也可以一次读取固定的字节数或指定字节数
 *为提高效率而增加的缓冲流： BufferedInputStream  BufferedOutputStream
 *								可按行读取
 *--->对对象进行读取和写入： ObjectInputStream ObjectOutputStream
 *				被写的对象必须实现序列化：serilizable，其中被transient修饰的变量不能被写入
 *--->对数据进行读取和写入： DataInputStream  DataOutputStream
 *--->相当于可变长的字节数组： ByteArrayInputStream  ByteArrayOutputStream 
 *
 *
 *字符流；Reader  Writer
 *最长用的对象： FileReader  FileWriter
 *				可进行读取的方式与字节流相同，只是字节数组改为了字符数组
 *为提高效率而增加的缓冲流： BufferedReader  BufferedWriter
 *								可按行读取
 *--->StringReader StringWriter:相当于可变长的String数组
 *--->CharArrayReader CharArrayWriter  :相当于可变长的字符数组
 *
 *
 *其他字节流和字符流：
 *打印流：  PrintStream  PrintWriter     用于向控制台或文件打印字节流或字符流
 *
 *转换流： InputStreamReader   OutputStreamWriter   :用于字节流和字符流之间的转换，可指定编码类型
 *
 *键值对形式的Properties  ：常用于配置文件
 *
 *控制台输入输出：System.in   System.out
 *
 *管道流：PipedInputStream   PipedOutputStream  :常用于多线程对共享资源的读取，防止死锁
 *
 *随机读取文件：RandomAccessFile   ：可在文件任意位置读取或写入
 *
 *SequenceInputStream（Enumeration<? extends InputStream> e）：对多个文件进行一次读取
 *
 *LineNumberInputStream   LineNumberReader  
 *			带行号的的读取，可用于设置行号
 *
 *
 */
import java.io.*;
public class IOTest {
	static void FileInputOutputStreamTest(){
		FileInputStream fis=null;
		FileOutputStream fos=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try{
			fis=new FileInputStream("D:/CODE/JAVA/DEFAULT/IOTest.txt");
			fos=new FileOutputStream("D:/CODE/JAVA/DEFAULT/IOTest.txt",true);
			bis=new BufferedInputStream(fis);
			bos=new BufferedOutputStream(fos);
			byte[] b=new byte[16];
			int len=0;
			StringBuilder sb=new StringBuilder();
			while((len=fis.read(b))!=-1){
				sb.append(new String(b,0,len));
			}
			System.out.println(sb.toString());
			fos.write(new String(sb).getBytes());
			fis.close();
			fos.close();
			bis.close();
			bos.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}
	static void FileReaderWriterTest(){
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			fr=new FileReader("D:/CODE/JAVA/DEFAULT/IOTest.txt");
			fw=new FileWriter("D:/CODE/JAVA/DEFAULT/IOTest.txt",true);
			br=new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			String str=null;
			while((str=br.readLine())!=null){
				System.out.println(str);
			}
			bw.write("bw!!");
			bw.flush();
			fr.close();
			fw.close();
			br.close();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	static void ObjectTest(){
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
		try{
			oos=new ObjectOutputStream(new FileOutputStream("D:/CODE/JAVA/DEFAULT/object.txt"));
			ois=new ObjectInputStream(new FileInputStream("D:/CODE/JAVA/DEFAULT/object.txt"));
			Cat dog=new Cat("small",23,538.43);
			oos.writeObject(dog);
		
			Cat newdog=(Cat)ois.readObject();
			
			System.out.println(newdog);
			
			oos.close();
			ois.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException ee){
			ee.printStackTrace();
		}
		
	}
	static void DataTest(){
		DataInputStream dis=null;
		DataOutputStream dos=null;
		try{
			dis=new DataInputStream(new FileInputStream("D:/CODE/JAVA/DEFAULT/IOTest.txt"));
			dos=new DataOutputStream(new FileOutputStream("D:/CODE/JAVA/DEFAULT/IOTest.txt"));
			dos.writeInt(734);
			dos.writeDouble(43.654);
			dos.writeBoolean(true);
			dos.flush();
			System.out.println(dis.readInt());
//			System.out.println(dis.readFloat());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			dis.close();
			dos.close();
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	public static void main(String[] args){
//		FileReaderWriterTest();
//		ObjectTest();
//		DataTest();
		
	}
}
class Cat implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	static int age;
	transient double weight;
	@SuppressWarnings("static-access")
	public Cat(String name,int age,double weight){
		this.name=name;
		this.age=age;
		this.weight=weight;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@SuppressWarnings("static-access")
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public double getWeight(){
		return weight;
	}
	public String toString(){
		return name+"---"+age+"---"+weight;
	}
}





