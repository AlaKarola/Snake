package snake.game.GamePanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GameOver extends JFrame {
    public GameOver(Graphics g, int applesEaten, int bestScore) {
        //new Background(g,Color.black,Color.black);

        g.setColor((Color.black));
        g.fillRect(32,64,576,576);

//        new DrawScore(g,applesEaten,bestScore);

        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        g.setColor(Color.WHITE);
        String s1s = "" + (Snake1.bodyParts-3);
        String s2s = "" + (Snake2.bodyParts-3);
        g.setColor(new Color(0, 24, 180));
        g.drawString(s1s, 2*UNIT_SIZE, UNIT_SIZE+UNIT_SIZE/3);
        g.setColor(new Color(120, 61, 185));
        g.drawString(s2s, 12*UNIT_SIZE, UNIT_SIZE+UNIT_SIZE/3);

        g.setColor(Color.CYAN);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));

        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over",
                (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2,
                SCREEN_HEIGHT/2);

        g.setColor(Color.white);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        g.drawString("Press Esc to exit      Press R to play again",
                (SCREEN_WIDTH - metrics2.stringWidth("123456789"))/2-10,
                (SCREEN_HEIGHT/2)+60);
    }
}
