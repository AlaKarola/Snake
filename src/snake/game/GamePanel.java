package snake.game;

import snake.game.PanelClasses.GameActions.*;
import snake.game.PanelClasses.Interface.Background;
import snake.game.PanelClasses.Interface.DrawScore;
import snake.game.PanelClasses.Interface.GameOver;
import snake.game.PanelClasses.Interface.GamePaused;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

    static public final int SCREEN_WIDTH = 640;//650 1300;
    static public final int SCREEN_HEIGHT = 672;//375 750;
    static public final int UNIT_SIZE = 32;
    static public final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static public final int DELAY = 100;
    static final public int x[] = new int[GAME_UNITS];
    static final public int y[] = new int[GAME_UNITS];
    int snakeX = x[0];
    int snakeY = y[0];
    int bodyParts = 3;
    int applesEaten;
    int bestScore;
    char direction = 'R';
    int appleX;
    int appleY;
    boolean running = false;
    boolean alive = false;
    boolean escPressed = false;
    Timer timer;
    Random random;
    Image apple = Toolkit.getDefaultToolkit().getImage("./resources/apple.png");

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        timer = new Timer(DELAY,this);
        timer.start();

        appleX = NewApple.newAppleX();
        appleY = NewApple.newAppleY();
        applesEaten = 0;
        direction = 'R';
        x[0] = UNIT_SIZE*6;
        y[0] = UNIT_SIZE*12;

        bodyParts = 3;
        running = true;
        alive = true;
        try{
            bestScore = BestScore.getScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error found: File scores not found.");
        }
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
                draw(g);
    }   //(i / UNIT_SIZE) % 2 == 0 ? 0 : UNIT_SIZE
    public void draw(Graphics g) {
        if(alive) {
            new Background(g);
            g.drawImage(apple, appleX, appleY, null);
            new ImageChange(g,direction,bodyParts);
            new DrawScore(g,applesEaten,bestScore);
            if(!running){
                new GamePaused(g);
            }
        }
        else {
            new GameOver(g, applesEaten, bestScore);
            try{
                new BestScore(bestScore);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error found: File scores not found.");
            }
        }
    }

    public void checkApple() {
        if((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            appleX = NewApple.newAppleX();
            appleY = NewApple.newAppleY();
            if(applesEaten>bestScore){
                bestScore=applesEaten;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(running) {
                new Move(snakeX, snakeY, bodyParts, direction);
                checkApple();
            } else {
                for(int i = bodyParts;i>0;i--) {
                    x[i] = x[i];
                    y[i] = y[i];
                }
            }
            if(!CheckCollisions.checkCollisions(bodyParts)) {
                alive = false;
                timer.stop();
            }
            repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {

                switch(e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        if(!escPressed) {
                            escPressed = true;
                            running = false;
                        }
                        else {
                            escPressed = false;
                            running = true;
                        }
                        if(!alive) System.exit(0);
                        break;
                    case KeyEvent.VK_LEFT:
                        if(direction != 'R') {
                            if(running){
                                direction = 'L';
                            }
                        }
                        break;
                    case KeyEvent.VK_R:
                        if(!alive){
                            startGame();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(direction != 'L') {
                            if(running){
                                direction = 'R';
                            }
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if(direction != 'D') {
                            if(running){
                                direction = 'U';
                            }
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(direction != 'U') {
                            if(running){
                                direction = 'D';
                            }
                        }
                        break;
                }
        }
    }
}