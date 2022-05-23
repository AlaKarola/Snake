package snake.game.PanelClasses.GameActions;

import java.awt.*;

import static snake.game.GamePanel.*;

public class ImageChange {
    public ImageChange(Graphics g, char direction, int bodyParts){

        Image headUp = Toolkit.getDefaultToolkit().getImage("./resources/headU.png");
        Image headDown = Toolkit.getDefaultToolkit().getImage("./resources/headD.png");
        Image headLeft = Toolkit.getDefaultToolkit().getImage("./resources/headL.png");
        Image headRight = Toolkit.getDefaultToolkit().getImage("./resources/headR.png");

        for(int i = 0; i< bodyParts;i++) {
            if(i == 0) {
                if(direction == 'U'){
                    g.drawImage(headUp, x[i], y[i], null);
                } else if(direction == 'D') {
                    g.drawImage(headDown, x[i], y[i], null);
                } else if(direction == 'L') {
                    g.drawImage(headLeft, x[i], y[i], null);
                } else if(direction == 'R') {
                    g.drawImage(headRight, x[i], y[i], null);
                }
            }
            else {
                g.setColor(new Color(0, 24, 180)); //45,180,0
                g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//                    if(direction == 'R' || direction == 'L')
//                        g.drawImage(bodyLeft, x[i], y[i], null);
//                    else
//                        g.drawImage(bodyUp, x[i], y[i], null);

            }
        }

    }
}
