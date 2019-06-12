import sun.font.FontRunIterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends JPanel {

    Snake snake;
    Timer timer;
    private ArrayList<Sprite> hoppsImages;
    private boolean Dead;
    private int erin = -1;

    public Main() {
         Dead = false;
        snake = new Snake(300, 300, Sprite.NORTH);
        timer = new Timer(1000/60, e -> {
            snake.move();

            for (int i = 0; i < hoppsImages.size(); i++) {
                if (snake.intersects(hoppsImages.get(i))) {
                    hoppsImages.remove(0);

                }

            }
            if(snake.getLoc().y> 600 || snake.getLoc().y<0)
                 Dead = true;

            if(snake.getLoc().x> 600 || snake.getLoc().x<0)
                Dead= true;












            repaint();
        });
        timer.start();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_UP){
                    snake.setDir(Snake.UP);
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    snake.setDir(Snake.DOWN);
                }

                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    snake.setDir(Snake.LEFT);
                }

                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    snake.setDir(Snake.RIGHT);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        hoppsImages = new ArrayList<Sprite>();
        for (int i = 0; i < 1; i++) {
            hoppsImages.add(new Hopps((int)(Math.random()*600), (int)(Math.random()*600), Sprite.WEST, 1));
        }
    }



    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        background.DRAW(g2);

        snake.draw(g2);
        if(Dead) {
            g2.setColor(Color.black);
            g2.fillRect(0,0,FRAMEWIDTH,FRAMEHEIGHT);
            g2.setColor(Color.white);
            g2.drawString("You Lose", 200, 300);
        }

        for(Sprite spr : hoppsImages)
            spr.draw(g2);

        for (int i = 0; i < hoppsImages.size(); i++) {

            if(snake.intersects(hoppsImages.get(i))){
                hoppsImages.remove(i);
                hoppsImages.add(new Hopps((int)(Math.random()*600), (int)(Math.random()*600), Sprite.WEST, 1));
            }

        }

        repaint();

    }



    public static final int FRAMEWIDTH = 600, FRAMEHEIGHT = 600;

    public static void main(String[] args) {
        JFrame window = new JFrame("Give us an A PLS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }

}
