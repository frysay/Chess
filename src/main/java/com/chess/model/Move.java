package com.chess.model;

public class Move {

	private DuoInt position;
	private int count;

	public Move(int positionX, int positionY) {
		position = new DuoInt(positionX, positionY);
		count = 0;
	}
	
	public Move(DuoInt position) {
		this.position = position;
		count = 0;
	}

	public int getPositionX() {
		return position.getFisrt();
	}

	public int getPositionY() {
		return position.getSecond();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}
}
