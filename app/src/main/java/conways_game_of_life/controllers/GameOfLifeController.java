package conways_game_of_life.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conways_game_of_life.models.GameOfLifeModel;
import conways_game_of_life.ui.GameOfLifeView;

public class GameOfLifeController {
    private GameOfLifeModel model;
    private GameOfLifeView view;

    public GameOfLifeController(GameOfLifeModel model, GameOfLifeView view) {
        this.model = model;
        this.view = view;

        this.view.setGridButtonListener(new GridButtonListener());
        this.view.setStartButtonListener(new StartButtonListener());
        this.view.setStopButtonListener(new StopButtonListener());
        this.view.setResetButtonListener(new ResetButtonListener());
    }

    private class GridButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] coordinates = e.getActionCommand().split(",");
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);

            model.getGrid().getCell(row, column).toggleState();
            view.updateGridButton(row, column, model.getGrid().getCell(row, column).isAlive());
        }
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.addObserver(view);
            model.start();
        }
    }

    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.stop();
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.reset();

            for (int row = 0; row < model.getGrid().getRows(); row++) {
                for (int column = 0; column < model.getGrid().getColumns(); column++) {
                    view.updateGridButton(row, column, false);
                }
            }
        }
    }
}
