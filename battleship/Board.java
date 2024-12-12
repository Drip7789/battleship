package battleship;

public class Board {
    private static final int SIZE = 10; //this is the grid size, its final so no change
    private char[][] grid; // grid[][] is a 2d array, the []'s get numerical values and it returns a character
    private Ship[] ships;
    private int shipCount;


    public Board() {
        grid = new char[SIZE][SIZE]; // sets grid size for column and row
        ships = new Ship[5]; // Maximum 5 ships in classic battleship
        shipCount = 0; //shipcount starts at 0
        initializeGrid();
    }

    // grid[] is a 2d array, when initialized adds * to all grids
    private void initializeGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = '*';
            }
        }
    }

    // adds ship positions to the positions[]
    // increases ship count
    // updates ship positions with ship.setPositions(positions)
    public boolean placeShip(Ship ship, Position start, String direction) {
        Position[] positions = calculateShipPositions(ship.getLength(), start, direction);
        if (positions == null) return false;

        // Check if positions are valid and not occupied
        for (Position pos : positions) {
            if (!isValidPosition(pos) || isOccupied(pos)) {
                return false;
            }
        }

        ship.setPositions(positions);

        ships[shipCount++] = ship;

        // Update grid 2d array and adds S to the positions
        for (Position pos : positions) {
            grid[pos.getRow()][pos.getCol()] = 'S';
        }

        return true;
    }

    // gets inout of ship lenght start position on board and direction
    // adds coordinate values to positions and returns it
    private Position[] calculateShipPositions(int length, Position start, String direction) {
        Position[] positions = new Position[length];
        int row = start.getRow();
        int col = start.getCol();

        for (int i = 0; i < length; i++) {
            switch (direction.toLowerCase()) {
                case "north":
                    positions[i] = new Position(row - i, col);
                    break;
                case "south":
                    positions[i] = new Position(row + i, col);
                    break;
                case "east":
                    positions[i] = new Position(row, col + i);
                    break;
                case "west":
                    positions[i] = new Position(row, col - i);
                    break;
                default:
                    return null;
            }
        }
        return positions;
    }


    // this method makes an attack, changes grid to X and H according to what happened
    // returns true if hit and false if missed
    //returns false if attack posiyion is invalid
    public boolean receiveAttack(Position pos) {
        if (!isValidPosition(pos)) return false;

        for (int i = 0; i < shipCount; i++) {
            if (ships[i].hit(pos)) {
                grid[pos.getRow()][pos.getCol()] = 'H';
                return true;
            }
        }

        grid[pos.getRow()][pos.getCol()] = 'X';
        return false;
    }

    //returns false if ships are not destroyed
    // returns true if all ships are destroyed
    public boolean areAllShipsDestroyed() {
        for (int i = 0; i < shipCount; i++) {
            if (!ships[i].isDestroyed()) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidPosition(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < SIZE && 
               pos.getCol() >= 0 && pos.getCol() < SIZE;
    }

    // returns true if given position is S which is ship occupied
    private boolean isOccupied(Position pos) {
        return grid[pos.getRow()][pos.getCol()] == 'S';
    }


    // displays board
    // can choose between hide ships or not
    public void displayBoard(boolean hideShips) {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < SIZE; j++) {
                char cell = grid[i][j];
                // displays * even though its S when hideships is active
                if (hideShips && cell == 'S') {
                    System.out.print("* ");
                // if hideShips is not active just print the cell value
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
}