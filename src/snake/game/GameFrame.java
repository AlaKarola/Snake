package snake.game;

import javax.swing.*;

import static snake.game.GamePanel.headUp;

public class GameFrame extends JFrame{
    GameFrame(){
        //this.add(new MenuPanel());
        this.add(new GamePanel());
        this.setTitle("Snakes Inc.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(headUp);
    }
}