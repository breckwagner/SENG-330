public class gameProcessor extends game {
  import java.util.Random;

  public Monster currentMonster;

  public Room currentRoom;

  public Room nextRoom;

  public Room previousRoom;

  public void Move( room1,  room2) {
    System.out.println("There are two doors, one to the left and one to the right. Which door do you take?");
    stdin= stdin.next();
    boolean valid = false;
    while(valid = false){
      if(stdin = "left"){
      currentRoom = room1;
      valid = true;
      } else if(stdin = "right"){
      currentRoom= room2;
      valid = true;
      } else {
      System.out.println("Please either enter 'left' or 'right'");
      }
    }
  }

  public void putMonster( Monster,  room) {
  }

  public void useItem( item) {
    item.use(target);
  }

  public void attackMonster( Monster monster) {
    monster.Health = monster.Health - calculateAttack();
    if(monster.Health <=0){       /* Monster has been defeated */
      System.out.println("The monster has been defeated!");
    } else{
      player.Health = Player.Health - monster.Attack;
	  System.out.println("The monster attacked you. Your health decreased by %d\n", monster.Attack);
    }
  }

  public int calculateAttack(Player player){
      int min = player.Attack - 2;
      int max - player.Attack + 2;

      Random rand = new Random();
      return rand.nextInt(max - min) + min;     /* Have to test, pulled it from stack overflow*/
  }

  public void pickupItem( Item) {
  }

  public void gameOver( player) {
    System.out.println("You have failed in your journey, a new quest alwasy awaits you!");
    /* Not sure how to start bring the game back to the initial state */
    /* Can either automatically relaunch the game
       or can ask the user if they want to quit or restart */    
  }

  public void checkHealth( Player player) {
    int health = player.Health
    System.out.println("Your health is currently at " + health + "health points.");
  }

  public void avoidTrap() {
    int trapChance = currentRoom.trap;    /* each Room contains a trap value, that value determines 
                                             the threshold needed to meet/surpass to avoid the trap
                                             the max value will be 99*/

    int playerRoll = Random.nextInt(100); /*For now just a random number between 0 and 100 is chosen,
                                            this will always give the player a chance to pass the trap*/

    if(playerRoll >= trapChance){
      System.out.println("You have avoided the trap!");
      currentRoom.hasTrap = false;
    } else{
      System.out.println("You have failed to avoid the trap, you lose 10 health points!");
      player.Health = player.Health - 10;         /* Just decided on 10 for now, can be changed to a new value or
                                                      a value based off some player stat such as armor */
    }
  }

  public void DiscoverItem() {
    String type = currentRoom.item.type;
    System.out.println("You have found a " + type ". Would you like to pick it up?")
    /* User input */
    char userInput = stdin.next() /* Just an example, not 100% on how we are handling the input yet*/
    if(userInput = "y"){
      pickupItem(currentRoom.item);
    }
  }

  public void checkInventory( inventory) {
  }

}