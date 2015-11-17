/**
 * 
 */

/**
 * @author breckwagner
 *
 */
public class TestBed1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Room[] listOfRooms = new Room[20];
		for(int i = 0; i < listOfRooms.length; i++){
			System.out.println("Added Room: "+i);
			listOfRooms[i] = new Room();
			if(i>0) listOfRooms[i].neighboringRooms.add(listOfRooms[i-1]);
		}

	}

}
