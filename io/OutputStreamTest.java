package io;

/*�ַ�����
 * Reader
 * Writer
 * FileReader
 * FileWriter
 * LineNumberReader
 * �ֽ�����
 * OutputStream
 * InputStream
 * FileInputStream
 * FileOutputStream
 * read��Ѷ�ȡ��һ���ֽڵ���ת��Ϊ���ֽڵ�int��
 * write���intǿתΪbyte�ͣ�ֻ�������һ���ֽ�
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
		//�����ļ����ֽ���
		int count=fis.available();
		System.out.println(count);
		fis.close();
	}
	public static void main(String[] args) throws Exception{
		fileReader2();
		fileReader3();
	}
}










