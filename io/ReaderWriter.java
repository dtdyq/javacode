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
				System.out.println("文件读取错误");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到");
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					System.out.println("文件关闭错误");
				}
			}
		}
		System.out.println("==================FileWriter=======================");
		String strl="D:/CODE/JAVA/test/copystr.txt";
		FileWriter fw=null;
		try {
			fw=new FileWriter(strl);
			String s="锄禾日当午,码农真辛苦；一本小破书，一读一上午";
			fw.write(s);
			fw.flush();
			System.out.println("文件写入成功");
		} catch (IOException e) {
			System.out.println("文件写入错误");
		}finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("文件关闭错误");
				}
			}
		}

	}

}
