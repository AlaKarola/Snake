package snake.game.GamePanelClasses;

import static snake.game.GamePanel.GAME_UNITS;

public class SnakeDTO {
    public int[] x = new int[GAME_UNITS];
    public int[] y = new int[GAME_UNITS];
    public char[] body = new char[GAME_UNITS];
    public char direction = 'U';
    public int snakeX = x[0];
    public int snakeY = y[0];
    public int bodyParts = 3;
    public int applesEaten;
    public boolean running = false;
    public boolean alive = false;
    public String controls;

}
