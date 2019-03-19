package com.chess.model;

import java.util.List;
import java.util.Set;

public class Knight extends Piece {

	public Knight(int boardSize) {
		super(boardSize);
	}

	private static final DuoInt[] POSSIBLE_MOVES = new DuoInt[] {
			new DuoInt(-2, -1),
			new DuoInt(-1, -2),
			new DuoInt(1, -2),
			new DuoInt(2, -1),
			new DuoInt(-2, 1),
			new DuoInt(-1, 2),
			new DuoInt(1, 2),
			new DuoInt(2, 1),
	};

	@Override
	public void queueNextPossibleMoves(Move currentMove, Set<Move> alreadyVisited, List<Move> queue) {
		for (int i = 0; i < POSSIBLE_MOVES.length; i++) {
			int newPositionX = currentMove.getPositionX() + POSSIBLE_MOVES[i].getFisrt();  
			int newPositionY = currentMove.getPositionY() + POSSIBLE_MOVES[i].getSecond();  

			Move newMove = new Move(newPositionX, newPositionY);

			if (isNewAndValidMove(newMove, alreadyVisited)) {
				newMove.setCount(currentMove.getCount() + 1);
				alreadyVisited.add(newMove);
				queue.add(newMove);
			}  
		} 
	}
}
