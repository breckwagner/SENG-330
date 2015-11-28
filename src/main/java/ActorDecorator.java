

abstract class ActorDecorator implements Adversarial {
	protected Adversarial object; // the Window being decorated

	public ActorDecorator(Adversarial objectToBeDecorated) {
		this.object = objectToBeDecorated;
	}
}

class AgentDecorator extends ActorDecorator {
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