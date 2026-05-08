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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import static snake.game.PanelClasses.Interface.Score.getBestScore;
import static snake.game.PanelClasses.Interface.Score.setBestScore;

public class GamePanel extends JPanel implements ActionListener{
    static public final int UNIT_SIZE = 32;

    static public final int SCREEN_WIDTH = 20*UNIT_SIZE;
    static public final int SCREEN_HEIGHT = 21*UNIT_SIZE;

    static public final int GAME_UNITS = // The amount of units
            (SCREEN_WIDTH*SCREEN_HEIGHT) / (UNIT_SIZE*UNIT_SIZE);
    static public final int DELAY = 100;

    public static int bestScore;

    File sprite = new File("./resources/sprite.png");

    boolean GamePaused = false;


    Timer timer;
    static public Random random;

    public Apple apple;
    public Snake snake;

    //public static Image apple = Toolkit.getDefaultToolkit().getImage("./resources/apple.png");
    public static Image headUp = Toolkit.getDefaultToolkit().getImage("./resources/headU.png");
    public static Image headDown = Toolkit.getDefaultToolkit().getImage("./resources/headD.png");
    public static Image headLeft = Toolkit.getDefaultToolkit().getImage("./resources/headL.png");
    public static Image headRight = Toolkit.getDefaultToolkit().getImage("./resources/headR.png");

    public static Image tailU = Toolkit.getDefaultToolkit().getImage("./resources/tailU.png");
    public static Image tailD = Toolkit.getDefaultToolkit().getImage("./resources/tailD.png");
    public static Image tailL = Toolkit.getDefaultToolkit().getImage("./resources/tailL.png");
    public static Image tailR = Toolkit.getDefaultToolkit().getImage("./resources/tailR.png");

    public static Image curve1 = Toolkit.getDefaultToolkit().getImage("./resources/curve1.png");
    public static Image curve2 = Toolkit.getDefaultToolkit().getImage("./resources/curve2.png");
    public static Image curve3 = Toolkit.getDefaultToolkit().getImage("./resources/curve3.png");
    public static Image curve4 = Toolkit.getDefaultToolkit().getImage("./resources/curve4.png");

    GamePanel() {
        random = new Random();
        apple = new Apple();
        snake = new Snake(Controls.WASD);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());


        snake.clearArray();
        startGame();
    }

    public void startGame() {
        timer = new Timer(DELAY,this);
        snake = new Snake(Controls.WASD);

        snake.setBodyArray(new Directions[GAME_UNITS]);
        snake.setX(0, UNIT_SIZE*6);
        snake.setY(0, UNIT_SIZE*12);
        snake.setApplesEaten(0);
        snake.setBody(0, Directions.RIGHT);
        snake.setBody(1, Directions.RIGHT);
        snake.setBody(2, Directions.RIGHT);
        snake.setAlive(true);
        snake.setRunning(true);

        try{
            bestScore = getBestScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error found: File 'scores' not found.");
        }

        timer.start();
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
                draw(g);
    }

    public void draw(Graphics g) {
        if(snake.isAlive()) {
            new Background(g,new Color(31, 99, 28),new Color(37, 117, 33));
            g.drawImage(apple.getImage(), apple.getAppleX(), apple.getAppleY(), null);
            snake.ImageChange(g,snake.getDirection(),snake.getBodyParts());
            new Score(g,snake.getApplesEaten(),bestScore);

            if(!snake.isRunning()){
                new GamePaused(g);
            }
        }
        else {
            new GameOver(g, snake.getApplesEaten(), bestScore);
            try {
                setBestScore(bestScore);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error found: File 'scores' not found.");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            if(snake.isRunning()) {
                Directions temp[] = new Directions[GAME_UNITS];
                temp[0] = snake.getDirection();
                if (snake.getBodyParts() >= 0) System.arraycopy(snake.getBodyArray(), 0, temp, 1, snake.getBodyParts());
                snake.setBodyArray(temp);
                if (snake.getBody(snake.getBodyParts() - 1) != snake.getBody(snake.getBodyParts() - 2)) {
                    //body[bodyParts-1] = body[bodyParts-2];
                    snake.setBody(snake.getBodyParts() - 1, snake.getBody(snake.getBodyParts() - 2));
                }
                snake.Move();
                apple.checkApple(snake);
            }
//            } else {
//                for(int i = snake.getBodyParts();i>0;i--) {
//                    x[i] = x[i];
//                    y[i] = y[i];
//                }
//            }
            if(!snake.checkCollisions()) {
                snake.setAlive(false);
                timer.stop();
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
                        break;
                    }
                    case KeyEvent.VK_SPACE -> {
                        if (!GamePaused) {
                            GamePaused = true;
                            snake.setRunning(false);
                        } else {
                            GamePaused = false;
                            snake.setRunning(true);
                        }
                        break;
                    }
                    case KeyEvent.VK_R -> {
                        if (!snake.isAlive()) {
                            startGame();
                        }
                        break;
                    }
                    case KeyEvent.VK_A -> {
                        if (snake.getDirection() != Directions.RIGHT) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.LEFT);
                            }
                        }
                        break;
                    }
                    case KeyEvent.VK_D -> {
                        if (snake.getDirection() != Directions.LEFT) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.RIGHT);
                            }
                        }
                        break;
                    }
                    case KeyEvent.VK_W -> {
                        if (snake.getDirection() != Directions.DOWN) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.UP);
                            }
                        }
                        break;
                    }
                    case KeyEvent.VK_S -> {
                        if (snake.getDirection() != Directions.UP) {
                            if (snake.isRunning()) {
                                snake.setDirection(Directions.DOWN);
                            }
                        }
                        break;
                    }
                }
        }
    }
}