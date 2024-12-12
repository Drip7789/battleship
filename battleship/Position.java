package battleship;

public class Position {
    private int row;
    private int col;


    // if the method is called with numeric inputs, row and col is constructed
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // if the method is called with string position such as (A1,5), the values get converted into numerical values and constructed
    public Position(String position) {
        this.row = position.toUpperCase().charAt(0) - 'A';
        this.col = Integer.parseInt(position.substring(1)) - 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    // pos.equals(obj) is the usage format
    // first checks if obj is a position instance
    // other is created with the value of inputted obj
    // returns true if other row is equal to row and other column is equal to column
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position) {
            Position other = (Position) obj;
            return row == other.row && col == other.col;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%c%d", (char)('A' + row), col + 1);
    }
}
