import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCases{
	Player player = new Player();
	Room room = new Room();
	Monster monster = new Monster(room);
	
	//Test player's constructor
	@Test
	public void testPlayerConstructor(){
		assertEquals(100, player.health);
		assertEquals(10, player.attack);
		assertEquals(0, player.potion);
	}
	
	//Test player's usePotion()
	@Test
	public void testUsePotion(){
		player.potion++;
		player.usePotion();
		assertEquals(120, player.health);
		assertEquals(0, player.potion);
	}
	
}