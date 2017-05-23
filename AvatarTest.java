package AvatarGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AvatarTest {
	// Initialising GameBoard
	GameBoard testBoard = new GameBoard(10, 10);
	// Creating two Avatar object
	Avatar avaOne = new Avatar("Rachel Green");
	Avatar avaTwo = new Avatar("Joey Tribbiani");
	// Creating two Position object
	Position startingPositionOne = new Position(0, 1);
	Position startingPositionTwo = new Position(0, 0);
	// Creating two Strategies 
	Strategy testStratOne = new AvatarStrategy();
	Strategy testStratTwo = new AvatarStrategy();
	
	@Before
	public void setUp() throws Exception {
		
		// Adding avatars to the board
		testBoard.addPlayer(avaOne, startingPositionOne);
		testBoard.addPlayer(avaTwo, startingPositionTwo);
		
		// Adding behaviours to strategies 
		testStratOne.addBehaviour("Walk", new Walk()); 
		testStratOne.addBehaviour("Jump", new Jump());
		testStratOne.addBehaviour("Fly", new Fly());
		
		testStratTwo.addBehaviour("Walk", new Walk()); 
		testStratTwo.addBehaviour("Jump", new Jump());
		testStratTwo.addBehaviour("Fly", new Fly());
		
	}
	
	// Testing that Avatar and Positions are being correctly added to the GameBoard
	@Test
	public void testBoard() {
		
		assertNotNull(testBoard);
	}
	
	
	// Clearing position and testing if it is null
	@Test
	public void testRandomPosition(){
		
		Position test1Position = new Position(0, 1);
		
		testBoard.clearPosition(test1Position.getXCoor(), test1Position.getYCoor());
		
		assertNull(testBoard.returnBoard(0, 1));
	}
	
	// Testing that the distance is being calculated correctly
	@Test
	public void testDistance(){
		
		Position testPosition1 = new Position(0,0);
		
		Position testPosition2 = new Position(4,0);
		// Distance should be approx 4.0
		testBoard.calcDistance(testPosition1, testPosition2);
		
		double expectedDistance = 4.0;
		double actualDistance = testBoard.getDistance();
		
		// 0 represents a delta value - required when comparing doubles
		assertEquals(expectedDistance, actualDistance, 0);
		
	}
	
	// Adding an Avatar to the board at the specified position - Testing that the board correctly registers this
	@Test
	public void testAddPlayer(){
		
		Position p1 = new Position(3,4);
		Avatar a = new Avatar("Ross");
		
		testBoard.addPlayer(a, p1);
		
		assertNotNull(testBoard.returnBoard(3, 4));	
	}
	// Testing Invalid Command Exception
	@Test
	public void testExceptions(){
		
		avaOne.setAvatarStrategy(testStratOne);
		
		String command = "Dance"; //Not a defined behaviour - will throw exception
		
		try {
			testStratOne.execute(command); 
			
			fail("Exception expected because of undefined behaviour");
		} catch (InvalidCommandException e) {
			
			System.out.println(e.getMessage());
			
			assertTrue(true);
		}
	}
	
}
