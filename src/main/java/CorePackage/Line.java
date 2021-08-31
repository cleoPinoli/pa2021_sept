package CorePackage;


public interface Line {

    public void trace (Point2D point1, Point2D point2);

    public Point2D getEndPoint(int angle, int length, Point2D startingPoint);
}
