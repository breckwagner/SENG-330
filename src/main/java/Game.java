

/**
 * 	Creates a new player object(class constructor) for the game and while game
 *  is currently a placeholder
 *	for the game obect which will run the game.
 *
 * 	@author Richard B. Wagner
 *	@author Mook Tungs
 *	@author Zac Broitman
 *	@author Greg Bacic
 */

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7283897225120872578L;
	public Player player;
	public Room currentRoom;
	public LinkedList<Room> roomList;
	protected Function<Game, Boolean> isRunning;
	private int turn;

	/**
	 * Constructor for the game with static variables.
	 */
	public Game() {
		isRunning = game -> {
			return this.player.getHealth() > 0;
		};
	}

	/**
	 * Constructor for builder
	 */
	private Game(Player p, Room r) {
		this.player = p;
		this.currentRoom = r;
	}

	/**
	 * Constructor for Game with set number of end Rooms
	 * 
	 * @param endRooms
	 *            sets the last number of rooms before the game will end, with
	 *            the player beating the game.
	 */
	public Game(int endRooms) {

	}

	/**
	 * checks the players health while the game is running.
	 * 
	 * @return boolean denoting whether the player objects health is greater
	 *         than 0
	 */
	public boolean isRunning() {
		return (player.getHealth() > 0);
	}

	public int getTurn() {
		return turn;
	}

	public void incrementTurn(int turn) {
		this.turn++;
	}

	public static class Builder {
		// Required parameters
		private final Room startingRoom;
		private final Player localPlayer;
		private LinkedList<Room> roomList = new LinkedList<Room>();

		// Optional parameters - initialize with default values
		private long seed = new Random().nextLong();
		private Function<Game, Boolean> isRunning;
		
		// PreBuilt GameObjects
		
		/*
		Function<Game, Boolean> xyz = isRunning = game -> {
			int monsterCount = 0;
			for (Room room : this.roomList) {
				for (Monster m : room.listOfObjects.stream().filter(p -> p instanceof Monster)
						.map(p -> (Monster) p).collect(Collectors.toList())) {
					monsterCount++;
				}
			}
			return this.localPlayer.getHealth() > 0 || monsterCount > 0;
		};
		
		
		private void addBef() {
			java.util.ArrayList<Function<Game, Boolean>> x = new java.util.ArrayList<Function<Game, Boolean>>();
			x.add(isRunning = game -> {
				int monsterCount = 0;
				for (Room room : this.roomList) {
					for (Monster m : room.listOfObjects.stream().filter(p -> p instanceof Monster)
							.map(p -> (Monster) p).collect(Collectors.toList())) {
						monsterCount++;
					}
				}
				return this.localPlayer.getHealth() > 0 || monsterCount > 0;
			});
			
			
		}*/
		
		
		
		
		
		
		public Builder(Room room, Player player) {
			startingRoom = room;
			localPlayer = player;
		}

		/** mod is a modified modulus operation
		 * @param x
		 * @param n
		 * 
		 * Note: Java default modulus doesn't have positive results for negative numbers
		 * example: -1 % 5 = -1. mod(-1, 5) -> 4
		 */
		private int mod(int x, int n) {
			int r = x % n;
			if (r < 0) {
				r += n;
			}
			return r;
		}

		/**
		 * Generates the map and sets up custom game function.
		 * 
		 * @param n
		 *            the edge size of the grid. This becomes indistinguishable
		 *            to the user because the world wraps around.
		 * 
		 *            <p>
		 *            Note: This game type initializes the entire playing field
		 *            at the start. Large values of n may become very memory
		 *            intensive.
		 */
		public void prebuildMapExtermination(int n) {

			Room[][] map = new Room[n][n];
			String roomNumber;
			Room current = startingRoom;

			Random r = new Random(seed);
			
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = (i == 0 && j == 0) ? startingRoom : (new Room());
				}
			}
			
			for (int i = 0; i < n; i++) { // i <- x East/West
				for (int j = 0; j < n; j++) { // j <- y North/South
					current = map[i][j];
					roomList.add(current);

					current.addNeighboringRoom(map[i][mod(j - 1, n)], "north");
					current.addNeighboringRoom(map[mod(i + 1, n)][j], "east");
					current.addNeighboringRoom(map[i][mod(j + 1, n)], "south");
					current.addNeighboringRoom(map[mod(i - 1, n)][j], "west");
					
					roomNumber = "["+i+"]["+j+"]";
					
					current.addDescription(
							"You are in a very uniform looking place in the woods. All around you is dense forest."+roomNumber);

					if (r.nextDouble() < 0.5) {
						current.listOfObjects.add(new Monster(current));
					}

					if (r.nextDouble() < 0.2) {
						// current.listOfObjects.add(new Item());
					}

					isRunning = game -> {
						int monsterCount = 0;
						for (Room room : this.roomList) {
							for (Monster m : room.listOfObjects.stream().filter(p -> p instanceof Monster)
									.map(p -> (Monster) p).collect(Collectors.toList())) {
								monsterCount++;
							}
						}
						return this.localPlayer.getHealth() > 0 || monsterCount > 0;
					};
				}
			}
		}

		/**
		 * Sets the value of seed to be used by builders. If left unset, a
		 * pseudo-random seed will be chosen
		 */
		public void setSeed(long seed) {
			this.seed = seed;
		}

		public Game build() {
			Game g = new Game(localPlayer, startingRoom);

			if (this.isRunning != null)
				g.isRunning = this.isRunning;
			g.roomList = this.roomList;

			return g;
		}
	}
}
