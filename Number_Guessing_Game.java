import java.util.Random;
import java.util.Scanner;

public class Number_Guessing_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int totalScore = 0;
        int maxRounds = 3;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have up to " + maxRounds + " rounds to play.");

        for (int round = 1; round <= maxRounds; round++) {
            int guessNum = rand.nextInt(100) + 1;
            int attempts = 5;
            boolean guessed = false;
            int score = 0;
            System.out.println("\n--- Round " + round + " ---");
            System.out.println("Guess the number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it!");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts--;
                if (userGuess == guessNum) {
                    System.out.println("Correct! You guessed the number.");
                    score = 10; // Score for correct guess
                    guessed = true;
                    break;
                } 
                else if (userGuess > guessNum) {
                    System.out.println("Too high! Attempts left: " + attempts);
                } 
                else {
                    System.out.println("Too low! Attempts left: " + attempts);
                }
            }

            if (!guessed) {
                System.out.println("You've used all attempts. The correct number was " + guessNum);
            }

            totalScore += score;
            System.out.println("Score for this round: " + score);
            System.out.println("Total score so far: " + totalScore);
            if (round < maxRounds) {
                System.out.print("\nDo you want to go to the next round? (yes/no): ");
                String response = sc.next();
                if (!response.equalsIgnoreCase("yes")) {
                    break;  // Exit the loop early if user doesn't want to continue
                }
            }
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        if(totalScore==0){
            System.out.println("Better luck next time!");
        }
        else if(totalScore==10){
            System.out.println("Good try! Keep practicing.");
        }
        else if (totalScore==20) {
            System.out.println("Very good! You are great at guessing.");
        }
        else{
            System.out.println("Excellent! Perfect guessing skills.");
        }
        sc.close();
    }
}
