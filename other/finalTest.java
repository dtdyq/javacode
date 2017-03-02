package other;

public class finalTest {
	public static void main(String[] args){
		System.out.println(getInt());
		System.out.println(getInts());
	}
	@SuppressWarnings("finally")
	static int getInt(){
		int a=10;
		try{
			System.out.println(a/0);
		}catch(ArithmeticException e){
			a=20;
			return a;
		}finally{
			a=30;
			return a;
		}
	}
	static int getInts(){
		int a=100;
		try{
			a=a/0;
		}catch(ArithmeticException e){
			a=200;
			return a;
		}finally{
			a=50;
		}
		return a;
	}
}
