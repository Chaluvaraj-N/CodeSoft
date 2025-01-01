import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;  // Total rounds played
        int roundsWon = 0;    // Rounds won by the player
        boolean playAgain = true;

        while (playAgain) {
            int maxAttempts = 10;  // Limit the number of attempts per round
            int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;      // Number of attempts in the current round
            boolean guessedCorrectly = false;

            System.out.println("A new round begins! Guess the number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Round logic
            while (attempts < maxAttempts && !guessedCorrectly) {
                attempts++;
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the correct number.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                // If the player runs out of attempts
                if (attempts == maxAttempts && !guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
                }
            }

            // Update rounds won count
            if (guessedCorrectly) {
                roundsWon++;
            }

            totalRounds++;
            
            // Ask if the user wants to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        // Final score display
        System.out.println("Game Over! You played " + totalRounds + " rounds and won " + roundsWon + " rounds.");
        scanner.close();
    }
}
