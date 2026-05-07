package snake.game.PanelClasses.Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Apple {
    Image apple = Toolkit.getDefaultToolkit().getImage("./resources/apple.png");
    //BufferedImage apple = ImageIO.read(new File());
    int appleX;
    int appleY;

    public Apple(int appleX, int appleY) {
        this.appleX = appleX;
        this.appleY = appleY;
    }

    public int getAppleX() {
        return appleX;
    }

    public void setAppleX(int appleX) {
        this.appleX = appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public void setAppleY(int appleY) {
        this.appleY = appleY;
    }
}