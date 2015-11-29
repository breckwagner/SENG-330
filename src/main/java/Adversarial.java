


/**
 * Implements gameObject for the adversaries to interact with the player. The adversary can either be a monster
 * or a trap.
 */
public interface Adversarial extends GameObject {
	/**
	 * Takes the player as a parameter and will reduce its health by the Adversary's attack
	 * @param p take the player removes the value for the adversary attack formt he players health.
	 */
	public void receiveDamage(Actor p);
}
