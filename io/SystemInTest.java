package io;

import java.io.IOException;
import java.io.InputStream;

public class SystemInTest {
	public static void main(String[] args){
		InputStream in=System.in;
		StringBuffer s=new StringBuffer();
		while(true){
			try{
				int k=in.read();
				if(k=='\r')
					continue;
				if(k=='\n'){
					if("over".equals(new String(s))){
						break;
					}
					System.out.println(s);
					s.delete(0, s.length());
				}
				else{
					s.append((char)k);
				}
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
}
