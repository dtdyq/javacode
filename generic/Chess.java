package generic;

public class Chess extends BoardGame{
	Chess(){
		super(11);
		System.out.println("Chess constructor");
	}
	public static void main(String[] args) {
		Chess c=new Chess();
		System.out.println(c);
		BoardGame bg=new BoardGame(12);
		System.out.println(bg);
	}
}
class Game{
	Game(int i){
		System.out.println("Game constructor");
	}
} 
class BoardGame extends Game{
	BoardGame(int i){ 
		super(i);
		System.out.println("BoardGame constructor");
	}
}