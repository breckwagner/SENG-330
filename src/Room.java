import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * Room is the class representation of any space in the game.
 * A Room object encapsulates the state information needed
 * for the various configurations of of games.
 *
 * @author      Richard B. Wagner
 */
public class Room {
	ArrayList<GameObject> listOfObjects = new ArrayList<GameObject>();
	ArrayList<Room> neighboringRooms = new ArrayList<Room>();


	/**
	 * Default constructor. (For invocation by subclass
	 * constructors, typically implicit.)
	 */
    public Room() {}


	/**
     * Prints a list of the GameObject in a room.
	 * @param prefix a String to prepend at the beginning the output
	 * @param postfix a String to append at the end of the output
	 * @param delimiter a string to insert in between each element in the list
     */
	private String joinWith(String prefix, String postfix, String delimiter, List<GameObject> list) {
		StringBuilder output = new StringBuilder(prefix);
		Boolean flag = true;
		for (GameObject object : listOfObjects) {
			output.append((flag)?(object.toString()):(delimiter+object.toString()));
		}
		return output.append(postfix).toString();
	}

	/**
     * Prints a list of the GameObject in a room.
	 * @param prefix a String to prepend at the beginning the output
	 * @param postfix a String to append at the end of the output
	 * @param delimiter a string to insert in between each element in the list
     */
	public void printListObjectsInRoom(String prefix, String postfix, String delimiter) {
		System.out.println(joinWith(prefix, postfix, delimiter, this.listOfObjects));
	}

    public void listObjectsInRoom() {
        for (GameObject object : listOfObjects) {
        	System.out.println(object + ", ");
        }
    }
}
