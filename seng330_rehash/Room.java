import java.util.LinkedList;


public class Room {

    List<GameObject> listOfObjects = LinkedList<GameObject>();

    public void listObjectsInRoom() {

        for (GameObject object : listOfObjects) {
            java.io.print(object + ", ")
        }
    }
}
