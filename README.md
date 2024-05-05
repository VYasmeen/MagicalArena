# Magical Arena Game

Welcome to the Magical Arena! This project simulates a combat arena where two players engage in a turn-based battle. Each player has health, strength, and attack attributes. The game determines the winner based on a dice-based combat system.

## How It Works

- **Players**: There are two players in the arena, each with a unique set of attributes (health, strength, attack).
- **Combat**: Players attack in turns. An attacking player rolls a dice to determine the attack damage, while the defending player rolls a dice to determine defense. The defender's health is reduced by the difference between the attack damage and the defense value.
- **End Condition**: The game ends when one player's health drops to or below zero. The player with remaining health is declared the winner.

## Classes

- **Player**: Represents a player in the arena. Each player has health, strength, attack, and dice attributes. Methods include `rollDice` (to simulate a dice roll) and `fight`.
- **MagicalArena**: Represents the arena where the battle takes place. It has methods for checking if both players are alive, rolling the dice for each player, and executing the fight logic.
- **Main**: Entry point for the program. This class sets up players, initializes the arena, and starts the fight.

## Running the Code

1. **Prerequisites**: Ensure you have Java Development Kit (JDK) installed on your system.
2. **Compilation**: Compile the code with `javac Main.java`.
3. **Execution**: Run the code with `java Main`.
4. **Output**: The program will output the result of the battle, indicating which player won the game.

## Sample Output
Player 2 won the game!

