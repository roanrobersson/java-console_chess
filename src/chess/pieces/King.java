package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	private ChessMatch chessMatch;

	public King(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)board.piece(position);
		return p == null || p.getColor() != getColor() ;
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() & p.getMoveCount() == 0;
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
		
		// #specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #specialmove castling kingside rook
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					matrix[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// #specialmove castling queenside rook
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					matrix[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}
		
		return matrix;
	}
}