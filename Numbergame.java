import java.util.Scanner;
import java.util.Random;
public class Numbergame {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5;
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Can you guess it?");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < attemptsLimit && !guessedCorrectly) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + "/" + attemptsLimit + "): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < minRange || userGuess > maxRange) {
                    System.out.println("Your guess is out of range. Please enter a number between " + minRange + " and " + maxRange + ".");
                    continue;
                }
                
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
                
                attempts++;
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }
            
            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}