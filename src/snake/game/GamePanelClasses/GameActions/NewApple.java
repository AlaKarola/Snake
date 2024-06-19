package snake.game.GamePanelClasses.GameActions;

import java.util.Random;

import static snake.game.GamePanel.*;

public class NewApple {
    public static int newAppleX(){
        Random random = new Random();
        int appleX;
        appleX = random.nextInt(18)*UNIT_SIZE;
        appleX=appleX+UNIT_SIZE; // adding UNIT_SIZE removes issue of an apple appearing out of bounds (left right)
        return appleX;
    }

    public static int newAppleY(){
        Random random = new Random();
        int appleY;
        appleY = random.nextInt(18)*UNIT_SIZE;
        appleY = appleY+2*UNIT_SIZE; // adding 2*UNIT_SIZE removes issue of an apple appearing out of bounds (up down)
        return appleY;
    }
}
