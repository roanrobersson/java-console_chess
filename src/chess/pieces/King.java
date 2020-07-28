package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)board.piece(position);
		return p == null || p.getColor() != getColor() ;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[board.getRows()][board.getColumns()];
		
		Position p = new Position(0, 0);
		
		// left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// left+up
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up
		p.setValues(position.getRow() - 1, position.getColumn());
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up+right
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right+down
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// down
		p.setValues(position.getRow() + 1, position.getColumn());
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// down+left
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}

		return matrix;
	}
}