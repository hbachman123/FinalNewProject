import java.awt.*;

public class background{
    int x;
    int y;

    public background(int x, int y){
        this.x = x;
        this.y= y;


    }

    public static void DRAW(Graphics g2){
        g2.setColor(new Color(149,209,199));
        g2.fillRect(0, 0, 600, 600);
    }

}
