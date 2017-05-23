package AvatarGame;

import java.util.HashMap;

public class AvatarStrategy implements Strategy {

	private Avatar avatar;
	private HashMap<String, Behaviour> actionTaken = new HashMap<String, Behaviour>();
	

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
		
	}
	// Adds a behaviour & command to the HashMap
	public void addBehaviour(String command, Behaviour behaviour) {
			actionTaken.put(command, behaviour);
		
	}
   // Executes a behaviour based on the command passed in
	public void execute(String command) throws InvalidCommandException {
		
		if (actionTaken.containsKey(command)){
			System.out.print(avatar.getName() + " is ");
			actionTaken.get(command).action();
		} else {
			throw new InvalidCommandException(command + " is not a valid command for " + avatar.getName());
			
		}
		
		
	}

}
