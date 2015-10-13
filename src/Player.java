
public class Player extends game {

  public Player(String name){
	this.playerName = name;
    this.health = 100;
	this.attack = 15; //not sure what we would start with
  }
  public String playerName;

  public Inventory inventory;

  public int Health;

  public int Attack;

  public Type Character;

}