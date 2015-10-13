public class Monster extends game {

	public int health;
	public int attack;


	public Monster(){
	this.health = 30; // stat could change 
	this.Attack = 10; //
}

public Integer AvoidChance;		/* Between 0-10 */

public void attack(Player player) {
	player.Health = player.Health - monster.Attack;
	if(player.Health <= 0){
		System.out.println("Game Over! Start over?");
	}
}


}