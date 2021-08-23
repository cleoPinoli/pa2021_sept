public class Point2D { //TODO do we add an interface + implements  Point

    private int x;

    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition (int newX, int newY) { //TODO check invalid parameters?
        x = newX;
        y = newY;
    }


    public void setX (int x) {
        this.x = x;
    }

    public  void setY (int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
