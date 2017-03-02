package other;

public class PairTest {

	public static void main(String[] args) {
		String[] str={"e","g","f","a","l"};
		Pair<String> p=ArrayLog.minmax(str);
		System.out.println(p.getFirst()+" "+p.getSecond());
	}
}
class Pair<T>{
	private T first;
	private T second;
	public  Pair(T f,T s){
		this.first=f;
		this.second=s;
	}
	public void setFirst(T t){
		this.first=t;
	}
	public void setSecond(T t){
		this.second=t;
	}
	public T getFirst(){
		return this.first;
	}
	public T getSecond(){
		return this.second;
	}
}
class ArrayLog{
	public static Pair<String> minmax(String[] str){
		if(str==null)		return null;
		String min=str[0];
		String max=str[0];
		for(int i=1;i<str.length;i++){
			if(str[i].compareTo(min)<0){
				min=str[i];
			}
			if(str[i].compareTo(max)>0){
				max=str[i];
			}
		}
		return new Pair<>(min,max);
	}
}