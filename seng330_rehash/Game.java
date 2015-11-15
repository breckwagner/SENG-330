



public class Game {
    public Player player = new Player();

    public Game() {

    }

    public Game(long seed) {

    }


    public boolean isRunning() {
        return (player.health > 0);
    }
}
