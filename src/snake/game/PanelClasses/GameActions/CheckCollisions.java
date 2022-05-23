package snake.game.PanelClasses.GameActions;


import static snake.game.GamePanel.*;

public class CheckCollisions {
    public static boolean checkCollisions(int bodyParts) {
        //checks if head collides with body
        boolean alive =true;

        for(int i = bodyParts;i>0;i--) {
            if((x[0] == x[i])&& (y[0] == y[i])) {
                alive = false;
            }
        }
        //check if head touches left border
        if(x[0] < 32) {
            alive = false;
        }
        //check if head touches right border
        if(x[0] >= SCREEN_WIDTH-32) {
            alive = false;
        }
        //check if head touches top border
        if(y[0] < 64) {
            alive = false;
        }
        //check if head touches bottom border
        if(y[0] >= SCREEN_HEIGHT-32) {
            alive = false;
        }
        return alive;
    }

}
