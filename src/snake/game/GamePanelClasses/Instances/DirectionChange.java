package snake.game.GamePanelClasses.Instances;

import snake.game.GamePanelClasses.SnakeDTO;

import static snake.game.GamePanel.GAME_UNITS;

public class DirectionChange {

    public DirectionChange (SnakeDTO Snake) {
        System.out.println("Direct change ...");
        char temp[] = new char [GAME_UNITS];
        temp[0]=Snake.direction;
        if (Snake.bodyParts >= 0) System.arraycopy(Snake.body, 0, temp, 1, Snake.bodyParts);
        Snake.body = temp;
        if(Snake.body[Snake.bodyParts-1]!=Snake.body[Snake.bodyParts-2]){
            Snake.body[Snake.bodyParts-1] = Snake.body[Snake.bodyParts-2];
        }
    }

}
