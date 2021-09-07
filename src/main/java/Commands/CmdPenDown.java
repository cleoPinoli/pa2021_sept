package Commands;

import CorePackage.MyPlane;

import java.util.Queue;

public class CmdPenDown extends BasicCommand  {

    public CmdPenDown (Queue<String> context) { }

    @Override
    public void execute(MyPlane plane) {
      plane.getMyCursor().setPlot(true);
    }

    @Override
    public String getName() {
        return "PENDOWN";
    }
}

