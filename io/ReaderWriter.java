package io;
import java.io.*;
public class ReaderWriter {

	public static void main(String[] args) {
		System.out.println("==================FileReader=======================");
		String str="D:/CODE/JAVA/test/22.txt";
		File file=new File(str);
		FileReader fr=null;
		try {
			fr=new FileReader(file);
			char[] c=new char[8];
			try {
				while(fr.read(c)!=-1){
					System.out.println(c);
				}
			} catch (IOException e) {
				System.out.println("�ļ���ȡ����");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�δ�ҵ�");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("�ļ��رմ���");
				}
			}
		}
		System.out.println("==================FileWriter=======================");
		String strl="D:/CODE/JAVA/test/copystr.txt";
		FileWriter fw=null;
		try {
			fw=new FileWriter(strl);
			String s="�����յ���,��ũ�����ࣻһ��С���飬һ��һ����";
			fw.write(s);
			fw.flush();
			System.out.println("�ļ�д��ɹ�");
		} catch (IOException e) {
			System.out.println("�ļ�д�����");
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("�ļ��رմ���");
				}
			}
		}

	}

}
