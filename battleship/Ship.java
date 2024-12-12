package battleship;


public class Ship {
    private int length; // ship's lenght
    private boolean[] hits; // stores ships hit locations (true, false, false ,false) etc
    private Position[] positions; // stores the positions the ship occupt

    public Ship(int length) {
        this.length = length;
        this.hits = new boolean[length]; // this array represent all hitted points on each segment of the ship
        this.positions = new Position[length]; // this array stores positions the ship occupies
    }


    // returns trye if all segments of the ship is hit
    // returns false if even one segment is not hit
    public boolean isDestroyed() {
        for (boolean hit : hits) {
            if (!hit) return false;
        }
        return true;
    }

    // adds the ships position to positions variable
    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    // returns the positions
    public Position[] getPositions() {
        return positions;
    }

    // gets a position input and if there is a ship there, makes the hits boolean true at that position
    // and then returns true if the given pos equals to positions that the ship occupy
    // returns false if there is no ship at given position
    public boolean hit(Position pos) {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i].equals(pos)) {
                hits[i] = true;
                return true;
            }
        }
        return false;
    }

    // returns ship lengh
    public int getLength() {
        return length;
    }
}
