package connect4;

public class Board {
	private Cell[][] board;
	private int Rows;
	private int Cols;

	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = State.E;
			}
		}

	}

	public void deposit(int colour, int column,
			int[][] board) {/* need runtime exception for column full */
		int lowest = 0;
		for (int i = board.length - 1; i >= 0; i--) {
			if (board[i][column] == 0) {
				lowest = i;
				break;
			}
		}
		board[lowest][column] = colour;
	}

	@Override
	public String toString() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
			}
			System.out.print("/n");
		}
		return null;

	}

	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		} // thank you dark souls

	}
}
