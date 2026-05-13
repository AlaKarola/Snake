package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.SCREEN_WIDTH;
import static snake.game.GamePanel.UNIT_SIZE;

public class Score extends JFrame {

    public Score(Graphics g, int applesEaten, int bestScore ){
        g.setColor(Color.white);
        g.setFont( new Font("Segoe Print",Font.BOLD, 35));
        FontMetrics metrics = getFontMetrics(g.getFont());
        String score = "Score: " + applesEaten;
        g.drawString(score, (UNIT_SIZE*2), g.getFont().getSize()+UNIT_SIZE/4);
        score = "Best Score: " + bestScore;
        g.drawString(score, (SCREEN_WIDTH - (UNIT_SIZE*2) -metrics.stringWidth("Best score: 00")), g.getFont().getSize()+UNIT_SIZE/4);
    }
}
