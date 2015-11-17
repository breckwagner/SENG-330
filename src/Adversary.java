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
	*/
	public Adversary(int h, int a){
		health = h;
		attack = a;
	}
	/*
	* Takes the player as a parameter and will reduce its health by the Adversary's attack
	*/
	public static int recieveDamage(Player p){
		health -= p.attack;
	}


}
