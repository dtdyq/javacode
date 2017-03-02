package generic;

public class Cartoon extends Drawing{
	public Cartoon(){
		System.out.println("Cartoon constructor");
	}
	public static void main(String[] args){
		Cartoon car=new Cartoon();
		System.out.println(car);
	}
}
class Art{
	Art(){
		System.out.println("Art constructor");
		
	}
}
class Drawing extends Art{
	Drawing(){
		System.out.println("Drawing constructor");
		
	}
}