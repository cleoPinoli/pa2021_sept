package Commands;

import CorePackage.MyPlane;

import java.util.Queue;

public class CmdPenUp implements Command {

    public CmdPenUp (Queue<String> context) {}

    @Override
    public void execute(MyPlane plane) {
        plane.getMyCursor().setPlot(false);
    }

    @Override
    public String getName() {
        return "PENUP";
    }
}
