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

}

