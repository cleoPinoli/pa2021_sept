package CorePackage;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursorPoint that = (CursorPoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
