package CorePackage;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.util.Arrays;
import java.lang.Math;
import java.util.LinkedList;
import java.util.List;

public class MyPlane {
    private Group group;
    private ScrollPane scrollPane;
    private MyCursor myCursor;
    private Path currentPath;

    public Point2D getHome(){
        return new CursorPoint( (int)(this.getWidth()/2), (int)(this.getHeight()/2) );
    }


    public int getWidth() {     return width;}

    public int getHeight() {return height;}

    public MyCursor getMyCursor () {return this.myCursor;}

    //private GridPoint[][] plane;

    private ColorRGB areaFillingColor;
    private ColorRGB lineColor;
    private ColorRGB backgroundColor;

    private int width, height;

    public Node getCanvas(){
        return scrollPane;
    }

    public MyPlane (int width, int height, ScrollPane scrollPane) {
        this.width = width;
        this.height = height;
        backgroundColor = Colors.COLOR_WHITE.getColor(); //TODO FIX THIS, maybe unnecessary
        areaFillingColor = Colors.COLOR_WHITE.getColor();
        myCursor = new MyCursor(getHome());
        currentPath = new Path(new MoveTo(getHome().getX(), getHome().getY()));
        group = new Group();
        group.getChildren().add(currentPath);

        this.scrollPane = scrollPane;
        scrollPane.setPrefSize(width, height);
        scrollPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        scrollPane.setContent(group);

        /*this.plane = new GridPoint[width][height];

        for (int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                plane[i][j] = new GridPoint(i, j);
            }
        }*/

    }

    /*public void printGrid () {  //for debugging purposes
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
    }*/


    public void changeBackground (int red, int green, int blue) {
        scrollPane.setBackground(new Background(new BackgroundFill(Color.rgb(red, green, blue), null, null)));

        /*for (GridPoint[] row: plane) { //I'm keeping this for now
            Arrays.stream(row).filter(gp -> gp.isBackground()).forEach(gp -> gp.setColor(newColor));
        }*/


    }

    public void clearPlane () {
        group.getChildren().clear();
    }

    public ColorRGB getAreaFillingColor() {
        return this.areaFillingColor;
    }

    /**
     * Changes the color of the closed figures' filling
     * @param areaFillingColor the new color
     */
    public void setAreaFillingColor(ColorRGB areaFillingColor) {
        this.areaFillingColor = areaFillingColor;
        currentPath.setFill(Color.rgb(areaFillingColor.getRed(), areaFillingColor.getGreen(), areaFillingColor.getBlue()));
    }

    /**
     * Changes the color of the segments to be drawn
     * @param lineColor the new color
     */
    public void setLineColor(ColorRGB lineColor) {
        this.lineColor = lineColor;
        currentPath = new Path(new MoveTo(myCursor.getPosition().getX(), myCursor.getPosition().getY()));
        group.getChildren().add(currentPath);
        currentPath.setStroke(Color.rgb(lineColor.getRed(), lineColor.getGreen(), lineColor.getBlue()));
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
        //System.out.println(endPoint.getX()+" , "+endPoint.getY());
        if (myCursor.isPlot()) {
            //draw(myCursor.getPosition(), endPoint, myCursor.getSize());
            currentPath.getElements().add(new LineTo(endPoint.getX(), endPoint.getY()));
            currentPath.setStrokeWidth(myCursor.getSize());} //TODO tbr
        else {
            currentPath.getElements().add(new MoveTo(endPoint.getX(), endPoint.getY()));
        }

            myCursor.setPosition(endPoint); //not sure we need this still

    }

    //private void draw(Point2D beginPoint, Point2D endPoint, int thickness) {}


    /**
     * Computes the end point of a segment, given the starting point, the segment's length
     * and the angle, treated as radian.
     *
     * @param angle the segment's angle
     * @param length the segment's length
     * @param startingPoint point from where we want to draw a line
     * @return a new CursorPoint with the computed coordinates
     */
    private Point2D getEndPoint(int angle, int length, Point2D startingPoint) {
        int startingX = startingPoint.getX();
        int startingY = startingPoint.getY();
        double aRadian = Math.toRadians(angle);

        return new CursorPoint ((int)Math.round((startingX + length * Math.cos(aRadian))),
                (int)Math.round((startingY + length * Math.sin(aRadian))));

    }

    /**
     * Computes all the points crossed by a line from point1 to point2,
     * using Bresenham's line algorithm.
     *
     * @param point1 a starting point
     * @param point2 an end point
     * @param points the list of points to be populated
     * @param width the segment width
     */
    private void computeLinePoints (Point2D point1, Point2D point2, List<Point2D> points, int width) {

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




