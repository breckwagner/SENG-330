public class Adversary implements GameObject{

	Room currRoom;
	int health;
	int attack;

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
	*/
	public Adversary(Room r,int h, int a){
		currRoom = r;
		health = h;
		attack = a;
	}
	/*
	* Takes the player as a parameter and will reduce its health by the Adversary's attack
	*/
	public int recieveDamage(Player p){
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
		p.recieveDamage(this);
	}



}
