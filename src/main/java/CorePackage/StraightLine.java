package CorePackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class implementing the most basic trait that can be drawn on the plane:
 * a straight segment from point A to point B.
 *
 * @author claudia.raffaelli@studenti.unicam.it
 */
public class StraightLine implements Line {

    private Point2D pointA;
    private Point2D pointB;

    private List<Point2D> linePoints = new ArrayList<>();

    @Override
    public void trace(Point2D point1, Point2D point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();

        int deltaX = Math.abs(x2 - x1);
        int deltaY = Math.abs(y2 - y1);
        int error = 0;
        int y = y1;

        for (int x = x1; x < x2; x++) {
            linePoints.add(new CursorPoint(x, y));
            error = error + deltaY;
            if (2 * error >= deltaX) {
                y++;
                error -= deltaX;
            }
        }


    }       //TODO questi poi vanno COLORATI! nel plane dico, fuck qui sento puzza di function bifunction blah

    @Override
    public Point2D getEndPoint(int angle, int length, Point2D startingPoint) {
        int startingX = startingPoint.getX();
        int startingY = startingPoint.getY();
        double aRadian = Math.toRadians(angle);

        return new CursorPoint ((int)Math.round((startingX + length * Math.cos(aRadian))),
                (int)Math.round((startingY + length * Math.sin(aRadian))));
    }


}

