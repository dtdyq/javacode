package io;
/**
 * 
 * @author dtdyq
 *�ֽ�����InputStream OutputStream
 *��ö���FileInputStream FileOutputStream
 *				�������ֽڵĶ�ȡ��Ҳ����һ�ζ�ȡ�̶����ֽ�����ָ���ֽ���
 *Ϊ���Ч�ʶ����ӵĻ������� BufferedInputStream  BufferedOutputStream
 *								�ɰ��ж�ȡ
 *--->�Զ�����ж�ȡ��д�룺 ObjectInputStream ObjectOutputStream
 *				��д�Ķ������ʵ�����л���serilizable�����б�transient���εı������ܱ�д��
 *--->�����ݽ��ж�ȡ��д�룺 DataInputStream  DataOutputStream
 *--->�൱�ڿɱ䳤���ֽ����飺 ByteArrayInputStream  ByteArrayOutputStream 
 *
 *
 *�ַ�����Reader  Writer
 *��õĶ��� FileReader  FileWriter
 *				�ɽ��ж�ȡ�ķ�ʽ���ֽ�����ͬ��ֻ���ֽ������Ϊ���ַ�����
 *Ϊ���Ч�ʶ����ӵĻ������� BufferedReader  BufferedWriter
 *								�ɰ��ж�ȡ
 *--->StringReader StringWriter:�൱�ڿɱ䳤��String����
 *--->CharArrayReader CharArrayWriter  :�൱�ڿɱ䳤���ַ�����
 *
 *
 *�����ֽ������ַ�����
 *��ӡ����  PrintStream  PrintWriter     ���������̨���ļ���ӡ�ֽ������ַ���
 *
 *ת������ InputStreamReader   OutputStreamWriter   :�����ֽ������ַ���֮���ת������ָ����������
 *
 *��ֵ����ʽ��Properties  �������������ļ�
 *
 *����̨���������System.in   System.out
 *
 *�ܵ�����PipedInputStream   PipedOutputStream  :�����ڶ��̶߳Թ�����Դ�Ķ�ȡ����ֹ����
 *
 *�����ȡ�ļ���RandomAccessFile   �������ļ�����λ�ö�ȡ��д��
 *
 *SequenceInputStream��Enumeration<? extends InputStream> e�����Զ���ļ�����һ�ζ�ȡ
 *
 *LineNumberInputStream   LineNumberReader  
 *			���кŵĵĶ�ȡ�������������к�
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





