
import java.util.Scanner;

/**
 * This class is just to test
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
		
		listOfRooms[0].printListObjectsInRoom("","",",");
		
		
		Scanner input = new Scanner(System.in);
		String in;
		System.out.println();
		while (true) {
			in=input.next();
			switch (in) {
				case "help":
					System.out.println("Here is your help");
					break;
				case "x":
					System.out.println("Here is your help");
					break;
				default:
					break;
			}
		}
	}
}



