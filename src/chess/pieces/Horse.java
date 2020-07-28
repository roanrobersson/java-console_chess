package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece{
	
	public Horse(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "H";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)board.piece(position);
		return p == null || p.getColor() != getColor() ;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matrix = new boolean[board.getRows()][board.getColumns()];
		
		Position p = new Position(0, 0);
		
		// up+up+right
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// up+up+left
		p.setValues(position.getRow() - 2, position.getColumn() - 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right+right+up   
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// right+right+down
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// down+down+right
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// down+down+left
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// left+left+up
		p.setValues(position.getRow() - 1, position.getColumn() - 2);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
		
		// left+left+down
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (board.positionExists(p) && canMove(p)) {
			matrix[p.getRow()][p.getColumn()] = true;
		}
			
		return matrix;
	}
	
}
