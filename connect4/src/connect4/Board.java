package connect4;

/**
 * 
 * @author Zach Yerrill. The board class contains all the functions and the 2D
 *         array of cells to allow the driver to play the connect 4 game.
 *
 */
public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;
	private boolean recursionValid = false; // checkNextPos() sets to true if winner is found
	private State recursionState; // checkNextPos() sets to a player if a winner is found
	private int connectNum = 4; // Number of pieces connected needed to win

	public Board(int aRows, int aCols) { // Initialize the 2D array of cells
		rows = aRows;
		cols = aCols;
		board = new Cell[rows][cols];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	public int getRow(int column) { // Gets the lowest empty space available for dropped piece
		int lowest = rows - 1;
		for (int i = lowest; i > 0; i--) {
			if (board[i][column].getState() == State.E) {
				return i;
			}
		}
		return 0;
	}

	public boolean isColFull(int column) { // Checks if players selected column is full
		if (board[0][column].getState() == State.E) {
			return false;
		} else {
			return true;
		}
	}

	public void setState(int row, int column, State state) { // Changes the state of a cell
		board[row][column].changeState(state);
	}

	public void checkNextPos(int row, int col, State s, int layer, int dir) {
		/*
		 * Recursion function behind winner(). Dir - Direction (see diagram in
		 * github for values). s - state that the function it is checking for.
		 * Layer - How many times it has recursed(is that a word?). Win function
		 * starts by inputting a row, col, state, and enters '0' for all
		 * directions. Searching from bottom up, it checks all positions
		 * surrounding the selected piece for the same state. If it finds one, a
		 * layer is added on and only that direction is specified to be
		 * searched, then again until it gets 4(or connectNum value). Once 4
		 * have been confirmed, the next pass will not check for another match,
		 * but rather set recursionValid and recursionState to be used by the
		 * winner() function.
		 */
		if (layer < connectNum - 1) {
			try {
				if (dir == 0 || dir == 1) {
					if (board[row - 1][col - 1].getState() == s) {
						checkNextPos(row - 1, col - 1, s, layer + 1, 1);
					} else {
					}
				} else {
				}
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				if (dir == 0 || dir == 2) {
					if (board[row - 1][col].getState() == s) {
						checkNextPos(row - 1, col, s, layer + 1, 2);
					} else {
					}
				} else {
				}
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				if (dir == 0 || dir == 3) {
					if (board[row - 1][col + 1].getState() == s) {
						checkNextPos(row - 1, col + 1, s, layer + 1, 3);
					} else {
					}
				} else {
				}
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				if (dir == 0 || dir == 4) {
					if (board[row][col - 1].getState() == s) {
						checkNextPos(row, col - 1, s, layer + 1, 4);
					} else {
					}
				} else {
				}
			} catch (IndexOutOfBoundsException e) {
			}
			try {
				if (dir == 0 || dir == 5) {
					if (board[row][col + 1].getState() == s) {
						checkNextPos(row, col + 1, s, layer + 1, 5);
					} else {
					}
				} else {
				}
			} catch (IndexOutOfBoundsException e) {
			}
		} else {
			recursionState = s;
			recursionValid = true;
		}
	}

	public State winner() { //Scans for pieces, bottom up, then runs checkNextPos()
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].getState() != State.E) {
					checkNextPos(i, j, board[i][j].getState(), 0, 0);
				}
			}
		}
		if (recursionValid == true) {
			return recursionState;
		}
		return State.E;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				output += board[i][j].toString() + "  ";
			}
			output += "\n";
		}
		return output;
	}
}