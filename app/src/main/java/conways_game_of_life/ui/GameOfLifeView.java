package conways_game_of_life.ui;

import javax.swing.*;

import conways_game_of_life.models.GameOfLifeModel;
import conways_game_of_life.models.ModelObserver;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOfLifeView extends JFrame implements ModelObserver{
    private JPanel mainPanel;
    private JPanel gridPanel;
    private JPanel controlPanel;
    private JButton[][] gridButtons;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    public GameOfLifeView(int rows, int columns) {
        setTitle("The Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        gridPanel = new JPanel(new GridLayout(rows, columns));
        controlPanel = new JPanel();

        gridButtons = new JButton[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                gridButtons[row][column] = new JButton();
                gridButtons[row][column].setPreferredSize(new Dimension(20, 20)); // Adjust the size as needed
                gridButtons[row][column].setBackground(Color.WHITE);
                gridButtons[row][column].setActionCommand(row + "," + column);
                gridPanel.add(gridButtons[row][column]);
            }
        }

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);

        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setGridButtonListener(ActionListener listener) {
        for (int row = 0; row < gridButtons.length; row++) {
            for (int column = 0; column < gridButtons[row].length; column++) {
                gridButtons[row][column].addActionListener(listener);
            }
        }
    }

    public void update(GameOfLifeModel model) {
        for (int row = 0; row < model.getGrid().getRows(); row++) {
            for (int column = 0; column < model.getGrid().getColumns(); column++) {
                updateGridButton(row, column, model.getGrid().getCell(row, column).isAlive());
            }
        }
        System.out.println("Update view");
    }

    public void setStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void setStopButtonListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }

    public void setResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }

    public void updateGridButton(int row, int column, boolean alive) {
        if (alive) {
            gridButtons[row][column].setBackground(Color.BLACK);
        } else {
            gridButtons[row][column].setBackground(Color.WHITE);
        }
    }
}
