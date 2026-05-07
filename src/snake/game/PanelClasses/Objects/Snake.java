package snake.game.PanelClasses.Objects;


import static snake.game.GamePanel.GAME_UNITS;

public class Snake {
    int[] x;
    int[] y;
    char[] body;
    Directions direction;
    int snakeX;
    int snakeY;
    int bodyParts;
    int applesEaten;
    boolean running = false;
    boolean alive = false;
    Controls controls;


    public Snake(Controls con) {
        this.x = new int[GAME_UNITS];
        this.y = new int[GAME_UNITS];
        this.body = new char[GAME_UNITS];
        this.direction = Directions.UP;
        this.snakeX = x[0];
        this.snakeY = y[0];
        this.bodyParts = 3;
        this.applesEaten = 0;
        this.running = false;
        this.alive = false;
        this.controls = con;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public void setSnakeY(int snakeY) {
        this.snakeY = snakeY;
    }

    public int getX(int index) {
        return x[index];
    }

    public void setX(int index, int value) {
        this.x[index] = value;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public char[] getBody() {
        return body;
    }

    public void setBody(char[] body) {
        this.body = body;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public int getSnakeX() {
        return snakeX;
    }

    public void setSnakeX(int snakeX) {
        this.snakeX = snakeX;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setBodyParts(int bodyParts) {
        this.bodyParts = bodyParts;
    }

    public int getApplesEaten() {
        return applesEaten;
    }

    public void setApplesEaten(int applesEaten) {
        this.applesEaten = applesEaten;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


}