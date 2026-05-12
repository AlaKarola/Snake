package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class Menu extends JFrame {
    public Menu (Graphics g) {

        g.setColor((new Color(38, 38, 38)));
        g.fillRect(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);

        String status = "Snake";
        String message = "Press Esc to exit       Press Enter to play";

        g.setColor(Color.green);
        g.setFont( new Font("Vladimir Script",Font.BOLD, 250));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(status, ((SCREEN_WIDTH - metrics.stringWidth(status))/2) , UNIT_SIZE*7);


        g.setColor(Color.red);
        g.setFont( new Font("Bookman Old Style",Font.BOLD, 30));
        metrics = getFontMetrics(g.getFont());
        g.drawString(message, ((SCREEN_WIDTH - metrics.stringWidth(message))/2) , UNIT_SIZE*15);

    }
}
