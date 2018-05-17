package connect4;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

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
			if (board[rows][cols].getState() == State.E) {
				return i;
			}
		}
		return 0;
	}
	
	public boolean isColFull(int column){
		if(board[0][column].getState() == State.E){
			return false;
		}
		else {
			return true;
		}
	}
	
	public void setState(int row, int column, State state){
		board[row][column].changeState(state);
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