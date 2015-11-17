import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCases{
	Player player = new Player();
	
	//Test player's default health
	@Test
	public void testPlayerHealth(){
		assertEquals(100, player.health);
	}
}