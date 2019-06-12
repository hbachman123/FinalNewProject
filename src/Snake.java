import java.awt.*;

public class Snake extends Sprite{

    public static final int UP=1, DOWN=2, LEFT=3, RIGHT=4;
    private int dir, x, y, speed;

    public Snake(int x, int y, int dir){
        super(x, y, dir);
        this.x = x;
        this.y = y;
        setPic("Hopps.png", NORTH);  //Assumes pic is oriented NORTH by default
        speed = 3;
    }

    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.fillRect(x, y, 20, 20);
    }

    public void move() {
        if (dir == UP) {
            y =loc.y-=speed;
        }

        if (dir == DOWN) {
            y = loc.y+=speed;
        }

        if (dir == LEFT) {
            x = loc.x-=speed;
        }

        if (dir == RIGHT) {
            x = loc.x+=speed;
        }

        if(loc.x < 0 || loc.x > 600){

//            setLoc(300, 300);
        }

        

    }

    public void setDir(int newDir){
        dir = newDir;
    }


}
