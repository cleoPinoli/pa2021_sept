import java.util.Objects;

public class MyCursor implements Cursor {

    private static final ColorRGB COLOR_WHITE = new ColorRGB ((byte)255, (byte)255, (byte)255);
    private static final ColorRGB COLOR_BLACK = new ColorRGB ((byte)0, (byte)0, (byte)0);
    private static MyCursor cursor = null;
    private ColorRGB areaColor;

    private ColorRGB lineColor;

    private boolean plot;

    private short direction; //TODO do we want to add a class idk

    private Point2D position;



    private MyCursor () { //default constructor
        areaColor = COLOR_WHITE; //TODO umh, gotta double check this constant thing
        lineColor = COLOR_BLACK;
        position = MyPlane.getHome(); //TODO define the 'home' definition thingy
        direction = 0;
        plot = true;

    }

    public static MyCursor getInstance() {
        if (Objects.isNull(cursor)) {
            cursor = new MyCursor();
        }
        return cursor;
    };

}
