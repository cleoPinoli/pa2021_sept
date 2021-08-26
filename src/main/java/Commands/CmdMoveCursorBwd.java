package Commands;
import CorePackage.MyPlane;

public class CmdMoveCursorBwd implements Command {
    private int distance;
    public CmdMoveCursorBwd (int distance) {
        this.distance = distance;
    }

    //get and set maybe

    @Override
    public void execute(MyPlane plane) {
        plane.moveCursor(distance, false);
    }
}
