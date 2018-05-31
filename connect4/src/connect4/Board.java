package connect4;
// Docstring
public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;
	private int recursion = 0;
	private boolean recursionValid = false;
	private State recursionState;

	public Board(int aRows, int aCols) {
		rows = aRows;
		cols = aCols;
		board = new Cell[rows][cols];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell();
			}
		}
	}

	public int getRow(int column) {
		int lowest = rows - 1;
		for (int i = lowest; i > 0; i--) {
			if (board[i][column].getState() == State.E) {
				return i;
			}
		}
		return 0;
	}

	public boolean isColFull(int column) {
		if (board[0][column].getState() == State.E) {
			return false;
		} else {
			return true;
		}
	}

	public void setState(int row, int column, State state) {
		board[row][column].changeState(state);
	}

	public void checkNextPos(int row, int col, State s, int layer, int dir) {
		if (dir == 0) {
			recursion = 0;
		}
		if (layer < 3) {
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

	public State winner() {
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
				output += board[i][j].toString();
			}
			output += "\n";
		}
		return output;
	}
}