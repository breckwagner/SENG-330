/**
 * Extends gameObject for the adversaries to interact with the player. The adversary can either be a monster
 * or a trap.
 */

public class Adversary extends GameObject{

	int health;
	int attack;

	/*
	* Default Constructor for Adversary
	*/
	public Adversary(){
		health = 20;
		attack = 10;
	}

	/*
	* Constructor allowing for health and attack to be specified
	* @param h health of the monster or trap
	* @param a attack damage of the monster or trap
	*/
	public Adversary(int h, int a){
		health = h;
		attack = a;
	}
	/*
	* Takes the player as a parameter and will reduce its health by the Adversary's attack
	* @param p take the player removes the value fo the adversary attack formt he players health.
	*/
	public static int recieveDamage(Player p){
		health -= p.attack;
	}


}
