import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;
import java.util.ArrayList;

public class TestCases{
	Player player = new Player();
	Room room1 = new Room();
	List<Room> listRoom = new ArrayList<Room>();
	Monster monster = new Monster(room1);
	
	//Test Player's usePotion()
	@Test
	public void testUsePotion(){
		player.potion++;
		player.usePotion();
		assertEquals(120, player.health);
		assertEquals(0, player.potion);
	}
	@Test
	//Test Player's receiveDamage()
	public void testPlayerReceiveDamage()
	{
		player.receiveDamage(monster);
		assertEquals(90, player.health);
	}
	//Test Monster's receiveDamage()
	@Test
	public void testMonsterReceiveDamage(){
		monster.receiveDamage(player);
		assertEquals(10, monster.health);
	}
	//Test Room's neighbor list
	@Test
	public void testRoomNeighbor(){
		listRoom.add(room1);
		Room room2 = new Room(listRoom);
		listRoom.add(room2);
		Room room3 = new Room(room2.neighboringRooms);
		listRoom.add(room3);
		assertEquals(listRoom.size(), room3.neighboringRooms.size());
	}
}