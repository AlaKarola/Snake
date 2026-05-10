package snake.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Objects;

import static snake.game.GamePanel.images;

public class GameFrame extends JFrame{
    GameFrame(){
        try {
            images = ImageIO.read(Objects.requireNonNull(getClass().getResource("/sprite.png")));
        } catch (Exception e) {
            System.err.println("#Fatal Exception: sprite image file not found");
            e.printStackTrace();
            System.exit(1);
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