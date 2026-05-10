package snake.game.PanelClasses.Objects;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import static snake.game.GamePanel.*;
import static snake.game.GamePanel.UNIT_SIZE;


public class Snake {
    int[] x;
    int[] y;
    Directions[] body;
    Directions direction;
    int snakeX;
    int snakeY;
    int bodyParts;
    int applesEaten;
    boolean running;
    boolean alive;
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
            }
            case DOWN -> {
                y[0] = y[0] + UNIT_SIZE;
                snakeY = y[0];
            }
            case LEFT -> {
                x[0] = x[0] - UNIT_SIZE;
                snakeX = x[0];
            }
            case RIGHT -> {
                x[0] = x[0] + UNIT_SIZE;
                snakeX = x[0];
            }
        }
    }

    public void ImageChange(Graphics g, Directions direction, int bodyParts) {
        for (int i = 0; i < bodyParts; i++) {
            Graphics2D g2d = (Graphics2D) g.create();
            if (i == 0) {
                double angle = 0;
                if (direction == Directions.UP) {
                    angle = 0;
                }
                else if (direction == Directions.RIGHT) {
                    angle = 90;
                }
                else if (direction == Directions.DOWN) {
                    angle = 180;
                }
                else if (direction == Directions.LEFT) {
                    angle = 270;
                }
                drawRotated(g2d, images.getSubimage(0, 0, 32, 32), x[i], y[i], angle);
            } else {
                if (i == bodyParts - 1) {
                    double angle = 0;
                    if (body[bodyParts - 1] == Directions.UP) {
                        angle = 0;
                    }
                    else if (body[bodyParts - 1] == Directions.RIGHT) {
                        angle = 90;
                    }
                    else if (body[bodyParts - 1] == Directions.DOWN) {
                        angle = 180;
                    }
                    else if (body[bodyParts - 1] == Directions.LEFT) {
                        angle = 270;
                    }
                    drawRotated(g2d, images.getSubimage(0, 34, 32, 32), x[i], y[i], angle);
                } else {
                    BufferedImage curveSprite = images.getSubimage(34, 0, 32, 32);
                    if(body[i-1]==Directions.LEFT&&body[i]==Directions.DOWN||body[i-1]==Directions.UP&&body[i]==Directions.RIGHT){
                        drawRotated(g2d, curveSprite, x[i], y[i], 180);
                    } else if(body[i-1]==Directions.RIGHT&&body[i]==Directions.UP||body[i-1]==Directions.DOWN&&body[i]==Directions.LEFT){
                        drawRotated(g2d, curveSprite, x[i], y[i], 360);
                    } else if(body[i-1]==Directions.UP&&body[i]==Directions.LEFT||body[i-1]==Directions.RIGHT&&body[i]==Directions.DOWN){
                        drawRotated(g2d, curveSprite, x[i], y[i], 270);
                    } else if(body[i-1]==Directions.DOWN&&body[i]==Directions.RIGHT||body[i-1]==Directions.LEFT&&body[i]==Directions.UP) {
                        drawRotated(g2d, curveSprite, x[i], y[i], 90);
                    } else {
                        g.setColor(new Color(0, 24, 180));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }
            }
            g2d.dispose();
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

    private void drawRotated(Graphics2D g2d, BufferedImage image, int x, int y, double angle) {
        AffineTransform at = new AffineTransform();
        at.translate(x, y);
        at.rotate(Math.toRadians(angle), image.getWidth() / 2.0, image.getHeight() / 2.0);
        g2d.drawImage(image, at, null);
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

    public void setX(int index, int value) {
        this.x[index] = value;
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