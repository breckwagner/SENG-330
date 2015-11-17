/**
* 	Creates a new player object(class constructor) for the game and while game is currently a placeholder
*	for the game obect which will run the game. 
* 	@author Breck Wagner
*	@author Mook Tungs
*	@author Zac Broitman
*	@author Greg Bacic
* 
* 
* 
*/

public class Game {
    public Player player = new Player();
    public int currentRooms;
    public int maxRooms;
    /**
    *  Constructor for the game with static variables.
    */
    public Game() {
    	currentRooms = 0;
    	maxRooms = 15;

    }
    /**
    *   Constructor for Game with set number of end Rooms
    *   @param endRooms sets the last number of rooms before the game will end, with the player beating the game.
    */
    public Game(int endRooms){
    	maxRooms = endRooms;
    }

    /*
    public Game(long seed) {

    }
    */

	/**
 	*	checks the pleayrs health while the game is running.
 	*	@return  boolean denoting wether the player objects health is greater than 0
 	*/
    public boolean isRunning() {
    	if(player.health > 0 && currentRooms <= maxRooms){
    		return true;
    	} 
    }
}
