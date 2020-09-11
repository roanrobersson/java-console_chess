package boardgame;

public abstract class Piece {
	
	protected Position position;
	protected Board board;

	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() {
		boolean[][] matrix = possibleMoves();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}

