package io;

import java.io.*;
public class ObjectStreamTest {
	public static void main(String[] args) throws ClassNotFoundException{
		ObjectOutputStream obj=null;
		Dog dog=new Dog(12,23.34,"iii");
		ObjectInputStream oij=null;
		try{
			obj=new ObjectOutputStream(new FileOutputStream("D:/CODE/JAVA/DEFAULT/1.txt"));
			obj.writeObject(dog);
			oij=new ObjectInputStream(new FileInputStream("D:/CODE/JAVA/DEFAULT/1.txt"));
			Dog d=(Dog)oij.readObject();
			System.out.println(d);
		}catch(IOException e){
			System.out.println(e);
		}finally{
			try{
				obj.close();
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}
}
//所有能被写入流中的对象都必须实现序列化、
//如果一个对象持有另一个对象的引用，则另一个对象也必须实现序列化，否则该对象也不能被序列化 
class Dog implements Serializable{
	private static final long serialVersionUID = 87645L;
	private int age;
	//transient修饰的不能被序列化
	transient double weight;
	static String name="fuddv";
	public Dog(int age,double weight,String name){
		this.age=age;
		this.weight=weight;
		Dog.name=name;
	}
	public String toString(){
		return age+" "+weight+" "+name;
	}
}