package snake.game.GamePanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GamePaused extends JFrame {
    public GamePaused(Graphics g) {
        g.setColor(Color.CYAN);
        g.setFont( new Font("Ink Free",Font.BOLD, 75)); // origin: 75, red
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Paused", (SCREEN_WIDTH - metrics2.stringWidth("Paused"))/2, SCREEN_HEIGHT/2);
        g.setColor(Color.black);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        g.drawString("Press Space to continue", ((SCREEN_WIDTH - metrics2.stringWidth("Press Esc to continue"))/2)+7*UNIT_SIZE, (SCREEN_HEIGHT/2)+60);
    }
}
