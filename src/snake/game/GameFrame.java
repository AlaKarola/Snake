package snake.game;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.IOException;
import java.util.Objects;

import static snake.game.GamePanel.images;

public class GameFrame extends JFrame{
    GameFrame(){
        try {
            images = ImageIO.read(Objects.requireNonNull(getClass().getResource("/sprite.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(images.getSubimage(0, 0, 32, 32));
        this.getIconImage();
    }
}