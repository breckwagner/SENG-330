
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class is just to test
 * 
 * @author Richard B. Wagner
 * @author Mook Tungs
 * @author Zac Broitman
 * @author Greg Bacic
 *
 */
public class TestBed1 {

	static final String GAME_OVER_ASCII = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼";

	Function<GameObject, Boolean> callback = gameObject -> {
		return true;
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Room startRoom = new Room();
		Player player = new Player(startRoom);

		Game.Builder gBuilder = new Game.Builder(startRoom, player);
		gBuilder.setSeed(0);
		gBuilder.prebuildMapExtermination();

		Game g;
		if (args.length > 0) {
			try {
				FileInputStream fileIn = new FileInputStream(args[0]);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				g = (Game) in.readObject();
				in.close();
				fileIn.close();
			} catch (Exception e) {
				System.out.println("");
				g = gBuilder.build();
			}
		} else {
			g = gBuilder.build();
		}

		Scanner input = new Scanner(System.in);
		String in;

		loop: while (g.isRunning()) {
			System.out.println(g.currentRoom);
			System.out.println("\nYou could go: " + g.currentRoom.getDirections());
			in = input.next().trim();
			switch (in) {
			case "help":

				continue loop;
			case "attack":
				for (Monster m : g.currentRoom.listOfObjects.stream().filter(p -> p instanceof Monster)
						.map(p -> (Monster) p).collect(Collectors.toList())) {
					m.receiveDamage(g.player);
				}
				break;
			case "north":
				move(g, "North");
				break;
			case "east":
				move(g, "East");
				break;
			case "south":
				move(g, "South");
				break;
			case "west":
				move(g, "West");
				break;
			case "save":
				System.out.println("Please specify save path (e.g. \"/foo/bar.ser\"): ");
				in = input.next().trim();
				FileOutputStream fout;
				try {
					fout = new FileOutputStream(in);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(g);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("FUK");
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("FUK");
					e.printStackTrace();
				}
				break loop;
			case "quit":
				break loop;
			default:
				break;
			}
			g.currentRoom.initiateEvents(g.player);
		}
		if(!g.isRunning()) {
			System.out.println(GAME_OVER_ASCII);
		}
		input.close();
	}

	public static Room move(Game g, String direction) {
		Room output = g.currentRoom;
		int index = 0;
		for (String s : g.currentRoom.geo) {
			if (direction.equals(s)) {
				output = g.currentRoom.neighboringRooms.get(index);
			}
			index++;
		}
		g.currentRoom.listOfObjects.remove(g.player);
		output.listOfObjects.add(g.player);
		g.currentRoom = output;
		return output;
	}
}

/*
 * TODO ADD COMMANDS AND NLP
 * 
 * Move commands Command Shortcut Action north n Move north south s Move south
 * east e Move east west w Move west northeast ne Move northeast northwest nw
 * Move northwest southeast se Move southeast southwest sw Move southwest up u
 * Move up down d Move down look l Looks around at current location save Save
 * state to a file restore Restores a saved state restart Restarts the game
 * verbose Gives full description after each command score Displays score and
 * ranking diagnostic Give description of health brief Give a description upon
 * first entering an area superbrief Never describe an area quit q Quit game
 * climb climbs(up) g last common go(direction) go towards
 * direction(west/east/north/south/in/out/into) in/into in to the
 * place(window,...) out go out of the place(kitchen,...) hi/hello say hello...
 * fuck/shit/damn Random Comment e.g. : Such language in a high-class
 * establishment like this! i inventory (None) I beg your pardon? Item commands
 * Command (Argument) Action get/take (item) Removes item from current room;
 * places it in your inventory get/take all takes all takeable objects in room
 * throw (item) at (location) Throws the item at something open (container)
 * Opens the container, whether it is in the room or your inventory open (exit)
 * Opens the exit for travel read (item) Reads what is written on readable item
 * drop (item) Removes item from inventory; places it in current room put (item)
 * in (container) Removes item from inventory; places it in container turn
 * (control) with (item) Attempts to operate the control with the item turn on
 * (item) Turns on the item turn off (item) Turns the item off move (object)
 * Moves a large object that cannot be picked up attack (creature) with (item)
 * Attacks creature with the item examine (object) Examines, or looks, at an
 * object or item or location inventory Shows contents of Inventory eat Eats
 * item (specifically food) shout Aaaarrrrgggghhhh! close [Door] Closes door tie
 * (item) to (object) pick (item) take/get item kill self with (weapon)
 * Humorously commits suicide break (item) with (item) Breaks item kill
 * (creature) with (item) Attacks creature with the item pray when you are in
 * temples... drink drink an item
 * 
 * smell smell an item
 * 
 * Thanks for playing this game!
 * 
 * 
 */