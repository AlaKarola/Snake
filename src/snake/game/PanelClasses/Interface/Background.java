package snake.game.PanelClasses.Interface;

import java.awt.*;

import static snake.game.GamePanel.*;
import static snake.game.GamePanel.UNIT_SIZE;

public class Background {
    public Background(Graphics g, Color color1, Color color2){

        Color color3;
        Color ramka = new Color(110, 53, 14);
        for(int i = 0; i < SCREEN_HEIGHT; i += UNIT_SIZE) {
            color3 = color1;
            color1 = color2;
            color2 = color3;
            for (int j = 0; j < SCREEN_WIDTH; j += UNIT_SIZE) {
                if (i >= 64) {
                    if ((j / UNIT_SIZE) % 2 == 0)
                        g.setColor(color1);
                    else
                        g.setColor(color2);
                } else {
                    g.setColor(ramka);
                }
                if (j == 0 || j == 608 || i > 608) {
                    g.setColor(ramka);
                }
                g.fillRect(j, i, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
}
