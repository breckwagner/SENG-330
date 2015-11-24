
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
	 * @return boolean denoting whether the player objects health is greater than
	 *         0
	 */
	public boolean isRunning() {
		return (player.getHealth() > 0);
	}
	
	
	public static class Builder {
		// Required parameters
		private final Room startingRoom;
		private final Player localPlayer;
		private LinkedList<Room> roomList = new LinkedList<Room>();


		// Optional parameters - initialize with default values
		private long seed = new Random().nextLong();
		private Function<Game, Boolean> isRunning;
		
		public Builder(Room room, Player player) {
			startingRoom = room;
			localPlayer = player;
		}
		
		private int mod(int x, int n) {
			int r = x % n;
			if (r < 0)
			{
			    r += n;
			}
			return r;
		}
		
		public void prebuildMapExtermination() {
			int N = 5;
			
			Room[][] map = new Room[N][N];
			
			Room current = startingRoom;
			
			Random r = new Random(seed);
			
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					map[i][j] = (i == 0 && j == 0)?startingRoom:(new Room());
				}
			}
			
			for(int i = 0; i < N; i++){ // i <- x East/West
				for(int j = 0; j < N; j++){ // j <- y North/South
					current = map[i][j];
					roomList.add(current);
					
					current.addNeighboringRoom(map[i][mod(j-1,N)], "North");
					current.addNeighboringRoom(map[mod(i+1,N)][j], "East");
					current.addNeighboringRoom(map[i][mod(j+1,N)], "South");
					current.addNeighboringRoom(map[mod(i-1,N)][j], "West");
					current.addDescription("You are in a very uniform looking place in the woods. All around you is dense forest.");
					
					if(r.nextDouble()<0.5) {
						current.listOfObjects.add(new Monster(current));
					}
					
					if(r.nextDouble()<0.2) {
						//current.listOfObjects.add(new Item());
					}
					
					isRunning = game -> {
						int monsterCount = 0;
						for(Room room : this.roomList){
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
		
		public void setSeed(long seed) {
			this.seed = seed;
		}

		public Game build() {
			Game g = new Game(localPlayer, startingRoom);
			
			if(this.isRunning!=null) g.isRunning = this.isRunning;
			g.roomList = this.roomList;
			
			return g;
		}
	}
}
