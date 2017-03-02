package other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class InvoTest {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Pers p=new Persons();
		InvocationHandler ih=new MyInvo(p);
		Pers py=(Pers)Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), ih);
		py.show();
		py.Method("haha");
		Properties pr=new Properties();
		pr.load(new FileInputStream("t.txt"));
		
	}
}
class MyInvo implements InvocationHandler{
	private Object obj;
	public MyInvo(Object obj){
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("test");
		Object o=method.invoke(obj, args);
		return o;
	}
	
}