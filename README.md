# Snake Game


## Description

This project presents an implementation of the **Snake** game created in the Java using the Swing library for the graphical user interface. 
The player controls a snake moving across the game board and collects apples appearing on the map. Each collected apple increases the snake’s length and the player’s score. The game ends when the snake collides with its own body or the edges of the board, or when it fills the entirety of it. The project also includes a system for saving high scores to a text file, a pause screen, an end game screen, and the option to restart the game.

The project was developed using an object-oriented approach with separate classes responsible for different parts of the game, such as snake and its movement, apple generation, interface rendering, and score management. 
The following libraries were used during the production:

* `javax.swing` — window creation and graphical interface,
* `java.awt` — rendering graphics and handling drawing operations,
* `java.nio.file` — reading and writing files,
* `java.awt.image` — loading icon sprites.

## Controls

| Key             | Function                      |
| --------------- | ----------------------------- |
| W / Up Arrow    | Move up                       |
| S / Down Arrow  | Move down                     |
| A / Left Arrow  | Move left                     |
| D / Right Arrow | Move right                    |
| SPACE           | Pause / resume the game       |
| R               | Restart the game after losing |
| ESC             | Exit the game after game over |
