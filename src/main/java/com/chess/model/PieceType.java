package com.chess.model;

public enum PieceType {

	KNIGHT(Knight.class);
	
	public static final String DEFAULT_PIECE_TYPE = "KNIGHT";

	private final Class<? extends Piece> clazz;

	PieceType(Class<? extends Piece> clazz) {
		this.clazz = clazz;
	}

	public Class<? extends Piece> getClazz() {
		return clazz;
	}
	
	public Piece getInstance(int boardSize) throws Exception {
		return (Piece) this.getClazz().getDeclaredConstructor(int.class).newInstance(boardSize);
	}
}
