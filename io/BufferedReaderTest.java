package io;
import java.io.*;
public class BufferedReaderTest {
	public static void main(String[] args){
		MyBufferedReader mb=null;
			try{
				mb=new MyBufferedReader("././WriterTest.txt");
				String str=null;
				while((str=mb.readLine())!=null){
					System.out.println(str);
				}
			}catch(IOException e){
				System.out.println(e.toString());
			}
			
	}
}
class MyBufferedReader{
	FileReader fr=null;
	public MyBufferedReader(String str){
		try{
			fr=new FileReader(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	public String readLine() throws IOException{
		StringBuilder sb=new StringBuilder();
		int ch=0;
		while((ch=fr.read())!=-1){
			if(ch=='\r'){
				continue;
			}
			if(ch=='\n'){
				return sb.toString();
			}
			else
			sb.append((char)ch);
		}
		return null;
	}
	public boolean close(){
		try{
			fr.close();
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return true;
	}
}