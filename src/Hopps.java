import java.awt.*;

public class Hopps extends Sprite{

    public Hopps(int x, int y, int direction, int img) {
        super(x, y, direction);
        if (img == 1)
            setPic("Hopps.png", WEST);
    }

    @Override
    public void update() {
        super.update();
        if (getLoc().x > Main.FRAMEWIDTH)
            setLoc(new Point(0, getLoc().y));
        if(getLoc().x < 0)
            setLoc(new Point(1000, getLoc().y));
    }
}






