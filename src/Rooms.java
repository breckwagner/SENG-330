import java.util.Random;

public class Room extends game {


	public Boolean HasItem;

	public Integer Trap;

	public Boolean HasMonster;

	public Room ConnectingRoom1;

	public Room ConnectingRoom2;

	public Room PreviousRoom;

	public Room(){
		Random rand = new Random();

		Trap = rand.nextInt(99);

		if(rand.nextInt(1)>0){
			HasMonster = True;
		} else{
			HasMonster = False;
		}

		if(rand.nextInt(1)>0){
			HasBoolean = True;
		} else{
			HasBoolean = False;
		}
		/* For the two if statements I made it so that rather than the room holding an item and a monster it
		instead simply holds flags for if a monster encounter should be brought up and if a discover item event
		should occur. When the player enters a room the game will first check to see if that room should hold a
		monster, then after monster is dealt with (defeating it if it exist) then it will check for if the room
		holds an item.*/

		ConnectingRoom1 = new Room();
		ConnectingRoom2 = new Room();
	}
}
