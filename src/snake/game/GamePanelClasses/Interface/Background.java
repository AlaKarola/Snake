package snake.game.GamePanelClasses.Interface;

import java.awt.*;

import static snake.game.GamePanel.*;
import static snake.game.GamePanel.UNIT_SIZE;

public class Background {
    public Background(Graphics g, Color color1, Color color2){

        Color color3; //an empty color variable later used to switch two variables
        Color ramka = new Color(110, 53, 14);
        for(int i = 0; i < SCREEN_HEIGHT; i += UNIT_SIZE) {
            color3 = color1;
            color1 = color2;
            color2 = color3;
            for (int j = 0; j < SCREEN_WIDTH; j += UNIT_SIZE) {
                if (i >= UNIT_SIZE*2) {
                    //drawing a checked play area
                    if ((j / UNIT_SIZE) % 2 == 0)
                        g.setColor(color1);
                    else
                        g.setColor(color2);
                } else {
                    //drawing plain brown border
                    g.setColor(ramka);
                }
                if (j == 0 || j == UNIT_SIZE*19 || i > UNIT_SIZE*19) {
                    g.setColor(ramka);
                }
                g.fillRect(j, i, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
}
