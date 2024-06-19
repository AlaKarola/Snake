package snake.game.GamePanelClasses.GameActions;


import snake.game.GamePanelClasses.SnakeDTO;

public class CheckCollisions {
    public static boolean checkCollisions(SnakeDTO SnakeHost, SnakeDTO SnakeEnemy) {
        //checks if head collides with body
        for(int i = SnakeHost.bodyParts;i>0;i--) {
            if ((SnakeHost.x[0] == SnakeHost.x[i]) && (SnakeHost.y[0] == SnakeHost.y[i])) {
                return false;
            }
        }
//        //check if head touches left border
//        if(SnakeHost.x[0] < UNIT_SIZE) {
//            return false;
//        }
//        //check if head touches right border
//        if(SnakeHost.x[0] >= SCREEN_WIDTH-UNIT_SIZE) {
//            return false;
//        }
//        //check if head touches top border
//        if(SnakeHost.y[0] < 2*UNIT_SIZE) {
//            return false;
//        }
//        //check if head touches bottom border
//        if(SnakeHost.y[0] >= SCREEN_HEIGHT-UNIT_SIZE) {
//            return false;
//        }

        //check snake-to-snake collisions
        for(int i = 0; i<SnakeHost.bodyParts; i++) {
            for(int j = 0; j < SnakeEnemy.bodyParts;j++) {
                if ((SnakeHost.x[i] == SnakeEnemy.x[j]) && (SnakeHost.y[i] == SnakeEnemy.y[j])) {
                    return false;
                }
            }
        }


        return true;
    }

}
