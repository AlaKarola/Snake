package snake.game.PanelClasses.GameActions;

import snake.game.PanelClasses.Objects.Directions;

import java.awt.*;

import static snake.game.GamePanel.*;

//public class ImageChange {
//    public void ImageChange(Graphics g, Directions direction, int bodyParts){
//
//        for(int i = 0; i< bodyParts;i++) {
//            if(i == 0) {
//                if(direction == Directions.UP){
//                    g.drawImage(headUp, x[i], y[i], null);
//                } else if(direction == Directions.DOWN) {
//                    g.drawImage(headDown, x[i], y[i], null);
//                } else if(direction == Directions.LEFT) {
//                    g.drawImage(headLeft, x[i], y[i], null);
//                } else if(direction == Directions.RIGHT) {
//                    g.drawImage(headRight, x[i], y[i], null);
//                }
//            }
//            else {
//                if(i==bodyParts-1){
//                    if(body[bodyParts-1] == Directions.UP){
//                        g.drawImage(tailU, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == Directions.DOWN) {
//                        g.drawImage(tailD, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == Directions.LEFT) {
//                        g.drawImage(tailL, x[i], y[i], null);
//                    } else if(body[bodyParts-1] == Directions.RIGHT) {
//                        g.drawImage(tailR, x[i], y[i], null);
//                    }
//                } else {
//                    if(body[i-1]==Directions.LEFT&&body[i]==Directions.DOWN||body[i-1]==Directions.UP&&body[i]==Directions.RIGHT){
//                        g.drawImage(curve3, x[i], y[i], null);
//                    } else if(body[i-1]==Directions.RIGHT&&body[i]==Directions.UP||body[i-1]==Directions.DOWN&&body[i]==Directions.LEFT){
//                        g.drawImage(curve1, x[i], y[i], null);
//                    } else if(body[i-1]==Directions.UP&&body[i]==Directions.LEFT||body[i-1]==Directions.RIGHT&&body[i]==Directions.DOWN){
//                        g.drawImage(curve4, x[i], y[i], null);
//                    } else if(body[i-1]==Directions.DOWN&&body[i]==Directions.RIGHT||body[i-1]==Directions.LEFT&&body[i]==Directions.UP) {
//                        g.drawImage(curve2, x[i], y[i], null);
//                    } else {
//                        g.setColor(new Color(0, 24, 180));
//                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//                    }
//                }
//            }
//        }
//    }
//}
