package io;
/**
 * @author dtdyq
 *	记录运用程序的运行次数，到达一定的次数后给出提醒
 */
import java.io.*;
import java.util.Properties;
public class PropertiesApplcation {
	public static void ApplicationStart(){
		FileInputStream fr=null;
		Properties pop=new Properties();
		try{
			fr=new FileInputStream("D:/CODE/JAVA/DEFAULT/3.txt");
			pop.load(fr);
			System.out.println(pop.getProperty("time"));
			if(Integer.parseInt(pop.getProperty("time"))<10){
				Application();
				pop.setProperty("time", String.valueOf((Integer.parseInt(pop.getProperty("time"))+1)));
				pop.store(new FileOutputStream("D:/CODE/JAVA/DEFAULT/3.txt"), "time update");
			}
			else{
				System.out.println("time is full!please buy the least license!!!!");
				System.exit(0);
	
			}
		}catch(IOException e){
			System.out.println("error");
		}finally{
			try{
			fr.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
	public static void Application(){
		int k=2;
		while(k>0){
			System.out.println("a application");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			k--;
		}
	}
	public static void main(String[] args){
			ApplicationStart();
	}
}
