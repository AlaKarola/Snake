package snake.game;

import snake.game.GamePanelClasses.GameActions.*;
import snake.game.GamePanelClasses.Instances.DirectionChange;
import snake.game.GamePanelClasses.Instances.WarmUp;
import snake.game.GamePanelClasses.Interface.Background;
import snake.game.GamePanelClasses.Interface.GameOver;
import snake.game.GamePanelClasses.Interface.GamePaused;
import snake.game.GamePanelClasses.SnakeDTO;
import snake.game.GamePanelClasses.SnakeControlsKeyEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener{
    static public final int UNIT_SIZE = 32;
    static public final int SCREEN_WIDTH = UNIT_SIZE*20;
    static public final int SCREEN_HEIGHT = UNIT_SIZE*21;
    static public final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static public final int DELAY = 100; ///////////////////////////////////////////////////////////
    public static boolean escPressed = false;
    public static int bestScore;
    int appleX;
    int appleY;
    int warmUp = 0;
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

    public static SnakeDTO Snake1;
    public static SnakeDTO Snake2;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new SnakeKeyAdapter());
        Snake2 = new SnakeDTO();
        Snake1 = new SnakeDTO();
        clearArray(Snake1.x,Snake1.y);
        clearArray(Snake2.x,Snake2.y);
        startGame();
    }

    public void startGame() {
        timer = new Timer(DELAY,this);
        timer.start();

        appleX = NewApple.newAppleX();
        appleY = NewApple.newAppleY();

        Snake1.x[0] = Snake1.x[1]= Snake1.x[2] = UNIT_SIZE;
        Snake1.y[0] = UNIT_SIZE*12;
        Snake1.y[1] = UNIT_SIZE*13;
        Snake1.y[2] = UNIT_SIZE*14;
        Snake1.body[0] = Snake1.body[1] = Snake1.body[2] = 'U';
        Snake1.controls = "wasd";

        Snake1.direction = Snake2.direction = 'U';
        Snake1.applesEaten = Snake2.applesEaten = 0;
        Snake1.bodyParts = Snake2.bodyParts = 3;
        Snake1.running = Snake2.running = false;
        Snake1.alive = Snake2.alive = false;

        Snake2.x[0] = Snake2.x[1]= Snake2.x[2] = UNIT_SIZE*5;
        Snake2.y[0] = UNIT_SIZE*12;
        Snake2.y[1] = UNIT_SIZE*13;
        Snake2.y[2] = UNIT_SIZE*14;
        Snake2.body[0] = Snake2.body[1] = Snake2.body[2] = 'D';
        Snake2.controls = "ijkl";

        try{
            bestScore = BestScore.getScore();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error found: File 'scores' not found.");
        }
    }

    public void clearArray(int[] x, int[] y){
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
        if(Snake1.alive&&Snake2.alive) {
            if(warmUp<1){
                WarmUp.imageWarmUp(g);
                warmUp++;
            }
            g.setFont( new Font("Ink Free",Font.BOLD, 40));
            new Background(g,new Color(31, 99, 28),new Color(37, 117, 33));
            g.drawImage(apple, appleX, appleY, null);
            g.setColor(Color.WHITE);
            String s1s = "" + (Snake1.bodyParts-3);
            String s2s = "" + (Snake2.bodyParts-3);
            g.setColor(new Color(0, 24, 180));
            g.drawString(s1s, 2*UNIT_SIZE, UNIT_SIZE+UNIT_SIZE/3);
            g.setColor(new Color(120, 61, 185));
            g.drawString(s2s, 12*UNIT_SIZE, UNIT_SIZE+UNIT_SIZE/3);
            new ImageChange(g,Snake1,new Color(0, 24, 180));
            new ImageChange(g,Snake2,new Color(120, 61, 185));

            if(!Snake1.running&&!Snake2.running){
                new GamePaused(g);
            }
        }
        else {
            new GameOver(g, Snake1.applesEaten, bestScore);
            try{
                new BestScore(bestScore);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("Error found: File 'scores' not found.");
            }
        }
    }

    public static boolean CheckApple(SnakeDTO Snake, int appleX, int appleY) {
        if((Snake.x[0] == appleX) && (Snake.y[0] == appleY)) {
            Snake.bodyParts++;
            Snake.applesEaten++;
            if(Snake.applesEaten>bestScore){
                bestScore=Snake.applesEaten;
            }
            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Snake1.running && Snake2.running) {
            new DirectionChange(Snake1);
            new DirectionChange(Snake2);
            new Move(Snake1);
            new Move(Snake2);

            if (CheckApple(Snake1, appleX, appleY)) {
                appleX = NewApple.newAppleX();
                appleY = NewApple.newAppleY();
            }
            if (CheckApple(Snake2, appleX,appleY)) {
                appleX = NewApple.newAppleX();
                appleY = NewApple.newAppleY();
            }
        }
        Snake1.alive = CheckCollisions.checkCollisions(Snake1, Snake2);
        Snake2.alive = CheckCollisions.checkCollisions(Snake2, Snake1);
        if(!Snake1.alive || !Snake2.alive) {
            timer.stop();
        }
        repaint();
    }
    public class SnakeKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()) {
                case KeyEvent.VK_SPACE:
                    System.out.println("excPressed: " + escPressed);
                    if (!escPressed) {
                        escPressed = true;
                        Snake1.running = false;
                        Snake2.running = false;
                    } else {
                        escPressed = false;
                        Snake1.running = true;
                        Snake2.running = true;
                    }
                case KeyEvent.VK_ESCAPE:
                    if (!Snake1.alive || !Snake2.alive) System.exit(0);
                    break;
                case KeyEvent.VK_R:
                    if(!Snake1.alive || !Snake2.alive){
                        startGame();
                    }
                    break;
            }
            new SnakeControlsKeyEvent(e, Snake1);
            new SnakeControlsKeyEvent(e, Snake2);
        }
    }
}