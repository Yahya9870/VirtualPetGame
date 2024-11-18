package Assignment_2;

public class GameLauncher {
    public static void main(String[] args) {
        System.out.println("Welcome to the Virtual Pet Game System!");
        System.out.println("Please enter your player name:");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String playerName = scanner.nextLine();

        GameManager gameManager = new GameManager(playerName);
        gameManager.startGame();
    }
}
