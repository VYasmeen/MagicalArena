import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerHealthDecreaseAfterAttack() {
        Player player = new Player(50, 5, 10);
        player.receiveAttack(30); // Assuming 30 damage is received
        assertEquals(20, player.getHealth());
    }

    @Test
    public void testPlayerDiesWhenHealthZero() {
        Player player = new Player(50, 5, 10);
        player.receiveAttack(50); // Assuming 50 damage is received
        assertTrue(player.isDead());
    }
}
