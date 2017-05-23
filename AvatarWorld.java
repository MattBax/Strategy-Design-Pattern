package AvatarGame;

public class AvatarWorld {

	public static void main(String[] args) {

		// Creating two Avatar objects
		Avatar test1 = new Avatar("Marty Morissey");
		Avatar test2 = new Avatar("Pat Spillane");

		// Creating new Avatar Strategy
		Strategy testStrat = new AvatarStrategy();
		testStrat.addBehaviour("Walk", new Walk()); // Adding three behaviours
		testStrat.addBehaviour("Jump", new Jump());
		testStrat.addBehaviour("Fly", new Fly());
		// Setting strategy for Avatar object
		test1.setAvatarStrategy(testStrat);
		// Creating a second Avatar Strategy
		Strategy testStrat2 = new AvatarStrategy();
		testStrat2.addBehaviour("Walk", new Walk()); // Adding three behaviours
		testStrat2.addBehaviour("Jump", new Jump());
		testStrat2.addBehaviour("Fly", new Fly());

		// Setting strategy for second Avatar object
		test2.setAvatarStrategy(testStrat2);

		// Setting starting positions
		Position startingPos = new Position(1, 0);
		Position startingPos2 = new Position(0, 0);

		// Initialising new Gameboard 10x10 in size
		GameBoard board = new GameBoard(10, 10);

		System.out.println();
		// Adding both avatars and their starting positions
		board.addPlayer(test1, startingPos);
		board.addPlayer(test2, startingPos2);

		// Moving the two Avatars
		// Using loop to move five times
		
		System.out.println("Two Avatars have been added to the Gameboard.");
		System.out.println("They will now move around the Gameboard fives times each.");
		System.out.println("The Distance will be calculated between the positions.");
		System.out.println("The Avatars will do a certain behaviour based on the distance travelled.");
		System.out.println();
		System.out.println("---------------------------------------------------------------------------");
		
		// loop 5 times - calling the move method each time.
		// Checking for Invalid commands each iteration.
		for (int i = 0; i < 5; i++) {

			try {
				startingPos = test1.move(startingPos, board);
			} catch (InvalidCommandException e) {

				System.out.println(e.getMessage());
			}
			System.out.println();
			try {
				startingPos2 = test2.move(startingPos2, board);
			} catch (InvalidCommandException e) {

				System.out.println(e.getMessage());
			}
			System.out.println();

			try {
				startingPos = test1.move(startingPos, board);
			} catch (InvalidCommandException e) {

				System.out.println(e.getMessage());
			}
			System.out.println();
			try {
				startingPos2 = test2.move(startingPos2, board);
			} catch (InvalidCommandException e) {

				System.out.println(e.getMessage());
			}
			System.out.println();
		
		
		}
	}
}
