package CorePackage;

import java.util.Arrays;
import java.lang.Math;
import java.util.LinkedList;
import java.util.List;

public class MyPlane { //TODO singleton or not

    private final int width;
    private final int height;
    private ColorRGB currentBackground;
    private MyCursor myCursor;

    public Point2D getHome(){
        return new CursorPoint(width/2, height/2);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public MyCursor getCursor () {
        return this.myCursor;
    }

    private GridPoint[][] plane;

    private ColorRGB areaFillingColor;

    public MyPlane (int width, int height) { //TODO remember passare dimensioni dal main
        this.width=width;
        this.height=height;
        currentBackground = Colors.COLOR_WHITE.getColor();
        areaFillingColor = Colors.COLOR_WHITE.getColor();
        myCursor = new MyCursor(getHome());

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
                    System.out.print("- ");

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



    /**
     * Moves the cursor in a new location, given distance and direction.
     * If the pen is down, also draws a line.
     *
     * @param distance a given distance
     * @param direction a given direction (true = forward; false = backward;)
     */


    public void moveCursor (int distance, boolean direction) {
        int angle;
        if (direction)
            angle = myCursor.getDirection();
        else
            angle = (myCursor.getDirection() + 180) % 360;

        Point2D endPoint = getEndPoint(angle, distance, myCursor.getPosition());
        System.out.println(endPoint.getX()+" , "+endPoint.getY());
        if (myCursor.isPlot())
            draw(myCursor.getPosition(), endPoint, myCursor.getSize());

        myCursor.setPosition(endPoint);

    }

    private void draw(Point2D beginPoint, Point2D endPoint, int thickness) {
        List<Point2D> points = new LinkedList<>();
        computeLinePoints(beginPoint, endPoint, points, thickness);
        points.stream().forEach(p -> {plane[p.getX()][p.getY()].setColor(myCursor.getLineColor());
                                        plane[p.getX()][p.getY()].changeBackgroundStatus();
                        });
    }




    private Point2D getEndPoint(int angle, int length, Point2D startingPoint) {
        int startingX = startingPoint.getX();
        int startingY = startingPoint.getY();
        double aRadian = Math.toRadians(angle);

        return new CursorPoint ((int)Math.round((startingX + length * Math.cos(aRadian))),
                (int)Math.round((startingY + length * Math.sin(aRadian))));

    }

    /**
     * Computes all the points
     *
     *
     *
     */



    private void computeLinePoints (Point2D point1, Point2D point2, List<Point2D> points, int width) {    //TODO this width can easily be an integer, amirite, like, why a float value, bruh

        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        int deltaX = Math.abs(x2 - x1);
        int deltaY = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        int error = deltaX - deltaY;
        int error2 = 0, x3 = 0, y3 = 0;

        float ed = (deltaX + deltaY == 0) ? 1 : (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        for (width = (width + 1) / 2; ; ) {
            points.add(new GridPoint(x1, y1));
            error2 = error;
            x3 = x1;
            if (2 * error2 >= -deltaX) {
                for (error2 += deltaY, y3 = y1;
                     error2 < ed * width && (y2 != y3 || deltaX > deltaY);
                     error2 += deltaX) {
                    points.add(new GridPoint(x1, y3 += sy));
                }
                if (x1 == x2) { break; }
                error2 = error;
                error -= deltaY;
                x1 += sx;
            }
            if (2 * error2 <= deltaY) {
                for (error2 = deltaX - error2; error2 < ed * width &&
                        (x2 != x3 || deltaX < deltaY);
                     error2 += deltaY) {
                    points.add(new GridPoint(x3 += sx, y1));
                }
                    if (y1 == y2) { break; }
                    error += deltaX;
                    y1 += sy;

            }

        }
    }







































   /* private List<Point2D> computeLinePoints (Point2D point1, Point2D point2) { //TODO this has been copypasted into another class!!
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        int deltaX = Math.abs(x2 - x1);
        int deltaY = -Math.abs(y2 - y1);

        List<Point2D> linePoints = new LinkedList<Point2D>();

        int sx = x1<x2 ? 1 : -1;

        int sy = y1<y2 ? 1 : -1;
        int error = deltaX+deltaY;  //error value e_xy
        while (true) {
            linePoints.add(new CursorPoint(x1, y1));
            if (x1 == x2 && y1 == y2) { break; }
            int error2 = 2 * error;
            if (error2 >= deltaY) //e_xy+e_x > 0
            {
                error += deltaY;
                x1 += sx;
            }
            if (error2 <= deltaX) // e_xy+e_y < 0
                {
                error += deltaX;
                y1 += sy;
            }
        }
        return linePoints;
    } */


}




