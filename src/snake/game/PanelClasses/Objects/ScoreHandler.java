package snake.game.PanelClasses.Objects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScoreHandler {
    public static int getBestScore() {
        try {
            String text = Files.readString(Paths.get("./resources/scores.txt")).trim();
            return Integer.parseInt(text);

        } catch (IOException e) {
            System.err.println("#Exception -> File scores.txt or its content not found, BestScore set to 0.");
            e.printStackTrace();
            return 0;
        }
    }

    public static void setBestScore(int bestScore){
        try {
            Files.writeString(Paths.get("./resources/scores.txt"), String.valueOf(bestScore));
        } catch (IOException e) {
            System.err.println("#Exception -> File scores.txt not found, BestScore not updated.");
            e.printStackTrace();
        }
    }
}
