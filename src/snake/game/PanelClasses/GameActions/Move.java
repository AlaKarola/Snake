package snake.game.PanelClasses.GameActions;

import static snake.game.GamePanel.*;

public class Move {
    public Move(int snakeX, int snakeY, int bodyParts, char direction){

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
