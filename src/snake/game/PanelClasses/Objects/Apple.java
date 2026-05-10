package snake.game.PanelClasses.Objects;


import java.awt.*;
import java.awt.image.BufferedImage;

import static snake.game.GamePanel.*;

public class Apple {
    BufferedImage appleImage = images.getSubimage(34, 34, 32, 32);
    int appleX;
    int appleY;

    public Apple() {
        this.appleX = newAppleX();
        this.appleY = newAppleY();
    }

    public void checkApple(Snake snake) {
        if ((snake.x[0] == appleX) && (snake.y[0] == appleY)) {
            snake.bodyParts++;
            snake.applesEaten++;
            appleX = newAppleX();
            appleY = newAppleY();
            if (snake.applesEaten > bestScore) {
                bestScore = snake.applesEaten;
            }
        }
    }

    public static int newAppleX() {
        return random.nextInt(18) + 1;
    }

    public static int newAppleY() {
        return random.nextInt(18) + 2;
    }

    public int getAppleX() {
        return appleX*UNIT_SIZE;
    }

    public int getAppleY() {
        return appleY*UNIT_SIZE;
    }

    public BufferedImage getImage() {
        return appleImage;
    }

    public void setImage(BufferedImage img) {
        this.appleImage = img;
    }
}