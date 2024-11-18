package Assignment_2;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static int play() {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int attempts = 7;

        System.out.println("\n--- Number Guessing Game ---");
        System.out.println("Guess the number (1-100):");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            int guess = scanner.nextInt();

            if (guess == target) {
                System.out.println("Correct! You found the number in " + i + " attempts.");
                return 7 - i + 1;
            } else if (guess < target) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("Out of attempts! The number was " + target + ".");
        return 0;
    }
}
