package snake.game.PanelClasses.GameActions;

import java.awt.*;

import static snake.game.GamePanel.*;

public class ImageChange {
    public ImageChange(Graphics g, char direction, int bodyParts){

        Image headUp = Toolkit.getDefaultToolkit().getImage("./resources/headU.png");
        Image headDown = Toolkit.getDefaultToolkit().getImage("./resources/headD.png");
        Image headLeft = Toolkit.getDefaultToolkit().getImage("./resources/headL.png");
        Image headRight = Toolkit.getDefaultToolkit().getImage("./resources/headR.png");

        Image tailU = Toolkit.getDefaultToolkit().getImage("./resources/tailU.png");
        Image tailD = Toolkit.getDefaultToolkit().getImage("./resources/tailD.png");
        Image tailL = Toolkit.getDefaultToolkit().getImage("./resources/tailL.png");
        Image tailR = Toolkit.getDefaultToolkit().getImage("./resources/tailR.png");

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
                if(i==bodyParts-1){
                    if(body[bodyParts-1] == 'U'){
                        g.drawImage(tailU, x[i], y[i], null);
                    } else if(body[bodyParts-1] == 'D') {
                        g.drawImage(tailD, x[i], y[i], null);
                    } else if(body[bodyParts-1] == 'L') {
                        g.drawImage(tailL, x[i], y[i], null);
                    } else if(body[bodyParts-1] == 'R') {
                        g.drawImage(tailR, x[i], y[i], null);
                    }
                } else {
                    g.setColor(new Color(0, 24, 180));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
        }
    }
}
