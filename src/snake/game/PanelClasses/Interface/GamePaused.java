package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GamePaused extends JFrame {
    public GamePaused(Graphics g, String status, String message) {
        g.setColor(Color.WHITE);
        g.setFont( new Font("Ink Free",Font.BOLD, 90));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(status, (SCREEN_WIDTH - metrics.stringWidth(status))/2, (SCREEN_HEIGHT/2));

        g.setFont( new Font("Ink Free",Font.BOLD, 30));
        metrics = getFontMetrics(g.getFont());
        g.drawString(message, ((SCREEN_WIDTH - metrics.stringWidth(message))/2), (SCREEN_HEIGHT/2)+(UNIT_SIZE*3)/2);
    }
}
