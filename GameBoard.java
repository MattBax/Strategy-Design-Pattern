package AvatarGame;


import java.util.HashMap;
import java.util.Random;

public class GameBoard {

	// declaring class array called gameboard
	// public static char[][] gameBoard = new char[10][10];

	protected int noOfRows; // num of rows
	protected int noOfColumns; // num of columns
	protected int randomRow;
	protected int randomColumn;
	protected double distance;
	protected boolean isEmpty;

	HashMap<Avatar, Position> board = new HashMap<Avatar, Position>();
	String[][] gameboard; // create 2d array

	// GameBoard constructor 
	public GameBoard(int rows, int columns) { 

		noOfRows = rows;
		noOfColumns = columns;
		gameboard = new String[rows][columns];

	}
	// return current location
	public String returnBoard(int i, int j){
		
		return this.gameboard[i][j];
		
	}
	// Clear previously held position on the board
	public void clearPosition(int i, int j){
		
		gameboard[i][j] = null;
		
		
	}
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	// prints board - returns null values where no avatar is present
	public void printBoard() {

		for (int i = 0; i < noOfRows; i++) {

			for (int j = 0; j < noOfColumns; j++) {

				System.out.println(gameboard[i][j] + "");

			}

			System.out.println("");
		}
	}
	// Method to add an Avatar object and a position to the board
	public String addPlayer(Avatar avatar, Position pos) {

		int k = pos.getXCoor();
		int j = pos.getYCoor();

		gameboard[k][j] = avatar.getName();

		return gameboard[k][j];

	}

	// Method to generate two random values and place them in a position
	public Position getRandCoor() {
		Random rand = new Random();
		int randRow = rand.nextInt(10);
		int randColumn = rand.nextInt(10);

		Position pos = new Position(randRow, randColumn);

		return pos;

	}
	// Method to calculate the distance between two points
	public void calcDistance(Position oldPos, Position newPos) {
		int newXCoor = newPos.getXCoor();
		int newYCoor = newPos.getYCoor();

		int oldXCoor = oldPos.getXCoor();
		int oldYCoor = oldPos.getYCoor();

		int calcDiffX = (oldXCoor - newXCoor);
		int calcDiffY = (oldYCoor - newYCoor);
		// Distance is rounded to the nearest whole num
		this.setDistance(Math.round(Math.sqrt((calcDiffX * calcDiffX) + (calcDiffY * calcDiffY))));
		

	}

}
