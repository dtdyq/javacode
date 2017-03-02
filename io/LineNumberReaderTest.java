package io;

/*
◊∞ Œ¿‡£∫LineNumberRedaer
*/
import java.io.*;
public class  LineNumberReaderTest{
	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("D:/CODE/JAVA/DEFAULT/2.txt");
		myLineReader lr=new myLineReader(fr);
		lr.setLineNumber(100);
		String line=null;
		while((line=lr.readLine())!=null){
			System.out.println(lr.getLineNumber()+" "+line);
		}
		fr.close();
		lr.myClose();
	}
}
class myLineReader{
	private Reader r;
	private int lineNumber;
	public myLineReader(Reader r){
		this.r=r;
	}
	public void setLineNumber(int linenum){
		this.lineNumber=linenum;
	}
	public int getLineNumber(){
		return lineNumber;
	}
	public String readLine() throws IOException{
		lineNumber++;
		StringBuffer buff=new StringBuffer();
		int ch=0;
		while((ch=r.read())!=-1){
			if(ch=='\r')
				continue;
				if(ch=='\n'){
					return buff.toString();
				}
			    else{
				buff.append((char)ch);
			}
		}
		if(buff.length()!=0){
			
			return buff.toString();
		}
		return null;
	}
	public void myClose() throws IOException{
		r.close();
	}
}











