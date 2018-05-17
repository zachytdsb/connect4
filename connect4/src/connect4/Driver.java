package connect4;

public class Driver {
	public static void main(String[] args) {
		boolean play = true;
		int turn = 0;
		Board b = new Board(7, 7);
		while (play == true) {

		}
		System.out.print(b);

	}

	public String who(int turn) { // Used for look up of turn int
		if (turn == 0) {
			return "P1";
		} else if (turn == 1) {
			return "P2";
		} else {
			return "Error";
		}
	}

	public int swap(int turn) {// Change whose turn it is
		if (turn == 0) {
			return 1;
		} else if (turn == 1) {
			return 0;
		} else {
			return 99;
		}
	}
}
