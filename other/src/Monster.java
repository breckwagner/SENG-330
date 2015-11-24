public class Monster extends Actor {
	public Monster(Room r){
		super(r);
	}
	public Monster(Room r,int h, int a){
		super(r, h, a);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Monster [health=" + health + ", attack=" + attack + "]";
	}
}