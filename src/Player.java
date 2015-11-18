import java.util.LinkedList;

public class Player {
	
	/*
	* Player's health stat
	*/
	public int health;
	
	/*
	* Player's attack stat	
	*/
	public int attack;
	
	/*
	* The number of potion the player has
	*/
	public int potion;
	
	/*
	* Default Constructor for Player
	*/
	public Player() 
	{
		this.health = 100;
		this.attack = 10;
		this.potion = 0;
	}
	
	/*
	* Increase the player's health and decrease potion by 1
	*/
	public void usePotion()
	{
		this.health += 20;
		this.potion--;
	}

	public void recieveDamage(Adversary a){
		health -= a.attack;
	}
}
