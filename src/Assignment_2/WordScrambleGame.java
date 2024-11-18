package Assignment_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class WordScrambleGame {
    private static final String[] WORDS = {"dog", "cat", "rabbit", "fish", "hamster", "parrot", "lizard"};

    public static int play() {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        String scrambledWord = scrambleWord(word);

        System.out.println("\n--- Word Scramble Game ---");
        System.out.println("Unscramble this word: " + scrambledWord);

        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            String guess = scanner.nextLine();

            if (guess.equalsIgnoreCase(word)) {
                System.out.println("Correct! You unscrambled the word in " + i + " attempts.");
                return 4 - i; // Rewards decrease with attempts
            }
        }

        System.out.println("No more attempts. The word was " + word + ".");
        return 0;
    }

    private static String scrambleWord(String word) {
        ArrayList<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }
        Collections.shuffle(chars);
        StringBuilder scrambled = new StringBuilder();
        for (char c : chars) {
            scrambled.append(c);
        }
        return scrambled.toString();
    }
}
