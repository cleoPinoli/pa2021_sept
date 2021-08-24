package CorePackage;

import CorePackage.ColorRGB;
import CorePackage.Colors;
import CorePackage.Point2D;

public class MyCursor {

    private ColorRGB areaColor;

    private ColorRGB lineColor;

    private boolean plot;

    private short direction; //TODO do we want to add a class idk

    private Point2D position;

    private byte size;


    public MyCursor (Point2D home) { //default constructor
        areaColor = Colors.COLOR_WHITE.getColor();
        lineColor = Colors.COLOR_BLACK.getColor();
        position = home;
        direction = 90;
        plot = true;
        size = 1;
    }


    public ColorRGB getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(ColorRGB areaColor) {
        this.areaColor = areaColor;
    }

    public ColorRGB getLineColor() {
        return lineColor;
    }

    public void setLineColor(ColorRGB lineColor) {
        this.lineColor = lineColor;
    }

    public boolean isPlot() {
        return plot;
    }

    public void setPlot(boolean plot) {
        this.plot = plot;
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = (short) (direction % 360);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }
}
