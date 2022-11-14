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

    static public final int SCREEN_WIDTH = 640;
    static public final int SCREEN_HEIGHT = 672;
    static public final int UNIT_SIZE = 32;
    static public final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static public final int DELAY = 100;
    static public int x[] = new int[GAME_UNITS];
    static public int y[] = new int[GAME_UNITS];
    static public char body[] = new char[GAME_UNITS];
    int snakeX = x[0];
    int snakeY = y[0];
    int bodyParts = 3;
    int applesEaten;
    int bestScore;
    char direction = 'R';
    int appleX;
    int appleY;
    int warmUp = 0;
    boolean running = false;
    boolean alive = false;
    boolean escPressed = false;
    Timer timer;
    Random random;
    public static Image apple = Toolkit.getDefaultToolkit().getImage("./resources/apple.png");
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
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        clearArray();
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
        body[0] = 'R';
        body[1] = 'R';
        body[2] = 'R';

        bodyParts = 3;
        running = true;
        alive = true;
        try{
            bestScore = BestScore.getScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error found: File 'scores' not found.");
        }
    }

    public void clearArray(){
        for(int i = 0; i < x.length; i++){
            x[i] = 0;
            y[i] = 0;
        }
    }

    public void paintComponent(Graphics g) {
            super.paintComponent(g);
                draw(g);
    }

    public void draw(Graphics g) {
        if(alive) {
            if(warmUp<1){
                WarmUp.imageWarmUp(g);
                warmUp++;
            }
            new Background(g,new Color(31, 99, 28),new Color(37, 117, 33));
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
                System.out.println("Error found: File 'scores' not found.");
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
                char temp[] = new char [GAME_UNITS];
                temp[0]=direction;
                if (bodyParts >= 0) System.arraycopy(body, 0, temp, 1, bodyParts);
                body = temp;
                if(body[bodyParts-1]!=body[bodyParts-2]){
                    body[bodyParts-1] = body[bodyParts-2];
                }
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