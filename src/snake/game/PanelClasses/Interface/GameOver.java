package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;

import static snake.game.GamePanel.*;

public class GameOver extends JFrame {
    public GameOver(Graphics g, int applesEaten, String status) {
        new Background(g, Color.black);
        new Score(g, applesEaten, bestScore);

        String exitMessage = "Press Esc to exit";
        String replayMesstage = "Press R to play again";

        g.setColor(Color.RED);
        g.setFont(new Font("Ink Free", Font.BOLD, 90));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString(status, (SCREEN_WIDTH - metrics.stringWidth(status)) / 2, SCREEN_HEIGHT / 2);

        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        metrics = getFontMetrics(g.getFont());
        g.drawString(exitMessage, (SCREEN_WIDTH - metrics.stringWidth(exitMessage)) / 2, (SCREEN_HEIGHT / 2) + UNIT_SIZE * 4 / 2);

        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.BOLD, 25));
        metrics = getFontMetrics(g.getFont());
        g.drawString(replayMesstage, (SCREEN_WIDTH - metrics.stringWidth(replayMesstage)) / 2, (SCREEN_HEIGHT / 2) + UNIT_SIZE * 7 / 2);
    }
}