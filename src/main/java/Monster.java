


public class Monster extends Actor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1278188525316525032L;

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