package snake.game.GamePanelClasses.GameActions;

import snake.game.GamePanelClasses.SnakeDTO;

import static snake.game.GamePanel.*;

public class Move {
    public Move(SnakeDTO Snake){

        System.out.println("Moved ...");
        int[] x = Snake.x;
        int[] y = Snake.y;
        int bodyParts = Snake.bodyParts;
        int snakeY = Snake.snakeY;
        int snakeX = Snake.snakeX;
        char direction = Snake.direction;

        //check if head touches left border
        if(Snake.x[0]-UNIT_SIZE < UNIT_SIZE && Snake.direction=='L') {
            Snake.x[0] = SCREEN_WIDTH-2*UNIT_SIZE;
        }
        //check if head touches right border
        if(Snake.x[0]+UNIT_SIZE >= SCREEN_WIDTH-UNIT_SIZE && Snake.direction=='R') {
            Snake.x[0] = 2*UNIT_SIZE;
        }
        //check if head touches top border
        if(Snake.y[0]-UNIT_SIZE < 2*UNIT_SIZE && Snake.direction == 'U') {
            Snake.y[0] = SCREEN_HEIGHT-2*UNIT_SIZE;

        }
        //check if head touches bottom border
        if(Snake.y[0]+UNIT_SIZE >= SCREEN_HEIGHT-UNIT_SIZE && Snake.direction == 'D') {
            Snake.y[0] = 2*UNIT_SIZE;
        }

        for(int i = bodyParts;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case 'U' : /*->*/ {
                y[0] = y[0] - UNIT_SIZE;
                snakeY = y[0];
                break;
            }
            case 'D': /*->*/{
                y[0] = y[0] + UNIT_SIZE;
                snakeY = y[0];
                break;
            }
            case 'L': /*->*/{
                x[0] = x[0] - UNIT_SIZE;
                snakeX = x[0];
                break;
            }
            case 'R': /*->*/ {
                x[0] = x[0] + UNIT_SIZE;
                snakeX = x[0];
                break;
            }
        }

    }
}
