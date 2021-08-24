public class CursorPoint implements Point2D {

    private int x;

    private int y;

    public CursorPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition (int newX, int newY) { //TODO check invalid parameters?
        x = newX;
        y = newY;
    }

    @Override
    public void setX (int x) {
        this.x = x;
    }
    @Override
    public  void setY (int y) {
        this.y = y;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }



}
