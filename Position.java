package AvatarGame;

public class Position {
	
	// instance variables
	protected int xCoor;
	protected int yCoor;
	protected Position pos;
	// Constructor
	public Position(int xCoor, int yCoor) {

		this.xCoor = xCoor;
		this.yCoor = yCoor;

	}
	
	public Position(Position randCoor) {
		this.pos = randCoor;
	}

	// Getters and Setters
	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}

	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}

	public int getXCoor() {

		return xCoor;
	}

	public int getYCoor() {

		return yCoor;

	}
	// returns the current position
	public Position getCurrentPosition(Position pos) {

		int i = pos.getXCoor();
		int j = pos.getYCoor();

		Position currentPos = new Position(i, j);

		return currentPos;

	}

}
