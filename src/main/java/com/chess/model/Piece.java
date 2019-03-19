package com.chess.model;

import java.util.List;
import java.util.Set;

public abstract class Piece {
	
	private int boardSize;
	
	public Piece(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	protected boolean isNewAndValidMove(Move newMove, Set<Move> alreadyVisited) {
		return (!alreadyVisited.contains(newMove)
				&& newMove.getPositionX() >= 0 && newMove.getPositionX() < boardSize
				&& newMove.getPositionY() >= 0 && newMove.getPositionY() < boardSize);
	}
	
	public abstract void queueNextPossibleMoves(Move currentMove, Set<Move> alreadyVisited, List<Move> queue);

}
