import java.awt.*;
import java.util.Arrays;

public class MyPlane { //TODO singleton or not

    private final int width;
    private final int height;
    private ColorRGB currentBackground;
    private MyCursor myCursor;
    public Point2D getHome(){
        return new Point2D(width/2, height/2);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private GridPoint[][] plane;

    private ColorRGB areaFillingColor;

    public MyPlane (int width, int height) { //TODO remember passare dimensioni dal main
        this.width=width;
        this.height=height;
        currentBackground = Colors.COLOR_WHITE.getColor();
        areaFillingColor = Colors.COLOR_WHITE.getColor();

        myCursor = MyCursor.getInstance();

        this.plane = new GridPoint[width][height];

        for (int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                plane[i][j] = new GridPoint(i, j);
            }
        }

    }

    public void printGrid () {  //for debugging purposes
        for (GridPoint[] row: plane) {
            for (GridPoint gp: row)     {
                if ( gp.getColor().equals(Colors.COLOR_WHITE.getColor()) ) {
                    System.out.print("W ");
                }
                else if ( gp.getColor().equals((Colors.COLOR_BLACK.getColor()))) {
                    System.out.print("B ");
                }
                else
                    System.out.print("umh..");

            } System.out.println();
        }
    }


    public void changeBackground (ColorRGB newColor) {
        currentBackground = newColor;
        for (GridPoint[] row: plane) {
            Arrays.stream(row).filter(gp -> gp.isBackground()).forEach(gp -> gp.setColor(newColor));
        }


    }

    public void clearPlane () {
        for (GridPoint[] row: plane) {
            for (GridPoint gp: row) {
                if (!gp.isBackground()) {
                    gp.setColor(currentBackground);
                    gp.changeEnclosure();
                    gp.changeBackgroundStatus();
                }
            }
        }
    }

    public ColorRGB getAreaFillingColor() {
        return areaFillingColor;
    }

    public void setAreaFillingColor(ColorRGB areaFillingColor) {
        this.areaFillingColor = areaFillingColor;
    }

    public void draw() {} // :)


}
