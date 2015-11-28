
public class Player extends Actor {
	
	/*
	* Default Constructor for Player
	*/
	public Player(Room currentRoom) {
		super(currentRoom);
		health += 50;
		currentRoom.listOfObjects.add(this);
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
	
}
