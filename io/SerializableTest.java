package io;
//�Զ������л�;
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
//�Լ��������л�ʱ����Ҫʵ��Externalizable��ڣ���дwriteExternal��readExternal����
//ͨ��Externalizableʵ�����л�ʱ����ҪΪ�����ṩ�޲�������������Ϊ��ʱ�ڷ����л�ʱ�������
//��ʹ��public���޲�������������ʵ��
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
	//writeReplace:���������л�����֮ǰ���ȵ��ø÷�����
	//����д�˸÷�������readObject���صĽ��Ǹú����ķ���ֵ
//	private Object writeReplace()throws ObjectStreamException{
//		ArrayList<Object> al=new ArrayList<>();
//		al.add(name);
//		al.add(age);
//		return al;
//	}
	//readResolve:�÷����ķ���ֵ�������ԭ���������л��Ķ���
	private Object readResolve()throws ObjectStreamException{
		return new Person(99,"newPerson");
	}
}
