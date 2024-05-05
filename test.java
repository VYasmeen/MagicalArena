import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class MagicalArenaTest {

    @Test
    public void testPlayerHealthDecreaseAfterAttack() {
        Player player = new Player(50, 5, 10);
        assertEquals(50, player.health);

        player.health -= 20; 
        assertEquals(30, player.health);
    }

    @Test
    public void testPlayerDiesWhenHealthZero() {
        Player player = new Player(50, 5, 10);
        assertFalse(player.health <= 0);

        player.health = 0; // Simulate health becoming 0
        assertTrue(player.health <= 0);
    }

    @Test
    public void testIsBothAlive() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(player1, player2);
        assertTrue(arena.isBothAlive());

        player1.health = 0; 
        assertFalse(arena.isBothAlive());
    }

    @Test
    public void testRollDice() {
        Player player = new Player(50, 5, 10);
        Random rand = new Random();
        player.rollDice(rand);
        assertTrue(player.dice >= 1 && player.dice <= 6);
    }

    @Test
    public void testFight() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(player1, player2);

        // Simulate a fight
        Random rand = new Random();
        while (arena.isBothAlive()) {
            arena.rollDices(rand);
            arena.fight();
        }

        assertTrue(player1.health <= 0 || player2.health <= 0);
    }

    @Test
    public void testResult() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(player1, player2);

        // Simulate a fight
        Random rand = new Random();
        while (arena.isBothAlive()) {
            arena.rollDices(rand);
            arena.fight();
        }

        String result = arena.result();
        assertTrue(result.equals("Player 1 won the game!") || result.equals("Player 2 won the game!"));
    }
}
