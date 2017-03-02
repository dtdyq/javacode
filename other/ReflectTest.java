package other;

import java.lang.reflect.Field;

public class ReflectTest {
	public static void setPorperty(Object o,String field,String args){
		@SuppressWarnings("rawtypes")
		Class c=o.getClass();
		try {
			Field f=c.getDeclaredField(field);
			f.setAccessible(true);
			try {
				f.set(o, args);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Persons p=new Persons();
		ReflectTest.setPorperty(p, "name", "linqingxia");
		System.out.println(p);
	}
}
interface Pers{
	public void show();
	public void Method(String args);
}
class Persons implements Pers{
	private String name;
	public String add;
	public String toString(){
		return name+"--->"+add;
	}
	public void show(){
		System.out.println("show");
	}
	public void Method(String args){
		System.out.println("hello=-->"+args);
	}
}