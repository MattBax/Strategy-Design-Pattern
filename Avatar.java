package AvatarGame;

public class Avatar {
	
	protected String name;
	protected Strategy strategy;
	protected Avatar avatar;
	
	public Avatar(String name){
		this.name = name;
		
	}
	
	public void setAvatarStrategy(Strategy strat){
		
		this.strategy = strat;
		strategy.setAvatar(this);
		
	}
	
	public String getName(){
		
		return name;
	}
	// Moves Avatar to new coordinates.
	public Position move(Position oldPos,GameBoard gameBoard) throws InvalidCommandException {
		
		// Randomly setting new position
		Position newPos = gameBoard.getRandCoor(); 
		
		// Checking that the current position is empty
		if (gameBoard.returnBoard(newPos.getXCoor(), newPos.getYCoor()) == null){
		
		// Calculating distance between the old position and new position
		gameBoard.calcDistance(oldPos, newPos);
		// Return the distance between the oldPos and newPos
		double distance = gameBoard.getDistance();
		
		System.out.println(getName() + " is moving from current coordinates X: "+ oldPos.getXCoor()+ " Y: " + oldPos.getYCoor() 
		+ " to new coordinates: X: " + newPos.getXCoor()+ " Y: " + newPos.getYCoor());
		System.out.println("The Distance is " + distance);
		// Clearing original position
		gameBoard.clearPosition(oldPos.getXCoor(), oldPos.getYCoor());
		// Moves the Avatar to the new position
		gameBoard.addPlayer(this, newPos);
		
		
		// Depending on the distance, pass a command string
		String command;
		if(distance <= 5.0){
			
			command = "Walk";
		}
		
		else if(distance > 5 && distance <= 10){
			
			command = "Jump";
		}
		
		else {
			
			command = "Fly";
		}
		
		try {
			this.strategy.execute(command); // execute command based on distance
		} catch (InvalidCommandException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		}
		
		else {
			// If current position is occupied then print this 
			System.out.println("This Position is occupied. Please select alternative coordinates!");
			
		}
		// updates avatars position to the new position
		return newPos;
	}

	
}
