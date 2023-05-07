package conways_game_of_life.models;

public class Cell {
    private int x;
    private int y;
    private boolean isAlive;
    private boolean hasBeenAlive;


    public Cell(int x, int y, boolean isAlive) {
        validateCell(x, y);
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
        this.hasBeenAlive = isAlive;

    }

    public Cell(int x, int y) {
        this(x, y, false);
    }

    private static void validateCell(final int x,final int y) throws IllegalArgumentException{
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Cell coordinates cannot be negative");
        }
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(final boolean isAlive) {
        this.isAlive = isAlive;
        if (isAlive) {
            this.hasBeenAlive = true;
        }
    }

    public void toggleState() {
        this.isAlive = !isAlive;
    }
}