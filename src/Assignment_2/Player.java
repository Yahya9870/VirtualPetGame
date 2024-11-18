package Assignment_2;

import Assignment_1.Pet;
import java.util.ArrayList;

public class Player {
    private String name;
    private int foodSupply;
    private ArrayList<Pet> pets;

    public Player(String name) {
        this.name = name;
        this.foodSupply = 50; // Initial food supply
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getFoodSupply() {
        return foodSupply;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void feedPet(int petIndex) {
        if (petIndex >= 0 && petIndex < pets.size()) {
            if (foodSupply > 0) {
                pets.get(petIndex).feed();
                foodSupply--;
                System.out.println("You fed " + pets.get(petIndex).getName() + ".");
            } else {
                System.out.println("Not enough food to feed your pet!");
            }
        } else {
            System.out.println("Invalid pet selection.");
        }
    }

    public void earnFood(int amount) {
        foodSupply += amount;
        System.out.println("You earned " + amount + " food!");
    }

    public void displayStatus() {
        System.out.println("\n--- Player Status ---");
        System.out.println("Name: " + name);
        System.out.println("Food Supply: " + foodSupply);
        System.out.println("Number of Pets: " + pets.size());
        for (int i = 0; i < pets.size(); i++) {
            System.out.print("Pet " + (i + 1) + ": ");
            pets.get(i).getStatus(pets.get(i).getName());
        }
    }
}
