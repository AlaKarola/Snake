package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.SCREEN_WIDTH;

public class DrawScore extends JFrame {

    public DrawScore(Graphics g,int applesEaten, int bestScore ){
        g.setColor(Color.white);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten + "          Best score: " + bestScore,
                (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesEaten+ "          Best score: " + bestScore))/2,
                g.getFont().getSize());
    }
}
