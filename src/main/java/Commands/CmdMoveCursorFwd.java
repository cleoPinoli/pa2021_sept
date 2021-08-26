package Commands;

import CorePackage.MyPlane;

public class CmdMoveCursorFwd implements Command  {
    private int distance;
    public CmdMoveCursorFwd (int distance) {
        this.distance = distance; //good lord
    }

    @Override
    public void execute(MyPlane plane) {
        plane.moveCursor(distance, true);
    }
}
