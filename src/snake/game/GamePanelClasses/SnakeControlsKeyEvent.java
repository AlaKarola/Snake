package snake.game.GamePanelClasses;

import java.awt.event.KeyEvent;

public class SnakeControlsKeyEvent {

    public SnakeControlsKeyEvent (KeyEvent e, SnakeDTO Snake) {

        if(Snake.controls == "wasd") {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    if(Snake.direction != 'R') {
                        if(Snake.running){
                            Snake.direction = 'L';
                        }
                    }
                    break;
                case KeyEvent.VK_D:
                    if(Snake.direction != 'L') {
                        if(Snake.running){
                            Snake.direction = 'R';
                        }
                    }
                    break;
                case KeyEvent.VK_W:
                    if(Snake.direction != 'D') {
                        if(Snake.running){
                            Snake.direction = 'U';
                        }
                    }
                    break;
                case KeyEvent.VK_S:
                    if(Snake.direction != 'U') {
                        if(Snake.running){
                            Snake.direction = 'D';
                        }
                    }
                    break;
            }
        } else if(Snake.controls == "ijkl") {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_J:
                    if(Snake.direction != 'R') {
                        if(Snake.running){
                            Snake.direction = 'L';
                        }
                    }
                    break;
                case KeyEvent.VK_L:
                    if(Snake.direction != 'L') {
                        if(Snake.running){
                            Snake.direction = 'R';
                        }
                    }
                    break;
                case KeyEvent.VK_I:
                    if(Snake.direction != 'D') {
                        if(Snake.running){
                            Snake.direction = 'U';
                        }
                    }
                    break;
                case KeyEvent.VK_K:
                    if(Snake.direction != 'U') {
                        if(Snake.running){
                            Snake.direction = 'D';
                        }
                    }
                    break;
            }
        }
    }
}
