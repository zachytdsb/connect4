package connect4;

public class Cell {
	private State state;
	public Cell (){
		state = State.E;
		
	}
	
	public void changeState(State aState){
		state = aState;
	}
	
	@Override
	public String toString(){
		switch(state){
		case P1:
			return "P1";
		case P2:
			return "P2";
		case E:
			return "E";
		default:
			return "E";
		}
	}
}
