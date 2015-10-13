public class Monster extends game {
  
  public Monster(){
    this.health = 30; // stat could change 
	this.attack = 10; //
  }

  public Integer AvoidChance;		/* Between 0-10 */

  public void attack(Monster monster, Player player) {
	player.Health = player.Health - monster.Health;
	if(player.Health <= 0){
	  System.out.println("Game Over! Start over?");
	}
  }
  
  public int health;
  public int attack;
}