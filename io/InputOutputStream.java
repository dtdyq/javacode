package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutputStream {

	public static void main(String[] args) {
		File file=new File("D:/CODE/JAVA/test/22.txt");
		InputStream is=null;
		
		try {
			is=new FileInputStream(file);
			byte[] car=new byte[10];
			int len=0;
			while((len=is.read(car))!=-1){
				String info=new String(car,0,len);
				System.out.println(info);
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�δ�ҵ�");
		}catch(IOException e){
			System.out.println("�ļ���ȡ����");
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					
					System.out.println("�ļ��رմ���");
					
				}
			}
		}
		File temp=new File("D:\\CODE\\JAVA\\test\\dataout.txt");
		OutputStream os=null;
		try {
			os=new FileOutputStream(temp,true);
			String str="this is a paragraph����";
			os.write(str.getBytes());
		} catch (FileNotFoundException e){
			System.out.println("�ļ�����");
		} catch (IOException e) {
			System.out.println("�������");
		}finally{
			if(os!=null){
				try{
					os.close();
				}catch(IOException e){
					System.out.println("�ļ��رմ���");
				}
			}
		}

	}

}
