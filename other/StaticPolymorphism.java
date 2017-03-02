package other;
class Super{
	public int field=0;
	public int getField(){
		return field;
	}
}
class Sub extends Super{
	public int field=1;
	public int getField(){
		return field;
	}
	public int getSuperField(){
		return super.field;
	}
}
class staticT {
//	
//	public static void main(String[] args){
//		Super sup=new Sub();
//		System.out.println(sup.field);
//		System.out.println(sup.getField());
//		Sub sub=new Sub();
//		System.out.println(sub.getSuperField());
//		System.out.println();
//	}
}
class staticSuper{
	//静态方法不存在多态。
	public static String staticGet(){
		return "Base staticGet()";
	}
	public String dynamicGet(){
		return "Base dynamicGet()";
	}
}
class staticSub extends staticSuper{
	public static String staticGet(){
		return "Derived staticGet()";
	}
	public String dynamicGet(){
		return "Derived dynamicGet()";
	}
}
public class StaticPolymorphism{
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		staticSuper sup=new staticSub();
		System.out.println(sup.staticGet());
		System.out.println(sup.dynamicGet());
		System.out.println(new staticSub().staticGet());
		staticSub sub=new staticSub();
		System.out.println(sub.staticGet());
	}
}







