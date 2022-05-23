package snake.game.PanelClasses.GameActions;

import java.util.Random;

import static snake.game.GamePanel.*;

public class NewApple {
    public static int newAppleX(){
        Random random = new Random();
        int appleX;
        appleX = random.nextInt(18)*UNIT_SIZE;
        appleX=appleX+32;
        return appleX;
    }

    public static int newAppleY(){
        Random random = new Random();
        int appleY;
        appleY = random.nextInt(18)*UNIT_SIZE;
        appleY = appleY+64;
        return appleY;
    }
}
