package io;
//自定义序列化;
import java.io.*;
//import java.util.*;
public class SerializableTest {
	public static void main(String[] args) throws ClassNotFoundException{
		ObjectOutputStream os=null;
		ObjectInputStream is=null;
		Person p=new Person(18,"person");
		try{
			os=new ObjectOutputStream(new FileOutputStream("D:\\CODE\\JAVA\\DEFAULT\\serializable.txt"));
			os.writeObject(p);
			os.flush();
			os.close();
			is=new ObjectInputStream(new FileInputStream("D:\\CODE\\JAVA\\DEFAULT\\serializable.txt"));
			Person person=((Person)is.readObject());
			System.out.println(person);
//			@SuppressWarnings("unchecked")
//			ArrayList<Object> list=(ArrayList<Object>) is.readObject();
//			System.out.println(list);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				is.close();
			}catch(IOException e){
				System.out.println(e);
			}
		}
	}
}
//自己定义序列化时，需要实现Externalizable借口，重写writeExternal和readExternal方法
//通过Externalizable实现序列化时，需要为该类提供无参数构造器，因为这时在反序列化时，程序会
//先使用public的无参数构造器构造实例
class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private int age;
	private String name;
	public Person(int age,String name){
		this.age=age;
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}  
	public String toString(){
		return "age: "+age+"__name: "+name;
	}
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
		this.name=((StringBuffer)in.readObject()).reverse().toString();
		this.age=in.readInt();
	}
	//writeReplace:程序在序列化对象之前，先调用该方法：
	//当重写了该方法后。则readObject返回的将是该函数的返回值
//	private Object writeReplace()throws ObjectStreamException{
//		ArrayList<Object> al=new ArrayList<>();
//		al.add(name);
//		al.add(age);
//		return al;
//	}
	//readResolve:该方法的返回值将会代替原来被反序列化的对象
	private Object readResolve()throws ObjectStreamException{
		return new Person(99,"newPerson");
	}
}
