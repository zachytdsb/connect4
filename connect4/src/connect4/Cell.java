package connect4;

/**
 * 
 * @author Zach Yerrill. Contains a state and a change state. Cell used for
 *         board, and cell uses states.
 *
 */
public class Cell { // test
	private State state;

	public Cell() {
		state = State.E;
	}

	public State getState() {
		return state;
	}

	public void changeState(State aState) {
		state = aState;
	}

	@Override
	public String toString() {
		switch (state) {
		case X:
			return "X";
		case O:
			return "O";
		case E:
			return "E";
		default:
			return "E";
		}
	}

	public boolean equals(Cell i) {
		if (state == i.getState()) {
			return true;
		} else {
			return false;
		}
	}
}
