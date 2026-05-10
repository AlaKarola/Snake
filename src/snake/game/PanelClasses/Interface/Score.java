package snake.game.PanelClasses.Interface;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static snake.game.GamePanel.SCREEN_WIDTH;
import static snake.game.GamePanel.UNIT_SIZE;

public class Score extends JFrame {

    public Score(Graphics g, int applesEaten, int bestScore ){
        g.setColor(Color.white);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        String score = "Score: " + applesEaten;
        g.drawString(score, (UNIT_SIZE*2), g.getFont().getSize());
        score = "Best score: " + bestScore;
        g.drawString(score, (SCREEN_WIDTH - (UNIT_SIZE*2) -metrics.stringWidth("Best score: 00")), g.getFont().getSize());

    }

    public static int getBestScore() {
        int score = 0;
        try (Scanner input = new Scanner(new File("./resources/scores.txt"))) {
            while (input.hasNext()) {
                String word  = input.next();
                score = Integer. parseInt(word);
            }
        } catch (FileNotFoundException e) {
            System.err.println("#Exception -> File scores.txt not found, score set to 0.");
            e.printStackTrace();
        }

        return score;
    }

    public static void setBestScore(int bestScore){
        try (PrintWriter writer = new PrintWriter("./resources/scores.txt")) {
            writer.print(bestScore);
        } catch (FileNotFoundException e){
            System.err.println("#Exception -> File scores.txt not found, bestScore not updated.");
            e.printStackTrace();
        }


    }


}
