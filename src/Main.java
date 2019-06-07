import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    Snake snake;
    Timer timer;

    public Main() {
        snake = new Snake(700, 300);
        timer = new Timer(1000/60, e -> {
            snake.move();

        });
        timer.start();

    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;

        background.DRAW(g2);

        snake.draw(g2);


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
