package snake.game.PanelClasses.GameActions;

import java.awt.*;

import static snake.game.GamePanel.*;

public class WarmUp {
    public static void imageWarmUp(Graphics g){
        Image[] images = new Image[]{headUp,headDown,headRight,headLeft,tailU,tailD,tailL,tailR,curve1,curve2,curve3,curve4,apple};

        for(int i = 0; i< 12;i++) {
            g.drawImage(images[i],0 , 0, null);
        }
    }
}
