package other;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args){
		TreeSet<Dog> tree=new TreeSet<>();
		tree.add(new Dog("dog1"));
		tree.add(new Dog("dog2"));
		System.out.println(tree.first());
		
	}
}
class Dog implements Comparable<Dog>{
	String name;
	public Dog(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	@Override
	public int compareTo(Dog d){
		return this.name.compareTo(d.name);
	}
	public String toString(){
		return name;
	}
}