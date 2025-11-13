package snake.game;

import snake.game.GamePanelClasses.Interface.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static snake.game.GamePanel.SCREEN_HEIGHT;
import static snake.game.GamePanel.SCREEN_WIDTH;

public class MenuPanel extends JPanel implements ActionListener {
    MenuPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MenuKeyAdapter());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {

    }

    public class MenuKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            switch(e.getKeyCode()) {
                case KeyEvent.VK_P: {

                }

            }
        }
    }


}
