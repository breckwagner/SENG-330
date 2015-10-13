public class Monster extends game {

	public int health;  // The initial health of the monster. Will be read from file.
	public int attack;  // The attack strengh of the monster. Will be read from file.
	public String type; // Will be the name the monster appears as in the terminal

	public Monster(){
	this.health = 30; // stat could change 
	this.Attack = 10; //
	this.type = "MonsterTemplate"; // Template name for Monster
}

public Integer AvoidChance;		/* Between 0-10 */

public void attack(Player player) {
	player.Health = player.Health - monster.Attack;
	if(player.Health <= 0){
		System.out.println("Game Over! Start over?");
	}
}


}
