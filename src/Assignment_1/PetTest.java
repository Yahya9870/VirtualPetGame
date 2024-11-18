package Assignment_1;

import java.util.Scanner;

public class PetTest {
    public static void main(String[] args) {
        Assignment_1.Pet firstPet = new Assignment_1.Pet();

        while (firstPet.getHunger() < 100) {
            firstPet.play();
            firstPet.updateStatus();
            firstPet.getStatus("");
        }
        System.out.println("First Pet with id " + firstPet.getId() + " just died! *cry*");

        Scanner petAlive = new Scanner(System.in);

        System.out.println("Please enter the name of the pet: ");
        String name = petAlive.nextLine();
        petAlive.close();

        Assignment_1.Pet secondPet = new Assignment_1.Pet(name);
        System.out.println("Let's treat " + name + " with the ID Number " + secondPet.getId() + " well.");

        for (int rounds = 0; rounds < 10; rounds++) {
            System.out.println();
            System.out.println("Lets start the day with feeding our little friend!");
            secondPet.feed();
            System.out.println();
            System.out.println("Lets go on with playing a bit with " + name);
            secondPet.play();
            System.out.println();
            System.out.println("Lets end the day with letting " + name + " rest. See you tomorrow my friend!");
            secondPet.rest();
            secondPet.updateStatus();
            secondPet.getStatus(secondPet.getName());
        }
    }
}