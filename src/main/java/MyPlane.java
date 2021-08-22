import java.awt.*;

public class MyPlane {

    private static final int width = 512;
    private static final int height = 512;

    public static Point2D getHome(){
        return new Point2D(width/2, height/2);
    }

    public MyPlane() {
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
