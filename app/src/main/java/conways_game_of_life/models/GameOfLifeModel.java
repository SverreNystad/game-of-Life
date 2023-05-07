package conways_game_of_life.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells,
 * each of which is in one of two possible states, alive or dead, (or populated and unpopulated, respectively).
 */
public class GameOfLifeModel {
    private Grid grid;
    private Timer timer;
    private boolean isRunning;

    public GameOfLifeModel(int rows, int columns) {
        grid = new Grid(rows, columns);
        isRunning = false;
    }

    private List<ModelObserver> observers = new ArrayList<>();
    
    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }
    
    public void removeObserver(ModelObserver observer) {
        observers.remove(observer);
    }
    
    private void notifyObservers() {
        for (ModelObserver observer : observers) {
            System.out.println("Notified observer");
            observer.update(this);
        }
    }

    public void start() {
        if (!isRunning && grid.isLife()) {
            isRunning = true;
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Updated grid");
                    grid.updateGrid();
                    notifyObservers();
                }
            }, 0, 1); // Adjust the second parameter for delay and third parameter for the time interval between generations as needed
        }
    }


    public void stop() {
        if (isRunning) {
            isRunning = false;
            timer.cancel();
        }
    }

    public void reset() {
        stop();
        grid.initializeGrid();
    }

    public Grid getGrid() {
        return grid;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
