import java.util.LinkedList;
import java.util.ArrayList;


public class Room {
	ArrayList<GameObject> listOfObjects = new ArrayList<GameObject>();
	ArrayList<Room> neighboringRooms = new ArrayList<Room>();
    
    public Room() {
    	
    }

    public void listObjectsInRoom() {

        for (GameObject object : listOfObjects) {
        	System.out.println(object + ", ");
        }
    }
}
