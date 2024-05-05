import java.util.Random;

class Player
{
    int health, strength, attack, dice = 0;

    Player(int hp, int str, int atk)
    {
        health = hp;
        strength = str;
        attack = atk;
    }

    void rollDice(Random rand)
    {
        dice = rand.nextInt(6) + 1;
    }
}

class MagicalArena
{
    Player player1, player2;

    MagicalArena(Player input1, Player input2)
    {
        player1 = input1;
        player2 = input2;
    }

    boolean isBothAlive()
    {
        return player1.health > 0 && player2.health > 0;
    }

    void rollDices(Random rand)
    {
        player1.rollDice(rand);
        player2.rollDice(rand);
    }

    void fight()
    {
        Random rand = new Random();
        boolean turn = player1.health < player2.health;
        int damaged, defended, loss;
        while (isBothAlive())
        {
            rollDices(rand);
            if (turn)
            {
                damaged = player1.attack * player1.dice;
                defended = player2.strength * player2.dice;
                loss = damaged - defended;
                if (loss < 0)
                {
                    loss = 0;
                }
                player2.health -= loss;
            }
            else
            {
                damaged = player2.attack * player2.dice;
                defended = player1.strength * player1.dice;
                loss = damaged - defended;
                if (loss < 0)
                {
                    loss = 0;
                }
                player1.health -= loss;
            }
            turn = !turn;
        }
    }

    String result()
    {
        return (player1.health > 0 ? "Player 1 won the game!" : "Player 2 won the game!");
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        Player Elsa = new Player(50, 5, 10);
        Player Akbar = new Player(100, 10, 5);
        MagicalArena arena = new MagicalArena(Elsa, Akbar);
        arena.fight();
        System.out.println(arena.result());
    }
}
