package Commands;

import CorePackage.MyPlane;

public class CmdClearPlane implements Command {

    public CmdClearPlane () {

    }

    @Override
    public void execute(MyPlane plane) {
        plane.clearPlane();
    }
}
