
public class Adversary implements GameObject{
/**
 * Implements gameObject for the adversaries to interact with the player. The adversary can either be a monster
 * or a trap.
 */

	Room currRoom;
	public int health;
	public int attack;

	/*
	* Default Constructor for Adversary
	*/
	public Adversary(Room r){
		currRoom = r;
		health = 20;
		attack = 10;
	}

	/*
	* Constructor allowing for health and attack to be specified
	* r the current room
	* h health of the monster or trap
	* a attack damage of the monster or trap
	*/
	public Adversary(Room r,int h, int a){
		currRoom = r;
		health = h;
		attack = a;
	}
	/*
	* Takes the player as a parameter and will reduce its health by the Adversary's attack
	* p take the player removes the value fo the adversary attack formt he players health.
	*/
	public void receiveDamage(Player p){
		health -= p.attack;
		if(health <= 0){
			currRoom.listOfObjects.remove(this);
		}
	}

	/*
	* Calls the player's recieve damage function using the current instance of the adversary,
	* is the case of the adversary dealing damage to the player
	*/
	public void action(Player p){
		p.receiveDamage(this);
	}



}
