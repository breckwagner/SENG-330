public class Trap extends Adversary{

	public Trap(){
		health = (int) (Math.random()* 3) + 9;
	}

	public void action(Player p){
		super.action();
		currRoom.listOfObjects.remove(this);
	}
}