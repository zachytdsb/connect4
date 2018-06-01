package connect4;

import java.util.Scanner;

/**
 * 
 * @author Zach Yerrill. Driver runs all the game and use board, cell, and
 *         state.
 *
 */
public class Driver {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		int rows = 7; //Rows for board
		int cols = 7; //Columns for board
		int turn = 0; //Who's turn it is, changed by swap() function
		int col; //Saves selected column for drop
		int colTest; //Saves the return value for isColFull()
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
					//System.out.print(b);
					turn = swap(turn);
				}
			}
		}
	}

	public static int checkCol(int cols, Board board) { //Checks if a column is full
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

	public static State getState(int turn) { //Returns state value for turn int
		if (turn == 0) {
			return State.X;
		} else if (turn == 1) {
			return State.O;
		} else {
			return State.E;
		}
	}

	public static int swap(int turn) { //Change who's turn it is
		if (turn == 0) {
			return 1;
		} else if (turn == 1) {
			return 0;
		} else {
			return 99;
		}
	}
}
