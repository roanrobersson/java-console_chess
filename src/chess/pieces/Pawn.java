package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	
	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "P";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[board.getRows()][board.getColumns()];
		
		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			// up 1x
			p.setValues(position.getRow() - 1, position.getColumn());
			if (board.positionExists(p) && !board.thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			
			// up 2x
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (board.positionExists(p) && !board.thereIsAPiece(p) && board.positionExists(p2) && !board.thereIsAPiece(p2) && getMoveCount() == 0) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			
			// up+right
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (board.positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			
			// up+left
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (board.positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
		} else {
			// down 1x
			p.setValues(position.getRow() + 1, position.getColumn());
			if (board.positionExists(p) && !board.thereIsAPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			
			// down 2x
			p.setValues(getPosition().getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (board.positionExists(p) && !board.thereIsAPiece(p) && board.positionExists(p2) && !board.thereIsAPiece(p2) && getMoveCount() == 0) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
						
			// down+right
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (board.positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
			
			// down+left
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (board.positionExists(p) && isThereOpponentPiece(p)) {
				matrix[p.getRow()][p.getColumn()] = true;
			}
		}
		
		return matrix;
	}
	
}
