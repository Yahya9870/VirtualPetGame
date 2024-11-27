package Assignment_1;

public class Pet {
    private static int nextId = 0;
    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    private final int id;
    private String name;
    private int happiness;
    private int hunger;
    private int energy;

    // Constructors
    public Pet() {
        this.id = getNextId();
        this.happiness = MAX_VALUE;
        this.hunger = MIN_VALUE;
        this.energy = MAX_VALUE;
    }

    public Pet(String name) {
        this.name = name;
        this.id = getNextId();
        this.happiness = MAX_VALUE;
        this.hunger = MIN_VALUE;
        this.energy = MAX_VALUE;
    }

    private static int getNextId() {
        return nextId++;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    // Setters (without printing to avoid duplicate messages)
    private void setHappiness(int happiness) {
        this.happiness = Math.max(MIN_VALUE, Math.min(happiness, MAX_VALUE));
    }

    private void setHunger(int hunger) {
        this.hunger = Math.max(MIN_VALUE, Math.min(hunger, MAX_VALUE));
    }

    private void setEnergy(int energy) {
        this.energy = Math.max(MIN_VALUE, Math.min(energy, MAX_VALUE));
    }

    // Status Updates
    public void updateStatus() {
        setHappiness(happiness - 3);
        setHunger(hunger + 5);
        setEnergy(energy - 2);
    }

    // Actions
    public void feed() {
        setHappiness(happiness + 10);
        setHunger(hunger - 20);
    }

    public void play() {
        setHappiness(happiness + 15);
        setHunger(hunger + 10);
        setEnergy(energy - 15);
    }

    public void rest() {
        setHunger(hunger + 5);
        setEnergy(energy + 20);
    }

    // Centralized Status Display
    public void getStatus(String name) {
        System.out.println("\n--- Pet Status ---");
        System.out.println("Name: " + (name.isEmpty() ? "Unnamed Pet" : name));
        System.out.println("Happiness: " + happiness);
        System.out.println("Hunger: " + hunger);
        System.out.println("Energy: " + energy);

        // Happiness Description
        if (happiness == MAX_VALUE) {
            System.out.println("I'm very happy!");
        } else if (happiness > 75) {
            System.out.println("I'm happy.");
        } else if (happiness > 50) {
            System.out.println("I'm a little happy.");
        } else if (happiness > 25) {
            System.out.println("I'm a little sad.");
        } else {
            System.out.println("I'm very sad.");
        }

        // Hunger Description
        if (hunger == MAX_VALUE) {
            System.out.println("I'm starving!");
        } else if (hunger > 75) {
            System.out.println("I'm very hungry.");
        } else if (hunger > 50) {
            System.out.println("I'm hungry.");
        } else if (hunger > 25) {
            System.out.println("I'm fine.");
        } else {
            System.out.println("I'm full.");
        }

        // Energy Description
        if (energy == MAX_VALUE) {
            System.out.println("I'm full of energy!");
        } else if (energy > 75) {
            System.out.println("I'm very energized.");
        } else if (energy > 50) {
            System.out.println("I'm energized.");
        } else if (energy > 25) {
            System.out.println("I'm a little tired.");
        } else {
            System.out.println("I'm out of energy.");
        }
    }
}
