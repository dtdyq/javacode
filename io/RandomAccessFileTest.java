package io;
/**
 * 
 * @author dtdyq
 *RandomAccessFile ���಻����IO��ϵ�е����࣬����ֱ�Ӽ̳���Object
 *�߱�����д������
 *�ɶ��ļ�������λ�÷��ʣ����ж�д����
 *
 *���ڲ���װ�����ֽ��������������������
 *
 *��������ֻ�ܲ����ļ�
 *����������Ҫ�й̶��ĸ�ʽ
 *�������ģʽΪֻ���Ļ����������Ѵ��ڵ��ļ��������׳��쳣
 *�������ģʽΪ��д�Ļ�������������ļ������ڣ���ᴴ���ļ�������ļ����ڣ�Ҳ���Ḳ���ļ�
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
