package connect4;
// Docstring
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		int rows = 7;
		int cols = 7;
		int turn = 0;
		int col;
		int colTest;
		State win = State.E;
		Board b = new Board(rows, cols);
		while (play == true) {
			win = b.winner();
			if (win != State.E) {
				System.out.println(win + " is the winner!\n\nFinal Board:");
				System.out.print(b);
				break;
			} else {
			}
			System.out.println(who(turn) + " it's your turn! Pick a column.");
			System.out.print(b);
			col = s.nextInt() - 1;
			if (col + 1 > cols) {
				System.out.println("Column number too large, please pick one between 1 and " + cols);
			} else {
				colTest = checkCol(col, b);
				if (colTest == 1) {
					System.out.println("Column full, pick a new column.");
				} else {
					b.setState(b.getRow(col), col, getState(turn));
					System.out.print(b);
					turn = swap(turn);
				}
			}
		}
	}

	public static int checkCol(int cols, Board board) {
		int result;
		if (board.isColFull(cols) == true) {
			result = 1;
		} else {
			result = 0;
		}
		return result;

	}

	public static String who(int turn) { // Used for look up of turn int
		if (turn == 0) {
			return "X";
		} else if (turn == 1) {
			return "O";
		} else {
			return "Error";
		}
	}

	public static State getState(int turn) {// may be able to get this from
											// board
		if (turn == 0) {
			return State.X;
		} else if (turn == 1) {
			return State.O;
		} else {
			return State.E;
		}
	}

	public static int swap(int turn) {// Change whose turn it is
		if (turn == 0) {
			return 1;
		} else if (turn == 1) {
			return 0;
		} else {
			return 99;
		}
	}
}
