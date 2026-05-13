package snake.game;

import snake.game.PanelClasses.Interface.Background;
import snake.game.PanelClasses.Interface.Score;
import snake.game.PanelClasses.Interface.GameOver;
import snake.game.PanelClasses.Interface.GamePaused;
import snake.game.PanelClasses.Objects.Apple;
import snake.game.PanelClasses.Objects.Controls;
import snake.game.PanelClasses.Objects.Directions;
import snake.game.PanelClasses.Objects.Snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static snake.game.PanelClasses.Objects.ScoreHandler.getBestScore;
import static snake.game.PanelClasses.Objects.ScoreHandler.setBestScore;

public class GamePanel extends JPanel implements ActionListener{
    static public final int UNIT_SIZE = 32;
    static public final int SCREEN_WIDTH = 20*UNIT_SIZE;
    static public final int SCREEN_HEIGHT = 21*UNIT_SIZE;
    static public final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT) / (UNIT_SIZE*UNIT_SIZE);
    static public final int DELAY = 100;
    public static int bestScore;

    public static BufferedImage images;
    public static Random random;

    public Apple apple;
    public Snake snake;
    boolean GamePaused = true;
    String gameOverStatus = "Game Over";
    String pauseStatus = "You are Snake";
    String message = "Press Space to play";
    Timer timer;

    GamePanel() {
        random = new Random();
        snake = new Snake(Controls.WASD);
        apple = new Apple(snake);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        snake.clearArray();
        startGame();
        timer.start();
    }

    public void startGame() {
        timer = new Timer(DELAY,this);
        snake = new Snake(Controls.WASD);

        bestScore = getBestScore();
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
                draw(g);
    }

    public void draw(Graphics g) {
         if(snake.isAlive()) {
            new Background(g, new Color(31, 99, 28), new Color(37, 117, 33));
            g.drawImage(apple.getImage(), apple.getAppleX(), apple.getAppleY(), null);
            snake.ImageChange(g, snake.getDirection(), snake.getBodyParts());
            new Score(g, snake.getApplesEaten(), bestScore);

            if(!snake.isRunning()){
                new GamePaused(g, pauseStatus, message);
            }
        }
        else {
            new GameOver(g,snake.getApplesEaten()  ,gameOverStatus);
            setBestScore(bestScore);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(snake.isRunning()) {
                Directions[] temp = new Directions[GAME_UNITS];
                temp[0] = snake.getDirection();
                if (snake.getBodyParts() >= 0) System.arraycopy(snake.getBodyArray(), 0, temp, 1, snake.getBodyParts());
                snake.setBodyArray(temp);
                if (snake.getBody(snake.getBodyParts() - 1) != snake.getBody(snake.getBodyParts() - 2)) {
                    System.out.println("Direct change ..."); //body[bodyParts-1] = body[bodyParts-2];
                    snake.setBody(snake.getBodyParts() - 1, snake.getBody(snake.getBodyParts() - 2));
                }
                snake.Move();
                apple.checkApple(snake);
                if(snake.getApplesEaten()>=321) {
                    gameOverStatus = "You Won!";
                    snake.setAlive(false);
                }
            }
            if(!snake.checkCollisions()) {
                snake.setAlive(false);
            }
            repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE -> {
                        if (!GamePaused) {
                            GamePaused = true;
                            snake.setRunning(false);
                        } else {
                            GamePaused = false;
                            snake.setRunning(true);
                        }
                        if (!snake.isAlive()) System.exit(0);
                    }
                    case KeyEvent.VK_SPACE -> {
                        System.out.println("GamePaused pauseStatus: " + GamePaused);
                        if (!GamePaused) {
                             GamePaused = true;
                             snake.setRunning(false);
                        } else {
                            GamePaused = false;
                            snake.setRunning(true);
                            pauseStatus = "Paused";
                            message = "Press Space to continue";
                        }
                    }
                    case KeyEvent.VK_R -> {
                        if (!snake.isAlive()) {
                            startGame();
                        }
                        GamePaused = true;
                        gameOverStatus = "Game Over";
                        pauseStatus = "You are Snake";
                        message = "Press Space to play";
                    }
                    case KeyEvent.VK_A, KeyEvent.VK_LEFT -> {
                        if (snake.getDirection() != Directions.RIGHT) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.LEFT);
                            }
                        }
                    }
                    case KeyEvent.VK_D,KeyEvent.VK_RIGHT  -> {
                        if (snake.getDirection() != Directions.LEFT) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.RIGHT);
                            }
                        }
                    }
                    case KeyEvent.VK_W, KeyEvent.VK_UP -> {
                        if (snake.getDirection() != Directions.DOWN) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.UP);
                            }
                        }
                    }
                    case KeyEvent.VK_S, KeyEvent.VK_DOWN -> {
                        if (snake.getDirection() != Directions.UP) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.DOWN);
                            }
                        }
                    }
                }
        }
    }
}