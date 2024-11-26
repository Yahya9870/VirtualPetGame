# VirtualPetGame

Here's a detailed report of your code's functionality and the flow of the game system, covering each method and its role:

---

## **Report on Virtual Pet Game System Functionality**

### **Overview**
The Virtual Pet Game System is a menu-based simulation that allows players to manage virtual pets. The system includes functionality for creating pets, feeding them, playing with them, letting them rest, and earning food through mini-games. The game ends when all pets are starving, and the player runs out of food.

---

### **1. Game Flow**
The game is managed by the `GameManager` class, which orchestrates the interactions between the player, pets, and mini-games. The flow includes:
1. Initialization of the player through the `GameManager` constructor.
2. Repeatedly displaying a menu for the player to choose actions until the game ends.
3. Updating pet statuses and checking for game-over conditions after each action.

---

### **2. Key Classes and Methods**

#### **2.1 `GameManager` Class**
The `GameManager` class is the core of the game, responsible for managing the game loop, player actions, and system updates.

##### **2.1.1 Constructor**
- **`GameManager(String playerName)`**
    - Initializes the player with the provided name.
    - Sets the turn counter to 0.

##### **2.1.2 Main Game Loop**
- **`startGame()`**
    - Displays a menu with options for player actions.
    - Accepts and validates user input for menu choices.
    - Calls appropriate methods based on the player's choice.
    - Increments the turn counter for each valid action (excluding mini-games).
    - Updates all pets’ statuses and checks for game-over conditions after each action.

##### **2.1.3 Menu Options**
Each menu option corresponds to a specific method:

1. **Create a Pet**:
    - **Method**: `createPet()`
    - **Functionality**:
        - Prompts the player to enter a pet name.
        - Creates a new `Pet` instance and adds it to the player’s list of pets.
        - Displays a confirmation message.
    - **Example Flow**:
      ```
      Enter pet name: Fluffy
      Fluffy has been added as your pet!
      ```

2. **Feed a Pet**:
    - **Method**: `feedPet()`
    - **Functionality**:
        - Displays a list of all pets owned by the player with indices.
        - Prompts the player to select a pet to feed by index.
        - Validates the selection and feeds the selected pet using the `Player.feedPet(index)` method.
        - Handles invalid inputs (e.g., out-of-range or non-numeric).
    - **Example Flow**:
      ```
      --- Your Pets ---
      1. Fluffy
      2. Buddy
      Select a pet to feed (index): 1
      You fed Fluffy.
      ```

3. **Play with a Pet**:
    - **Method**: `playWithPet()`
    - **Functionality**:
        - Displays a list of pets.
        - Allows the player to select a pet to play with.
        - Calls the `Pet.play()` method for the selected pet.
        - Updates the pet's happiness and energy levels.
    - **Example Flow**:
      ```
      Select a pet to play with (index): 2
      You played with Buddy!
      ```

4. **Let a Pet Rest**:
    - **Method**: `letPetRest()`
    - **Functionality**:
        - Displays a list of pets.
        - Allows the player to select a pet to rest.
        - Calls the `Pet.rest()` method for the selected pet.
        - Updates the pet's energy and hunger levels.
    - **Example Flow**:
      ```
      Select a pet to let rest (index): 1
      Fluffy is now well-rested!
      ```

5. **Play a Mini-Game**:
    - **Method**: `playMiniGame()`
    - **Functionality**:
        - Displays mini-game options:
            1. Number Guessing Game
            2. Word Scramble Game
        - Prompts the player to select a mini-game.
        - Executes the selected mini-game’s logic.
        - Rewards the player with food based on performance.
    - **Example Flow**:
      ```
      Choose a mini-game:
      1. Number Guessing Game
      2. Word Scramble Game
      Enter your choice: 1
      Correct! You found the number in 3 attempts.
      You earned 5 food!
      ```

6. **Display Player and Pet Status**:
    - **Method**: `player.displayStatus()`
    - **Functionality**:
        - Displays the player's name, food supply, and number of pets.
        - Shows the status of each pet, including happiness, energy, and hunger levels.
    - **Example Flow**:
      ```
      --- Player Status ---
      Name: John
      Food Supply: 47
      Number of Pets: 2
      Pet 1: Fluffy - Happiness: 88, Energy: 90, Hunger: 20
      Pet 2: Buddy - Happiness: 97, Energy: 94, Hunger: 5
      ```

7. **Exit the Game**:
    - **Functionality**:
        - Ends the game loop and displays a farewell message.

##### **2.1.4 Helper Methods**
1. **`displayPets()`**:
    - Displays a numbered list of all pets owned by the player.
    - Used in multiple menu options (e.g., feeding, playing, resting).

2. **`updatePets()`**:
    - Updates the status of all pets by calling their `updateStatus()` method.

3. **`checkGameOver()`**:
    - Checks if the player has run out of food and all pets are starving.
    - Ends the game if both conditions are met.

---

#### **2.2 `Player` Class**
The `Player` class manages player-specific information and actions.

- **Fields**:
    - `name`: The player’s name.
    - `foodSupply`: The player's remaining food supply (initially 50).
    - `pets`: A list of `Pet` objects owned by the player.

- **Methods**:
    1. `addPet(Pet pet)`: Adds a new pet to the player’s list.
    2. `feedPet(int index)`: Feeds the pet at the specified index and decrements the food supply.
    3. `earnFood(int amount)`: Increases the food supply by the given amount.
    4. `displayStatus()`: Displays the player's name, food supply, and the status of all pets.

---

#### **2.3 `Pet` Class**
The `Pet` class represents individual pets with attributes and actions.

- **Fields**:
    - `name`: The pet's name.
    - `happiness`, `hunger`, `energy`: Attributes representing the pet’s current state.

- **Methods**:
    1. `play()`: Increases happiness, decreases energy and hunger.
    2. `feed()`: Decreases hunger, increases happiness.
    3. `rest()`: Increases energy, slightly increases hunger.
    4. `updateStatus()`: Decreases happiness and energy, increases hunger over time.

---

#### **2.4 Mini-Game Classes**
1. **`NumberGuessingGame`**:
    - Generates a random number between 1 and 100.
    - Allows the player 7 attempts to guess the number.
    - Rewards food based on attempts used.

2. **`WordScrambleGame`**:
    - Selects and scrambles a random word from a predefined list.
    - Allows the player 3 attempts to unscramble the word.
    - Rewards food based on attempts used.

---

### **3. System Flow**
1. The game starts by creating a `GameManager` instance with the player's name.
2. The menu is displayed repeatedly, and the player chooses actions.
3. Actions modify the game state (e.g., pet attributes, food supply) and progress the game.
4. The game ends when the player runs out of food and all pets are starving.

---

### **Conclusion**
The Virtual Pet Game System is fully functional, with modular methods for creating pets, interacting with them, and playing mini-games. The `GameManager` class successfully coordinates player actions and game flow. The code is robust, handles errors gracefully, and provides a user-friendly experience. 🚀
