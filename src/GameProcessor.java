import java.util.Random;


public class GameProcessor extends Game {

    public Monster currentMonster;
    public Item currentItem;
    public Room currentRoom;
    public Random rand;

    public void Move(Room room1, Room room2) {
        System.out.println("There are two doors, one to the left and one to the right. Which door do you take?");
        stdin= stdin.next();
        boolean valid = false;
        while(valid = false) {
            if(stdin = "left") {
                currentRoom = room1;
                valid = true;
            } else if(stdin = "right") {
                currentRoom= room2;
                valid = true;
            } else {
                System.out.println("Please either enter 'left' or 'right'");
            }
            System.out.println("Invalid Answer, Left or Right please.");
            stdin =stdin.next();
        }
    }

    public void putMonster(Monster monster, Room room) {
            if(currentRoom.HasMonster) {
                    currentMonster = new Monster();
            }
    }

    public void useItem(Item item) {
            item.use(target);
    }

    public void attackMonster( Monster monster) {
            monster.Health = monster.Health - calculateAttack();
            if(monster.Health <=0) {  /* Monster has been defeated */
                    System.out.println("The monster has been defeated!");
            } else{
                    player.Health = Player.Health - monster.Attack;
                    System.out.println("The monster attacked you. Your health decreased by " + monster.Attack);
            }
    }

    public void avoidMonster(Monster monster) {
            int playerRoll = rand.nextInt(10);
            if(playerRoll>=monster.AvoidChance) {
                    System.out.println("You have successfully avoided the monster! You did not have a chance to see if there were any items around.");
                    currentRoom.hasMonster = false;
                    currentRoom.hasItem = false;
            }
    }

    public int calculateAttack(Player player){
		    Random rand = new Random();
            int min = player.Attack - 2;
            int max = player.Attack + 2;

            return rand.nextInt(max - min) + min;   /* Have to test, pulled it from stack overflow*/
    }

    public void pickupItem(Item item) {
            if(currentRoom.HasItem) {
                    currentItem = new Item();
                    player.inventory.add(currentItem);
            }
    }

    public void gameOver(Player player) {
            System.out.println("You have failed in your journey, a new quest always awaits you!");
            /* Not sure how to start bring the game back to the initial state */
            /* Can either automatically relaunch the game
               or can ask the user if they want to quit or restart */
    }

    public void checkHealth(Player player) {
            System.out.println("Your health is currently at " + player.Health + "health points.");
    }

    public void avoidTrap() {
            int trapChance = currentRoom.trap; /* each Room contains a trap value, that value determines
                                                  the threshold needed to meet/surpass to avoid the trap
                                                  the max value will be 99*/

            int playerRoll = rand.nextInt(100); /*For now just a random number between 0 and 100 is chosen,
                                                    this will always give the player a chance to pass the trap*/

            if(playerRoll >= trapChance) {
                    System.out.println("You have avoided the trap!");
                    currentRoom.hasTrap = false;
            } else{
                    System.out.println("You have failed to avoid the trap, you lose 10 health points!");
                    player.Health = player.Health - 10; /* Just decided on 10 for now, can be changed to a new value or
                                                            a value based off some player stat such as armor */
            }
    }

    public void DiscoverItem() {
        String type = currentRoom.item.type;
        System.out.println("You have found a " + type + ". Would you like to pick it up?");
        /* User input */
        char userInput = stdin.next(); /* Just an example, not 100% on how we are handling the input yet*/
        if(userInput = "y") pickupItem(currentItem);
    }

    public void checkInventory(Inventory inventory) {

    }

}
