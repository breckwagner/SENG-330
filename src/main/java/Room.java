


import java.util.ArrayList;
import java.util.List;

/**
 * Room is the class representation of any space in the game.
 * A Room object encapsulates the state information needed
 * for the various configurations of of games.
 *
 * 	@author Richard B. Wagner
 *	@author Mook Tungs
 *	@author Zac Broitman
 *	@author Greg Bacic
 *
 */
public class Room implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4762785916008141738L;
	List<GameObject> listOfObjects = new ArrayList<GameObject>();
	ArrayList<Room> neighboringRooms = new ArrayList<Room>();
	public ArrayList<String> geo = new ArrayList<String>();
	private String description = "";


	/**
	 * Default constructor. (For invocation by subclass
	 * constructors, typically implicit.)
	 */
    public Room() {}
    

	/**
	 * Constructor
	 */
	public Room(ArrayList<Room> neighboringRooms) {
		this.neighboringRooms = neighboringRooms;
	}

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

	/**
	 * Prints a list of the GameObject in a room.
	 * @param prefix a String to prepend at the beginning the output
	 * @param postfix a String to append at the end of the output
	 * @param delimiter a string to insert in between each element in the list
	 */
    public void listObjectsInRoom() {
        for (GameObject object : listOfObjects) {
        	System.out.println(object + ", ");
        }
    }

	/**
	 * For each GameObject in the room, call that objects action method. For
	 * items, this will be an empty call.
	 */
	public void initiateEvents(Player p) {
		for (GameObject object : listOfObjects) {
			if(!(object instanceof Player)) {
				object.action(p);
			}
		}
	}
	
	public void addNeighboringRoom(Room room, String g) {
		neighboringRooms.add(room);
		geo.add(g);
	}
	
	public void addDescription(String description){
		this.description = description;
	}
	
	@Override
	public String toString(){
		StringBuilder output = new StringBuilder();
		output.append(description);
		
		if(!this.listOfObjects.isEmpty()) {
			output.append("\n");
			output.append("In the room with you " + ((listOfObjects.size()==1)?"is a":"are"));
			for(GameObject obj : listOfObjects) {
				//if(obj instanceof Actor) {
					output.append(obj);
				//}
			}
		}
		
		return output.toString();
	}
	
	public String getDirections() {
		return geo.toString();
	}
	
}
