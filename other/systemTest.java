package system;
//System类：
import java.util.*;
public class systemTest {
	public static void main(String[] args){
		//Properties是HashTable的子类
		//该集合中是字符串，没有泛型定义
		
		//如何在系统中自定义信息：
		System.setProperty("Mykey","Myvalue");
		Properties pop=System.getProperties();
		for(Object o:pop.keySet()){
			String str=(String)pop.get(o);
			System.out.println(o+"-->"+str);
		}
		//获取指定系统信息：
		String s=System.getProperty("os.name");
		System.out.println(s);
		//虚拟机可不可以在启动时动态地加载属性信息：
		String v=System.getProperty("h");
		System.out.println(v);
		
	}
}
