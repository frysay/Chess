package com.chess.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.chess.model.PieceType;

public class MoveServiceTest {
	
	private MoveService service;
	
	@Before
	public void init() {
		service = new MoveService();
	}
	
	@Test
	public void moveNeededTest_bottomToTop_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 8, 0, 7, 7, 7);
		assertEquals(5, result);
	}

	@Test
	public void moveNeededTest_topToBottom_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 10, 7, 0, 3, 2);
		assertEquals(2, result);
	}
	
	@Test
	public void moveNeededTest_closeTarget_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 8, 0, 7, 1, 7);
		assertEquals(3, result);
	}
	
	@Test
	public void moveNeededTest_startSameAsTarget_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 6, 4, 5, 4, 5);
		assertEquals(0, result);
	}
	
	@Test
	public void moveNeededTest_startOutsideTheBoard_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 7, 8, 1, 2, 6);
		assertEquals(-1, result);
	}
	
	@Test
	public void moveNeededTest_targetOutsideTheBoard_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 5, 0, 2, 4, 5);
		assertEquals(-1, result);
	}
	
	@Test
	public void moveNeededTest_zeroBoardSize_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 0, 0, 2, 4, 5);
		assertEquals(-1, result);
	}
	
	@Test
	public void moveNeededTest_negativeBoardSize_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, -1, 0, 2, 4, 5);
		assertEquals(-1, result);
	}
	
	@Test
	public void moveNeededTest_negativeStart_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 8, -3, 2, 4, 5);
		assertEquals(-1, result);
	}
	
	@Test
	public void moveNeededTest_negativeTarget_success() throws Exception {
		int result = service.moveNeeded(PieceType.KNIGHT, 8, 0, 2, 4, -5);
		assertEquals(-1, result);
	}
}
