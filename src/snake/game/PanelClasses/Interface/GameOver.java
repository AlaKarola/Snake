package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GameOver extends JFrame {
    public GameOver(Graphics g, int applesEaten, int bestScore, String status) {
        new Background(g,Color.black,Color.black);

        g.setColor((Color.black));
        g.fillRect(UNIT_SIZE,UNIT_SIZE*2,UNIT_SIZE*18,UNIT_SIZE*18);

        new Score(g, applesEaten, bestScore);

        String message = "Press Esc to exit      Press R to play again";

        g.setColor(Color.CYAN);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(status, (SCREEN_WIDTH - metrics.stringWidth(status))/2, SCREEN_HEIGHT/2);

        g.setColor(Color.white);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        metrics = getFontMetrics(g.getFont());
        g.drawString(message, (SCREEN_WIDTH - metrics.stringWidth(message))/2, (SCREEN_HEIGHT/2)+UNIT_SIZE*3/2);
    }
}
