# Conway's Game of Life

This is a Java implementation of Conway's Game of Life, a cellular automaton devised by the British mathematician John Horton Conway in 1970. The game is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.
The application follows the Model-View-Controller pattern, separating the concerns of data, presentation, and user interaction.
The Model and View are connected using the Observer/Observable pattern. The Model acts as the Observable and the View acts as the Observer. This allows the Model to notify the View of changes, updating the display accordingly.
## Features

- A simple and easy-to-use GUI to set up the initial state
- Observer-observable pattern between the view and the model, allowing the view to be updated automatically when the model changes
- Customizable grid size
- Start, stop, and reset functionality

## Installation

To build and run the project, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have Java and Gradle installed on your computer.
3. Navigate to the project root directory in your terminal/command prompt.
4. Run `./gradlew run` (for macOS/Linux) or `gradlew.bat run` (for Windows) to build and run the project.

## Usage

1. Set the initial state of the grid by clicking on the cells to toggle their state (alive or dead).
2. Click the "Start" button to begin the simulation.
3. To pause the simulation, click the "Stop" button.
4. To reset the grid to the initial state, click the "Reset" button.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change. Please make sure to update tests as appropriate.

## Acknowledgments
I would like to gice thanks to
- John Horton Conway, the creator of the Game of Life, for his groundbreaking work in the field of cellular automata.
- The Java community, including the authors of various libraries and tools used in this project, for their invaluable resources and contributions to the open-source ecosystem.

## Future Features
1. **Adjustable Grid Size**: Allow users to customize the grid size to better suit their screen resolution and preferences.
2. **Speed Control**: Provide the ability to control the speed of the simulation, allowing users to observe the game's evolution at a slower or faster pace.
3. **Pattern Library**: Include a library of pre-built patterns that users can load into the grid, making it easy to experiment with well-known Game of Life patterns such as gliders, oscillators, and spaceships.
4. **Saving and Loading**: Allow users to save and load their grid configurations, enabling them to share and experiment with different setups.
5. **Statistics**: Display live statistics about the current state of the grid, such as the total number of live cells, the number of generations, and the overall population density.
6. **Cell Aging**: Implement a cell aging feature, where cells change color based on their age, providing a visual representation of the grid's history.
7. **Support for Other Cellular Automata**: Expand the application to support other cellular automata rules and systems, making it a versatile tool for exploring a wide range of mathematical models.


## License

[MIT](https://github.com/SverreNystad/game-of-Life/blob/master/LICENSE)
