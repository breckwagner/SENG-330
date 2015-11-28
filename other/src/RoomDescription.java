import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Collections;

public class RoomDescription{
	int numDescription = 35;
	String[] description = new String[numDescription];
	LinkedList<Integer> randomIntList = new LinkedList<Integer>();
	
	public RoomDescription(){
		try{
			Scanner s = new Scanner(new File("RoomDescription.txt"));
			int i = 0;
			while(s.hasNextLine()){
				description[i] = s.nextLine();
				i++;
			}
		} catch(FileNotFoundException e){
			System.out.println("Error: RoomDescription.txt is not found");
		}
		randomInt();
	}
	
	public String getDescription(){
		if(randomIntList.isEmpty()){
			randomInt();
		}
		int x = randomIntList.remove();
		return description[x];
	}
	
	public void randomInt(){
		for(int i = 0; i < numDescription; i++){
			randomIntList.add(i);
		}
		Collections.shuffle(randomIntList);
	}
}