package snake.game.PanelClasses.Objects;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static snake.game.GamePanel.*;

public class Apple {
    BufferedImage appleImage = images.getSubimage(34, 34, 32, 32);
    int appleX;
    int appleY;

    public Apple(Snake snake) {
        Tile freeTile = setNewApple(snake);
        this.appleX = freeTile.x;
        this.appleY = freeTile.y;
    }

    public void checkApple(Snake snake) {
        if ((snake.x[0] == appleX) && (snake.y[0] == appleY)) {
            snake.bodyParts++;
            snake.applesEaten++;
            Tile freeTile = setNewApple(snake);
            appleX = freeTile.x;
            appleY = freeTile.y;
            if (snake.applesEaten > bestScore) {
                bestScore = snake.applesEaten;
            }
        }
    }

    public static Tile setNewApple(Snake snake) {
        ArrayList<Tile> snakeTiles = new ArrayList<>();
        ArrayList<Tile> freeTiles = new ArrayList<>();
        for(int i = 0; i < snake.bodyParts-1; i++) {
            snakeTiles.add(new Tile(snake.x[i], snake.y[i]));
        }
        for (int i = 1; i <= 18; i++) {
            for (int j = 2; j <=19; j++) {
                Tile tile = new Tile(i, j);
                if (!snakeTiles.contains(tile)) {
                    freeTiles.add(tile);
                }
            }
        }
        return freeTiles.get(random.nextInt(freeTiles.size()));
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
}