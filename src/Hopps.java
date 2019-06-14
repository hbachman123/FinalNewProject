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
                setLoc(new Point((int) Math.random(), getLoc().y));
            if(getLoc().x < 0)
                setLoc(new Point((int) Math.random(), getLoc().y));
        }
    }



//    import java.awt.*;
//
//    /**
//     * Created by michael_hopps on 2/5/18.
//     */
//    public class Car extends Sprite {
//
//        public Car(int x, int y, int direction, int img) {
//            super(x, y, direction);
//            if(img == 1)
//                setPic("car1.png", WEST);
//
//            if(img == 2)
//                setPic("car2.png", WEST);
//
//            if(img == 3)
//                setPic("car3.png", WEST);
//
//            if(img == 4)
//                setPic("car4.png", WEST);
//
//            setSpeed(10); //GUESS?!
//        }
//
//        @Override
//        public void update() {
//            super.update();
//            if (getLoc().x > FroggerMain.FRAMEWIDTH)
//                setLoc(new Point(0, getLoc().y));
//            if(getLoc().x < 0)
//                setLoc(new Point(1000, getLoc().y));
//        }



