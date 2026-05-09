package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GamePaused extends JFrame {
    public GamePaused(Graphics g, String status, String message) {
        g.setColor(Color.CYAN);
        g.setFont( new Font("Ink Free",Font.BOLD, 75)); // origin: 75, red
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(status, (SCREEN_WIDTH - metrics.stringWidth(status))/2, (SCREEN_HEIGHT/2));

        g.setColor(Color.black);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        metrics = getFontMetrics(g.getFont());
        g.drawString(message, ((SCREEN_WIDTH - metrics.stringWidth(message))/2), (SCREEN_HEIGHT/2)+(UNIT_SIZE*3)/2);
    }
}
