package generic;

public class Bath {
	private String 
		s1="happy",
		s2="happy",
		s3,s4;
	private Soap castitle;
	private int i;
	private float toy;
	public Bath(){
		System.out.println("Inside Bath()");
		s3="joy";
		toy=3.14f;
		castitle=new Soap();
	}
	{
		i=47;
	}
	public String toString(){
		if(s4==null){
			s4="joy";
		}
		return 
				"s1 = "+s1+"\n"+
				"s2 = "+s2+"\n"+
				"s3 = "+s3+"\n"+
				"s4 = "+s4+"\n"+
				"i = "+i+"\n"+
				"toy= "+toy+"\n"+
				"castitle= "+castitle;
	}
	public static void main(String[] args){
		Bath b=new Bath();
		System.out.println(b);
	}
	
}
class Soap{
	private String s;
	Soap(){
		System.out.println("soap()");
		s="Constructed";
	}
	public String toString(){
		return s;
	}
}