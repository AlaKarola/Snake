package snake.game.GamePanelClasses.GameActions;

import snake.game.GamePanelClasses.SnakeDTO;

import java.awt.*;

import static snake.game.GamePanel.*;

public class ImageChange {
    public ImageChange(Graphics g, SnakeDTO Snake, Color color){

        char[] body = Snake.body;
        char direction = Snake.direction;
        int bodyParts = Snake.bodyParts;
        int[] x = Snake.x;
        int[] y = Snake.y;

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
                    g.setColor(new Color(0, 34, 255));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                } else {
                    g.setColor(color);//new Color(0, 24, 180));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
//                    if(body[bodyParts-1] == 'U'){
//                        g.drawImage(tailU, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == 'D') {
//                        g.drawImage(tailD, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == 'L') {
//                        g.drawImage(tailL, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == 'R') {
//                        g.drawImage(tailR, x[i], y[i], null);
//                    //}
////                } else {
////                    if(body[i-1]=='L'&&body[i]=='D'||body[i-1]=='U'&&body[i]=='R'){
////                        g.drawImage(curve3, x[i], y[i], null);
////                    } else if(body[i-1]=='R'&&body[i]=='U'||body[i-1]=='D'&&body[i]=='L'){
////                        g.drawImage(curve1, x[i], y[i], null);
////                    } else if(body[i-1]=='U'&&body[i]=='L'||body[i-1]=='R'&&body[i]=='D'){
////                        g.drawImage(curve4, x[i], y[i], null);
////                    } else if(body[i-1]=='D'&&body[i]=='R'||body[i-1]=='L'&&body[i]=='U') {
////                        g.drawImage(curve2, x[i], y[i], null);
//                    } else {

//                        g.setColor(new Color(0, 24, 180));
//                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
}
//}
//}
