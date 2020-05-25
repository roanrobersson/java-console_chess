package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		this.board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] matrix = new ChessPiece[this.board.getRows()][this.board.getColumns()];
		
		for (int i = 0; i < this.board.getRows(); i++) {
			for (int j = 0; j < this.board.getColumns(); j++) {
				matrix[i][j] = (ChessPiece) this.board.piece(i, j);
			}
		}
		
		return matrix;
		
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(this.board, Color.WHITE));
		placeNewPiece('e', 8, new King(this.board, Color.BLACK));
		placeNewPiece('e', 1, new King(this.board, Color.WHITE));
	}
}
