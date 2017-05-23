package AvatarGame;

public interface Strategy {
	
	// Overridden in the AvatarStrategy Class
	public void setAvatar(Avatar avatar);
	
	public void addBehaviour(String command, Behaviour behaviour);
	
	public void execute(String command) throws InvalidCommandException;
	
}
 