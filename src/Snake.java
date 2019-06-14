import java.awt.*;
import java.util.ArrayList;

public class Snake extends Sprite{

    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    private int dir, x, y, speed, length = 1;
    private ArrayList<Tuple> pieces;


    public Snake(int x, int y, int dir){
        super(x, y, dir);
        this.x = x;
        this.y = y;
        setPic("Hopps.png", NORTH);  //Assumes pic is oriented NORTH by default
        speed = 3;
        pieces = new ArrayList<Tuple>();
        pieces.add(new Tuple(300, 300));
    }

    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        for(Tuple t: pieces)
            g2.fillRect(t.x, t.y, 20, 20);
    }

    public void move() {
        if (dir == UP) {
            y = loc.y -= speed;
        }

        if (dir == DOWN) {
            y = loc.y += speed;
        }

        if (dir == LEFT) {
            x = loc.x -= speed;
        }

        if (dir == RIGHT) {
            x = loc.x += speed;
        }

        if (length == pieces.size())
            pieces.add(0, pieces.remove(pieces.size() - 1));
        else
            pieces.add(0, new Tuple(0, 0));
        pieces.get(0).x = x;
        pieces.get(0).y = y;
    }

    public void setDir(int newDir){
        dir = newDir;
    }

    public void incLength() {
        length++;
    }
}
