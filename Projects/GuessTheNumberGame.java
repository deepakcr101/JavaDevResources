package Projects;

import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String args[]) {
        // The Game generates a random number and Give User Exactly log2(n) chances to
        // guess it correct
        // A Fun way to learn and practice Java Basics
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Upper Limit of the Game: ");
        int upperLimit = sc.nextInt();
        int num = 1 + (int) (upperLimit * Math.random());
        int maxAttempts = (int) (Math.log10(upperLimit) / Math.log10(2)) + 1;
        int attempts = 0;
        while (attempts < maxAttempts) {
            System.out.println("Enter Your Guess: ");
            int guess = sc.nextInt();
            attempts++;
            if (guess == num) {
                System.out.println("Bravo! You Guessed Correct Answer in " + attempts + " Attempts");
                break;
            } else if (guess < num) {
                System.out.println("Wrong Guess! Your Guess is Lower than Expected Number.");
            } else if (guess > num) {
                System.out.println("Wrong Guess! Please Try Lower as Your Guess is Higher than Expected.");
            }

            if (attempts >= maxAttempts) {
                System.out.println("Alas! You Lost The Game Btter Luck Next Time");
                break;
            }
        }

        sc.close();
    }
}
