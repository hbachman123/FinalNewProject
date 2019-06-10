import java.awt.*;

public class Snake extends Sprite{

    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    private int dir, x, y;

    public Snake(int x, int y, int dir){
        super(x, y, dir);
        this.x = x;
        this.y = y;
        setPic("Hopps.png", NORTH);  //Assumes pic is oriented NORTH by default

    }

    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, 20, 20);
    }

    public void move() {
        if (dir == UP) {
            y--;
        }

        if (dir == DOWN) {
            y++;
        }

        if (dir == LEFT) {
            x--;
        }

        if (dir == RIGHT) {
            x++;
        }
    }

    public void setDir(int newDir){
        dir = newDir;
    }


}
