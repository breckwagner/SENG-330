

public class Trap extends Adversary{

	public Trap(Room r) {
		super(r);
		health = (int) (Math.random()* 3) + 9;
	}

	/**
	 * Calls the player's recieve damage function using the current instance of the adversary,
	 * is the case of the adversary dealing damage to the player
	 */
	public void action(Player p){
		super.action(p);
		currRoom.listOfObjects.remove(this);
	}
}