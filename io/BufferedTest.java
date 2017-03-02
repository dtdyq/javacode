package io;
/*
 * BufferedReader一次可以读取一行，但不包含行尾的换行符
 */
import java.io.*;
public class BufferedTest{
	static long ReaderTest(int k){
		long d=System.currentTimeMillis();
		FileReader fr=null;
		FileWriter fw=null;
		try{
			fr=new FileReader("././test.txt");
			fw=new FileWriter("././BufferedTest.txt");
			for(int i=0;i<k;i++){
				char[] ch=new char[1024];
				while((fr.read(ch))!=-1){
					fw.write(ch);
					fw.flush();
				}
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			try{
				fr.close();
				fw.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
		return System.currentTimeMillis()-d;
	}
	static long BufferTest(int k){
		long d=System.currentTimeMillis();
		BufferedReader br=null;
		BufferedWriter bw=null;
		try{
			br=new BufferedReader(new FileReader("././test.txt"));
			bw=new BufferedWriter(new FileWriter("././BufferedTest.tet"));
			for(int i=0;i<k;i++){
				char[] ch=new char[1024];
				while((br.read(ch))!=-1){
					bw.write(ch);
					bw.flush();
				}
			}
		}catch(IOException e){
			System.out.println("error");
		}finally{
			try{
				bw.close();
				br.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
		return System.currentTimeMillis()-d;
	}
	public static void main(String[] args){
		System.out.println(ReaderTest(10000));
		System.out.println(BufferTest(10000));
	}
}

