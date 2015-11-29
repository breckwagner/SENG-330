



import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * This class is just to test
 * 
 * @author Richard B. Wagner
 * @author Mook Tungs
 * @author Zac Broitman
 * @author Greg Bacic
 *
 */
public class Interface {

	static final String GAME_OVER_ASCII = "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "███▀▀▀██┼███▀▀▀███┼███▀█▄█▀███┼██▀▀▀\n" + "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼█┼┼┼██┼██┼┼┼\n"
			+ "██┼┼┼▄▄▄┼██▄▄▄▄▄██┼██┼┼┼▀┼┼┼██┼██▀▀▀\n" + "██┼┼┼┼██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██┼┼┼\n"
			+ "███▄▄▄██┼██┼┼┼┼┼██┼██┼┼┼┼┼┼┼██┼██▄▄▄\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "███▀▀▀███┼▀███┼┼██▀┼██▀▀▀┼██▀▀▀▀██▄┼\n" + "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██┼┼┼┼██┼┼┼┼┼██┼\n"
			+ "██┼┼┼┼┼██┼┼┼██┼┼██┼┼██▀▀▀┼██▄▄▄▄▄▀▀┼\n" + "██┼┼┼┼┼██┼┼┼██┼┼█▀┼┼██┼┼┼┼██┼┼┼┼┼██┼\n"
			+ "███▄▄▄███┼┼┼─▀█▀┼┼─┼██▄▄▄┼██┼┼┼┼┼██▄\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼██┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼████▄┼┼┼▄▄▄▄▄▄▄┼┼┼▄████┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼▀▀█▄█████████▄█▀▀┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼█████████████┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼┼██▀▀▀███▀▀▀██┼┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼██┼┼┼███┼┼┼██┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼┼█████▀▄▀█████┼┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼┼███████████┼┼┼┼┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼▄▄▄██┼┼█▀█▀█┼┼██▄▄▄┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼▀▀██┼┼┼┼┼┼┼┼┼┼┼██▀▀┼┼┼┼┼┼┼┼┼\n"
			+ "┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼▀▀┼┼┼┼┼┼┼┼┼┼┼\n" + "┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼┼";

	static final String GAME_START_ASCII = 
	  "__          __  _                            _______      __________  _____  _  __\n"
	+ "\\ \\        / / | |                          |__   __|    |___  / __ \\|  __ \\| |/ /\n"
	+ " \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___     | | ___      / / |  | | |__) | ' / \n"
	+ "  \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\    | |/ _ \\    / /| |  | |  _  /|  <  \n"
	+ "   \\  /\\  /  __/ | (_| (_) | | | | | |  __/    | | (_) |  / /_| |__| | | \\ \\| . \\ \n"
	+ "    \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|    |_|\\___/  /_____\\____/|_|  \\_\\_|\\_\\";
	
	
	
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// clear terminal
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		System.out.println(GAME_START_ASCII);
		int cols = Utility.getCols();
		
		for(int i = 0; i < cols; i++) {
			System.out.print("░");
		}
		

		Room startRoom = new Room();
		Player player = new Player(startRoom);

		Game.Builder gBuilder = new Game.Builder(startRoom, player);
		gBuilder.setSeed(0);
		gBuilder.prebuildMapExtermination(5);

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
			System.out.println(g.player.currentRoom);
			System.out.println("\nYou could go: " + g.player.currentRoom.getDirections());

			System.out.print("> ");
			in = "";// input.nextLine().trim();
			if(true) break loop;
			//System.in.read();
			switch (in) {
			case "help":

				continue loop;
			case "attack":
				for (Monster m : g.player.currentRoom.listOfObjects.stream().filter(p -> p instanceof Monster)
						.map(p -> (Monster) p).collect(Collectors.toList())) {
					m.receiveDamage(g.player);
				}
				break;
			case "north":
				g.player.move("north");
				break;
			case "east":
				move(g, "east");
				break;
			case "south":
				move(g, "south");
				break;
			case "west":
				System.out.println(move(g, "west"));
				break;
			case "save":
				System.out.println("Please specify save path (e.g. \"/foo/bar.ser\"): ");
				in = input.nextLine().trim();
				File file = new File(in);
				if (!file.exists()) {
					file.createNewFile();
				}
				FileOutputStream fout;
				try {
					fout = new FileOutputStream(in);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(g);
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break loop;
			case "quit":
				break loop;
			default:
				break;
			}
			g.player.currentRoom.initiateEvents(g.player);
		}
		if (!g.isRunning()) {
			System.out.println(GAME_OVER_ASCII);
		}
		input.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static enum Code {CONTINUE,EXIT}
	
	
	
	
	
	
	
	
	
	
	
	public static Code processInput(Game g, String input) throws IOException {
		
		switch (input) {
		case "help":

		case "attack":
			for (Monster m : g.player.currentRoom.listOfObjects.stream().filter(p -> p instanceof Monster)
					.map(p -> (Monster) p).collect(Collectors.toList())) {
				m.receiveDamage(g.player);
			}
			break;
		case "north": 
		case "n":
			move(g, "north");
			break;
		case "east":
		case "e":
			move(g, "east");
			break;
		case "south":
		case "s":
			move(g, "south");
			break;
		case "west":
		case "w":
			move(g, "west");
			break;
		case "save":
			System.out.println("Please specify save path (e.g. \"/foo/bar.ser\"): ");
			File file = new File(input);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fout;
			try {
				fout = new FileOutputStream(input);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(g);
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "quit":
			break;
		default:
			break;
		}
		
		return Code.EXIT;
	}

	public static Room move(Game g, String direction) {
		Room output = g.player.currentRoom;
		int index = 0;
		for (String s : g.player.currentRoom.geo) {
			if (direction.equals(s)) {
				output = g.player.currentRoom.neighboringRooms.get(index);
			}
			index++;
		}
		g.player.currentRoom.listOfObjects.remove(g.player);
		output.listOfObjects.add(g.player);
		g.player.currentRoom = output;
		
		return output;
	}
}

/*
 * TODO
 * 
 * - ADD Natural Language Processing - ADD More Commands - Find Solution for
 * LAMBDA not Serializable
 * 
 */

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