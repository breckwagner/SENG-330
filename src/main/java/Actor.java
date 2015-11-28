
/**
 * Implements gameObject for the adversaries to interact with the player. The adversary can either be a monster
 * or a trap.
 * 
 * 	@author Richard B. Wagner
 *	@author Mook Tungs
 *	@author Zac Broitman
 *	@author Greg Bacic
 *
 * 
 * 
 */
public class Actor implements GameObject, Adversarial {

	//protected LinkedList<Room> 
	protected Room currentRoom;
	protected int health;
	protected int attack;

	/**
	 * Default Constructor for Adversary
	 */
	public Actor(Room r){
		currentRoom = r;
		health = 20;
		attack = 10;
	}

	/**
	 * Constructor allowing for health and attack to be specified
	 * @param r the current room
	 * @param h health of the monster or trap
	 * @param a attack damage of the monster or trap
	*/
	public Actor(Room r,int h, int a){
		currentRoom = r;
		health = h;
		attack = a;
	}
	/**
	 * Takes the player as a parameter and will reduce its health by the Adversary's attack
	 * @param p take the player removes the value fo the adversary attack formt he players health.
	 */
	public void receiveDamage(Actor p){
		health -= p.attack;
		if(health <= 0){
			currentRoom.listOfObjects.remove(this);
		}
	}

	/**
	 * Calls the player's recieve damage function using the current instance of the adversary,
	 * is the case of the adversary dealing damage to the player
	 * 
	 * @param player the player object to damage/act on
	 */
	public void action(Actor p){
		p.receiveDamage(this);
	}
	
	public void move(String direction){
		Room output = this.currentRoom;
		int index = 0;
		for(String s : this.currentRoom.geo) {
			System.out.println(s);
			if(direction.equals(s)) {
				System.out.println(true);
				output = this.currentRoom.neighboringRooms.get(index);
			}
			index++;
		}
		this.currentRoom.listOfObjects.remove(this);
		output.listOfObjects.add(this);
		this.currentRoom = output;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attack;
		result = prime * result + ((currentRoom == null) ? 0 : currentRoom.hashCode());
		result = prime * result + health;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Actor)) {
			return false;
		}
		Actor other = (Actor) obj;
		if (attack != other.attack) {
			return false;
		}
		if (currentRoom == null) {
			if (other.currentRoom != null) {
				return false;
			}
		} else if (!currentRoom.equals(other.currentRoom)) {
			return false;
		}
		if (health != other.health) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Actor [health=" + health + ", attack=" + attack + "]";
	}
	


}
