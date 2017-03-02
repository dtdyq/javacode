package io;
import java.io.*;
public class PictureCopy {
	public static void pCopy(String str1,String str2)throws IOException{
		FileInputStream fis=new FileInputStream(str1);
		FileOutputStream fos=new FileOutputStream(str2);
		byte[] buff=new byte[1024];
		int len=0;
		while((len=fis.read(buff))!=-1){
			fos.write(buff,0,len);
		}
		fis.close();
		fos.close();
	}
	static void pCopy2(String str1,String str2) throws Exception{
		MyBufferReader bis=new MyBufferReader(new FileInputStream(str1));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(str2));
		int b=0;
		while((bis.myRead())!=-1){
			bos.write(b);
		}
		bis.myClose();
		bos.close();
	} 
	public static void main(String[] args) throws Exception{
		long t1=System.currentTimeMillis();
		for(int i=0;i<1;i++)
			pCopy("D:/test.avi","C:/Users/dtdyq/Desktop/npp.7.3.bin/themes/test.avi");
		System.out.println(System.currentTimeMillis()-t1);
		long t2=System.currentTimeMillis();
		for(int i=0;i<1;i++)
			pCopy2("D:/test.avi","C:/Users/dtdyq/Desktop/npp.7.3.bin/themes/test.avi");
		System.out.println(System.currentTimeMillis()-t2);
		
		
	}
}
