package Commands;

import CorePackage.MyPlane;

import java.util.Queue;

public class CmdPenDown implements Command  {

    public CmdPenDown (Queue<String> context) { }

    @Override
    public void execute(MyPlane plane) {
      plane.getCursor().setPlot(true);
    }
}

