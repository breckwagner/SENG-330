import java.util.LinkedList;

public class Player {
	
	public int health;
	public int attack;
	public LinkedList<Item> inventory = new LinkedList<Item>();
	
	public Player() 
	{
		this.health = 100;
		this.attackDamage = 10;
	}
	
}
