package Commands;

import CorePackage.MyPlane;

public class CmdPenUp implements Command {

    public CmdPenUp () {}

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setPlot(false);
    }
}
