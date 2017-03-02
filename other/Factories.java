package other;
public class Factories {
	public static void serviceConsumer(ServiceFactory sf){
		Service s=sf.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceConsumer(new Implemention1Factory());
		serviceConsumer(new Implemention2Factory());
	}
}
interface Service{
	void method1();
	void method2();
}
interface ServiceFactory{
	Service getService();
}
class Implemention1 implements Service{
	Implemention1(){
	}
	public void method1(){
		System.out.println("Implemention1 method1");
	}
	public void method2(){
		System.out.println("Implemention1 method2");
	}
}
class Implementation2 implements Service{
	Implementation2(){
	}
	public void method1(){
		System.out.println("Implemetnion2 method1");
	}
	public void method2(){
		System.out.println("Implemention2 method2");
	}
}
class Implemention1Factory implements ServiceFactory{
	public Service getService() {
		return new Implemention1();   
	}
}
class Implemention2Factory implements ServiceFactory{
	public Service getService(){
		return new Implementation2();
	}
}