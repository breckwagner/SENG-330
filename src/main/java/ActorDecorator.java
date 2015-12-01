




abstract class ActorDecorator extends Player implements Adversarial {
	/**
	 * 
	 */
	private static final long serialVersionUID = -235780774873439669L;
	protected Player object; // the Window being decorated
	
	public ActorDecorator(Room currentRoom) {
		super(currentRoom);
		// TODO Auto-generated constructor stub
	}

	public ActorDecorator(Player objectToBeDecorated) {
		super(objectToBeDecorated.getCurrentRoom());
	}
	
	//public ActorDecorator(Player objectToBeDecorated) {
		
	//	this.object = objectToBeDecorated;
	//}
}

class AgentDecorator extends ActorDecorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703707232400266222L;

	public AgentDecorator(Room objectToBeDecorated) {
		super(objectToBeDecorated);
	}

	@Override
	public void receiveDamage(Actor p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void action(Actor p) {
		// TODO Auto-generated method stub

	}

}

class PotionDecorator extends ActorDecorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -381804464412166794L;

	public PotionDecorator(Player objectToBeDecorated) {
		super(objectToBeDecorated);
	}

	@Override
	public void receiveDamage(Actor p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void action(Actor p) {
		// TODO Auto-generated method stub

	}
}