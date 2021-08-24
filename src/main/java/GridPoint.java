import java.awt.*;

public class GridPoint extends CursorPoint {
    /**
     * Blah blah write stuff here.
     */


    private boolean isEnclosedArea;

    private boolean isBackground;

    private ColorRGB color;


    public GridPoint(int x, int y) {
        this(x, y, false, Colors.COLOR_WHITE.getColor(), true);
    }


    public GridPoint(int x, int y, boolean isEnclosedArea, ColorRGB color, boolean isBackground) {
        super(x, y);
        this.isEnclosedArea = isEnclosedArea;
        this.color = color;
        this.isBackground = isBackground;
    }

    public ColorRGB getColor() {
        return color;
    }

    public void setColor (ColorRGB newColor) {
        this.color = newColor;
    }

    public boolean isBackground() { return isBackground; }

    public void changeBackgroundStatus() { isBackground = !isBackground; }

    public boolean isEnclosed () {
        return this.isEnclosedArea;
    }

    public void changeEnclosure () {
        isEnclosedArea = !isEnclosedArea;
    }

}
