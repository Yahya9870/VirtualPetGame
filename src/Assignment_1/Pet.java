package Assignment_1;

public class Pet {
    private static int nextId = 0;
    private static final int maxValue = 100;
    private static final int minValue = 0;

    private final int id;
    private String name;
    private int happiness;
    private int hunger;
    private int energy;

    public Pet() {
        this.id = getNextId();
        this.happiness = maxValue;
        this.hunger = minValue;
        this.energy = maxValue;
    }
    public Pet(String name) {
        this.name = name;
        this.id = getNextId();
        this.happiness = maxValue;
        this.hunger = minValue;
        this.energy = maxValue;
    }
    private static int getNextId() {
        return nextId++;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.isEmpty()) this.name = name;
    }
    public int getHappiness() {
        return happiness;
    }
    private void setHappiness(int happiness) {
        this.happiness = happiness;
        if (happiness > maxValue){
            this.happiness = maxValue;
        }
        else if (happiness < minValue){
            this.happiness = minValue;
        }
        if (this.happiness == maxValue) {
            System.out.println("I'm very happy");
        } else if (this.happiness > 75) {
            System.out.println("I'm happy");
        } else if (this.happiness > 50) {
            System.out.println("I'm a little happy");
        } else if (this.happiness > 25) {
            System.out.println("I'm a little sad");
        } else if (this.happiness > minValue) {
            System.out.println("I'm sad");
        } else if (this.happiness == minValue) {
            System.out.println("I'm very sad");
        } else {
            System.out.println("No happiness level");
        }
    }
    public int getHunger() {
        return hunger;
    }
    private void setHunger(int hunger) {
        this.hunger = hunger;
        if (hunger > maxValue){
            this.hunger = maxValue;
        }
        else if (hunger < minValue){
            this.hunger = minValue;
        }
        if (this.hunger == maxValue) {
            System.out.println("I'm starving");
        } else if (this.hunger > 75) {
            System.out.println("I'm very hungry");
        } else if (this.hunger > 50) {
            System.out.println("I'm is hungry");
        } else if (this.hunger > 25) {
            System.out.println("I'm little hungry");
        } else if (this.hunger > minValue) {
            System.out.println("I'm fine");
        } else if (this.hunger == minValue) {
            System.out.println("I'm full");
        } else {
            System.out.println("No hunger level");
        }
    }
    public int getEnergy() {
        return energy;
    }
    private void setEnergy(int energy) {
        this.energy = energy;
        if (energy > maxValue){
            this.energy = maxValue;
        }
        else if (energy < minValue){
            this.energy = minValue;
        }
        if (this.energy == maxValue) {
            System.out.println("I'm full of energy");
        } else if (this.energy > 75) {
            System.out.println("I'm very energized");
        } else if (this.energy > 50) {
            System.out.println("I'm energized");
        } else if (this.energy > 25) {
            System.out.println("I'm a little energized");
        } else if (this.energy > minValue) {
            System.out.println("I'm a little tired");
        } else if (this.energy == minValue) {
            System.out.println("I'm out of energy");
        } else {
            System.out.println("No energy level");
        }
    }
    public void updateStatus() {
        setHappiness(happiness -= 3);
        setHunger(hunger += 5);
        setEnergy(energy -= 2);
    }
    public void feed() {
        setHappiness(happiness += 10);
        setHunger(hunger -= 20);
    }
    public void play() {
        setHappiness(happiness += 15);
        setHunger(hunger += 10);
        setEnergy(energy -= 15);
    }
    public void rest () {
        setHunger(hunger += 5);
        setEnergy(energy += 20);
    }
    public void getStatus(String name) {
        if(!name.isEmpty()) {
            System.out.println();
            System.out.println("The name of the Pet is: " + name + " Happiness level: " + happiness +
                    " Energy level: " + energy + " Hunger level: " + hunger);
        }else{
            System.out.println("This pet's happiness level: " + happiness +
                    " Energy level: " + energy + " Hunger level: " + hunger);
        }
    }
}