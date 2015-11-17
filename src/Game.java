

public class Game {
    public Player player = new Player();
    public int currentRooms;
    public int maxRooms;

    public Game() {
    	currentRooms = 0;
    	maxRooms = 15;

    }

    public Game(int endRooms){
    	maxRooms = endRooms;
    }

    /*
    public Game(long seed) {

    }
    */


    public boolean isRunning() {
    	if(player.health > 0 && currentRooms <= maxRooms){
    		return true;
    	} 
    }
}
