package conways_game_of_life.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(5, 5);
    }

    @Test
    void testInitializeGrid() {
        grid.initializeGrid();
        assertNotNull(grid.getCell(0, 0));
        assertNotNull(grid.getCell(4, 4));
    }

    @Test
    void testUpdateGrid() {
        // Create a 5x5 grid with a blinker pattern
        grid.setCellState(2, 1, true);
        grid.setCellState(2, 2, true);
        grid.setCellState(2, 3, true);

        grid.updateGrid();

        assertFalse(grid.getCell(2, 1).isAlive());
        assertTrue(grid.getCell(1, 2).isAlive());
        assertTrue(grid.getCell(2, 2).isAlive());
        assertTrue(grid.getCell(3, 2).isAlive());
        assertFalse(grid.getCell(2, 3).isAlive());
    }

    // @Test
    // void testCountLiveNeighbors() {
    //     grid.setCellState(1, 1, true);
    //     grid.setCellState(1, 2, true);
    //     grid.setCellState(1, 3, true);

    //     assertEquals(1, grid.countLiveNeighbors(0, 2));
    //     assertEquals(2, grid.countLiveNeighbors(1, 1));
    //     assertEquals(3, grid.countLiveNeighbors(2, 2));
    // }

    @Test
    void testGetCell() {
        assertNotNull(grid.getCell(0, 0));
        assertNotNull(grid.getCell(4, 4));
    }

    @Test
    void testSetCellState() {
        grid.setCellState(1, 1, true);
        assertTrue(grid.getCell(1, 1).isAlive());

        grid.setCellState(1, 1, false);
        assertFalse(grid.getCell(1, 1).isAlive());
    }

    @Test
    void testGetRows() {
        assertEquals(5, grid.getRows());
    }

    @Test
    void testGetColumns() {
        assertEquals(5, grid.getColumns());
    }

}
