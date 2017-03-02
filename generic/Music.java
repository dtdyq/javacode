package generic;

public class Music {
	public static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	public static void main(String[] args) {
		Wind w=new Wind();
		//Instrument i=new Instrument();
		Stringed s=new Stringed();
		Brass b=new Brass();
		//tune(i);
		tune(w);
		tune(s);
		tune(b);
		Instrument k=new Brass();
		((Brass) k).music();
	}

}
abstract class Instrument{
	public abstract  void play(Note n);
}
enum Note{
	MIDDLE_C,C_SHARP,B_FLAT;
}
class Wind extends Instrument{
	public void play(Note n){
		System.out.println("Wind.play()"+n);
	}
}
class Stringed extends Instrument{
	public void play(Note n){
		System.out.println("Stringed.play()"+n);
	}
}
class Brass extends Instrument{
	public void play(Note n){
		System.out.println("Brass.play()"+n);
	}
	public void music(){
		System.out.println("music");
	}
}




