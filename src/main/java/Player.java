


public class Player extends Actor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6659813398468260515L;

	/*
	* Default Constructor for Player
	*/
	public Player(Room currentRoom) {
		super(currentRoom);
		health += 50;
		currentRoom.listOfObjects.add(this);
	}
	
	public Player(Player oldPlayer) {
		super(oldPlayer.getCurrentRoom());
		health = oldPlayer.health;
	}
	
	/*
	* Increase the player's health and decrease potion by 1
	*/
	public void useItem(GameObject i)
	{
		this.health += 20;
	}

	public void receiveDamage(Actor a){
		health -= a.attack;
	}
	
	@Override
	public void action(Actor a) {
		// DO NOTHING
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[health=" + health + ", attack=" + attack + "]";
	}
	
}
