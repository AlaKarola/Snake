package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GameOver extends JFrame {
    public GameOver(Graphics g, int applesEaten, int bestScore) {
        new Background(g,Color.black,Color.black);

        g.setColor((Color.black));
        g.fillRect(32,64,576,576);

        new DrawScore(g,applesEaten,bestScore);

        g.setColor(Color.CYAN);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);

        g.setColor(Color.white);
        g.setFont( new Font("Ink Free",Font.BOLD, 25));
        g.drawString("Press Esc to exit      Press R to play again", 510+((SCREEN_WIDTH - metrics2.stringWidth("Press Esc to exit      Press R to play again"))/2), (SCREEN_HEIGHT/2)+60);
    }
}
