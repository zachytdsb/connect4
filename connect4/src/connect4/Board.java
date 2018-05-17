package connect4;

public class Board {
	private Cell[][] board;
	private int Rows;
	private int Cols;

	public Board(int aRows, int aCols) {
		Rows = aRows;
		Cols = aCols;
		board = new Cell[Rows][Cols];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Cell();
			}
		}

	}

	public void deposit(State player, int column) {
		int lowest = 0;
		for (int i = board[column].length - 1; i >= 0; i--) {
			if (board[Rows][Cols].getState() == State.E) {
				lowest = i;
				break;
			}
		}
		board[lowest][column].changeState(player);;
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
/*
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < Rows; i++) {
			for (int j = 0; j < Cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println(); test
		} // thank you dark souls

	}*/
}