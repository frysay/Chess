package com.chess.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.chess.model.Move;
import com.chess.model.Piece;
import com.chess.model.PieceType;

@Service
public class MoveService {

	public int moveNeeded(PieceType pieceType, int boardSize, int piecePositionX, int piecePositionY, int targetPositionX, int targetPositionY) throws Exception {  

		if(isValidInput(boardSize, piecePositionX, piecePositionY, targetPositionX, targetPositionY)) {

			LinkedList<Move> queue = new LinkedList<>();  

			Move startingMove = new Move(piecePositionX, piecePositionY);
			queue.add(startingMove);

			Set<Move> alreadyVisited = new HashSet<>();

			alreadyVisited.add(startingMove);  

			while (!queue.isEmpty()) {  
				Move nextToBeVisited = queue.remove();  

				if (nextToBeVisited.getPositionX() == targetPositionX && nextToBeVisited.getPositionY() == targetPositionY) {
					return nextToBeVisited.getCount();  
				}
				
				Piece piece = pieceType.getInstance(boardSize);
				
				piece.queueNextPossibleMoves(nextToBeVisited, alreadyVisited, queue);
			}  
		}
		return -1; 
	} 

	private boolean isValidInput(int boardSize, int piecePositionX, int piecePositionY, int targetPositionX, int targetPositionY) {
		return (boardSize >= 0
				&& piecePositionX >= 0 && piecePositionX < boardSize
				&& piecePositionY >= 0 &&  piecePositionY < boardSize
				&& targetPositionX >= 0 &&  targetPositionX < boardSize
				&& targetPositionY >= 0 &&  targetPositionY < boardSize);
	}
}
