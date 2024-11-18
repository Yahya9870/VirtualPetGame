package Assignment_2;

import Assignment_1.Pet;

import java.util.Scanner;

public class GameManager {
    private Player player;
    private int turn;

    public GameManager(String playerName) {
        this.player = new Player(playerName);
        this.turn = 0;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("\n--- Game Menu ---");
                System.out.println("1. Create a new pet");
                System.out.println("2. Feed a pet");
                System.out.println("3. Play with a pet");
                System.out.println("4. Let a pet rest");
                System.out.println("5. Play a mini-game");
                System.out.println("6. Display status");
                System.out.println("7. Exit game");

                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> createPet();
                    case 2 -> feedPet();
                    case 3 -> playWithPet();
                    case 4 -> letPetRest();
                    case 5 -> playMiniGame();
                    case 6 -> player.displayStatus();
                    case 7 -> {
                        System.out.println("Exiting the game. Thank you for playing!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }

                if (choice != 5 && choice >= 1 && choice <= 6) {
                    turn++;
                    updatePets();
                    checkGameOver();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        System.out.println("Game Over! You survived " + turn + " turns.");
    }

    private void createPet() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pet name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Pet name cannot be empty. Try again.");
            return;
        }
        Pet newPet = new Pet(name);
        player.addPet(newPet);
        System.out.println(name + " has been added as your pet!");
    }

    private void feedPet() {
        if (player.getPets().isEmpty()) {
            System.out.println("No pets available to feed.");
            return;
        }

        displayPets();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Select a pet to feed (index): ");
                int index = scanner.nextInt() - 1;
                player.feedPet(index);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid selection. Please select a valid pet index.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private void playWithPet() {
        System.out.println("Playing with a pet... (Implement play logic here)");
    }

    private void letPetRest() {
        System.out.println("Letting a pet rest... (Implement rest logic here)");
    }

    private void playMiniGame() {
        System.out.println("Choose a mini-game:");
        System.out.println("1. Number Guessing Game");
        System.out.println("2. Word Scramble Game");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                int reward = switch (choice) {
                    case 1 -> NumberGuessingGame.play();
                    case 2 -> WordScrambleGame.play();
                    default -> {
                        System.out.println("Invalid choice. Please select 1 or 2.");
                        yield 0;
                    }
                };

                if (reward > 0) {
                    player.earnFood(reward);
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private void displayPets() {
        for (int i = 0; i < player.getPets().size(); i++) {
            System.out.println((i + 1) + ". " + player.getPets().get(i).getName());
        }
    }

    private void updatePets() {
        for (Pet pet : player.getPets()) {
            pet.updateStatus();
        }
    }

    private void checkGameOver() {
        boolean allPetsStarving = player.getPets().stream().allMatch(p -> p.getHunger() > 80);
        if (player.getFoodSupply() <= 0 && allPetsStarving) {
            System.out.println("Game over! All pets are starving and you have no food left.");
            System.exit(0);
        }
    }
}
