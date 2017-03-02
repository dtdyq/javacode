package generic;

public class Detergent extends Cleanser{
	public void scrub(){
		append("Detergent.scrub()");
		super.scrub();
	}
	public void foam(){
		append("foam()");
	}
	public static void main(String[] args){
		Detergent x=new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("test the base class:");
		Cleanser.main(args);
	}
}
class Cleanser{
	private String s="Cleanser";
	public void append(String a){
		s+=a;
	}
	public void dilute(){
		append("dilute()");
	}
	public void apply(){
		append("apply()");
	}
	public void scrub(){
		append("scrub()");
	}
	public String toString(){
		return s;
	}
	public static void main(String[] args){
		Cleanser x=new Cleanser();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);
	}
}
class Cleaner extends Detergent{
	public void scrub(){
		append("Cleaner.scrub()");
	}
	public void sterilize(){
		append("sterilize()");
	}
	public static void main(String[] args){
		Cleaner c=new Cleaner();
		c.scrub();
		c.sterilize();
		System.out.println(c);
		
	}
}








