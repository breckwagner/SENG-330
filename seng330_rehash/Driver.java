playerInput
if(retaliateOption(playerInput)){ monster/trap attacks }


import java.io.Console;
import java.util.Arrays;
import java.io.IOException;

public class Driver {

    public static void main (String args[]) throws IOException {

        Game g = new Game(0);
        String[] commands = {"help","pick up items","fight monster","move room","check inventory","use item"}


        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        while(g.isRunning()){
            System.out.println("You enter a new room which contains: ");
            System.out.println(g.currentRoom.listObjects());
            String playerInput = c.readLine("What would you like to do?:");
            if(retaliateOption(playerInput)){
                g.currentRoom.initiateEvents(g.player);
            }

        }

    }

    public static void runCommand(String cmd, Game g){
        switch(cmd){
            case "help":
                System.out.println(commands);
                break;
            case "pick up items":
                for(GameObject obj : g.currentRoom.listOfObjects){
                    if(obj instanceof Item){
                        g.player.inventory.add(obj);
                        g.currentRoom.listOfObjects.remove(obj);
                    }
                }
                break;

            case "fight monster":
                for (GameObject obj : g.currentRoom.listOfObjects){
                    obj.receiveDamage(g.player);
                }
                break;

            case "move room":
                System.out.println("There are 3 doors in the room, one to the left, middle and right.");
                String playerInput = c.readLine("Which door do you choose?: ");
                g.moveRoom();
                break;

            case "check inventory":
                System.out.println(g.player.inventory);
                break;

            case "use item":
                System.out.println("Your inventory currently holds :" + g.player.inventory);
                String playerInput = c.readLine("What type of item would you like to use?");
                for(Item i : g.player.inventory){
                    if(i.name.equals(playerInput)){
                        i.use();
                        break;
                    }
                }
                break;
        }
    }

}