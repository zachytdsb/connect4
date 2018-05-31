package connect4;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		int turn = 0;
		int col;
		int errorTest;
		Board b = new Board(7, 7);
		while (play == true) {
			System.out.println(who(turn) + " it's your turn! Pick a column.");
			System.out.print(b);
			col = s.nextInt();
			col -= 1;
			errorTest = checkCol(col, b);
			if (errorTest == 1) {
				System.out.println("Column full, pick a new column.");
			} else {
				b.setState(b.getRow(col), col, getState(turn));
				System.out.print(b);
				turn = swap(turn);
			}
		}
		System.out.print(b);
		turn = swap(turn);

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
			return "P1";
		} else if (turn == 1) {
			return "P2";
		} else {
			return "Error";
		}
	}

	public static State getState(int turn) {//may be able to get this from board
		if (turn == 0) {
			return State.P1;
		} else if (turn == 1) {
			return State.P2;
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
