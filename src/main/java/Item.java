
/**
 * An Item represents any type of equipment, potion, tool, etc. Items are meant
 * to be equipped to an Actor.
 * 
 * @author Richard B. Wagner
 *
 */
public class Item implements GameObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6343463843212544172L;
	
	private Runnable action;

	/**
	 * 
	 */
	public Item() {}

	@Override
	public void action(Actor p) {
		
	}

}
