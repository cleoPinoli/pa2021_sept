package Commands;

import CorePackage.MyPlane;

public class CmdHome implements Command  {

    public CmdHome () {

    }

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setPosition(plane.getHome());
    }
}
