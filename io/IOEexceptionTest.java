package io;
import java.io.*;
/*
 * ��д�ļ�
 */
public class IOEexceptionTest {
	public static void main(String[] args){
		FileWriter fw=null;
		try{
			fw=new FileWriter("././WriterTest.txt",true);
			//��windowsϵͳ�У�����Ҫʹ��\r��\n;
			fw.write("083\r\n2956739");
			//д���ַ����е��ַ���1�����ȡ�ַ�����ʼλ�ã�8����д����ַ���
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
