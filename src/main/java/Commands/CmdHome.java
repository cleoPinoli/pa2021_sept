package Commands;

import CorePackage.MyPlane;
import java.util.Queue;

public class CmdHome implements Command  {

    public CmdHome (Queue<String> context) {

    }




    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setPosition(plane.getHome());
    }
}
