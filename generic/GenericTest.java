package generic;

public class GenericTest {
	public static <T> T getMidlle(@SuppressWarnings("unchecked") T...a){
		return a[a.length/2];
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args){
		System.out.println(GenericTest.<String>getMidlle("vfue","fewi"));
		String[] test1={"zfwuey","niweuyf","igywef","oecchiu","mxfngr","uerbiw"};
		System.out.println("min: "+ArrayAlg.min(test1));
		System.out.println("minmax: "+ArrayAlg.minmax(test1));
		//getClass()只能返回原始类型，a instanceof Pair方法也只能判断是否是任意的Pair类型
		System.out.println(new Pair<String>().getClass()==new Pair<Integer>().getClass());
		//不能创建参数化类型的数组：
		//Pair<String>[] pair=new Pair<>[10];    error!
		Pair<String>[] pair=(Pair<String>[])new Pair<?>[10];
		pair[0]=new Pair(23,23);
		//抛出异常：
		//System.out.println(pair[0].getFrist());
	}
}
class ArrayAlg{
	public static <T extends Comparable<T>> T min(T[] a){
		if(a==null){
			return null;
		}
		T small=a[0];
		for(int i=1;i<a.length;i++){
			if(small.compareTo(a[i])>0){
				small=a[i];
			}
		}
		return small;
	}
	public static <T extends Comparable<T>> Pair<T> minmax(T[] a){
		if(a==null){
			return null;
		}
		T min=a[0],max=a[0];
		for(int i=0;i<a.length;i++){
			if(a[i].compareTo(min)<0){
				min=a[i];
			}
			if(a[i].compareTo(max)>0){
				max=a[i];
			}
		}
		return new Pair<T>(min,max);
	}
}
class Pair<T>{
	private T frist;
	private T second;
	public Pair(){
		
	}
	public Pair(T t1,T t2){
		this.frist=t1;
		this.second=t2;
	}
	public T getFrist(){
		return frist;
	}
	public T getSecond(){
		return second;
	}
	public String toString(){
		return "frist: "+frist+"; second: "+second;
	}
}





