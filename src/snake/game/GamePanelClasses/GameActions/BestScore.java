package snake.game.GamePanelClasses.GameActions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BestScore{
    public static int getScore() throws FileNotFoundException {
        File file = new File("./resources/scores.txt");
        int score = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word  = input.next();
            score = Integer. parseInt(word);
        }
        return score;
    }

    public BestScore(int bestScore) throws FileNotFoundException{
        File file = new File("./resources/scores.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.print(bestScore);
        writer.close();
    }
}
