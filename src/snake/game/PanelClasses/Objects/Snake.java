package snake.game.PanelClasses.Objects;


import java.awt.*;

import static snake.game.GamePanel.*;
import static snake.game.GamePanel.UNIT_SIZE;
import static snake.game.GamePanel.curve1;
import static snake.game.GamePanel.curve2;
import static snake.game.GamePanel.curve3;
import static snake.game.GamePanel.curve4;
import static snake.game.GamePanel.headLeft;
import static snake.game.GamePanel.headRight;
import static snake.game.GamePanel.tailD;
import static snake.game.GamePanel.tailL;
import static snake.game.GamePanel.tailR;
import static snake.game.GamePanel.tailU;

public class Snake {
    int[] x;
    int[] y;
    Directions[] body;
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
        this.body = new Directions[GAME_UNITS];
        this.direction = Directions.UP;
        this.snakeX = x[0];
        this.snakeY = y[0];
        this.bodyParts = 3;
        this.applesEaten = 0;
        this.running = false;
        this.alive = false;
        this.controls = con;
    }

    public void Move(){
        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case UP -> {
                y[0] = y[0] - UNIT_SIZE;
                snakeY = y[0];
                break;
            }
            case DOWN -> {
                y[0] = y[0] + UNIT_SIZE;
                snakeY = y[0];
                break;
            }
            case LEFT -> {
                x[0] = x[0] - UNIT_SIZE;
                snakeX = x[0];
                break;
            }
            case RIGHT -> {
                x[0] = x[0] + UNIT_SIZE;
                snakeX = x[0];
                break;
            }
        }
    }

    public void ImageChange(Graphics g, Directions direction, int bodyParts){
        for(int i = 0; i< bodyParts;i++) {
            if(i == 0) {
                if(direction == Directions.UP){
                    g.drawImage(headUp, x[i], y[i], null);
                } else if(direction == Directions.DOWN) {
                    g.drawImage(headDown, x[i], y[i], null);
                } else if(direction == Directions.LEFT) {
                    g.drawImage(headLeft, x[i], y[i], null);
                } else if(direction == Directions.RIGHT) {
                    g.drawImage(headRight, x[i], y[i], null);
                }
            }
            else {
                if(i==bodyParts-1){
                    if(body[bodyParts-1] == Directions.UP){
                        g.drawImage(tailU, x[i], y[i], null);
                    } else if(body[bodyParts-1] == Directions.DOWN) {
                        g.drawImage(tailD, x[i], y[i], null);
                    } else if(body[bodyParts-1] == Directions.LEFT) {
                        g.drawImage(tailL, x[i], y[i], null);
                    } else if(body[bodyParts-1] == Directions.RIGHT) {
                        g.drawImage(tailR, x[i], y[i], null);
                    }
                } else {
                    if(body[i-1]==Directions.LEFT&&body[i]==Directions.DOWN||body[i-1]==Directions.UP&&body[i]==Directions.RIGHT){
                        g.drawImage(curve3, x[i], y[i], null);
                    } else if(body[i-1]==Directions.RIGHT&&body[i]==Directions.UP||body[i-1]==Directions.DOWN&&body[i]==Directions.LEFT){
                        g.drawImage(curve1, x[i], y[i], null);
                    } else if(body[i-1]==Directions.UP&&body[i]==Directions.LEFT||body[i-1]==Directions.RIGHT&&body[i]==Directions.DOWN){
                        g.drawImage(curve4, x[i], y[i], null);
                    } else if(body[i-1]==Directions.DOWN&&body[i]==Directions.RIGHT||body[i-1]==Directions.LEFT&&body[i]==Directions.UP) {
                        g.drawImage(curve2, x[i], y[i], null);
                    } else {
                        g.setColor(new Color(0, 24, 180));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
        }
    }

    public boolean checkCollisions() {
        boolean alive = true;
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                alive = false;
                System.out.println("-> Body Collision");
            }
        }
        //check if head touches left border
        if(x[0] < UNIT_SIZE) {
            alive = false;
            System.out.println("-> Left Border Collision");
        }
        //check if head touches right border
        if(x[0] >= SCREEN_WIDTH-UNIT_SIZE) {
            alive = false;
            System.out.println("-> Right Border Collision");
        }
        //check if head touches top border
        if(y[0] < UNIT_SIZE*2) {
            alive = false;
            System.out.println("-> Top Border Collision");
        }
        //check if head touches bottom border
        if(y[0] >= SCREEN_HEIGHT-UNIT_SIZE) {
            alive = false;
            System.out.println("-> Bottom Border Collision");
        }
        return alive;
    }

    public void clearArray(){
        for(int i = 0; i < x.length; i++){
            x[i] = 0;
            y[i] = 0;
        }
    }

    public Directions[] getBodyArray() {
        return body;
    }

    public void setBodyArray(Directions[] temp) {
        this.body = temp;
    }

    public int getSnakeY() {
        return snakeY;
    }

    public int getSnakeX() {
        return snakeX;
    }

    public int getX(int index) {
        return x[index];
    }

    public void setX(int index, int value) {
        this.x[index] = value;
    }

    public int getY(int index) {
        return y[index];
    }

    public void setY(int index, int value) {
        this.y[index] = value;
    }

    public Directions getBody(int index) {
        return body[index];
    }

    public void setBody(int index, Directions din) {
        this.body[index] = din;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public int getBodyParts() {
        return bodyParts;
    }

    public void setApplesEaten(int i) {
        this.applesEaten = i;
    }

    public int getApplesEaten() {
        return applesEaten;
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