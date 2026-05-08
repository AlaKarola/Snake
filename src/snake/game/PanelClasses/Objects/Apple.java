package snake.game.PanelClasses.Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import static snake.game.GamePanel.*;

public class Apple {
    //Image appleImage = Toolkit.getDefaultToolkit().getImage("./resources/apple.png");
    BufferedImage testapple; // = ImageIO.read(new File("sprite.png"));
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
        return random.nextInt(18) * UNIT_SIZE + 32;
    }

    public static int newAppleY() {
        return random.nextInt(18) * UNIT_SIZE + 64;
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public BufferedImage getImage() {
        return testapple;
    }

    public void setImage(BufferedImage img) {
        this.testapple = img;
    }
}