package Commands;

import CorePackage.MyPlane;

import java.util.Queue;

public class CmdPenUp implements Command {

    public CmdPenUp (Queue<String> context) {}

    @Override
    public void execute(MyPlane plane) {
        plane.getCursor().setPlot(false);
    }
}
