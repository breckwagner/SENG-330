public class Monster extends game {

  public Integer Health;

  public Integer Attack;

  public void attack(Monster monster, Player player) {
	player.Health = player.Health - monster.Health;
	if(player.Health <= 0){
	  System.out.println("Game Over! Start over?");
	}
  }

}