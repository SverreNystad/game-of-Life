package conways_game_of_life.models;


public class Grid {
    private int rows;
    private int columns;
    private Cell[][] grid;

    public Grid(int rows, int columns) {
        validateGrid(rows, columns);
        this.rows = rows;
        this.columns = columns;
        initializeGrid();
    }

    private static void validateGrid(final int rows, final int columns) throws IllegalArgumentException {
        if (rows < 0 || columns < 0) {
            throw new IllegalArgumentException("Grid dimensions cannot be negative");
        }
    }

    public void initializeGrid() {
        grid = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = new Cell(row, column);
            }
        }
    }

    /**
     * Updates the grid according to the following rules: <br>
     * 1. Any live cell with fewer than two live neighbors dies, as if by underpopulation.<br>
     * 2. Any live cell with two or three live neighbors lives on to the next generation.<br>
     * 3. Any live cell with more than three live neighbors dies, as if by overpopulation.<br>
     * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
     */
    public void updateGrid() {
        Cell[][] nextGenerationGrid = new Cell[rows][columns];
    
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int liveNeighbors = countLiveNeighbors(row, column);
                boolean currentState = grid[row][column].isAlive();
                boolean nextState = currentState;
                
                if (currentState && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    // Rule 2: Survival
                    nextState = true;
                } else if (currentState && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // Rule 1 and 3: Underpopulation or Overpopulation
                    nextState = false; 
                } else if (!currentState && liveNeighbors == 3) {
                    // Rule 4: Reproduction
                    nextState = true; 
                }

    
                nextGenerationGrid[row][column] = new Cell(row, column, nextState);
            }
        }
    
        grid = nextGenerationGrid;
    }

    private int countLiveNeighbors(int row, int column) {
        int liveNeighbors = 0;
    
        // Iterate through the neighboring cells
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                // Skip the cell itself
                if (x == 0 && y == 0) {
                    continue;
                }
    
                int neighborRow = row + x;
                int neighborColumn = column + y;
    
                // Check if the neighboring cell is within the grid boundaries
                if (neighborRow >= 0 && neighborRow < rows && neighborColumn >= 0 && neighborColumn < columns) {
                    if (grid[neighborRow][neighborColumn].isAlive()) {
                        liveNeighbors++;
                    }
                }
            }
        }
    
        return liveNeighbors;
    }

    public Cell getCell(int row, int column) {
        return grid[row][column];
    }

    public void setCellState(int row, int column, boolean alive) {
        grid[row][column].setAlive(alive);
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
    public boolean isLife() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++){
                if (grid[row][column].isAlive()) {
                    return true;
                }
            }
        }
        return false;
    }
}  
