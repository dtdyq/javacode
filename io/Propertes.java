package io;

import java.util.Properties;
import java.io.*;

/*
 * Properities是HashTable的子类
 * 
 * 具备map集合的特点，是集合中和IO相结合的集合容器
 * 
 * 可用于键值对形式的配置文件
 */
public class Propertes {
	static void setGet(){
		Properties pop=new Properties();
//		pop.setProperty("zhangsan", "23");
//		pop.setProperty("lisi", "93");
//		try {
//			pop.store(new FileOutputStream("popTest.txt"), "");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			pop.load(new FileInputStream("popTest.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pop.setProperty("lisi", "99");
		System.out.println("pop--->"+pop);
//		System.out.println(pop.get("lisi"));
//		Set<String> set=pop.stringPropertyNames();
//		for(String name:set){
//			System.out.println(name+" "+pop.getProperty(name));
//		}
	}
	static Properties propertiesTest(String s){
		BufferedReader br=null;
		Properties p=new Properties();
		try{
			br=new BufferedReader(new FileReader(s));
			String str=null;
			while((str=br.readLine())!=null){
				String[] arg=str.split("=");
				p.setProperty(arg[0], arg[1]);
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}finally{
			try{
				br.close();
			}catch(IOException e){
				System.out.println("error");
			}
		}
		return p;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException{
		setGet();
		Properties pop=propertiesTest("D:/CODE/JAVA/DEFAULT/3.txt");
		System.out.println(pop);
		
		Properties p=new Properties();
		p.load(new FileInputStream("D:/CODE/JAVA/DEFAULT/3.txt"));
		System.out.println(p);
		p.setProperty("time", "8");
		p.store(new FileOutputStream("D:/CODE/JAVA/DEFAULT/3.txt"), "hahaha");
	}
}





