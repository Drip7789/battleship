package battleship;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board playerBoard;
    private Board computerBoard;
    private Scanner scanner;
    private Random random;

    public Game() {
        playerBoard = new Board(); // creates a new board named playerBoard
        computerBoard = new Board(); // creates a new board for the computer
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public void start() {
        System.out.println("Welcome to Battleship!");
        setupPlayerShips();
        setupComputerShips();
        playGame();
    }

    private void setupPlayerShips() {
        int[] shipLengths = {5, 4, 3, 3, 2}; // Classic battleship ship lengths
        String[] shipNames = {"Carrier (5)", "Battleship (4)", "Cruiser (3)", "Submarine (3)", "Destroyer (2)"};

        // this repeats untill all the ships are placed
        System.out.println("\nPlace your ships:");
        for (int i = 0; i < shipLengths.length; i++) {
            playerBoard.displayBoard(false); // first it displays the player's board
            System.out.println("\nPlacing " + shipNames[i]); // then tells which ship is being placed
            placePlayerShip(new Ship(shipLengths[i])); // calls the method for the player to place ship
            // ^^creates a new ship with a lenght, the lenght of the ship is pulled from every index of shipLenghts
        }
    }

    // called every time player has to place a ship
    private void placePlayerShip(Ship ship) {
        while (true) {

            // gets position and direction input from player
            System.out.println("Enter position and direction (e.g., B3,east): ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(",");
            
            // this checkes if the input format is position,direction because there are 2 values which are position and direction
            if (parts.length != 2) {
                System.out.println("Invalid input format! Use format: position,direction");
                continue;
            }

            try {
                Position pos = new Position(parts[0]); // gets the first index of input which is position and adds it to pos
                String direction = parts[1].trim(); // gets the second index of input which is direction and adds it to direction
                
                // calls placeship, this way the positions this shipo occupies are recorded
                // since placeShip returns true when succesfull, if loop breaks
                //if false is returned the placement is invalid 
                if (playerBoard.placeShip(ship, pos, direction)) {
                    break;
                } else {
                    System.out.println("Invalid placement! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
            }
        }
    }

    // this is called after player placed all of its ships
    private void setupComputerShips() {
        int[] shipLengths = {5, 4, 3, 3, 2}; // these are the ship lenghts for the computer ships
        for (Ship ship : generateShips(shipLengths)) {
            placeComputerShip(ship);
        }
    }

    private Ship[] generateShips(int[] lengths) {
        Ship[] ships = new Ship[lengths.length];
        for (int i = 0; i < lengths.length; i++) {
            ships[i] = new Ship(lengths[i]); // creates all the ships for computers with the lengts
        }
        return ships; // returns the all the generated computer ships and sends them to placeComputerShips method
    }

    private void placeComputerShip(Ship ship) {
        String[] directions = {"north", "south", "east", "west"}; // directions is the array that stores all possible directions
        while (true) {
            int row = random.nextInt(10); //selects random row
            int col = random.nextInt(10); //selects random column
            String direction = directions[random.nextInt(4)]; //selects random direction
            
            // calls method to place ship on computerBoard
            // after the method is executed succesfullt it returns true
            // when method is called, the ship object gets its positions[] values
            if (computerBoard.placeShip(ship, new Position(row, col), direction)) { 
                break;
            }
        }
    }

    private void playGame() {
        while (true) {
            // Player's turn first it displays all the tables
            System.out.println("\nYour board:");
            playerBoard.displayBoard(false);
            System.out.println("\nComputer's board:");
            computerBoard.displayBoard(true);
            
            playerTurn(); // runs the players turn
            // if all ships are destroyed game finishes
            if (computerBoard.areAllShipsDestroyed()) {
                System.out.println("Congratulations! You win!");
                break;
            }

            // Computer's turn
            computerTurn(); // runs the computers turn

            // if all the ships are destroyed game ends
            if (playerBoard.areAllShipsDestroyed()) {
                System.out.println("Game Over! Computer wins!");
                break;
            }
        }
    }

    private void playerTurn() {
        while (true) {
            System.out.println("\nEnter target position (e.g., B3): ");
            try {
                String input = scanner.nextLine().trim();
                Position pos = new Position(input); // turns the string position into numerical and adds to pos
                
                if (computerBoard.receiveAttack(pos)) { //runs recieve attack method and adds H in grid if hit also changes ship hits value
                    System.out.println("Ship hit!"); // the method returns true if ship is hit
                } else {
                    System.out.println("Miss!"); // method returns false if ship is missed or invalid position
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Try again."); 
            }
        }
    }

    private void computerTurn() {
        while (true) {
            // computer selects random position to attack
            Position pos = new Position(random.nextInt(10), random.nextInt(10));
            if (playerBoard.receiveAttack(pos)) {  // attack is excecuted on the player's board
                System.out.println("Computer hit your ship at " + pos + "!");
            } else {
                System.out.println("Computer missed at " + pos + "!");
            }
            break;
        }
    }

    public static void main(String[] args) {
        new Game().start();  // new game instance created and start() method is run
    }
}