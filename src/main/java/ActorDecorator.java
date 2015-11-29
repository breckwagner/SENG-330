




abstract class ActorDecorator implements Adversarial {
	/**
	 * 
	 */
	private static final long serialVersionUID = -235780774873439669L;
	protected Adversarial object; // the Window being decorated

	public ActorDecorator(Adversarial objectToBeDecorated) {
		this.object = objectToBeDecorated;
	}
}

class AgentDecorator extends ActorDecorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2703707232400266222L;

	public AgentDecorator(Adversarial objectToBeDecorated) {
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

	public PotionDecorator(Adversarial objectToBeDecorated) {
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