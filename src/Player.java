
public class Player {

	public Player(String name) {
		this.playerName = name;
		this.health = 100;
		this.attack = 15; // not sure what we would start with
	}

	public String playerName;

	public Inventory inventory;

	public int health;

	public int attack;

}