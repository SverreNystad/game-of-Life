package conways_game_of_life.ui;

import conways_game_of_life.controllers.GameOfLifeController;
import conways_game_of_life.models.GameOfLifeModel;

public class GameApp {
    public static void main(String[] args) {
        int rows = 30; // Adjust the grid size as needed
        int columns = 30;

        GameOfLifeModel model = new GameOfLifeModel(rows, columns);
        GameOfLifeView view = new GameOfLifeView(rows, columns);
        GameOfLifeController controller = new GameOfLifeController(model, view);
    }
}
